package pt2018.assign3.model;

public class Order
{

	private int id;
	private int idClient;
	private int idProduct;
	private int amount;
	private String status;
	
	public Order()
	{
		
	}
	
	public Order(int idClient, int idProduct, int amount, String status)
	{
		super();
		this.idClient = idClient;
		this.idProduct = idProduct;
		this.amount = amount;
		this.status = status;
	}

	public Order(int id, int idClient, int idProduct, int amount, String status)
	{
		super();
		this.id = id;
		this.idClient = idClient;
		this.idProduct = idProduct;
		this.amount = amount;
		this.status = status;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getIdClient()
	{
		return idClient;
	}

	public void setIdClient(int idClient)
	{
		this.idClient = idClient;
	}

	public int getIdProduct()
	{
		return idProduct;
	}

	public void setIdProduct(int idProduct)
	{
		this.idProduct = idProduct;
	}

	public int getAmount()
	{
		return amount;
	}

	public void setAmount(int amount)
	{
		this.amount = amount;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}
	
	@Override
	public String toString()
	{
		return id + " " + idClient + " " + idProduct + " " + amount + " " + status;
	}
		
}
