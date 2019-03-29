package pt2018.assign3.presentation.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class ViewAllObjects extends JFrame
{

	private JTable table;

	public ViewAllObjects(String[] columnNames, Object[][] data, String objects)
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);

		this.add(panel);
		this.setTitle(objects + " table");
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(1000, 800);
		
		table = new JTable(data, columnNames);
		table.setRowHeight(30);

		JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		panel.add(scroll);
		scroll.setBounds(50, 50, 900, 700);
	}
	
}
