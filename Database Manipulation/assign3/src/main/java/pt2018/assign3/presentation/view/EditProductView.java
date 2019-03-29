package pt2018.assign3.presentation.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class EditProductView extends JFrame
{
	
	private JTextField idTf = new JTextField();
	private JTextField descriptionTf = new JTextField();
	private JTextField pricePerUnitTf = new JTextField();
	private JTextField quantityTf = new JTextField();
	private JButton edit = new JButton("Edit product");
	
	public EditProductView()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		this.add(panel);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500, 400);
		this.setTitle("Edit product");
		
		JLabel idL = new JLabel("ID Product");
		JLabel descriptionL = new JLabel("Description");
		JLabel pricePerUnitL = new JLabel("Price per unit");
		JLabel quantityL = new JLabel("Quantity");
		
		panel.add(idTf);
		panel.add(descriptionTf);
		panel.add(pricePerUnitTf);
		panel.add(quantityTf);
		panel.add(edit);
		panel.add(idL);
		panel.add(descriptionL);
		panel.add(pricePerUnitL);
		panel.add(quantityL);
		
		idL.setBounds(50, 50, 100, 30);
		idTf.setBounds(150, 50, 300, 30);
		descriptionL.setBounds(50, 100, 100, 30);
		descriptionTf.setBounds(150, 100, 300, 30);
		pricePerUnitL.setBounds(50, 150, 100, 30);
		pricePerUnitTf.setBounds(150, 150, 300, 30);
		quantityL.setBounds(50, 200, 100, 30);
		quantityTf.setBounds(150, 200, 300, 30);
		edit.setBounds(175, 275, 150, 50);
	}
	
	public void actionListenerForEdit(ActionListener al)
	{
		edit.addActionListener(al);
	}

	public JTextField getIdTf()
	{
		return idTf;
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
