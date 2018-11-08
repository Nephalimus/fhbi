package model;

import java.util.ArrayList;

import view.ArtikellisteView;

public class ArtikellisteModel implements ArtikellisteModelInterface{

	private ArrayList<ArtikelModelInterface> artikelliste = new ArrayList<ArtikelModelInterface>();
	private ArrayList<Observer> a_observers = new ArrayList<Observer>();
	private KundeModel k_model;
	
	public ArtikellisteModel(KundeModel k_model){
		this.k_model = k_model;
	}
	
	public void hinzufuegenArtikelZuArtikelliste(ArtikelModelInterface a_model){
		artikelliste.add(a_model);
		notifyObservers();
	}
	
	/**
	* Löscht den ersten Artikel in der Artikelliste der mit dem 
	* übergebenen Artikel übereinstimmt.
	*
	* @param a Artikel, der aus dem Warenkorb gelöscht werden soll
	**/
	public void loescheArtikelAusArtikelliste(ArtikelModelInterface a_model){
		boolean geloescht = false;
		
		for(int i = 0; i < artikelliste.size(); i++){
			if(a_model.getArtikelnummer() == artikelliste.get(i).getArtikelnummer() && geloescht == false){
				artikelliste.remove(i);
				geloescht = true;
			}
		}
		
		notifyObservers();
		
	}
	
	public KundeModel getKunde(){
		return k_model;
	}
	
	public ArrayList<ArtikelModelInterface> getArtikelliste(){
		return artikelliste;
	}
	
	public void register(Observer artikellisteView) {
		a_observers.add(artikellisteView);
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
