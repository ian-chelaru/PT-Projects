package pt2018.assign4.model;

@SuppressWarnings("serial")
public class Person implements java.io.Serializable
{
	private final String firstName;
	private final String lastName;
	private final String phone;
	
	public Person(String firstName, String lastName, String phone)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public String getPhone()
	{
		return phone;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode()); 
		return result;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj == this)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		Person other = (Person) obj;
		if (firstName == null)
		{
			if (other.firstName != null)
			{
				return false;
			}
		}
		else if (!firstName.equals(other.firstName))
		{
			return false;
		}
		if (lastName == null)
		{
			if (other.lastName != null)
			{
				return false;
			}
		}
		else if (!lastName.equals(other.lastName))
		{
			return false;
		}
		if (phone == null)
		{
			if (other.phone != null)
			{
				return false;
			}
		}
		else if (!phone.equals(other.phone))
		{
			return false;
		}
		return true;
	}
	
	@Override
	public String toString()
	{
		return firstName + " " + lastName + " " + phone;
	}
	
}
