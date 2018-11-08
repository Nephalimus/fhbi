package model;


import java.util.ArrayList;

/**
* Je ein Objekt pro Kunde vorhanden. In ihm können Artikel abgelegt werden
* und es kann die Bestellung ausgelöst werden.
*/
public class WarenkorbModel extends ArtikellisteModel{

	private BestellungenModel best;
	
	public WarenkorbModel(KundeModel k, BestellungenModel best){
		super(k);
		this.best = best;
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
	public int bestellen(){
		int nr = -1;
		
		if(super.getArtikelliste().size() > 0){
			nr = best.neueBestellung(super.getArtikelliste(), super.getKunde());
			super.getArtikelliste().clear();
		}else{
			System.out.println("Keine Artikel im Warenkorb");
		}
		super.notifyObservers();
		
		return nr;
		
	}
	
}
