package pt2018.assign2.models;

import java.util.ArrayList;

/**
 * 
 * Queue class transpose the real world queue. The queue respects the FIFO principle.
 * The queue has a list of clients. Each client waits for its turn to be served.
 * The attribute len represents the number of clients presented in the queue (the size of the clients list).
 * The attribute running tells if the queue is available (open) for clients.
 * 
 * @author Ian Chelaru
 *
 */

public class Queue
{
	private ArrayList<Client> clients;
	private volatile boolean running;
	private volatile int len;

	/**
	 * Constructs and initializes a queue.
	 * The clients field is initialized with an empty list because at the beginning of the simulation there is no client in the queue.
	 * The len field is initialized with 0 because the client list is empty.
	 * The running field is initialized with true because the queue is available for the clients.
	 */
	
	public Queue()
	{
		this.clients = new ArrayList<>();
		this.running = true;
		this.len = 0;
	}

	public ArrayList<Client> getClients()
	{
		return clients;
	}

	public void setClients(ArrayList<Client> clients)
	{
		this.clients = clients;
	}

	public int getNumberOfClients()
	{
		return len;
	}

	public boolean getRunning()
	{
		return running;
	}

	public void setRunning(boolean running)
	{
		this.running = running;
	}

	/**
	 * Returns a string which represent the queue. The queue is represented by the list of the clients.
	 */
	@Override
	public String toString()
	{
		String s = "";
		for (Client client : clients)
		{
			s += String.valueOf(client.getId()) + " ";
		}
		return s;
	}

	/**
	 * The method has the purpose to add a client to the end of the queue.
	 * The method creates a new client and adds it to the end of the list.
	 * The size of the list increases by 1.
	 * @param id the unique id of the newly constructed client
	 * @param arTime arrivalTime the moment of time when the client enters a queue
	 * @param seTime serviceTime the amount of time a client needs to receive his service
	 */
	public void enQueue(int id, int arTime, int seTime)
	{
		Client client = new Client(id, arTime, seTime);
		clients.add(client);
		len++;
	}

	/**
	 * The method has the purpose to remove a client from the list.
	 * By FIFO principle, the client who has to be removed from the list is the first who entered the list
	 * (the one that occupies the position 0 from the list).
	 * The method remove() also shifts left all the elements from the list by one position.
	 * The size of the list decreases by 1.
	 */
	public void deQueue()
	{
		clients.remove(0);
		len--;
	}

}
