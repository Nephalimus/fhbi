package P2_20180522;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Panel1 extends JPanel{
	
	private JLabel lblInfo = new JLabel("Bitte geben Sie hier einen Text ein: ");
	private JTextArea taInfo = new JTextArea();
	private JScrollPane sp = new JScrollPane(taInfo);
	private JCheckBox tb = new JCheckBox("test");

	public Panel1() {
		super.setLayout(new BorderLayout());
		super.add(lblInfo,BorderLayout.WEST);
		super.add(sp,  BorderLayout.CENTER);
		super.add(tb,  BorderLayout.EAST);
		lblInfo.setVerticalAlignment(JLabel.NORTH);
		sp.setPreferredSize(new Dimension(400,300));
	}

}
