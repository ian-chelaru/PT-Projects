package pt2018.assign2.views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 
 * EventsView creates the frame in which the application outputs information about the simulation.
 * EventsView class extends the JFrame class, so it behaves like a frame.
 * The class has 10 text fields (JTextField) attributes which display the queues evolutions.
 * Each queue representation is displayed in its corresponding text field.
 * The class has 2 more text fields attributes which display the simulation results: average waiting time and peak time.
 * There exists getters for each text field because the text fields have to be accessed from the QueueController and Simulation classes.
 * EventsView class has a JTextArea in which the events is displayed.
 * 
 * @author Ian Chelaru
 *
 */

@SuppressWarnings("serial")
public class EventsView extends JFrame
{
	private JTextField queue1Tf = new JTextField();
	private JTextField queue2Tf = new JTextField();
	private JTextField queue3Tf = new JTextField();
	private JTextField queue4Tf = new JTextField();
	private JTextField queue5Tf = new JTextField();
	private JTextField queue6Tf = new JTextField();
	private JTextField queue7Tf = new JTextField();
	private JTextField queue8Tf = new JTextField();
	private JTextField queue9Tf = new JTextField();
	private JTextField queue10Tf = new JTextField();
	private JTextArea textArea = new JTextArea();
	private JTextField result1TF = new JTextField();
	private JTextField result2TF = new JTextField();
	
	/**
	 * Constructs and initializes the frame.
	 * For each text field a corresponding label is created. The labels sum up the purpose of the text fields.
	 * The text fields and the labels are added to a JPanel, which is added to the frame.
	 * The position and size of each component are set.
	 * The title and the size of the frame set.
	 * The attributes of the class are used only for displaying result. Thus, the attributes can not be editable by the user.
	 * A JScrollPane is created. It contains the text area. Thus, the content of the text area can be scrolled on vertical.
	 */

	public EventsView()
	{
		JPanel panel = new JPanel();
		this.add(panel);
		panel.setLayout(null);

		this.setTitle("Log of Events");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(1500, 800);

		JLabel queue1L = new JLabel("Queue 1:");
		JLabel queue2L = new JLabel("Queue 2:");
		JLabel queue3L = new JLabel("Queue 3:");
		JLabel queue4L = new JLabel("Queue 4:");
		JLabel queue5L = new JLabel("Queue 5:");
		JLabel queue6L = new JLabel("Queue 6:");
		JLabel queue7L = new JLabel("Queue 7:");
		JLabel queue8L = new JLabel("Queue 8:");
		JLabel queue9L = new JLabel("Queue 9:");
		JLabel queue10L = new JLabel("Queue 10:");
		JLabel result1L = new JLabel("Average waiting time:");
		JLabel result2L = new JLabel("Peak time:");

		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		panel.add(queue1Tf);
		panel.add(queue1L);
		panel.add(queue2Tf);
		panel.add(queue2L);
		panel.add(queue3Tf);
		panel.add(queue3L);
		panel.add(queue4Tf);
		panel.add(queue4L);
		panel.add(queue5Tf);
		panel.add(queue5L);
		panel.add(queue6Tf);
		panel.add(queue6L);
		panel.add(queue7Tf);
		panel.add(queue7L);
		panel.add(queue8Tf);
		panel.add(queue8L);
		panel.add(queue9Tf);
		panel.add(queue9L);
		panel.add(queue10Tf);
		panel.add(queue10L);
		panel.add(result1TF);
		panel.add(result1L);
		panel.add(result2TF);
		panel.add(result2L);

		panel.add(scroll);

		queue1L.setBounds(50, 50, 100, 35);
		queue1Tf.setBounds(150, 50, 500, 35);
		queue2L.setBounds(50, 100, 100, 35);
		queue2Tf.setBounds(150, 100, 500, 35);
		queue3L.setBounds(50, 150, 100, 35);
		queue3Tf.setBounds(150, 150, 500, 35);
		queue4L.setBounds(50, 200, 100, 35);
		queue4Tf.setBounds(150, 200, 500, 35);
		queue5L.setBounds(50, 250, 100, 35);
		queue5Tf.setBounds(150, 250, 500, 35);
		queue6L.setBounds(50, 300, 100, 35);
		queue6Tf.setBounds(150, 300, 500, 35);
		queue7L.setBounds(50, 350, 100, 35);
		queue7Tf.setBounds(150, 350, 500, 35);
		queue8L.setBounds(50, 400, 100, 35);
		queue8Tf.setBounds(150, 400, 500, 35);
		queue9L.setBounds(50, 450, 100, 35);
		queue9Tf.setBounds(150, 450, 500, 35);
		queue10L.setBounds(50, 500, 100, 35);
		queue10Tf.setBounds(150, 500, 500, 35);
		
		result1L.setBounds(200, 600, 200, 35);
		result1TF.setBounds(325, 600, 100, 35);
		result2L.setBounds(200, 650, 100, 35);
		result2TF.setBounds(325, 650, 100, 35);

		scroll.setBounds(800, 50, 600, 500);

		queue1Tf.setEditable(false);
		queue2Tf.setEditable(false);
		queue3Tf.setEditable(false);
		queue4Tf.setEditable(false);
		queue5Tf.setEditable(false);
		queue6Tf.setEditable(false);
		queue7Tf.setEditable(false);
		queue8Tf.setEditable(false);
		queue9Tf.setEditable(false);
		queue10Tf.setEditable(false);
		result1TF.setEditable(false);
		result2TF.setEditable(false);
		
		textArea.setEditable(false);

	}

	public JTextField getQueue1Tf()
	{
		return queue1Tf;
	}

	public JTextField getQueue2Tf()
	{
		return queue2Tf;
	}

	public JTextField getQueue3Tf()
	{
		return queue3Tf;
	}

	public JTextField getQueue4Tf()
	{
		return queue4Tf;
	}

	public JTextField getQueue5Tf()
	{
		return queue5Tf;
	}

	public JTextField getQueue6Tf()
	{
		return queue6Tf;
	}

	public JTextField getQueue7Tf()
	{
		return queue7Tf;
	}

	public JTextField getQueue8Tf()
	{
		return queue8Tf;
	}

	public JTextField getQueue9Tf()
	{
		return queue9Tf;
	}

	public JTextField getQueue10Tf()
	{
		return queue10Tf;
	}

	public JTextArea getTextArea()
	{
		return textArea;
	}

	public JTextField getResult1TF()
	{
		return result1TF;
	}

	public JTextField getResult2TF()
	{
		return result2TF;
	}

}
