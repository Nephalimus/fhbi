package P2_20180515;

import java.util.Comparator;

/**
 * Komparatorklasse soll Objekte der Klasse Artikel sortieren. Es soll nach
 * Artikelbezeichnung aufsteigend sortiert werden.
 * 
 * @author sleonardo
 *
 */
/*
 * Komparatorklasse muss das Interface Comparator<Artikel> implementieren
 */
public class MyComp implements Comparator<Artikel> {

	/*
	 * Nach der Implentierung des Interfaces muss zwingend die Methode
	 * compare(Artikel a1, Artikel a2) des Interfaces Comparator überschrieben
	 * werden.
	 */
	@Override
	public int compare(Artikel a1, Artikel a2) {
		
		return a1.getArtikelbezeichnung().compareTo(a2.getArtikelbezeichnung());
		
		/* *********************************
		 * * Weitere Sortiermöglichkeiten: *
		 * *********************************
		 * 
		 * Bei ganzzahligen Datentypen:
		 * ===========================
		 * return a1.getArtikelnummer() - a2.getArtikelnummer() -> nach Artikelnummer aufsteigend
		 * return a2.getArtikelnummer() - a1.getArtikelnummer -> nach Artikelnummer absteigend
		 * 
		 * Bei Fließkommawerten:
		 * =====================
		 * return Double.compare(a1.getPreis(),a2.getPreis()) -> Nach Preis aufsteigend
		 * return Double.compare(a2.getPreis(),a1.getPreis()) -> nach Preis absteigend
		 * return ((Double)a1.getPreis()).compareTo((Double)a2.getPreis()) -> Nach Preis aufsteigend
		 * return ((Double)a2.getPreis()).compareTo((Double)a1.getPreis()) -> nach Preis absteigend
		 * 
		 * Bei Zeichenketten:
		 * ==================
		 * return a1.getArtikelbezeichnung().compareTo(a2.getArtikelbezeichnung()) -> nach Artikelbezeichnung aufsteigend
		 * return a2.getArtikelbezeichnung().compareTo(a1.getArtikelbezeichnung()) -> nach Artikelbezeichnung absteigend
		 */
		
	}

}
