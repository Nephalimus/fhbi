package P2_20180522;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("all")
public class SimpleButton extends JFrame{
	
	private JButton btn = new JButton("Click me!");

	public SimpleButton(String title) {
		super.setTitle(title);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.add(this.btn,BorderLayout.CENTER);
		this.btn.setPreferredSize(new Dimension(250,40));
		super.pack();
		super.setVisible(true);
	}
	
	public static void main(String[] args){
		new SimpleButton("Der Fenstertitel");
	}

}
