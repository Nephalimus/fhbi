package P2_20180522;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class CheckBox extends JFrame{
	
	private JCheckBox cb = new JCheckBox("Do you like things to click on?");

	public CheckBox(String title) {
		super.setTitle(title);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.add(this.cb,BorderLayout.CENTER);
		this.cb.setPreferredSize(new Dimension(250,40));
		super.pack();
		super.setVisible(true);
	}
	
	public static void main(String[] args){
		new CheckBox("Der Fenstertitel");
	}

}
