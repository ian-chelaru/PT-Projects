package pt2018.assign4.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ViewAccounts extends JFrame
{
	private DefaultTableModel model = new DefaultTableModel();
	private JTable table = new JTable(model);
	private JTextField accountNumberTf = new JTextField();
	private JTextField holderFirstNameTf = new JTextField();
	private JTextField holderLastNameTf = new JTextField();
	private JButton addAccount = new JButton("Add new account");
	private JButton deleteAccount = new JButton("Delete account");
	private JButton editAccount = new JButton("Edit account");
	private JButton addWithdrawMoney = new JButton("Add / Withdraw money");
	private JComboBox<String> box;
	
	public ViewAccounts()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		add(panel);
		setResizable(false);
		setTitle("Accounts");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(1300, 750);
		
		table.setRowHeight(30);
		
		model.addColumn("Account number");
		model.addColumn("Sum");
		model.addColumn("Holder first name");
		model.addColumn("Holder last name");
		model.addColumn("Account type");
		
		JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		panel.add(scroll);
		scroll.setBounds(50, 50, 750, 650);
		
		JLabel accountNumberL = new JLabel("Account number");
		JLabel holderFirstNameL = new JLabel("Holder first name");
		JLabel holderLastNameL = new JLabel("Holder last name");
		JLabel typeL = new JLabel("Type");
		
		String[] items = {"Saving", "Spending"};
		box = new JComboBox<>(items);
		
		panel.add(accountNumberTf);
		panel.add(accountNumberL);
		panel.add(holderFirstNameTf);
		panel.add(holderFirstNameL);
		panel.add(holderLastNameTf);
		panel.add(holderLastNameL);
		panel.add(box);
		panel.add(typeL);
		panel.add(addAccount);
		panel.add(deleteAccount);
		panel.add(editAccount);
		panel.add(addWithdrawMoney);
		
		addAccount.setBounds(950, 50, 200, 50);
		deleteAccount.setBounds(950, 125, 200, 50);
		editAccount.setBounds(950, 200, 200, 50);
		addWithdrawMoney.setBounds(950, 275, 200, 50);
		accountNumberL.setBounds(850, 450, 140, 35);
		accountNumberTf.setBounds(1000, 450, 200, 35);
		holderFirstNameL.setBounds(850, 500, 140, 35);
		holderFirstNameTf.setBounds(1000, 500, 200, 35);
		holderLastNameL.setBounds(850, 550, 140, 35);
		holderLastNameTf.setBounds(1000, 550, 200, 35);
		typeL.setBounds(850, 600, 140, 35);
		box.setBounds(1000, 600, 200, 35);
		
		holderFirstNameTf.setEditable(false);
		holderLastNameTf.setEditable(false);
	}
	
	public void actionListenerForAddAccount(ActionListener al)
	{
		addAccount.addActionListener(al);
	}
	
	public void actionListenerForDeleteAccount(ActionListener al)
	{
		deleteAccount.addActionListener(al);
	}
	
	public void actionListenerForEditAccount(ActionListener al)
	{
		editAccount.addActionListener(al);
	}
	
	public void actionListenerForAddWithdrawMoney(ActionListener al)
	{
		addWithdrawMoney.addActionListener(al);
	}
	
	public JTextField getAccountNumberTf()
	{
		return accountNumberTf;
	}

	public JTextField getHolderFirstNameTf()
	{
		return holderFirstNameTf;
	}

	public JTextField getHolderLastNameTf()
	{
		return holderLastNameTf;
	}
	
	public JComboBox<String> getBox()
	{
		return box;
	}

	public DefaultTableModel getModel()
	{
		return model;
	}

	public JTable getTable()
	{
		return table;
	}
	
	public void clearTextFields()
	{
		accountNumberTf.setText("");
	}
	
	public void disableButtons()
	{
		addAccount.setEnabled(false);
		deleteAccount.setEnabled(false);
		editAccount.setEnabled(false);
		addWithdrawMoney.setEnabled(false);
	}
	
	public void enableButtons()
	{
		addAccount.setEnabled(true);
		deleteAccount.setEnabled(true);
		editAccount.setEnabled(true);
		addWithdrawMoney.setEnabled(true);
	}
	
}
