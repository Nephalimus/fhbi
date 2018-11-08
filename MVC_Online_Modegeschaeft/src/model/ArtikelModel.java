package model;

import java.util.ArrayList;

/**
* Artikel können von Kunden in deren Warenkorb hinzugefügt werden
* und dann bestellt werden.
*/
public class ArtikelModel implements ArtikelModelInterface{

	private int artikelnummer;
	private String bezeichnung;
	private double preis;
	private ArrayList<Observer> a_observers = new ArrayList<Observer>();
	
	public ArtikelModel(int aNr, String bez, double pr){
		this.artikelnummer = aNr;
		this.bezeichnung = bez;
		this.preis = pr;			
	}
	
	public int getArtikelnummer(){
		return artikelnummer;
	}
	
	public String getBezeichnung(){
		return bezeichnung;
	}
	
	public double getPreis(){
		return preis;
	}
	
	public void setBezeichnung(String bezeichnung){
		this.bezeichnung = bezeichnung;
		notifyObservers();
	}
	
	public void setPreis(double preis){
		this.preis = preis;
		notifyObservers();
	}

	public void register(Observer view) {
		a_observers.add(view);
	}

	public void removeObserver(Observer view) {

		if(a_observers.contains(view)){
			a_observers.remove(view);
		}
		
	}

	public void notifyObservers() {
		
		for(int i = 0; i < a_observers.size(); i++){
			a_observers.get(i).update();
		}
		
	}
	
}
