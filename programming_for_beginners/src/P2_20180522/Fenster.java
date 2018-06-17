package P2_20180522;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Fenster extends JFrame{

	public Fenster() {
		super.setTitle("Mein Fenster");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLocation(500,200);
		super.setSize(500,200);
//		super.setBounds(500,200,500,200);
		super.add(new JButton("North"),BorderLayout.NORTH);
		super.add(new JButton("South"),BorderLayout.SOUTH);
		super.add(new JButton("West"),BorderLayout.WEST);
		super.add(new JButton("East"),BorderLayout.EAST);
		super.add(new JButton("Center"),BorderLayout.CENTER);	
		
		super.setVisible(true);
	}

	public static void main(String[] args) {
		new Fenster();

	}

}
