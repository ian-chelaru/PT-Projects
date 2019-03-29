package pt2018.assign3.model;

public class Client
{

	private int id;
	private String name;
	private String address;
	private String city;
	private String email;

	public Client()
	{

	}

	public Client(int id, String name, String address, String city, String email)
	{
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.email = email;
	}

	public Client(String name, String address, String city, String email)
	{
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.email = email;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	@Override
	public String toString()
	{
		return id + " " + name + " " + address + " " + city + " " + email;
	}

}
