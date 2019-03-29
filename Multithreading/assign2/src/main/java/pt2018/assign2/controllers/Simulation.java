package pt2018.assign2.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

import pt2018.assign2.models.*;
import pt2018.assign2.views.EventsView;

/**
 * 
 * Simulation class has the purpose to create and execute the simulation.
 * Simulation class implements the Runnable interface which provides the ability
 * to create and run threads The generatedClients attribute is a list of clients
 * which contains every single client who takes part to the simulation (every
 * client from this list will enter a queue at a certain time of the
 * simulation). The generatedQueues attribute represents the list of available
 * queues (clients can enter these queues). The queueControllers attribute
 * represents the list of queues' controllers. Each queue from the
 * generatedQueues has a corresponding queue controller. The simulationTime
 * attribute represents how many seconds the simulation takes place. The
 * viewEvents attribute is the frame in which information about the state of the
 * simulation will be displayed.
 * 
 * 
 * @author Ian Chelaru
 *
 */

public class Simulation implements Runnable
{
	private ArrayList<Client> generatedClients;
	private ArrayList<Queue> generatedQueues;
	private ArrayList<QueueController> queueControllers = new ArrayList<>();
	private int simulationTime;
	private EventsView viewEvents = new EventsView();
	private int peakTime;
	private int peakAmountOfClients;
	private int averageWaitingTime;
	private int noOfClients;

	/**
	 * 
	 * Constructs and initializes a new simulation. Generates the list of
	 * clients and the list of queues. For each queue, creates a queue
	 * controller which creates and starts a queue thread. Initializes the frame
	 * to display the simulation.
	 * 
	 * @param simulationTime
	 *            the number of seconds the simulation lasts
	 * @param noOfClients
	 *            the number of clients which are part of the simulation
	 * @param noOfQueues
	 *            the number of available queues
	 * @param minArTime
	 *            the lower bound of the arrival time for each client
	 * @param maxArTime
	 *            the upper bound of the arrival time for each client
	 * @param minSeTime
	 *            the lower bound of the service time for each client
	 * @param maxSeTime
	 *            the upper bound of the service time for each client
	 */

	public Simulation(int simulationTime, int noOfClients, int noOfQueues, int minArTime, int maxArTime, int minSeTime,
			int maxSeTime)
	{
		this.generatedClients = generateClients(noOfClients, minArTime, maxArTime, minSeTime, maxSeTime);
		this.generatedQueues = generateQueues(noOfQueues);
		this.simulationTime = simulationTime;
		this.averageWaitingTime = 0;
		this.peakAmountOfClients = 0;
		this.noOfClients = noOfClients;
		generatedQueues.forEach(queue ->
		{
			QueueController queueC = new QueueController(queue, viewEvents);
			queueControllers.add(queueC);
			Thread t = new Thread(queueC);
			t.start();
		});
		this.viewEvents.setVisible(true);
	}

	/**
	 * 
	 * Generates a list of clients. For each client the arrival time and the
	 * service time is randomly generated with the restriction to be in between
	 * the specified bounds (inclusively). The list of clients is ascending
	 * sorted with respect to the arrival time.
	 * 
	 * @param noOfClients
	 *            the number of clients that will be generated
	 * @param minArTime
	 *            the lower bound of the arrival time for each client
	 * @param maxArTime
	 *            the upper bound of the arrival time for each client
	 * @param minSeTime
	 *            the lower bound of the service time for each client
	 * @param maxSeTime
	 *            the upper bound of the service time for each client
	 * @return the newly generated list of clients
	 */

	public ArrayList<Client> generateClients(int noOfClients, int minArTime, int maxArTime, int minSeTime,
			int maxSeTime)
	{
		ArrayList<Client> clients = new ArrayList<>();
		Random random = new Random();
		for (int i = 1; i <= noOfClients; i++)
		{
			int arTime = random.nextInt(maxArTime - minArTime + 1) + minArTime;
			int seTime = random.nextInt(maxSeTime - minSeTime + 1) + minSeTime;
			Client client = new Client(i, arTime, seTime);
			clients.add(client);
		}
		Collections.sort(clients);
		return clients;
	}

	/**
	 * 
	 * Generates a list of empty queues.
	 * 
	 * @param noOfQueues
	 *            the number of queues which will be generated
	 * @return the newly generated list of queues
	 */

	public ArrayList<Queue> generateQueues(int noOfQueues)
	{
		ArrayList<Queue> queues = new ArrayList<>();
		for (int i = 0; i < noOfQueues; i++)
		{
			Queue queue = new Queue();
			queues.add(queue);
		}
		return queues;
	}

