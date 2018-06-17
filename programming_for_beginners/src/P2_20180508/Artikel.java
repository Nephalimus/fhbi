package P2_20180508;

/**
 * Die Klasse Artikel erstellt Objekte der Klasse Artikel. Gleichartige Objekte
 * sollen nach Artikelnummer aufsteigend sortierbar sein.
 * 
 * @author sleonardo
 *
 */
/* 
 * Artikelklasse muss das Interface Comparable<Artikel> implementieren
 */
public class Artikel implements Comparable<Artikel> {

	private int artikelnummer;
	private String artikelbezeichnung;
	private double preis;

	public Artikel(int artikelnummer, String artikelbezeichnung, double preis) {
		this.artikelnummer = artikelnummer;
		this.artikelbezeichnung = artikelbezeichnung;
		this.preis = preis;
	}

	public String getArtikelbezeichnung() {
		return artikelbezeichnung;
	}

	public void setArtikelbezeichnung(String artikelbezeichnung) {
		this.artikelbezeichnung = artikelbezeichnung;
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

	public String toString() {
		/*
		 * Ausgabe des Preises auf zwei Nachkommastellen gerundet ausgeben
		 */
		return this.artikelnummer + ": " + this.artikelbezeichnung + " Preis: " + Math.round(this.preis*100)/100.0 + " €.";
	}

	/*
	 * Nach der Implentierung des Interfaces muss zwingend die Methode
	 * compareTo(Artikel a) des Interfaces Comparable überschrieben
	 * werden.
	 */
	@Override
	public int compareTo(Artikel a) {
		
		return this.artikelnummer - a.getArtikelnummer();
		
		/* *********************************
		 * * Weitere Sortiermöglichkeiten: *
		 * *********************************
		 * 
		 * Bei ganzzahligen Datentypen:
		 * ===========================
		 * return this.artikelnummer - a.getArtikelnummer() -> nach Artikelnummer aufsteigend
		 * return a.getArtikelnummer() - this.artikelnummer -> nach Artikelnummer absteigend
		 * 
		 * Bei Fließkommawerten:
		 * =====================
		 * return Double.compare(this.preis,a.getPreis()) -> Nach Preis aufsteigend
		 * return Double.compare(a.getPreis(),this.preis) -> nach Preis absteigend
		 * return ((Double)this.preis).compareTo((Double)a.getPreis()) -> Nach Preis aufsteigend
		 * return ((Double)a.getPreis()).compareTo((Double)this.preis) -> nach Preis absteigend
		 * 
		 * Bei Zeichenketten:
		 * ==================
		 * return this.artikelbezeichnung.compareTo(a.getArtikelbezeichnung()) -> nach Artikelbezeichnung aufsteigend
		 * return a.getArtikelbezeichnung().compareTo(this.artikelbezeichnung) -> nach Artikelbezeichnung absteigend
		 */
				
	}
}
