package P2_20180529;


import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyGridBag extends JFrame {

	private JLabel lblName = new JLabel("Name:");
	private JLabel lblVorname = new JLabel("Vorname:");
	private JLabel lblKommentar = new JLabel("Kommentar:");
	private JButton btnAbbrechen = new JButton("Abbrechen");
	private JButton btnUebernehmen = new JButton("�bernehmen");
	private JTextField tfName = new JTextField(30);
	private JTextField tfVorname = new JTextField(30);
	private JTextArea taKommentar = new JTextArea(5, 5);
	private JScrollPane spKommentar = new JScrollPane(taKommentar);
	private JPanel pButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT));

	public MyGridBag(String title) {
		super.setTitle(title);
		super.setLocation(150, 150);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Layout auf GridBagLayout setzen
		super.setLayout(new GridBagLayout());
		// Eigenschaften f�r einzelne Elemente
		GridBagConstraints c;
		// Abst�de zwischen den Gui-Komponenten
		Insets set = new Insets(5, 5, 5, 5);

		// Eigenschaften f�r das Label lblName festlegen und Label hinzuf�gen
		c = new GridBagConstraints();
		c.insets = set;
		c.gridx = 0;
		c.gridy = 0;
		// Ausrichtung festlegen
		c.anchor = GridBagConstraints.LINE_START;
		super.add(this.lblName, c);

		// Eigenschaften f�r das Label lblVorname festlegen und Label hinzuf�gen
		c.gridy = 1;
		super.add(this.lblVorname, c);

		// Eigenschaften f�r das Label lblKommentar festlegen und Label
		// hinzuf�gen
		c.gridy = 2;
		super.add(this.lblKommentar, c);

		// Eigenschaften f�r das TextFeld tfName festlegen und Textfeld
		// hinzuf�gen
		c.gridx = 1;
		c.gridy = 0;
		// Breite f�r das textFeldfestlegen
		// REMAINDER bedeutet, dass es sich um das letzte Element in der
		// jeweiligen Zeile bzw. Spalte handelt.
		c.gridwidth = GridBagConstraints.REMAINDER;
		// HORIZONTAL gibt hier an, das es sich um das letzte Element in der
		// jeweiligen Zeile handelt.
		c.fill = GridBagConstraints.HORIZONTAL;
		super.add(this.tfName, c);

		// Eigenschaften f�r das TextFeld tfVorname festlegen und Textfeld
		// hinzuf�gen
		c.gridy = 1;
		super.add(this.tfVorname, c);

		// Eigenschaften f�r das ScrollPane mit der TextArea festlegen und
		// hinzuf�gen
		c.gridx = 0;
		c.gridy = 3;
		super.add(this.spKommentar, c);

		// Eigenschaften f�r das Panel festlegen und hinzuf�gen
		this.pButtons.add(this.btnAbbrechen);
		this.pButtons.add(this.btnUebernehmen);
		c.gridy = 4;
		c.anchor = GridBagConstraints.LINE_END;
		super.add(this.pButtons, c);
		
		

		super.pack();
		super.setVisible(true);

	}

	public static void main(String[] args) {
		new MyGridBag("Mein GridBagLayout");
	}

}
