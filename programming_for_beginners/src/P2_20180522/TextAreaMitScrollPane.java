package P2_20180522;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextAreaMitScrollPane extends JFrame{
	private JTextArea ta = new JTextArea();
	private JScrollPane sp = new JScrollPane(ta);

	public TextAreaMitScrollPane(String title) {
		super.setTitle(title);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.add(this.sp,BorderLayout.CENTER);
		this.sp.setPreferredSize(new Dimension(250,150));
		super.pack();
		super.setVisible(true);
	}
	
	public static void main(String[] args){
		new TextAreaMitScrollPane("Der Fenstertitel");
	}

}
