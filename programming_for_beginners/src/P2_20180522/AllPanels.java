package P2_20180522;

import java.awt.BorderLayout;

import javax.swing.JFrame;

@SuppressWarnings("all")
public class AllPanels extends JFrame{

	public AllPanels() {
		super.setTitle("Alle Panels vereint");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.add(new Panel1(),BorderLayout.CENTER);
		super.add(new Panel2(), BorderLayout.SOUTH);
		super.pack();
		super.setVisible(true);
	}

	public static void main(String[] args) {
		new AllPanels();

	}

}
