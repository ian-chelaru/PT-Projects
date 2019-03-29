package pt2018.assign3.presentation.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WindowClientOperations extends JFrame
{

	private JButton add = new JButton("Add new client");
	private JButton edit = new JButton("Edit client");
	private JButton delete = new JButton("Delete client");
	private JButton viewAll = new JButton("View all clients");
	
	public WindowClientOperations()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		this.add(panel);
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Client Operations");
		
		panel.add(add);
		panel.add(edit);
		panel.add(delete);
		panel.add(viewAll);
		
		add.setBounds(175, 50, 150, 50);
		edit.setBounds(175, 125, 150, 50);
		delete.setBounds(175, 200, 150, 50);
		viewAll.setBounds(175, 275, 150, 50);
	}
	
	public void actionListenerForAdd(ActionListener al)
	{
		add.addActionListener(al);
	}
	
	public void actionListenerForEdit(ActionListener al)
	{
		edit.addActionListener(al);
	}
	
	public void actionListenerForDelete(ActionListener al)
	{
		delete.addActionListener(al);
	}
	
	public void actionListenerForViewAll(ActionListener al)
	{
		viewAll.addActionListener(al);
	}
	
}
