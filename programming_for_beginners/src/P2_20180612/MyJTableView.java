package P2_20180612;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("all")
public class MyJTableView extends JFrame implements ActionListener{

	private StudentTableModel tableModel;
	private JTable table;
	private JScrollPane sp;
	private JButton btnAddRow;
	private JButton btnRemove;
	private JButton btnPrint;
	private JPanel pnl;

	public MyJTableView(LinkedList<Student> slist) {
		super.setTitle("MyTable");
		super.setLocation(100, 100);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tableModel = new StudentTableModel(slist);
		table = new JTable(tableModel);
		sp = new JScrollPane(table);

		super.add(new JLabel("Studentenverwaltung"), BorderLayout.NORTH);
		super.add(sp, BorderLayout.CENTER);
		this.sp.setPreferredSize(new Dimension(500, 100));

		this.pnl = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		pnl.add(this.btnAddRow = new JButton("Hinzufügen"));
		this.btnAddRow.addActionListener(this);

		pnl.add(this.btnRemove = new JButton("Remove"));
		this.btnRemove.addActionListener(this);

		pnl.add(this.btnPrint = new JButton("Ausgabe"));
		this.btnPrint.addActionListener(this);
		super.add(pnl, BorderLayout.SOUTH);

		super.pack();
		super.setVisible(true);

	}
	
	public StudentTableModel getTableModel(){
		return this.tableModel;
	}

	public static void main(String[] args) {
		LinkedList<Student> slist = new LinkedList<Student>();
		slist.add(new Student(2, "Meier", "Andre", "Wirtschaftsinformatik", true));
		slist.add(new Student(4, "Hugo", "Andre", "Wirtschaftsinformatik", true));
		slist.add(new Student(6, "Schmidt", "Andre", "Wirtschaftsinformatik", true));
		new MyJTableView(slist);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if( e.getSource() == this.btnAddRow){
			new ErfasseDatenDialog(this, true);
		}
		if(e.getSource() == this.btnPrint){
			System.out.println(tableModel.getData(table.getSelectedRow()));
		}
		if(e.getSource() == this.btnRemove){
			tableModel.removeRow(table.getSelectedRow());
		}
		
	}

}
