package pt2018.assign3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * MysqlDAOFactory has the purpose to create and close the connection to a database.
 * The class uses overloading to create more close() methods which close the objects used to communicate with the database.
 * 
 * @author Ian Chelaru
 *
 */

public class MysqlDAOFactory
{
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/warehousedb?useSSL=false";
	private static final String USER = "root";
	private static final String PASS = "";

	private static Connection connection;

	private MysqlDAOFactory()
	{
		try
		{
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	public static Connection createConnection()
	{
		connection = null;
		new MysqlDAOFactory();
		try
		{
			connection = (Connection) DriverManager.getConnection(DBURL, USER, PASS);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return connection;
	}

	public static Connection getConnection()
	{
		return connection;
	}

	/**
	 * Close the connection to a database
	 * 
	 * @param connection the connection which will be closed
	 */
	public static void close(Connection connection)
	{
		try
		{
			connection.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Close a statement. 
	 * 
	 * @param statement the statement which will be closed
	 */
	public static void close(Statement statement)
	{
		try
		{
			statement.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Close a result set.
	 * 
	 * @param resultSet the result set which will be closed
	 */
	public static void close(ResultSet resultSet)
	{
		try
		{
			resultSet.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

}
