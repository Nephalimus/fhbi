package T1_20171130;

public class Artikel {
	
	private int artikelnummer;
	private String artikelbezeichnung;
	private double preis;

	public Artikel(int artikelnummer, String artikelbezeichnung, double preis) {
		this.artikelnummer = artikelnummer;
		this.artikelbezeichnung = artikelbezeichnung;
		this.preis = preis;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	public int getArtikelnummer() {
		return artikelnummer;
	}

	public String getArtikelbezeichnung() {
		return artikelbezeichnung;
	}
	
	/**
	 * 
	 */
	@Override
	public String toString(){
		return "Artikelnummer: " +this.artikelnummer + " Artikelbezeichnung: " + this.artikelbezeichnung + " Einzelpreis: " + this.preis;
	}

}
