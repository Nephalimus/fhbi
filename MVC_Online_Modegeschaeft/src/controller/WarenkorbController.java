package controller;

import model.ArtikelModelInterface;
import model.ArtikellisteModel;
import model.ArtikellisteModelInterface;
import model.WarenkorbModel;
import view.ArtikellisteView;
import view.WarenkorbView;

public class WarenkorbController {
	
	private WarenkorbModel wk_model;
	private WarenkorbView wk_view;
	
	public WarenkorbController(WarenkorbModel model, WarenkorbView warenkorbView){
		this.wk_model = model;
		this.wk_view = warenkorbView;
	}
	
	public void hinzufuegenArtikelZuArtikelliste(ArtikelModelInterface a_model){
		wk_model.hinzufuegenArtikelZuArtikelliste(a_model);
	}
	
	public void loescheArtikelAusArtikelliste(ArtikelModelInterface a_model){
		wk_model.loescheArtikelAusArtikelliste(a_model);
	}
	
	public void bestellen(){
		wk_model.bestellen();
	}
	
}
