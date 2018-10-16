package Ue2_Online_Modegeschaeft;

import java.util.ArrayList;
import java.util.TreeMap;

/**
* Verwaltet die einzelnen Bestellungen indem
* es sie erstellt und in einer ArrayList speichert.
*/
public class Bestellungen {

	 int id = 0;
	 TreeMap<Integer, Bestellung> bestellungen = new TreeMap<Integer, Bestellung>();
	
	/**
	* Erstellt eine neue Bestellung aus dem übergebenen Warenkorb
	* und erstellt durch die Übergabe des Kunden in der Bestellung 
	* eine Referenz von der Bestellung zum Kunden. Die id dient 
	* dazu durchgängige Bestellungsnummern zu erhalten.
	*
	* @param w ArrayList von Artikeln im Warenkorb
	* @param k Kunde der die Bestellung ausgelöst hat
	* 
	* @return Bestellungsnummer der Bestellung
	**/
	public int neueBestellung(ArrayList<Artikel> w, IKunde k) {
		id++;
		Bestellung neuB = new Bestellung(id, k);
		
		for(Artikel a: w){
			neuB.hinzufuegenArtikel(a);
		}
		
		bestellungen.put(id, neuB);
		return id;
		
	}
	
	public Bestellung getBestellung(int nr){
		return bestellungen.get(nr);
	}
	
}
