package pt2018.assign2.controllers;

import pt2018.assign2.views.SimulationSetup;

/**
 * 
 * MainController class creates and display the simulation setup frame.
 * When the start button is pressed the class takes the input data given by the user and creates a simulation.
 * A simulation thread is created and started. 
 * 
 * @author Ian Chelaru
 *
 */

public class MainController
{
	private Simulation s;
	private SimulationSetup viewSS = new SimulationSetup();

	public MainController()
	{
		viewSS.setVisible(true);

		viewSS.actionListenerForStart(al ->
		{
			int simulationTime = Integer.parseInt(viewSS.getSimulationTimeTf().getText());
			int noOfClients = Integer.parseInt(viewSS.getNoClientsTf().getText());
			int noOfQueues = Integer.parseInt(viewSS.getNoQueuesTf().getText());
			int minArTime = Integer.parseInt(viewSS.getMinArTimeTf().getText());
			int maxArTime = Integer.parseInt(viewSS.getMaxArTimeTf().getText());
			int minSeTime = Integer.parseInt(viewSS.getMinSeTimeTf().getText());
			int maxSeTime = Integer.parseInt(viewSS.getMaxSeTimeTf().getText());
			s = new Simulation(simulationTime, noOfClients, noOfQueues, minArTime, maxArTime, minSeTime, maxSeTime);
			Thread t = new Thread(s);
			t.start();
		});

	}

}
