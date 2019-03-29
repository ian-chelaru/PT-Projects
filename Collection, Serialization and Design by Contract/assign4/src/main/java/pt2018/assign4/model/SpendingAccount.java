package pt2018.assign4.model;

@SuppressWarnings("serial")
public class SpendingAccount extends Account
{
	public SpendingAccount(String accountNumber, String holderFirstName, String holderLastName)
	{
		super(accountNumber, holderFirstName, holderLastName);
		this.type = AccountType.SPENDING;
	}
	
}
