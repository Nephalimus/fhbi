package Arbeiten_mit_JTable;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class MessageDialog extends JDialog {

	private Studentenverwaltung gui;
	private JButton okButton;
	private JLabel information;


	/**
	 * Create the dialog.
	 */
	public MessageDialog(Studentenverwaltung gui, boolean erfolg) {
		/*
		 * Üergabe von Ausgangsfenster, der Fensterüberschrift und einer boolschen
		 * Information darüber, ob es sich um einen modalen oder nicht-modalen
		 * Dialog handeln soll.
		 * true == modaler Dialog
		 * false == nicht modaler Dialog
		 */
		super(gui,"Information",true);
		setSize(287,135);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		/*
		 * Displaygröße ermitteln
		 */
		Dimension display = Toolkit.getDefaultToolkit().getScreenSize();
		/*
		 * Grafische Anzeige mittig auf dem Display anzeigen.
		 */
		super.setLocation((display.getSize().width-getSize().width)/2,(display.getSize().height-getSize().height)/2);
		/*
		 * Darstellung an das Look and Feel von Windows angleichen.
		 */
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println(e);
		}
		/*
		 * Initialisieren des JLabel information
		 */
		information = new JLabel("",JLabel.CENTER);
		information.setFont(new Font("Tahoma", Font.BOLD, 14));
		if(erfolg){
			information.setText("Daten wurden erfolgreich gespeichert.");
			information.setForeground(new Color(0, 100, 0));
		}
		else{
			information.setText("Daten wurden nicht gespeichert!");
			information.setForeground(Color.RED);
		}
		/*
		 * Deklaration eines JPanels für die Steuerelenete.
		 * Indiesem Fall für den OK-Button.
		 */
		JPanel steuerelemente = new JPanel();
		/*
		 * Initialisierung des okButtons
		 */
		okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	
		steuerelemente.add(okButton);
		
		/*
		 * Hinzufügen der Steuerelemente
		 */
		getContentPane().add(information,BorderLayout.CENTER);
		getContentPane().add(steuerelemente,BorderLayout.SOUTH);
		
		setVisible(true);
	
	}

}
