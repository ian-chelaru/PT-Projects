package pt2018.assign3.presentation.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class DeleteObjectView extends JFrame
{

	private JTextField idTf = new JTextField();
	private JButton delete;
	
	public DeleteObjectView(String object)
	{
		delete = new JButton("Delete " + object);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		this.add(panel);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500, 250);
		this.setTitle("Delete " + object);
		
		JLabel idL = new JLabel("ID " + object);
		
		panel.add(idTf);
		panel.add(delete);
		panel.add(idL);
		
		idL.setBounds(50, 50, 100, 30);
		idTf.setBounds(150, 50, 300, 30);
		delete.setBounds(175, 125, 150, 50);
	}
	
	public void actionListenerForDelete(ActionListener al)
	{
		delete.addActionListener(al);
	}
	
	public JTextField getIdTf()
	{
		return idTf;
	}
	
}
