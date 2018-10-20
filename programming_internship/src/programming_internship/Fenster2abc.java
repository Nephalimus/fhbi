package programming_internship;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("all")

public class Fenster2abc extends JFrame{
	
	public JTextField name = new JTextField("Name");
	public JTextField geburtsjahr = new JTextField("Geburtsjahr");
	public JButton rechne = new JButton("Rechne");
	public JCheckBox gehabt = new JCheckBox("Schon Geburtstag gehabt");

	public Fenster2abc() {
		this.setTitle("Mein Fenster");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(500,200,500,200);		
		this.setLayout(new FlowLayout());//FlowLayout.RIGHT));
		
		this.add(name);
		this.add(geburtsjahr);
		this.add(rechne);
		this.add(gehabt);
		
		rechne.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GregorianCalendar cal = new GregorianCalendar();
				int year = cal.get(GregorianCalendar.YEAR);
				try {
					int alter = year - Integer.parseInt(geburtsjahr.getText().trim());
					if(!gehabt.isSelected()) {
						alter--;
					}
					String message = "Hallo " + name.getText().trim() + ", du bist " + alter + " Jahre alt";
					JOptionPane.showMessageDialog(null, message); // null für Mitte des Bildschirms, unabhängig vom Fenster, da hier kein Zugriff
				} catch (NumberFormatException ex) {
					geburtsjahr.setText("JJJJ");
					JOptionPane.showMessageDialog(null, "Geburtsjahr ist keine valide Zahl. Bitte Geburtsjahr im Format JJJJ angeben");
				}
			}
		});
		
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Fenster2abc();
	}


}
