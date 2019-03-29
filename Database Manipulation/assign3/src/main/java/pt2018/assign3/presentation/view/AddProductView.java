package pt2018.assign3.presentation.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AddProductView extends JFrame
{

	private JTextField descriptionTf = new JTextField();
	private JTextField pricePerUnitTf = new JTextField();
	private JTextField quantityTf = new JTextField();
	private JButton add = new JButton("Add product");
	
	public AddProductView()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		this.add(panel);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500, 350);
		this.setTitle("Add new product");
		
		JLabel descriptionL = new JLabel("Description");
		JLabel pricePerUnitL = new JLabel("Price per unit");
		JLabel quantityL = new JLabel("Quantity");
		
		panel.add(descriptionTf);
		panel.add(pricePerUnitTf);
		panel.add(quantityTf);
		panel.add(add);
		panel.add(descriptionL);
		panel.add(pricePerUnitL);
		panel.add(quantityL);
		
		descriptionL.setBounds(50, 50, 100, 30);
		descriptionTf.setBounds(150, 50, 300, 30);
		pricePerUnitL.setBounds(50, 100, 100, 30);
		pricePerUnitTf.setBounds(150, 100, 300, 30);
		quantityL.setBounds(50, 150, 100, 30);
		quantityTf.setBounds(150, 150, 300, 30);
		add.setBounds(175, 225, 150, 50);
	}
	
	public void actionListenerForAdd(ActionListener al)
	{
		add.addActionListener(al);
	}

	public JTextField getDescriptionTf()
	{
		return descriptionTf;
	}

	public JTextField getPricePerUnitTf()
	{
		return pricePerUnitTf;
	}

	public JTextField getQuantityTf()
	{
		return quantityTf;
	}
		
}
