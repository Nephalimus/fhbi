package P2_20180522;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Fenster3 extends JFrame{

	public Fenster3() {
		super.setTitle("Mein Fenster");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLocation(500,200);
		super.setSize(500,200);
		
		super.setLayout(new FlowLayout(FlowLayout.RIGHT));
		super.add(new JButton("1"));
		super.add(new JButton("2"));
		super.add(new JButton("3"));
		super.add(new JButton("4"));
		super.add(new JButton("5"));
		super.add(new JButton("6"));
		
		super.setVisible(true);
	}

	public static void main(String[] args) {
		new Fenster3();

	}

}
