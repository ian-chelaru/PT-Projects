package pt2018.assign5.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class View extends JFrame
{
	private JTextArea textArea = new JTextArea();
	private JButton button1 = new JButton("1");
	private JButton button2 = new JButton("2");
	private JButton button3 = new JButton("3");
	private JButton button4 = new JButton("4");
	private JButton button5 = new JButton("5");
	
	public View()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		add(panel);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(700, 500);
		
		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		panel.add(scroll);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		
		button1.setBounds(50, 50, 100, 50);
		button2.setBounds(175, 50, 100, 50);
		button3.setBounds(300, 50, 100, 50);
		button4.setBounds(425, 50, 100, 50);
		button5.setBounds(550, 50, 100, 50);
		scroll.setBounds(50, 150, 600, 300);
	}
	
	public JTextArea getTextArea()
	{
		return textArea;
	}
	
	public void actionListenerForButton1(ActionListener al)
	{
		button1.addActionListener(al);
	}
	
	public void actionListenerForButton2(ActionListener al)
	{
		button2.addActionListener(al);
	}
	
	public void actionListenerForButton3(ActionListener al)
	{
		button3.addActionListener(al);
	}
	
	public void actionListenerForButton4(ActionListener al)
	{
		button4.addActionListener(al);
	}
	
	public void actionListenerForButton5(ActionListener al)
	{
		button5.addActionListener(al);
	}
	
}
