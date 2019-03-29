package pt2018.assign3.business;

import pt2018.assign3.dao.DataAccessOrder;
import pt2018.assign3.model.Order;

public class OrderBLL
{

	private DataAccessOrder orderDAO;
	
	public OrderBLL()
	{
		orderDAO = new DataAccessOrder();
	}
	
	public boolean insertOrder(Order order)
	{
		return orderDAO.insert(order);
	}
	
	public String[] getOrderFieldsName()
	{
		return orderDAO.getFieldsName();
	}
	
	public Object[][] getOrderData()
	{
		return orderDAO.getData();
	}
	
}
