package pt2018.assign2.models;

/**
 * 
 * Client class transpose the real world client. Like in real world, a java object Client has a unique id,
 * enters the queue at a certain moment of time equal to the arrivalTime and is served a certain amount of
 * time equal to serviceTime.
 * Client class implements the Comparable interface and overrides the method compareTo(). Thus, two objects
 * of type Client can be compared.
 * 
 * @author Ian Chelaru 
 *
 */

public class Client implements Comparable<Client>
{
	private int id;
	private int arrivalTime;
	private int serviceTime;
	
	/**
	 * Constructs and initializes a client.
	 * @param id the unique id of the newly constructed client
	 * @param arrivalTime the moment of time when the client enters a queue
	 * @param serviceTime the amount of time a client needs to receive his service
	 */

	public Client(int id, int arrivalTime, int serviceTime)
	{
		this.id = id;
		this.arrivalTime = arrivalTime;
		this.serviceTime = serviceTime;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getArrivalTime()
	{
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime)
	{
		this.arrivalTime = arrivalTime;
	}

	public int getServiceTime()
	{
		return serviceTime;
	}

	public void setServiceTime(int serviceTime)
	{
		this.serviceTime = serviceTime;
	}

	/**
	 * Returns a string which represents the client. The string shortly presents the useful information about the client.
	 */
	@Override
	public String toString()
	{
		String s = "C(" + String.valueOf(id) + " " + String.valueOf(arrivalTime) + " " + String.valueOf(serviceTime)
				+ ")";
		return s;
	}

	/**
	 * Provides the ability to compare two objects of type Client with respect to their arrival time.
	 * This client is considered to be smaller than the object "client" transmitted as a parameter if
	 * the arrivalTime of this client is smaller than the arrivalTime of the object "client".
	 */
	@Override
	public int compareTo(Client client)
	{
		return this.arrivalTime - client.getArrivalTime();
	}

}
