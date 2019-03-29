package pt2018.assign4.model;

/**
 * 
 * @invariant isWellFormed
 *
 */

public interface BankProc
{
	/**
	 * 
	 * @pre person != null
	 * @pre !data.containsKey(person)
	 * @post data.size() == data.size()@pre + 1
	 * @post data.containsKey(person)
	 */
	public void addPerson(Person person);
	
	
	/**
	 * 
	 * @pre person != null
	 * @pre data.containsKey(person)
	 * @post data.size() == data.size()@pre - 1
	 * @post !data.containsKey(person)
	 */
	public void removePerson(Person person);
	
	
	/**
	 * 
	 * @pre account != null
	 * @pre data.constainsKey(person)
	 * @pre !data.get(person).contains(account)
	 * @post data.get(person).size() == data.get(person).size()@pre + 1;
	 * @post data.get(person).contains(account)
	 */
	public void addAccount(Person person, Account account);
	
	
	/**
	 * 
	 * @pre account != null
	 * @pre data.containsKey(person)
	 * @pre data.get(person).contains(account)
	 * @post data.get(person).size() == data.get(person).size()@pre - 1;
	 * @post !data.get(person).contains(account)
	 */
	public void removeAccount(Person person, Account account);
		
	
	public void readData();
	public void writeData();
	
	public boolean isWellFormed();
}
