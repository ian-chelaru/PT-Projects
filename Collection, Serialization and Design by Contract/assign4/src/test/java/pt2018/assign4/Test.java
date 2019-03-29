package pt2018.assign4;

import static org.junit.Assert.*;

import pt2018.assign4.model.Account;
import pt2018.assign4.model.Bank;
import pt2018.assign4.model.Person;
import pt2018.assign4.model.SavingAccount;
import pt2018.assign4.model.SpendingAccount;

public class Test
{
	private Bank bank = new Bank();

	@org.junit.Test
	public void test()
	{
		Person person1 = new Person("Alex", "Muresan", "0744555666");
		Person person2 = new Person("Radu", "Garba", "0743222222");
		Person person3 = new Person("George", "Lar", "0742111111");
		Person person4 = new Person("Alex", "Muresan", "0744555666");
		Person person5 = new Person("Alexa", "Muresan", "0744555666");

		assertTrue(person2.equals(person2));
		assertFalse(person3.equals(null));
		assertTrue(person1.equals(person4));
		assertTrue(person4.equals(person1));
		assertEquals(person1.hashCode(), person4.hashCode());
		assertFalse(person1.equals(person5));
		assertFalse(person4.hashCode() == person5.hashCode());

		assertTrue(bank.getData().isEmpty());
		assertTrue(bank.isWellFormed());
		bank.addPerson(person1);
		assertTrue(bank.getData().containsKey(person1));
		assertFalse(bank.getData().isEmpty());
		assertTrue(bank.isWellFormed());
		assertTrue(bank.getData().get(person1).isEmpty());
		assertEquals(bank.getData().keySet().size(), 1);

		bank.removePerson(person1);
		assertFalse(bank.getData().containsKey(person1));
		assertTrue(bank.getData().isEmpty());
		assertTrue(bank.isWellFormed());

		bank.addPerson(person1);
		bank.addPerson(person2);
		bank.addPerson(person3);
		bank.addPerson(person5);
		assertTrue(bank.isWellFormed());
		assertEquals(bank.getData().keySet().size(), 4);
		assertTrue(bank.getData().values().size() == 4);

		bank.getData().values().forEach(value ->
		{
			assertTrue(value.isEmpty());
		});

		bank.removePerson(person5);
		assertTrue(bank.isWellFormed());
		assertFalse(bank.getData().containsKey(person5));
		assertEquals(bank.getData().keySet().size(), 3);

		Account account1 = new SavingAccount("1234", "Alex", "Muresan");
		Account account2 = new SavingAccount("9999", "Radu", "Garba");
		Account account3 = new SpendingAccount("8888", "Radu", "Garba");
		Account account4 = new SpendingAccount("1234", "Alex", "Muresan");
		Account account5 = new SavingAccount("1234", "Alex", "Muresan");
		
		account1.addMoney(200);
		assertTrue(account1.getSum() == 200);
		account1.withdrawMoney(100);
		assertTrue(account1.getSum() == 95);
		
		account4.addMoney(200);
		assertTrue(account4.getSum() == 200);
		account4.withdrawMoney(100);
		assertTrue(account4.getSum() == 100);

		assertTrue(account1.equals(account5));
		assertTrue(account5.equals(account1));
		assertFalse(account4.equals(account5));
		assertFalse(account2.equals(account3));
		assertEquals(account1.hashCode(), account5.hashCode());
		assertFalse(account4.hashCode() == account5.hashCode());
		assertFalse(account2.hashCode() == account3.hashCode());

		bank.addAccount(person1, account1);
		assertTrue(bank.isWellFormed());
		assertFalse(bank.getData().get(person1).isEmpty());
		assertTrue(bank.getData().get(person1).contains(account1));
		assertTrue(bank.getData().get(person1).size() == 1);
		
		bank.removeAccount(person1, account1);
		assertTrue(bank.isWellFormed());
		assertTrue(bank.getData().get(person1).isEmpty());
		assertTrue(!bank.getData().get(person1).contains(account1));
		
		bank.addAccount(person1, account1);
		bank.addAccount(person1, account4);
		bank.addAccount(person2, account2);
		bank.addAccount(person2, account3);
		assertTrue(bank.isWellFormed());
	}

}
