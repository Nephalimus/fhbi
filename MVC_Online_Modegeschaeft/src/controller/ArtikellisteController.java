package controller;

import view.ArtikellisteView;
import model.ArtikelModelInterface;
import model.ArtikellisteModel;
import model.ArtikellisteModelInterface;

public class ArtikellisteController {
	
	private ArtikellisteModel al_model;
	private ArtikellisteView al_view;
	
	public ArtikellisteController(ArtikellisteModel model, ArtikellisteView view){
		this.al_model = model;
		this.al_view = view;
	}
	
	public void hinzufuegenArtikelZuArtikelliste(ArtikelModelInterface a_model){
		al_model.hinzufuegenArtikelZuArtikelliste(a_model);
	}
	
	public void loescheArtikelAusArtikelliste(ArtikelModelInterface a_model){
		al_model.loescheArtikelAusArtikelliste(a_model);
	}

}
