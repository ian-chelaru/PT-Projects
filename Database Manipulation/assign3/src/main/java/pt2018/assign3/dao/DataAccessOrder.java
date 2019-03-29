package pt2018.assign3.dao;

import pt2018.assign3.model.Order;

public class DataAccessOrder extends AbstractDAO<Order>
{

	public DataAccessOrder()
	{
		super();
	}
	
	public boolean insert(Order order)
	{
		return super.insert(order);
	}
	
	public Order select(int id)
	{
		return super.select(id);
	}
	
	public void update(Order order)
	{
		super.update(order);
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
