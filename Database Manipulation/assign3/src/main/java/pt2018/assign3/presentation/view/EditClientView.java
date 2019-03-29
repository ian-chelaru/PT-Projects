package pt2018.assign3.presentation.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class EditClientView extends JFrame
{

	private JTextField idTf = new JTextField();
	private JTextField nameTf = new JTextField();
	private JTextField addressTf = new JTextField();
	private JTextField cityTf = new JTextField();
	private JTextField emailTf = new JTextField();
	private JButton edit = new JButton("Edit client");
	
	public EditClientView()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		this.add(panel);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500, 450);
		this.setTitle("Edit client");
		
		JLabel idL = new JLabel("ID Client");
		JLabel nameL = new JLabel("Name");
		JLabel addressL = new JLabel("Address");
		JLabel cityL = new JLabel("City");
		JLabel emailL = new JLabel("Email");
		
		panel.add(idTf);
		panel.add(nameTf);
		panel.add(addressTf);
		panel.add(cityTf);
		panel.add(emailTf);
		panel.add(edit);
		panel.add(idL);
		panel.add(nameL);
		panel.add(addressL);
		panel.add(cityL);
		panel.add(emailL);
		
		idL.setBounds(50, 50, 100, 30);
		idTf.setBounds(150, 50, 300, 30);
		nameL.setBounds(50, 100, 100, 30);
		nameTf.setBounds(150, 100, 300, 30);
		addressL.setBounds(50, 150, 100, 30);
		addressTf.setBounds(150, 150, 300, 30);
		cityL.setBounds(50, 200, 100, 30);
		cityTf.setBounds(150, 200, 300, 30);
		emailL.setBounds(50, 250, 100, 30);
		emailTf.setBounds(150, 250, 300, 30);
		edit.setBounds(175, 325, 150, 50);
	}
	
	public void actionListenerForEdit(ActionListener al)
	{
		edit.addActionListener(al);
	}

	public JTextField getIdTf()
	{
		return idTf;
	}

	public JTextField getNameTf()
	{
		return nameTf;
	}

	public JTextField getAddressTf()
	{
		return addressTf;
	}

	public JTextField getCityTf()
	{
		return cityTf;
	}

	public JTextField getEmailTf()
	{
		return emailTf;
	}

}
