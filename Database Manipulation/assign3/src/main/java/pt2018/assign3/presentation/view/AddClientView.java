package pt2018.assign3.presentation.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AddClientView extends JFrame
{

	private JTextField nameTf = new JTextField();
	private JTextField addressTf = new JTextField();
	private JTextField cityTf = new JTextField();
	private JTextField emailTf = new JTextField();
	private JButton add = new JButton("Add client");
	
	public AddClientView()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		this.add(panel);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500, 400);
		this.setTitle("Add new client");
		
		JLabel nameL = new JLabel("Name");
		JLabel addressL = new JLabel("Address");
		JLabel cityL = new JLabel("City");
		JLabel emailL = new JLabel("Email");
		
		panel.add(nameTf);
		panel.add(addressTf);
		panel.add(cityTf);
		panel.add(emailTf);
		panel.add(add);
		panel.add(nameL);
		panel.add(addressL);
		panel.add(cityL);
		panel.add(emailL);
		
		nameL.setBounds(50, 50, 100, 30);
		nameTf.setBounds(150, 50, 300, 30);
		addressL.setBounds(50, 100, 100, 30);
		addressTf.setBounds(150, 100, 300, 30);
		cityL.setBounds(50, 150, 100, 30);
		cityTf.setBounds(150, 150, 300, 30);
		emailL.setBounds(50, 200, 100, 30);
		emailTf.setBounds(150, 200, 300, 30);
		add.setBounds(175, 275, 150, 50);
	}
	
	public void actionListenerForAdd(ActionListener al)
	{
		add.addActionListener(al);
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
