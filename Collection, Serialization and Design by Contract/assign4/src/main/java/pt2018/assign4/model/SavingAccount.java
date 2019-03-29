package pt2018.assign4.model;

import java.util.Date;

@SuppressWarnings("serial")
public class SavingAccount extends Account
{
	public SavingAccount(String accountNumber, String holderFirstName, String holderLastName)
	{
		super(accountNumber, holderFirstName, holderLastName);
		this.type = AccountType.SAVING;
	}
	
	@Override
	public void addMoney(double money)
	{
		double interest = 3 * money / 100;
		money -= interest;
		sum += money;
		sum = Math.round(sum * 100) / 100.0;
	}

	@Override
	public void withdrawMoney(double money)
	{
		double interest = 5 * money / 100;
		sum -= money;
		sum -= interest;
		sum = Math.round(sum * 100) / 100.0;
	}
	
	@Override
	public void updateSum()
	{
		Date date = new Date();
		long minutes = (date.getTime() - startDate.getTime()) / 60000;
		for (int i = 0; i < minutes; i++)
		{
			double interest = sum / 100;
			sum += interest;
			sum = Math.round(sum * 100) / 100.0;
		}
		startDate = date;
	}

}
