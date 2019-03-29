package pt2018.assign2.controllers;

import pt2018.assign2.models.Client;
import pt2018.assign2.models.Queue;
import pt2018.assign2.views.EventsView;

/**
 * 
 * QueueController class implements the Runnable interface which provides the ability to create and run threads.
 * QueueController class has the purpose of running a thread queue and displaying events.
 * The queue attribute represents the queue on which the thread is applied.
 * The viewEvents attribute is the frame in which information about the state of the simulation will be displayed.
 * 
 * @author Ian Chelaru
 *
 */

public class QueueController implements Runnable
{
	private Queue queue;
	private EventsView viewEvents;

	/**
	 * 
	 * Constructs and initializes a queue controller.
	 * 
	 * @param queue the queue on which the thread is applied
	 * @param viewEvents the frame in which information about the state of the simulation will be displayed
	 */
	
	public QueueController(Queue queue, EventsView viewEvents)
	{
		this.queue = queue;
		this.viewEvents = viewEvents;
	}

	/**
	 * The threads created for this class will execute the sequence of instruction written in this method.
	 * 
	 * The thread is executed while the queue is available. The first client from the queue is taken and
	 * the thread is stopped until the client is finished being served. Then, the client is removed from 
	 * the queue.
	 */
	
	@Override
	public void run()
	{
		while (queue.getRunning())
		{
			if (queue.getNumberOfClients() > 0)
			{
				Client client = queue.getClients().get(0);
				while (client.getServiceTime() > 0)
				{
					client.setServiceTime(client.getServiceTime() - 1);
					try
					{
						Thread.sleep(1000);
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				displayEvent(client);
				queue.deQueue();
			}
		}
	}

	/**
	 * Stops the execution of the thread by making the queue unavailable.
	 */
	
	public void stop()
	{
		queue.setRunning(false);
	}

	public void displayEvent(Client client)
	{
		String event = "\t" + client.toString() + " leaved the queue" + "\n";
		viewEvents.getTextArea().append(event);
	}
}
