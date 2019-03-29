package pt2018.assign3.dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * An abstract generic class which uses the reflection technique in order to generate and execute the queries which access the database.
 * 
 * @author Ian Chelaru
 *
 * @param <T> represents any java type(class)
 */

public abstract class AbstractDAO<T>
{

	private final Class<T> type;

	/**
	 * Initializes the concrete type of the type attribute.
	 */
	@SuppressWarnings("unchecked")
	public AbstractDAO()
	{
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * Construct the insert statement.
	 * 
	 * @param fields the attributes names of the concrete class
	 * @return a string which represent the insert statement
	 */
	private String createInsertQuery(ArrayList<String> fields)
	{
		StringBuilder insertQuery = new StringBuilder();
		insertQuery.append("INSERT INTO warehousedb.");
		insertQuery.append(type.getSimpleName());
		insertQuery.append(" (" + fields.get(0));
		for (int i = 1; i < fields.size(); i++)
		{
			insertQuery.append(", " + fields.get(i));
		}
		insertQuery.append(") VALUES (?");
		for (int i = 1; i < fields.size(); i++)
		{
			insertQuery.append(",?");
		}
		insertQuery.append(")");
		return insertQuery.toString();
	}

	private String createSelectQuery()
	{
		StringBuilder selectQuery = new StringBuilder();
		selectQuery.append("SELECT * FROM warehousedb.");
		selectQuery.append(type.getSimpleName());
		selectQuery.append(" WHERE id = ?");
		return selectQuery.toString();
	}

	private String createSelectAllQuery()
	{
		StringBuilder selectAllQuery = new StringBuilder();
		selectAllQuery.append("SELECT * FROM warehousedb.");
		selectAllQuery.append(type.getSimpleName());
		return selectAllQuery.toString();
	}

	private String createUpdateQuery(ArrayList<String> fields)
	{
		StringBuilder updateQuery = new StringBuilder();
		updateQuery.append("UPDATE warehousedb.");
		updateQuery.append(type.getSimpleName());
		updateQuery.append(" SET " + fields.get(0) + " = ?");
		for (int i = 1; i < fields.size(); i++)
		{
			updateQuery.append(", " + fields.get(i) + " = ?");
		}
		updateQuery.append(" WHERE id = ?");
		return updateQuery.toString();
	}

	private String createDeleteQuery()
	{
		StringBuilder selectQuery = new StringBuilder();
		selectQuery.append("DELETE FROM warehousedb.");
		selectQuery.append(type.getSimpleName());
		selectQuery.append(" WHERE id = ?");
		return selectQuery.toString();
	}

	/**
	 * Creates a new instance of the T class.
	 * For each field (attribute) of the class, extracts the value from the database and creates the corresponding setField() method.
	 * Call the setField(value) method.  
	 * 
	 * @param result
	 * @return the new created instance
	 */
	private T createObject(ResultSet result)
	{
		T instance = null;
		try
		{
			instance = type.newInstance();
			for (Field field : type.getDeclaredFields())
			{
				Object value = result.getObject(field.getName());
				PropertyDescriptor pd = new PropertyDescriptor(field.getName(), type);
				Method method = pd.getWriteMethod();
				method.invoke(instance, value);
			}
		} catch (InstantiationException | IllegalAccessException | SQLException | IntrospectionException
				| IllegalArgumentException | InvocationTargetException e)
		{
			e.printStackTrace();
		}
		return instance;
	}

	public boolean insert(T instance)
	{
		Connection connection = MysqlDAOFactory.createConnection();
		PreparedStatement statement = null;
		ArrayList<String> fields = new ArrayList<>();
		for (Field field : type.getDeclaredFields())
		{
			fields.add(field.getName());
		}
		String query = createInsertQuery(fields);
		try
		{
			statement = connection.prepareStatement(query);
			int i = 1;
			for (Field field : type.getDeclaredFields())
			{
				field.setAccessible(true);
				statement.setObject(i, field.get(instance));
				i++;
			}
			statement.execute();
		} catch (SQLException | IllegalArgumentException | IllegalAccessException e)
		{
			e.printStackTrace();
			return false;
		}
		MysqlDAOFactory.close(connection);
		MysqlDAOFactory.close(statement);
		return true;
	}

	public T select(int id)
	{
		T instance = null;
		Connection connection = MysqlDAOFactory.createConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		String query = createSelectQuery();
		try
		{
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			result = statement.executeQuery();
			if (result.next() && result != null)
			{
				instance = createObject(result);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		MysqlDAOFactory.close(connection);
		MysqlDAOFactory.close(statement);
		MysqlDAOFactory.close(result);
		return instance;
	}

	public ArrayList<T> selectAll()
	{
		ArrayList<T> objects = new ArrayList<>();
		Connection connection = MysqlDAOFactory.createConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		String query = createSelectAllQuery();
		try
		{
			statement = connection.prepareStatement(query);
			result = statement.executeQuery();
			while (result.next() && result != null)
			{
				objects.add(createObject(result));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		MysqlDAOFactory.close(connection);
		MysqlDAOFactory.close(statement);
		MysqlDAOFactory.close(result);
		return objects;
	}

	public String[] getFieldsName()
	{
		String[] fieldsName = new String[type.getDeclaredFields().length];
		int i = 0;
		for (Field field : type.getDeclaredFields())
		{
			fieldsName[i] = field.getName();
			i++;
		}
		return fieldsName;
	}

	public Object[][] getData()
	{
		ArrayList<T> objects = selectAll();
		Object[][] data = new Object[type.getClass().getDeclaredFields().length][objects.size()];
		int i = 0;
		int j = 0;
		for (Object object : objects)
		{
			for (Field field : object.getClass().getDeclaredFields())
			{
				field.setAccessible(true);
				try
				{
					data[i][j] = field.get(object);
				} catch (IllegalArgumentException | IllegalAccessException e)
				{
					e.printStackTrace();
				}
				j++;
			}
			j = 0;
			i++;
		}
		return data;
	}

	public void update(T instance)
	{
		Connection connection = MysqlDAOFactory.createConnection();
		PreparedStatement statement = null;
		ArrayList<String> fields = new ArrayList<>();
		Field[] declaredFields = type.getDeclaredFields();
		int size = declaredFields.length;
		for (int i = 1; i < size; i++)
		{
			fields.add(declaredFields[i].getName());
		}
		String query = createUpdateQuery(fields);
		try
		{
			statement = connection.prepareStatement(query);
			int i = size;
			for (Field field : declaredFields)
			{
				field.setAccessible(true);
				statement.setObject(i, field.get(instance));
				i = (i + 1) % size;
			}
			statement.execute();
		} catch (SQLException | IllegalArgumentException | IllegalAccessException e)
		{
			e.printStackTrace();
		}
		MysqlDAOFactory.close(connection);
		MysqlDAOFactory.close(statement);
	}

	public void delete(int id)
	{
		Connection connection = MysqlDAOFactory.createConnection();
		PreparedStatement statement = null;
		String query = createDeleteQuery();
		try
		{
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			statement.execute();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		MysqlDAOFactory.close(connection);
		MysqlDAOFactory.close(statement);
	}
}
