package pt2018.assign4.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class EditAccount extends JFrame
{
	private JTextField accountNumberTf = new JTextField();
	private JButton edit = new JButton("Edit");
	
	public EditAccount()
	{
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		
		setResizable(false);
		setTitle("Edit account");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(450, 250);
		
		JLabel accountNumberL = new JLabel("Account number");
		
		panel.add(accountNumberL);
		panel.add(accountNumberTf);
		panel.add(edit);
		
		accountNumberL.setBounds(50, 50, 140, 35);
		accountNumberTf.setBounds(200, 50, 200, 35);
		edit.setBounds(50, 150, 150, 50);
	}
	
	public void actionListenerForEdit(ActionListener al)
	{
		edit.addActionListener(al);
	}
	
	public JTextField getAccountNumberTf()
	{
		return accountNumberTf;
	}
}
