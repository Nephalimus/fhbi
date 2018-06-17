package P2_20180522;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel2 extends JPanel{
	
	private JButton btnSpeichern = new JButton("Speichern");
	private JButton btnBeednden = new JButton("Beenden");

	public Panel2() {
		super.setLayout(new FlowLayout(FlowLayout.RIGHT));
		super.add(btnSpeichern);
		super.add(btnBeednden);
	}

}
