package pt2018.assign3.dao;

import pt2018.assign3.model.Product;

public class DataAccessProduct extends AbstractDAO<Product>
{
	
	public DataAccessProduct()
	{
		super();
	}
	
	public boolean insert(Product product)
	{
		return super.insert(product);
	}
	
	public Product select(int id)
	{
		return super.select(id);
	}
	
	public void update(Product product)
	{
		super.update(product);
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
