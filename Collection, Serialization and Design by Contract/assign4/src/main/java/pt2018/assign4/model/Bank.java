package pt2018.assign4.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("serial")
public class Bank implements BankProc, java.io.Serializable
{
	private HashMap<Person, HashSet<Account>> data;
	
	public Bank()
	{
		data = new HashMap<>();
	}
	
	public HashMap<Person, HashSet<Account>> getData()
	{
		return data;
	}
	
	@Override
	public void addPerson(Person person)
	{
		assert person != null;
		assert !data.containsKey(person);
		assert isWellFormed();
		int sizePre = data.size();
		data.put(person, new HashSet<Account>());
		int sizePost = data.size();
		assert sizePost == sizePre + 1;
		assert data.containsKey(person);
		assert isWellFormed();
	}

	@Override
	public void removePerson(Person person)
	{
		assert person != null;
		assert data.containsKey(person);
		assert isWellFormed();
		int sizePre = data.size();
		data.remove(person);
		int sizePost = data.size();
		assert sizePost == sizePre - 1;
		assert !data.containsKey(person);
		assert isWellFormed();
	}
	
	@Override
	public void addAccount(Person person, Account account)
	{
		assert account != null;
		assert data.containsKey(person);
		assert !data.get(person).contains(account);
		assert isWellFormed();
		int sizePre = data.get(person).size();
		data.get(person).add(account);
		int sizePost = data.get(person).size();
		assert sizePost == sizePre + 1;
		assert data.get(person).contains(account);
		assert isWellFormed();
	}

	@Override
	public void removeAccount(Person person, Account account)
	{
		assert account != null;
		assert data.containsKey(person);
		assert data.get(person).contains(account);
		assert isWellFormed();
		int sizePre = data.get(person).size();
		data.get(person).remove(account);
		int sizePost = data.get(person).size();
		assert sizePost == sizePre - 1;
		assert !data.get(person).contains(account);
		assert isWellFormed();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void readData()
	{
		try
		{
			FileInputStream fileIn = new FileInputStream("bank.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			data = (HashMap<Person, HashSet<Account>>) in.readObject();
			in.close();
			fileIn.close();
		}
		catch (IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		assert isWellFormed();
	}

	@Override
	public void writeData()
	{
		assert isWellFormed();
		try
		{
			FileOutputStream fileOut = new FileOutputStream("bank.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(data);
			out.close();
			fileOut.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString()
	{
		String s = "";
		for (Person person : data.keySet())
		{
			s += person.toString();
			s += " has " + data.get(person).size() + " accounts:";
			s += "\n";
			for (Account account : data.get(person))
			{
				s += "\t";
				s += account.toString();
				s += "\n";
			}
		}
		return s;
	}
	
	@Override
	public boolean isWellFormed()
	{
		int n = 0;
		for (Person person : data.keySet())
		{
			int m = 0;
			for (Account account : data.get(person))
			{
				if (!account.getHolderFirstName().equals(person.getFirstName()))
				{
					return false;
				}
				if (!account.getHolderLastName().equals(person.getLastName()))
				{
					return false;
				}
				if (account.getSum() < 0)
				{
					return false;
				}
				m++;
			}
			if (m != data.get(person).size())
			{
				return false;
			}
			n++;
		}
		return n == data.size();
	}

}
