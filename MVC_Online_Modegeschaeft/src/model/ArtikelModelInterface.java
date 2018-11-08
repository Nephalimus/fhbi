package model;


/**
 *Schnittstelle, die das Model definiert, das die Artikel speichert.
 */
public interface ArtikelModelInterface extends Observable{

	public int getArtikelnummer();
	public String getBezeichnung();
	public double getPreis();
	
	public void setBezeichnung(String bezeichnung);
	public void setPreis(double preis);
	
}
