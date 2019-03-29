package pt2018.assign3.dao;

import pt2018.assign3.model.Client;

public class DataAccessClient extends AbstractDAO<Client>
{
	
	public DataAccessClient()
	{
		super();
	}
	
	public boolean insert(Client client)
	{
		return super.insert(client);
	}
	
	public Client select(int id)
	{
		return super.select(id);
	}
	
	public void update(Client client)
	{
		super.update(client);
	}
	
	public void delete(int id)
	{
		super.delete(id);
	}
	
	public String[] getFieldsName()
	{
		return super.getFieldsName();
	}
	
	public Object[][] getData()
	{
		return super.getData();
	}
	
}