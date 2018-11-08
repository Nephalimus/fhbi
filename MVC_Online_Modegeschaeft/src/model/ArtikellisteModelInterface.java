package model;

import java.util.ArrayList;


public interface ArtikellisteModelInterface extends Observable{

	public void hinzufuegenArtikelZuArtikelliste(ArtikelModelInterface a_model);
	public void loescheArtikelAusArtikelliste(ArtikelModelInterface a_model);
	
	public ArrayList<ArtikelModelInterface> getArtikelliste();
	
}
