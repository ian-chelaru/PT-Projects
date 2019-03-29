package pt2018.assign4.model;

import java.util.Date;

@SuppressWarnings("serial")
public class Account implements java.io.Serializable
{
	protected final String accountNumber;
	protected double sum;
	protected final String holderFirstName;
	protected final String holderLastName;
	protected AccountType type;
	protected Date startDate;
	
	public Account(String accountNumber, String holderFirstName, String holderLastName)
	{
		this.accountNumber = accountNumber;
		this.sum = 0;
		this.holderFirstName = holderFirstName;
		this.holderLastName = holderLastName;
		this.startDate = new Date();
	}

	public String getAccountNumber()
	{
		return accountNumber;
	}

	public double getSum()
	{
		return sum;
	}
	
	public void setSum(double sum)
	{
		this.sum = sum;
	}

	public String getHolderFirstName()
	{
		return holderFirstName;
	}

	public String getHolderLastName()
	{
		return holderLastName;
	}

	public AccountType getType()
	{
		return type;
	}
	
	public void addMoney(double money)
	{
		sum += money;
	}
	
	public void withdrawMoney(double money)
	{
		sum -= money;
	}
	
	public void updateSum()
	{
		
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((holderFirstName == null) ? 0 : holderFirstName.hashCode());
		result = prime * result + ((holderLastName == null) ? 0 : holderLastName.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
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
		Account other = (Account) obj;
		if (accountNumber == null)
		{
			if (other.accountNumber != null)
			{
				return false;
			}
		}
		else if (!accountNumber.equals(other.accountNumber))
		{
				return false;
		}
		if (holderFirstName == null)
		{
			if (other.holderFirstName != null)
			{
				return false;
			}
		}
		else if (!holderFirstName.equals(other.holderFirstName))
		{
			return false;
		}
		if (holderLastName == null)
		{
			if (other.holderLastName != null)
			{
				return false;
			}
		}
		else if (!holderLastName.equals(other.holderLastName))
		{
			return false;
		}
		if (type != other.type)
		{
			return false;
		}
		return true;
	}
	
	@Override
	public String toString()
	{
		return accountNumber + " " + sum + " " + holderFirstName + " " + holderLastName + " " + type;
	}

}
