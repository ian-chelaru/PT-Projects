package pt2018.assign3.presentation.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StartView extends JFrame
{

	private JButton clients = new JButton("Client operations");
	private JButton products = new JButton("Product operations");
	private JButton orders = new JButton("Order operations");
	
	public StartView()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		this.add(panel);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 325);
		this.setTitle("Warehouse");
		
		panel.add(clients);
		panel.add(products);
		panel.add(orders);
		
		clients.setBounds(175, 50, 150, 50);
		products.setBounds(175, 125, 150, 50);
		orders.setBounds(175, 200, 150, 50);
	}
	
	public void actionListenerForClients(ActionListener al)
	{
		clients.addActionListener(al);
	}
	
	public void actionListenerForProducts(ActionListener al)
	{
		products.addActionListener(al);
	}
	
	public void actionListenerForOrders(ActionListener al)
	{
		orders.addActionListener(al);
	}
	
}
