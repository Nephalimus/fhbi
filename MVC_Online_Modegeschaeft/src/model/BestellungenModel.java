package model;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.JLabel;

/**
* Verwaltet die einzelnen Bestellungen indem
* es sie erstellt und in einer ArrayList speichert.
*/
public class BestellungenModel {

	 int id = 0;
	 TreeMap<Integer, BestellungModel> bestellungen = new TreeMap<Integer, BestellungModel>();
	
	/**
	* Erstellt eine neue Bestellung aus dem übergebenen Warenkorb
	* und erstellt durch die Übergabe des Kunden in der Bestellung 
	* eine Referenz von der Bestellung zum Kunden. Die id dient 
	* dazu durchgängige Bestellungsnummern zu erhalten.
	*
	* @param arrayList ArrayList von Artikeln im Warenkorb
	* @param k_model Kunde der die Bestellung ausgelöst hat
	* 
	* @return Bestellungsnummer der Bestellung
	**/
	public int neueBestellung(ArrayList<ArtikelModelInterface> arrayList, KundeModel k_model) {
		id++;
		BestellungModel neuB = new BestellungModel(id, k_model);
		
		for(ArtikelModelInterface a_model: arrayList){
			neuB.hinzufuegenArtikel(a_model);
		}
		
		bestellungen.put(id, neuB);
		NumberFormat n = NumberFormat.getInstance();
		n.setMaximumFractionDigits(2);
		System.out.println("Neue Bestellung " + id + " mit Betrag von " + n.format(bestellungen.get(id).getGesamtbetrag()) + "€ eingegangen.");
		return id;
		
	}
	
	public BestellungModel getBestellung(int nr){
		return bestellungen.get(nr);
	}
	
}
