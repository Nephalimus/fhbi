package Ue2_Online_Modegeschaeft;

import java.util.ArrayList;

/**
* Je ein Objekt pro Kunde vorhanden. In ihm können Artikel abgelegt werden
* und es kann die Bestellung ausgelöst werden.
*/
public class Warenkorb {

	private ArrayList<Artikel> artikelliste = new ArrayList<Artikel>();
	private Kunde kunde;
	
	public Warenkorb(Kunde k){
		kunde = k;
	}
	
	public void hinzufuegenArtikelZuWarenkorb(Artikel a){
		artikelliste.add(a);
	}
	
	/**
	* Löscht den ersten Artikel in der Artikelliste der mit dem 
	* übergebenen Artikel übereinstimmt.
	*
	* @param a Artikel, der aus dem Warenkorb gelöscht werden soll
	**/
	public void loescheArtikelAusWarenkorb(Artikel a){
		boolean geloescht = false;
		
		for(int i = 0; i < artikelliste.size(); i++){
			if(a.getArtikelnummer() == artikelliste.get(i).getArtikelnummer() && geloescht == false){
				artikelliste.remove(i);
				geloescht = true;
			}
		}
		
	}
	
	/**
	* Löst eine Bestellung aus dem Warenkorb aus, wenn in der 
	* Artikelliste des Warenkorbes mindestens ein Artikel
	* vorhanden ist. 
	*
	* @param best Referenz auf ein Objekt Bestellungen von
	* dem aus die einzelne Bestellung erzeugt und verwaltet
	* wird.
	* 
	* @return Gibt den Wert -1 zurück wenn keine Bestellung 
	* ausgelöst wird. Gibt die Bestellungsnummer zurück 
	* wenn eine Bestellung ausgelöst wird.
	**/
	public int bestellen(Bestellungen best){
		int nr = -1;
		
		if(artikelliste.size() > 0){
			nr = best.neueBestellung(artikelliste, kunde);
			artikelliste.clear();
		}else{
			System.out.println("Keine Artikel im Warenkorb");
		}
		
		return nr;
		
	}
	
}
