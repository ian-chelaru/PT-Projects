package pt2018.assign3.business;

import pt2018.assign3.dao.DataAccessClient;
import pt2018.assign3.model.Client;

public class ClientBLL
{
	private DataAccessClient clientDAO;
	
	public ClientBLL()
	{
		clientDAO = new DataAccessClient();
	}
	
	public boolean insertClient(Client client)
	{
		return clientDAO.insert(client);
	}
	
	/**
	 * Updates a client.
	 * If one of the client attributes is null then the old client respective attribute is kept.
	 * 
	 * @param client
	 */
	
	public void updateClientById(Client client)
	{
		Client oldClient = clientDAO.select(client.getId());
		if (client.getName().isEmpty())
		{
			client.setName(oldClient.getName());
		}
		if (client.getAddress().isEmpty())
		{
			client.setAddress(oldClient.getAddress());
		}
		if (client.getCity().isEmpty())
		{
			client.setCity(oldClient.getCity());
		}
		if (client.getEmail().isEmpty())
		{
			client.setEmail(oldClient.getEmail());
		}
		clientDAO.update(client);
	}
	
	public void deleteClientById(int id)
	{
		clientDAO.delete(id);
	}
	
	public String[] getClientFieldsName()
	{
		return clientDAO.getFieldsName();
	}
	
	public Object[][] getClientData()
	{
		return clientDAO.getData();
	}
	
}
