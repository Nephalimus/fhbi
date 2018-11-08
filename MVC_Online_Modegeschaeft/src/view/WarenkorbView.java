package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.WarenkorbController;
import model.Observer;
import model.WarenkorbModel;

public class WarenkorbView implements Observer{

	private WarenkorbModel wk_model;
	private WarenkorbController wk_controller;
	private JFrame frame = new JFrame();
	private JTable table;
	private JButton bestellenButton;
	private JLabel gesamtpreis;
	private JPanel paneltable = new JPanel();
	private JPanel panelunten = new JPanel();
	
	public WarenkorbView(WarenkorbModel model){
		wk_model = model;
		wk_model.register(this);
		wk_controller = new WarenkorbController(wk_model, this);
		createComponents();
	}

	public void createComponents() {
		
		frame.setTitle("Warenkorb " + wk_model.getKunde().getNachname());
		frame.setSize(800, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
		
        String spalten[] = {"Pos.", "Bezeichnung", "Preis"};
		String [][] daten = new String[wk_model.getArtikelliste().size()][3];
		
		for(int i = 0; i < wk_model.getArtikelliste().size(); i++){
			int zaehler = i;
			zaehler++;
			daten[i][0] = String.valueOf(zaehler);
			daten[i][1] = wk_model.getArtikelliste().get(i).getBezeichnung();
			daten[i][2] = String.valueOf(wk_model.getArtikelliste().get(i).getPreis());
		}
		
		table = new JTable(daten, spalten);	
	    table.getColumn("Pos.").setPreferredWidth(20);
	    table.getColumn("Bezeichnung").setPreferredWidth(120);
	    table.getColumn("Preis").setPreferredWidth(50);
		paneltable.add(table);
		
		double preis = 0;
		for(int i = 0; i < wk_model.getArtikelliste().size(); i++){
			preis = preis + wk_model.getArtikelliste().get(i).getPreis();
		}
		NumberFormat n = NumberFormat.getInstance();
		n.setMaximumFractionDigits(2);
		gesamtpreis = new JLabel("Gesamtpreis: " + n.format(preis));
		panelunten.setLayout(new GridLayout(2,1));
		panelunten.add(gesamtpreis);
		
		bestellenButton = new JButton("bestellen");
		bestellenButton.setPreferredSize(new Dimension(100, 50));
		bestellenButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				wk_controller.bestellen();
			}
		});
		panelunten.add(bestellenButton);
		
		frame.add(paneltable, BorderLayout.CENTER);
		frame.add(panelunten, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public void update() {
		
		paneltable.remove(table);
		frame.remove(paneltable);
		panelunten.remove(gesamtpreis);
		panelunten.remove(bestellenButton);
		frame.remove(panelunten);
		createComponents();
		
	}
}
