package pt2018.assign4.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class EditPerson extends JFrame
{
	private JTextField firstNameTf = new JTextField();
	private JTextField lastNameTf = new JTextField();
	private JTextField phoneTf = new JTextField();
	private JButton edit = new JButton("Edit");
	
	public EditPerson()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		add(panel);
		setResizable(false);
		setTitle("Edit person");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(450, 350);
		
		JLabel firstNameL = new JLabel("First name");
		JLabel lastNameL = new JLabel("Last name");
		JLabel phoneL = new JLabel("Phone");
		
		panel.add(firstNameTf);
		panel.add(firstNameL);
		panel.add(lastNameTf);
		panel.add(lastNameL);
		panel.add(phoneTf);
		panel.add(phoneL);
		panel.add(edit);
		
		firstNameL.setBounds(50, 50, 140, 35);
		firstNameTf.setBounds(200, 50, 200, 35);
		lastNameL.setBounds(50, 100, 140, 35);
		lastNameTf.setBounds(200, 100, 200, 35);
		phoneL.setBounds(50, 150, 140, 35);
		phoneTf.setBounds(200, 150, 200, 35);
		edit.setBounds(50, 250, 150, 50);
	}
	
	public void actionListenerForEdit(ActionListener al)
	{
		edit.addActionListener(al);
	}

	public JTextField getFirstNameTf()
	{
		return firstNameTf;
	}

	public JTextField getLastNameTf()
	{
		return lastNameTf;
	}

	public JTextField getPhoneTf()
	{
		return phoneTf;
	}
	
}
