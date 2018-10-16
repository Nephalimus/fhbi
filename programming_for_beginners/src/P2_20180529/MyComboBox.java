package P2_20180529;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyComboBox extends JFrame{
	
	private String[] liste = {"Auswahl 1", "Auswahl 2", "Auswahl 3"};
	private JComboBox<String> cb = new JComboBox<String>(liste);
	

	public MyComboBox(String title) {
		super.setTitle(title);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLocation(200,200);
		super.add(new JLabel("JComboBox"),BorderLayout.NORTH);
		super.add(this.cb,BorderLayout.CENTER);
		this.cb.setPreferredSize(new Dimension(250,30));
		
		this.cb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(cb.getSelectedIndex() + ":  " + cb.getSelectedItem());
			}
			
		});
		super.pack();
		super.setVisible(true);
		
	}

	public static void main(String[] args) {
		new MyComboBox("MyComboBox");
	}

}
