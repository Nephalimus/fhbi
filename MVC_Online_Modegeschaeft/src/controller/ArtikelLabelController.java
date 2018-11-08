package controller;

import view.ArtikelLableView;
import model.ArtikelModelInterface;
import model.KundeModel;

public class ArtikelLabelController implements ArtikelControllerInterface{

	private ArtikelModelInterface a_model;
	private ArtikelLableView a_view;
	private KundeModel k_model;
	
	public ArtikelLabelController (ArtikelModelInterface model, ArtikelLableView view, KundeModel k_model){
		this.a_model = model;
		this.a_view = view;
		this.k_model = k_model;
	}
	
	public void artikelZuWarenkorb(){
		k_model.getWarenkorb().hinzufuegenArtikelZuArtikelliste(a_model);
	}
	
	public void loescheArtikelAusWarenkorb(){
		k_model.getWarenkorb().loescheArtikelAusArtikelliste(a_model);
	}
	
}
