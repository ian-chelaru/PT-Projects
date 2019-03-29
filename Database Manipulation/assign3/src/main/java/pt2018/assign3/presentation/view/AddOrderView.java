package pt2018.assign3.presentation.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AddOrderView extends JFrame
{

	private JTextField idClientTf = new JTextField();
	private JTextField idProductTf = new JTextField();
	private JTextField amountTf = new JTextField();
	private JTextField statusTf = new JTextField();
	private JButton add = new JButton("Add order");
	private JLabel errorL = new JLabel();
	
	public AddOrderView()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		this.add(panel);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500, 450);
		this.setTitle("Add new order");
		
		JLabel idClientL = new JLabel("ID client");
		JLabel idProductL = new JLabel("ID product");
		JLabel amountL = new JLabel("Amount");
		JLabel statusL = new JLabel("Status");
		
		panel.add(idClientTf);
		panel.add(idProductTf);
		panel.add(amountTf);
		panel.add(statusTf);
		panel.add(add);
		panel.add(idClientL);
		panel.add(idProductL);
		panel.add(amountL);
		panel.add(statusL);
		panel.add(errorL);
		
		idClientL.setBounds(50, 50, 100, 30);
		idClientTf.setBounds(150, 50, 300, 30);
		idProductL.setBounds(50, 100, 100, 30);
		idProductTf.setBounds(150, 100, 300, 30);
		amountL.setBounds(50, 150, 100, 30);
		amountTf.setBounds(150, 150, 300, 30);
		statusL.setBounds(50, 200, 100, 30);
		statusTf.setBounds(150, 200, 300, 30);
		add.setBounds(175, 275, 150, 50);
		errorL.setBounds(100, 350, 300, 30);
	}
	
	public void actionListenerForAdd(ActionListener al)
	{
		add.addActionListener(al);
	}

	public JTextField getIdClientTf()
	{
		return idClientTf;
	}

	public JTextField getIdProductTf()
	{
		return idProductTf;
	}

	public JTextField getAmountTf()
	{
		return amountTf;
	}

	public JTextField getStatusTf()
	{
		return statusTf;
	}
	
	public void setErrorText(String text)
	{
		errorL.setText(text);
	}

}
