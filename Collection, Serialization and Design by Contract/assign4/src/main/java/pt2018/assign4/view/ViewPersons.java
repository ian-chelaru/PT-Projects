package pt2018.assign4.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ViewPersons extends JFrame
{

	private JButton addPerson = new JButton("Add new person");
	private JButton deletePerson = new JButton("Delete person");
	private JButton editPerson = new JButton("Edit person");
	private JButton viewPersonAccounts = new JButton("View person accounts");
	private JButton viewAccounts = new JButton("View accounts");
	private DefaultTableModel model = new DefaultTableModel();
	private JTable table = new JTable(model);
	private JTextField firstNameTf = new JTextField();
	private JTextField lastNameTf = new JTextField();
	private JTextField phoneTf = new JTextField();

	public ViewPersons()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);

		add(panel);
		setResizable(false);
		setTitle("Persons");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1100, 700);

		table.setRowHeight(30);

		model.addColumn("First name");
		model.addColumn("Last name");
		model.addColumn("Phone");

		JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		panel.add(scroll);
		scroll.setBounds(50, 50, 550, 600);

		JLabel firstNameL = new JLabel("First name");
		JLabel lastNameL = new JLabel("Last name");
		JLabel phoneL = new JLabel("Phone");
		
		panel.add(addPerson);
		panel.add(deletePerson);
		panel.add(editPerson);
		panel.add(viewPersonAccounts);
		panel.add(viewAccounts);
		panel.add(firstNameTf);
		panel.add(firstNameL);
		panel.add(lastNameTf);
		panel.add(lastNameL);
		panel.add(phoneTf);
		panel.add(phoneL);
		
		addPerson.setBounds(750, 50, 200, 50);
		deletePerson.setBounds(750, 125, 200, 50);
		editPerson.setBounds(750, 200, 200, 50);
		viewPersonAccounts.setBounds(750, 275, 200, 50);
		viewAccounts.setBounds(750, 350, 200, 50);
		firstNameL.setBounds(700, 450, 90, 35);
		firstNameTf.setBounds(800, 450, 200, 35);
		lastNameL.setBounds(700, 500, 90, 35);
		lastNameTf.setBounds(800, 500, 200, 35);
		phoneL.setBounds(700, 550, 90, 35);
		phoneTf.setBounds(800, 550, 200, 35);
	}

	public void actionListenerForAddPerson(ActionListener al)
	{
		addPerson.addActionListener(al);
	}
	
	public void actionListenerForDeletePerson(ActionListener al)
	{
		deletePerson.addActionListener(al);
	}
	
	public void actionListenerForEditPersons(ActionListener al)
	{
		editPerson.addActionListener(al);
	}
	
	public void actionListenerForViewPersonAccounts(ActionListener al)
	{
		viewPersonAccounts.addActionListener(al);
	}

	public void actionListenerForViewAccounts(ActionListener al)
	{
		viewAccounts.addActionListener(al);
	}
	
	public DefaultTableModel getModel()
	{
		return model;
	}
	
	public JTable getTable()
	{
		return table;
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
	
	public void clearTextFields()
	{
		getFirstNameTf().setText("");
		getLastNameTf().setText("");
		getPhoneTf().setText("");
	}
	
	public void disableButtons()
	{
		addPerson.setEnabled(false);
		deletePerson.setEnabled(false);
		editPerson.setEnabled(false);
		viewPersonAccounts.setEnabled(false);
		viewAccounts.setEnabled(false);
	}
	
	public void enableButtons()
	{
		addPerson.setEnabled(true);
		deletePerson.setEnabled(true);
		editPerson.setEnabled(true);
		viewPersonAccounts.setEnabled(true);
		viewAccounts.setEnabled(true);
	}
}
