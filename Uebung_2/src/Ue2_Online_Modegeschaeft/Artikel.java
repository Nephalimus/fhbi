package Ue2_Online_Modegeschaeft;

/**
* Artikel können von Kunden in deren Warenkorb hinzugefügt werden
* und dann bestellt werden.
*/
public class Artikel {

	private int artikelnummer;
	private String bezeichnung;
	private double preis;
	
	public Artikel(int aNr, String bez, double pr){
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
	
	public void setBezeichnung(String bez){
		this.bezeichnung = bez;
	}
	
	public double getPreis(){
		return preis;
	}
	
	public void setPreis(double preis){
		this.preis = preis;
	}
	
}
