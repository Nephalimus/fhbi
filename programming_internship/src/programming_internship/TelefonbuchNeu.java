package programming_internship;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("all")

public class TelefonbuchNeu extends JFrame {
	
	private ArrayList<TelefonbuchEintrag> eintraege = new ArrayList<TelefonbuchEintrag>();
	private JList liste = new JList();
	private JPanel inputPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JTextField vorname = new JTextField("Test");
	private JTextField nachname = new JTextField("Mensch");
	private JTextField telefon = new JTextField("1");
	private JButton hinzufuegen = new JButton("Hinzufügen");
	private JButton loeschen = new JButton("Löschen");
	private JButton aendern = new JButton("Ändern");
	private JButton speichern = new JButton("Speichern");
	
	public TelefonbuchNeu() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Mein Telefonbuch");
		this.setBounds(500,200,700,500);
		
		//this.setLayout(new BorderLayout());
		this.add(new JLabel("Mein Telefonbuch"), BorderLayout.PAGE_START);
		JScrollPane scrollPane = new JScrollPane();
		
		BufferedReader load = null;
		try {
			FileReader fw = new FileReader("Telefon.dat");
			load = new BufferedReader(fw);
			String s = load.readLine();
			do {
				String[] daten = s.split(";");
				TelefonbuchEintrag neu = new TelefonbuchEintrag(daten[1],daten[0],daten[2]);
				eintraege.add(neu);
				s = load.readLine();
			} while (s != null);
			load.close();
			liste.setListData(eintraege.toArray());
			JOptionPane.showMessageDialog(null, "Daten geladen - Viel Spaß!!");
		} catch (IOException ex1){
			JOptionPane.showMessageDialog(null, "Fehler - Daten konnten nicht geladen werden!");
		} 

		scrollPane.setViewportView(liste);
		liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		liste.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(liste.hasFocus()) {
					TelefonbuchEintrag curEintrag = eintraege.get(liste.getSelectedIndex());
					vorname.setText(curEintrag.getVorname());
					nachname.setText(curEintrag.getNachname());
					telefon.setText(curEintrag.getTelefon());
				}
			}
		});
		this.add(scrollPane, BorderLayout.CENTER);
		
		
		inputPanel.setLayout(new GridLayout(4,2,15,10));
		inputPanel.add(new JLabel("Vorname", 4));
		inputPanel.add(vorname);
		inputPanel.add(new JLabel("Nachname", 4));
		inputPanel.add(nachname);
		inputPanel.add(new JLabel("Telefon", 4));
		inputPanel.add(telefon);
		inputPanel.add(new JLabel(" ", 4));
		/*
		inputPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 20, 10, 20);
		gbc.gridx = 0;
		gbc.gridy = 0;
		inputPanel.add(new JLabel("Vorname", SwingConstants.RIGHT), gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		vorname.setPreferredSize(new Dimension(400, 20));
		inputPanel.add(vorname, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		inputPanel.add(new JLabel("Nachname", SwingConstants.RIGHT), gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		inputPanel.add(nachname, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		inputPanel.add(new JLabel("Telefon", SwingConstants.RIGHT), gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		inputPanel.add(telefon, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		inputPanel.add(buttonPanel, gbc);
		*/
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.add(aendern);
		aendern.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelefonbuchEintrag changedEintrag = new TelefonbuchEintrag(vorname.getText(), nachname.getText(), telefon.getText());
				int curIndex = liste.getSelectedIndex();
				eintraege.set(curIndex, changedEintrag);
				liste.setListData(eintraege.toArray());
			}
		});
		buttonPanel.add(loeschen);
		loeschen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int curIndex = liste.getSelectedIndex();
				if(curIndex != -1) {
					eintraege.remove(curIndex);
					liste.setListData(eintraege.toArray());
				}
			}
		});
		buttonPanel.add(hinzufuegen);
		hinzufuegen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelefonbuchEintrag neuerEintrag = new TelefonbuchEintrag(vorname.getText(), nachname.getText(), telefon.getText());
				eintraege.add(neuerEintrag);
				liste.setListData(eintraege.toArray());
				
				telefon.setText(""+(Integer.parseInt(telefon.getText()) + 1));
			}
		});
		
		buttonPanel.add(speichern);
		speichern.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BufferedWriter save = null;
				try {
					FileWriter fw = new FileWriter("Telefon.dat");
					JOptionPane.showMessageDialog(null, "Daten werden gespeichert");
					save = new BufferedWriter(fw);
					for(TelefonbuchEintrag eintrag : eintraege) {
						save.write(eintrag.getNachname() +";"+eintrag.getVorname()+";"+eintrag.getTelefon());
						save.newLine();
					}
					save.close();
					JOptionPane.showMessageDialog(null, "Daten gespeichert!");
				} catch (IOException ex1){
					JOptionPane.showMessageDialog(null, "Fehler - Daten konnten nicht gespeichert werden!");
				} 
			}
		});
		
		inputPanel.add(buttonPanel);
		this.add(inputPanel, BorderLayout.PAGE_END);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new TelefonbuchNeu();
	}

}
