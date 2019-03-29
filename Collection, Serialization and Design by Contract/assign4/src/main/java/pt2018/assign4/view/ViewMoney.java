package pt2018.assign4.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ViewMoney extends JFrame
{
	private JTextField sumTf = new JTextField();
	private JButton addMoney = new JButton("Add money");
	private JButton withdrawMoney = new JButton("Withdraw money");
	
	public ViewMoney()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		add(panel);
		setResizable(false);
		setTitle("Sum");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(450, 200);
		
		panel.add(sumTf);
		panel.add(addMoney);
		panel.add(withdrawMoney);
		
		sumTf.setBounds(150, 50, 150, 35);
		addMoney.setBounds(50, 120, 150, 30);
		withdrawMoney.setBounds(250, 120, 150, 30);
	}
	
	public JTextField getSumTf()
	{
		return sumTf;
	}
	
	public void actionListenerForAddMoney(ActionListener al)
	{
		addMoney.addActionListener(al);
	}
	
	public void actionListenerForWithdrawMoney(ActionListener al)
	{
		withdrawMoney.addActionListener(al);
	}
	
}
