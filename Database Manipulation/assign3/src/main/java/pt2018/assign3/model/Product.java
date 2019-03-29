package pt2018.assign3.model;

public class Product
{
	
	private int id;
	private String description;
	private double pricePerUnit;
	private int quantity;
	
	public Product()
	{
		
	}
	
	public Product(int id, String description, double pricePerUnit, int quantity)
	{
		super();
		this.id = id;
		this.description = description;
		this.pricePerUnit = pricePerUnit;
		this.quantity = quantity;
	}
	
	public Product(String description, double pricePerUnit, int quantity)
	{
		super();
		this.description = description;
		this.pricePerUnit = pricePerUnit;
		this.quantity = quantity;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public double getPricePerUnit()
	{
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit)
	{
		this.pricePerUnit = pricePerUnit;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	@Override
	public String toString()
	{
		return id + " " + description + " " + pricePerUnit + " " + quantity;
	}
	
}
