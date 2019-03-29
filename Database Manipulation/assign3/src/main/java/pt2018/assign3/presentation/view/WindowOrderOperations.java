package pt2018.assign3.presentation.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WindowOrderOperations extends JFrame
{

	private JButton add = new JButton("Add new order");
	private JButton viewAll = new JButton("View all orders");
	
	public WindowOrderOperations()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		this.add(panel);
		this.setSize(500, 250);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Order Operations");
		
		panel.add(add);
		panel.add(viewAll);
		
		add.setBounds(175, 50, 150, 50);
		viewAll.setBounds(175, 125, 150, 50);
	}
	
	public void actionListenerForAdd(ActionListener al)
	{
		add.addActionListener(al);
	}
	
	
	public void actionListenerForViewAll(ActionListener al)
	{
		viewAll.addActionListener(al);
	}

}
