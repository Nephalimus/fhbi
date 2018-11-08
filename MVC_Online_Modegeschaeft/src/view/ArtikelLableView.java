package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.ArtikelControllerInterface;
import controller.ArtikelLabelController;
import model.ArtikelModel;
import model.ArtikelModelInterface;
import model.KundeModel;
import model.Observer;

public class ArtikelLableView implements Observer{

	private ArtikelLabelController a_controller;
	private ArtikelModelInterface a_model;
	private JFrame frame;
	private JLabel artikelbezeichnung;
	private JLabel artikelpreis;
	private JButton inWarenkorbButton;
	
	public ArtikelLableView(ArtikelModelInterface artikelModelInterface, KundeModel k_model){
		a_model = artikelModelInterface;
		a_model.register(this);
		a_controller = new ArtikelLabelController(artikelModelInterface, this, k_model);
		createComponents();
	}
	
	public void createComponents(){
		
		frame = new JFrame("Artikel");
		
		artikelbezeichnung = new JLabel("Bezeichnung: " + a_model.getBezeichnung());
		artikelpreis = new JLabel("Preis: " + a_model.getPreis() + "€");
		inWarenkorbButton = new JButton("Warenkorb hinzufügen");
		inWarenkorbButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				a_controller.artikelZuWarenkorb();
			}
		});
		
		frame.setLayout(new GridLayout(3,1));
		frame.add(artikelbezeichnung);
		frame.add(artikelpreis);
		frame.add(inWarenkorbButton);
		
		frame.setSize(300, 150);
		
		frame.setVisible(true);

	}
	
	@Override
	public void update() {
		// Hier Werte des Models abfragen und Labels anpassen
	}

}
