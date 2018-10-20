package P2_20180612;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("all")

public class ErfasseDatenDialog extends JDialog implements ActionListener{
	
	private JPanel pnlLabel;
	private JPanel pnlTextFields;
	private JPanel pnlButtons;
	private JTextField tfMatrikelnummer;
	private JTextField tfName;
	private JTextField tfVorname;
	private JTextField tfStudiengang;
	private JRadioButton rbAktiv;
	private JRadioButton rbInaktiv;
	private JButton btnErfassen;
	private JButton btnAbbrechen;
	private MyJTableView gui;

	public ErfasseDatenDialog(MyJTableView gui, boolean modal) {
		super.setTitle("Erfassen");
		super.setModal(modal);
		super.setLocation(400,300);
		this.gui = gui;
		
		pnlLabel = new JPanel(new GridLayout(6,1,5,5));
		pnlTextFields = new JPanel(new GridLayout(6,1,5,5));
		pnlButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		pnlLabel.setPreferredSize(new Dimension(150,0));
		pnlTextFields.setPreferredSize(new Dimension(250,200));
		
		pnlLabel.add(new JLabel("Matriklenummer:"));
		pnlLabel.add(new JLabel("Name:"));
		pnlLabel.add(new JLabel("Vorname:"));
		pnlLabel.add(new JLabel("Studiengang:"));
		pnlLabel.add(new JLabel("Satus:"));
		
		pnlTextFields.add(tfMatrikelnummer = new JTextField());
		pnlTextFields.add(tfName = new JTextField());
		pnlTextFields.add(tfVorname = new JTextField());
		pnlTextFields.add(tfStudiengang = new JTextField());
		pnlTextFields.add(rbAktiv = new JRadioButton("aktiv"));
		pnlTextFields.add(rbInaktiv = new JRadioButton("inaktiv"));
		ButtonGroup btng = new ButtonGroup();
		btng.add(rbAktiv);
		btng.add(rbInaktiv);
		rbAktiv.setSelected(true);
		
		pnlButtons.add(btnErfassen = new JButton("Erfassen"));
		pnlButtons.add(btnAbbrechen = new JButton("Abbrechen"));
		
		super.add(pnlLabel, BorderLayout.WEST);
		super.add(pnlTextFields, BorderLayout.CENTER);
		super.add(pnlButtons, BorderLayout.SOUTH);
		
		btnErfassen.addActionListener(this);
		
		btnAbbrechen.addActionListener(this);
		
		super.pack();
		super.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btnErfassen){
			try{
				int matrikelnummer = Integer.parseInt(tfMatrikelnummer.getText());
				String name = tfName.getText();
				String vorname = tfVorname.getText();
				String studiengang = tfStudiengang.getText();
				boolean aktiv = rbAktiv.isSelected();
				gui.getTableModel().addRow(new Student(matrikelnummer,name, vorname, studiengang, aktiv));
				dispose();
				
			}catch(NumberFormatException nfe){
				tfMatrikelnummer.selectAll();
				tfMatrikelnummer.requestFocus();
			}
		}
		if(e.getSource() == this.btnAbbrechen){
			dispose();
		}
		
	}

}
