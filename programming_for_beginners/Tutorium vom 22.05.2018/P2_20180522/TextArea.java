package P2_20180522;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class TextArea extends JFrame{
	private JTextArea ta = new JTextArea();

	public TextArea(String title) {
		super.setTitle(title);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.add(this.ta,BorderLayout.CENTER);
		this.ta.setPreferredSize(new Dimension(250,150));
		super.pack();
		super.setVisible(true);
	}
	
	public static void main(String[] args){
		new TextArea("Der Fenstertitel");
	}

}
