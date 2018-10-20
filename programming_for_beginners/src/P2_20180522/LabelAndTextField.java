package P2_20180522;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("all")
public class LabelAndTextField extends JFrame{

	private JLabel lbl = new JLabel("Bitte Namen eingeben: ");
	private JTextField tf = new JTextField();
	
	public LabelAndTextField(String title) {
		super.setTitle(title);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLayout(new FlowLayout());
		super.add(lbl);
		super.add(tf);
		tf.setPreferredSize(new Dimension(150,20));
		super.pack();
		super.setVisible(true);
	}

	public static void main(String[] args) {
		new LabelAndTextField("Namenseingabe");

	}

}