	/**
	 * 
	 * @return the position (in the generatedQueues list) of the queue with the
	 *         smallest number of clients
	 */

	public int getShortestQueue()
	{
		int pos = 0;
		int min = generatedQueues.get(0).getNumberOfClients();
		for (int i = 1; i < generatedQueues.size(); i++)
		{
			int size = generatedQueues.get(i).getNumberOfClients();
			if (size < min)
			{
				min = size;
				pos = i;
			}
		}
		return pos;
	}

	/**
	 * The threads created for this class will execute the sequence of
	 * instruction written in this method.
	 * 
	 * The simulation starts at the runtime 0 and finishes when the current time
	 * is greater than the simulation time. At each step of execution, the
	 * clients which have the arrival time equal to the current time are removed
	 * from the initial list and added to one of the queues. When a client
	 * enters a queue, the event is displayed. After the clients joined the
	 * queues, the state of the queues will be displayed. At each step the
	 * current time is incremented by 1 and the thread is suspended for 1000
	 * milliseconds = 1 second. After the simulation ends, the queues' threads
	 * are stopped.
	 */

	public void computeResults(int currentTime)
	{
		int totalNumberOfClientsAtOneStep = 0;
		for (Queue queue : this.generatedQueues)
		{
			totalNumberOfClientsAtOneStep += queue.getNumberOfClients();
		}
		this.averageWaitingTime += totalNumberOfClientsAtOneStep;
		if (totalNumberOfClientsAtOneStep > this.peakAmountOfClients)
		{
			this.peakAmountOfClients = totalNumberOfClientsAtOneStep;
			this.peakTime = currentTime;
		}
	}

	public void run()
	{
		int currentTime = 0;
		Client client;
		while (currentTime <= simulationTime)
		{
			displayCurrentTime(currentTime);
			Iterator<Client> it = generatedClients.iterator();
			if (it.hasNext())
			{
				client = it.next();
				while (client.getArrivalTime() == currentTime)
				{
					int pos = getShortestQueue();
					generatedQueues.get(pos).enQueue(client.getId(), client.getArrivalTime(), client.getServiceTime());
					displayEvent(client, pos + 1);
					if (it.hasNext())
					{
						it.remove();
						client = it.next();
					} else
					{
						it.remove();
						break;
					}
				}
			}
			computeResults(currentTime);
			displayQueues();
			currentTime++;
			try
			{
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		queueControllers.forEach(queueC ->
		{
			queueC.stop();
		});
		displayEndOfSimulation();
		this.averageWaitingTime /= this.noOfClients;
		displayResults();
	}
	
	public void displayResults()
	{
		viewEvents.getResult1TF().setText(String.valueOf(averageWaitingTime));
		viewEvents.getResult2TF().setText(String.valueOf(peakTime));
	}

	public void displayEndOfSimulation()
	{
		viewEvents.getTextArea().append("\nSimulation ended");
	}

	public void displayCurrentTime(int currentTime)
	{
		String time = "\nSimulation time " + currentTime + "\n";
		viewEvents.getTextArea().append(time);
	}

	public void displayEvent(Client client, int pos)
	{
		String event = "\t" + client.toString() + " entered the queue " + pos + "\n";
		viewEvents.getTextArea().append(event);
	}

	public void displayQueues()
	{
		for (int i = 0; i < generatedQueues.size(); i++)
		{
			switch (i)
			{
			case 0:
				viewEvents.getQueue1Tf().setText(generatedQueues.get(i).toString());
				break;
			case 1:
				viewEvents.getQueue2Tf().setText(generatedQueues.get(i).toString());
				break;
			case 2:
				viewEvents.getQueue3Tf().setText(generatedQueues.get(i).toString());
				break;
			case 3:
				viewEvents.getQueue4Tf().setText(generatedQueues.get(i).toString());
				break;
			case 4:
				viewEvents.getQueue5Tf().setText(generatedQueues.get(i).toString());
				break;
			case 5:
				viewEvents.getQueue6Tf().setText(generatedQueues.get(i).toString());
				break;
			case 6:
				viewEvents.getQueue7Tf().setText(generatedQueues.get(i).toString());
				break;
			case 7:
				viewEvents.getQueue8Tf().setText(generatedQueues.get(i).toString());
				break;
			case 8:
				viewEvents.getQueue9Tf().setText(generatedQueues.get(i).toString());
				break;
			default:
				viewEvents.getQueue10Tf().setText(generatedQueues.get(i).toString());
				break;
			}
		}
	}

}
