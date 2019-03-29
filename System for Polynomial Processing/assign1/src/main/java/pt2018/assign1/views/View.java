package pt2018.assign1.views;

import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * 
 * @author Ian Chelaru
 *
 */

@SuppressWarnings("serial")
public class View extends JFrame
{
	private JPanel panel = new JPanel();
	private JButton add = new JButton("+");
	private JButton sub = new JButton("-");
	private JButton mul = new JButton("*");
	private JButton div = new JButton("/");
	private JButton diff = new JButton("differentiate");
	private JButton inte = new JButton("integrate");
	private JLabel label = new JLabel("Result: ");
	private JLabel labelResult = new JLabel();
	private JTextField tf1 = new JTextField();
	private JTextField tf2 = new JTextField();
	
	public View()
	{
		panel.add(add);
		panel.add(sub);
		panel.add(mul);
		panel.add(div);
		panel.add(diff);
		panel.add(inte);
		panel.add(label);
		panel.add(labelResult);
		panel.add(tf1);
		panel.add(tf2);
		
		panel.setLayout(null);
		
		tf1.setBounds(50, 50, 400, 40);
		tf2.setBounds(50, 110, 400, 40);
		add.setBounds(50, 200, 50, 50);
		sub.setBounds(120, 200, 50, 50);
		mul.setBounds(190, 200, 50, 50);
		div.setBounds(260, 200, 50, 50);
		diff.setBounds(50, 270, 150, 50);
		inte.setBounds(220, 270, 150, 50);
		label.setBounds(50, 370, 70, 20);
		labelResult.setBounds(50, 400, 400, 20);
				
		this.add(panel);
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Polynomial processing");
	}
	
	public void actionListenerForAdd(ActionListener al)
	{
		add.addActionListener(al);
	}
	
	public void actionListenerForSub(ActionListener al)
	{
		sub.addActionListener(al);
	}
	
	public void actionListenerForMul(ActionListener al)
	{
		mul.addActionListener(al);
	}
	
	public void actionListenerForDiv(ActionListener al)
	{
		div.addActionListener(al);
	}
	
	public void actionListenerForDiff(ActionListener al)
	{
		diff.addActionListener(al);
	}
	
	public void actionListenerForInte(ActionListener al)
	{
		inte.addActionListener(al);
	}

	public JTextField getTf1()
	{
		return tf1;
	}
	
	public JTextField getTf2()
	{
		return tf2;
	}

	public JLabel getLabelResult()
	{
		return labelResult;
	}
	
}
