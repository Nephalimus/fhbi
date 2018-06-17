package P2_20180529;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MyList extends JFrame{

	private String[] liste = {"Auswahl 1", "Auswahl 2", "Auswahl 3"};
	private JList<String> li = new JList<String>(liste);
	
	public MyList(String title) {
		super.setTitle(title);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLocation(200,200);
		super.setSize(250, 250);
		super.add(this.li);
		this.li.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// ListSelectionListener löst bei Verwendung einer 
		// Maus immer zwei Events aus.
//		this.li.addListSelectionListener(new ListSelectionListener(){
//
//			@Override
//			public void valueChanged(ListSelectionEvent e) {
//				System.out.println(li.getSelectedValue());
//			}
//			
//		});
		
		// MouseListener unter Verwendung eines MouseAdapters
		this.li.addMouseListener(new MouseAdapter(){
	
			@Override
			public void mousePressed(MouseEvent arg0) {
				System.out.println(li.getSelectedValue());
			}

		});
		
		// KeyListener unter Verwendung eines KeyAdapters
		this.li.addKeyListener(new KeyAdapter(){
			@Override
			public void keyReleased(KeyEvent arg0) {
				System.err.println(li.getSelectedValue());				
			}	
		});
		
		super.setVisible(true);
		
		
	}

	public static void main(String[] args) {
		new MyList("JList");
	}

}
