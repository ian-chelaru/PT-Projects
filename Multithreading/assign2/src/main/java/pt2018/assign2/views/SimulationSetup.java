package pt2018.assign2.views;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * SimulationSetup class creates the initial frame which appears on the screen when running the program.
 * SimulationSetup class extends the JFrame class, so it behaves like a frame.
 * The frame receives the input data given by the user. The data then is taken from this class and 
 * transmitted to the controller.
 * The class has seven text fields (JTExtField) attributes where the user has to introduce the input parameters.
 * There exists getters for each text field because the text fields have to be accessed from the MainController class.
 * This class has a start button which starts the simulation when pressed.
 * 
 * 
 * @author Ian Chelaru
 *
 */

@SuppressWarnings("serial")
public class SimulationSetup extends JFrame
{
	private JButton start = new JButton("Start");
	private JTextField noClientsTf = new JTextField();
	private JTextField noQueuesTf = new JTextField();
	private JTextField simulationTimeTf = new JTextField();
	private JTextField minArTimeTf = new JTextField();
	private JTextField maxArTimeTf = new JTextField();
	private JTextField minSeTimeTf = new JTextField();
	private JTextField maxSeTimeTf = new JTextField();

	/**
	 * Constructs and initializes the frame.
	 * For each text field a corresponding label is created. The labels sum up the purpose of the text fields.
	 * All the components are added to a JPanel, which is added to the frame.
	 * The position and size of each component are set.
	 * The title and the size of the frame set.
	 */
	
	public SimulationSetup()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);

		this.add(panel);
		this.setSize(350, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Simulation Setup");

		JLabel noClientsL = new JLabel("Number of clients:");
		JLabel noQueuesL = new JLabel("Number of queues:");
		JLabel simTimeL = new JLabel("Simulation time:");
		JLabel minArTimeL = new JLabel("Minimum arrival time:");
		JLabel maxArTimeL = new JLabel("Maximum arrival time:");
		JLabel minSeTimeL = new JLabel("Minimum service time:");
		JLabel maxSeTimeL = new JLabel("Maximum service time:");

		panel.add(start);
		panel.add(noClientsTf);
		panel.add(noQueuesTf);
		panel.add(simulationTimeTf);
		panel.add(minArTimeTf);
		panel.add(maxArTimeTf);
		panel.add(minSeTimeTf);
		panel.add(maxSeTimeTf);
		panel.add(noClientsL);
		panel.add(noQueuesL);
		panel.add(simTimeL);
		panel.add(minArTimeL);
		panel.add(maxArTimeL);
		panel.add(minSeTimeL);
		panel.add(maxSeTimeL);

		noClientsL.setBounds(50, 50, 200, 25);
		noClientsTf.setBounds(175, 50, 50, 25);
		noQueuesL.setBounds(50, 100, 200, 25);
		noQueuesTf.setBounds(175, 100, 50, 25);
		simTimeL.setBounds(50, 150, 200, 25);
		simulationTimeTf.setBounds(175, 150, 50, 25);
		minArTimeL.setBounds(50, 200, 200, 25);
		minArTimeTf.setBounds(200, 200, 50, 25);
		maxArTimeL.setBounds(50, 250, 200, 25);
		maxArTimeTf.setBounds(200, 250, 50, 25);
		minSeTimeL.setBounds(50, 300, 200, 25);
		minSeTimeTf.setBounds(200, 300, 50, 25);
		maxSeTimeL.setBounds(50, 350, 200, 25);
		maxSeTimeTf.setBounds(200, 350, 50, 25);
		start.setBounds(100, 450, 150, 50);
	}

	/**
	 * Adds an action listener for the start button.
	 * @param al ActionListener
	 */
	
	public void actionListenerForStart(ActionListener al)
	{
		start.addActionListener(al);
	}

	public JTextField getNoClientsTf()
	{
		return noClientsTf;
	}

	public JTextField getNoQueuesTf()
	{
		return noQueuesTf;
	}

	public JTextField getSimulationTimeTf()
	{
		return simulationTimeTf;
	}

	public JTextField getMinArTimeTf()
	{
		return minArTimeTf;
	}

	public JTextField getMaxArTimeTf()
	{
		return maxArTimeTf;
	}

	public JTextField getMinSeTimeTf()
	{
		return minSeTimeTf;
	}

	public JTextField getMaxSeTimeTf()
	{
		return maxSeTimeTf;
	}

}
