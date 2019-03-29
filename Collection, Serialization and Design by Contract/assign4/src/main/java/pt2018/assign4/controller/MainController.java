package pt2018.assign4.controller;

import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.Set;

import pt2018.assign4.model.Account;
import pt2018.assign4.model.AccountType;
import pt2018.assign4.model.Bank;
import pt2018.assign4.model.Person;
import pt2018.assign4.model.SavingAccount;
import pt2018.assign4.model.SpendingAccount;
import pt2018.assign4.view.EditAccount;
import pt2018.assign4.view.EditPerson;
import pt2018.assign4.view.ViewAccounts;
import pt2018.assign4.view.ViewMoney;
import pt2018.assign4.view.ViewPersons;

public class MainController
{
	private Bank bank = new Bank();
	private ViewPersons viewPersons = new ViewPersons();
	private ViewAccounts viewAccounts = new ViewAccounts();
	private EditAccount editAccount = new EditAccount();
	private EditPerson editPerson = new EditPerson();
	private ViewMoney viewMoney = new ViewMoney();
	private int personRowIndex;
	private int accountRowIndex;

	public MainController()
	{
		personRowIndex = -1;
		accountRowIndex = -1;
		bank.readData();
		showPersonsData();
		
		viewPersons.setVisible(true);

		viewPersons.actionListenerForAddPerson(al ->
		{
			Object[] row = new Object[3];
			row[0] = viewPersons.getFirstNameTf().getText();
			row[1] = viewPersons.getLastNameTf().getText();
			row[2] = viewPersons.getPhoneTf().getText();
			Person person = new Person((String) row[0], (String) row[1], (String) row[2]);
			bank.addPerson(person);
			viewPersons.getModel().addRow(row);
			viewPersons.clearTextFields();
		});

		viewPersons.actionListenerForDeletePerson(al ->
		{
			try
			{
				Person person = constructPersonFromModel(personRowIndex);
				bank.removePerson(person);
				viewPersons.getModel().removeRow(personRowIndex);
				personRowIndex = -1;
			} catch (ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Please select a person to delete");
			}
		});

		viewPersons.actionListenerForEditPersons(al ->
		{
			try
			{
				Object firstName = viewPersons.getModel().getValueAt(personRowIndex, 0);
				Object lastName = viewPersons.getModel().getValueAt(personRowIndex, 1);
				Object phone = viewPersons.getModel().getValueAt(personRowIndex, 2);
				editPerson.setVisible(true);
				editPerson.getFirstNameTf().setText((String) firstName);
				editPerson.getLastNameTf().setText((String) lastName);
				editPerson.getPhoneTf().setText((String) phone);
				viewPersons.disableButtons();
			} catch (ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Please select a person to edit");
			}
		});

		editPerson.addWindowListener(new java.awt.event.WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				viewPersons.enableButtons();
			}
		});

		viewPersons.actionListenerForViewPersonAccounts(al ->
		{
			try
			{
				Person person = constructPersonFromModel(personRowIndex);
				showPersonAccounts(person);
				viewPersons.disableButtons();
				viewAccounts.setVisible(true);
				viewAccounts.getHolderFirstNameTf().setText(person.getFirstName());
				viewAccounts.getHolderLastNameTf().setText(person.getLastName());
			} catch (ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Please select a person to view his/her accounts");
			}
		});

		viewPersons.actionListenerForViewAccounts(al ->
		{
			showAccountsData();
			viewAccounts.disableButtons();
			viewAccounts.setVisible(true);
			viewPersons.disableButtons();
		});

		viewPersons.addWindowListener(new java.awt.event.WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				System.out.println(bank.toString());
				bank.writeData();
			}
		});

		viewPersons.getTable().addMouseListener(new java.awt.event.MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				personRowIndex = viewPersons.getTable().rowAtPoint(e.getPoint());
			}
		});

		viewAccounts.actionListenerForAddAccount(al ->
		{
			try
			{
				Person person = constructPersonFromModel(personRowIndex);
				String accountNumber = viewAccounts.getAccountNumberTf().getText();
				Object type = viewAccounts.getBox().getSelectedItem();
				Account account;
				if (type.equals("Saving"))
				{
					account = new SavingAccount(accountNumber, person.getFirstName(), person.getLastName());
				} else
				{
					account = new SpendingAccount(accountNumber, person.getFirstName(), person.getLastName());
				}
				bank.addAccount(person, account);
				Object[] row = { account.getAccountNumber(), account.getSum(), account.getHolderFirstName(),
						account.getHolderLastName(), account.getType() };
				viewAccounts.getModel().addRow(row);
				viewAccounts.clearTextFields();
			} catch (ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Please select a person to add an account");
			}
		});

		viewAccounts.actionListenerForDeleteAccount(al ->
		{
			try
			{
				Person person = constructPersonFromModel(personRowIndex);
				Account account = constructAccountFromModel(accountRowIndex);
				bank.removeAccount(person, account);
				viewAccounts.getModel().removeRow(accountRowIndex);
				accountRowIndex = -1;
			} catch (ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Please select an account to delete");
			}
		});

		editPerson.actionListenerForEdit(al ->
		{
			Person oldPerson = constructPersonFromModel(personRowIndex);
			String newFirstName = editPerson.getFirstNameTf().getText();
			String newLastName = editPerson.getLastNameTf().getText();
			String newPhone = editPerson.getPhoneTf().getText();
			Person newPerson = new Person(newFirstName, newLastName, newPhone);
			bank.addPerson(newPerson);
			transferAccounts(oldPerson, newPerson);
			bank.removePerson(oldPerson);
			viewPersons.getModel().setRowCount(0);
			showPersonsData();
			editPerson.dispose();
			viewPersons.enableButtons();
		});

		editAccount.actionListenerForEdit(al ->
		{
			Person person = constructPersonFromModel(personRowIndex);
			Account oldAccount = constructAccountFromModel(accountRowIndex);
			String newAccountNumber = editAccount.getAccountNumberTf().getText();
			Account newAccount;
			if (oldAccount.getType() == AccountType.SAVING)
			{
				newAccount = new SavingAccount(newAccountNumber, oldAccount.getHolderFirstName(),
						oldAccount.getHolderLastName());
			} else
			{
				newAccount = new SpendingAccount(newAccountNumber, oldAccount.getHolderFirstName(),
						oldAccount.getHolderLastName());
			}
			newAccount.setSum((Double)viewAccounts.getModel().getValueAt(accountRowIndex, 1));
			bank.removeAccount(person, oldAccount);
			bank.addAccount(person, newAccount);
			viewAccounts.getModel().setRowCount(0);
			showPersonAccounts(person);
			editAccount.dispose();
			viewAccounts.enableButtons();
		});

		editAccount.addWindowListener(new java.awt.event.WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				viewAccounts.enableButtons();
			}
		});

		viewAccounts.actionListenerForEditAccount(al ->
		{
			try
			{
				Object accountNumber = viewAccounts.getModel().getValueAt(accountRowIndex, 0);
				editAccount.setVisible(true);
				editAccount.getAccountNumberTf().setText((String) accountNumber);
				viewAccounts.disableButtons();
			} catch (ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Please select an account to edit");
			}
		});

		viewAccounts.actionListenerForAddWithdrawMoney(al ->
		{
			if (accountRowIndex == -1)
			{
				System.out.println("Please select an account");
			} else
			{
				viewMoney.getSumTf().setText("");
				viewMoney.setVisible(true);
				viewAccounts.disableButtons();
			}
		});

		viewMoney.actionListenerForAddMoney(al ->
		{
			String money = viewMoney.getSumTf().getText();
			try
			{
				double sum = Double.parseDouble(money);
				Person person = constructPersonFromModel(personRowIndex);
				Account account = constructAccountFromModel(accountRowIndex);
				bank.removeAccount(person, account);
				account.setSum((Double)viewAccounts.getModel().getValueAt(accountRowIndex, 1));
				account.addMoney(sum);
				bank.addAccount(person, account);
				viewAccounts.getModel().setRowCount(0);
				showPersonAccounts(person);
				viewMoney.dispose();
				viewAccounts.enableButtons();
			} catch (NumberFormatException e)
			{
				System.out.println("Invalid sum");
			}
		});

		viewMoney.actionListenerForWithdrawMoney(al ->
		{
			String money = viewMoney.getSumTf().getText();
			try
			{
				double sum = Double.parseDouble(money);
				Person person = constructPersonFromModel(personRowIndex);
				Account account = constructAccountFromModel(accountRowIndex);
				account.setSum((Double)viewAccounts.getModel().getValueAt(accountRowIndex, 1));
				if (account.getSum() < sum)
				{
					System.out.println("Not enough funds");
				}
				else
				{
					bank.removeAccount(person, account);
					account.withdrawMoney(sum);
					bank.addAccount(person, account);
					viewAccounts.getModel().setRowCount(0);
					showPersonAccounts(person);
					viewMoney.dispose();
					viewAccounts.enableButtons();
				}
			} catch (NumberFormatException e)
			{
				System.out.println("Invalid sum");
			}
		});

		viewMoney.addWindowListener(new java.awt.event.WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				viewAccounts.enableButtons();
			}
		});

		viewAccounts.addWindowListener(new java.awt.event.WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				viewAccounts.getModel().setRowCount(0);
				viewAccounts.enableButtons();
				viewPersons.enableButtons();
				accountRowIndex = -1;
			}
		});

		viewAccounts.getTable().addMouseListener(new java.awt.event.MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				accountRowIndex = viewAccounts.getTable().rowAtPoint(e.getPoint());
			}
		});

	}

	public void showPersonsData()
	{
		Set<Person> setPersons = bank.getData().keySet();
		setPersons.forEach(person ->
		{
			Object[] row = { person.getFirstName(), person.getLastName(), person.getPhone() };
			viewPersons.getModel().addRow(row);
		});
	}

	public void showAccountsData()
	{
		Set<Person> setPersons = bank.getData().keySet();
		setPersons.forEach(person ->
		{
			showPersonAccounts(person);
		});
	}

	public void showPersonAccounts(Person person)
	{
		Set<Account> setAccounts = bank.getData().get(person);
		setAccounts.forEach(account ->
		{
			account.updateSum();
			Object[] row = { account.getAccountNumber(), account.getSum(), account.getHolderFirstName(),
					account.getHolderLastName(), account.getType() };
			viewAccounts.getModel().addRow(row);
		});
	}

	public Person constructPersonFromModel(int personRowIndex)
	{
		Object firstName = viewPersons.getModel().getValueAt(personRowIndex, 0);
		Object lastName = viewPersons.getModel().getValueAt(personRowIndex, 1);
		Object phone = viewPersons.getModel().getValueAt(personRowIndex, 2);
		Person person = new Person((String) firstName, (String) lastName, (String) phone);
		return person;
	}

	public Account constructAccountFromModel(int accountRowIndex)
	{
		Object accountNumber = viewAccounts.getModel().getValueAt(accountRowIndex, 0);
		Object holderFirstName = viewAccounts.getModel().getValueAt(accountRowIndex, 2);
		Object holderLastName = viewAccounts.getModel().getValueAt(accountRowIndex, 3);
		Object type = viewAccounts.getModel().getValueAt(accountRowIndex, 4);
		Account account;
		if (((AccountType) type) == AccountType.SAVING)
		{
			account = new SavingAccount((String) accountNumber, (String) holderFirstName, (String) holderLastName);
		} else
		{
			account = new SpendingAccount((String) accountNumber, (String) holderFirstName, (String) holderLastName);
		}
		return account;
	}

	public void transferAccounts(Person oldPerson, Person newPerson)
	{
		Set<Account> oldAccounts = bank.getData().get(oldPerson);
		oldAccounts.forEach(oldAccount ->
		{
			Account newAccount;
			if (oldAccount.getType() == AccountType.SAVING)
			{
				newAccount = new SavingAccount(oldAccount.getAccountNumber(), newPerson.getFirstName(),
						newPerson.getLastName());
			} else
			{
				newAccount = new SpendingAccount(oldAccount.getAccountNumber(), newPerson.getFirstName(),
						newPerson.getLastName());
			}
			newAccount.setSum(oldAccount.getSum());
			bank.addAccount(newPerson, newAccount);
		});
	}
	
}
