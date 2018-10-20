package P2_20180515;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import edu.princeton.cs.introcs.StdIn;

@SuppressWarnings("all")
public class Artikeltest {

	public static void main(String[] args) {

		/*
		 * Artikel erstellen
		 */
		Artikel a1 = new Artikel(10001, "Fueller", 29.99);
		Artikel a2 = new Artikel(10002, "Glas", 6.99);
		Artikel a3 = new Artikel(10003, "Kaffeetasse", 5.99);
		Artikel a4 = new Artikel(10004, "Tischleuchte", 29.50);
		Artikel a5 = new Artikel(10005, "Kugelschreiber", 1.99);
		Artikel a6 = new Artikel(10006, "Bleistift", 0.99);
		Artikel a7 = new Artikel(10007, "Tischkalender", 10.00);
		Artikel a8 = new Artikel(10009, "Folienschreiber Set", 4.89);
		Artikel a9 = new Artikel(10008, "Tafelmagnet", 0.59);
		Artikel a10 = new Artikel(10010, "Lineal 30 cm", 3.99);
		Artikel a11 = new Artikel(10012, "Scheere", 2.50);
		Artikel a12 = new Artikel(10011, "Locher", 7.99);
		Artikel a13 = new Artikel(10014, "Hefter", 14.69);
		Artikel a14 = new Artikel(10013, "Schnellhefter", 0.79);
		Artikel a15 = new Artikel(10015, "Anspitzer", 6.09);
		Artikel a16 = new Artikel(10016, "Radiergummi", 1.99);
		Artikel a17 = new Artikel(10017, "Klebestift", 2.49);
		Artikel a18 = new Artikel(10020, "Stempelkissen", 4.29);
		Artikel a19 = new Artikel(10019, "Textmarker", 0.99);
		Artikel a20 = new Artikel(10018, "Ordner, breit", 4.99);
		Artikel a21 = new Artikel(10021, "Ordner schmal", 3.99);
		Artikel a22 = new Artikel(10025, "Notitzblock", 3.39);
		Artikel a23 = new Artikel(10023, "Büroklammern", 5.55);
		Artikel a24 = new Artikel(10024, "Heftklammern", 2.29);
		Artikel a25 = new Artikel(10022, "Schreibunterlage", 12.99);

		/*
		 * Erstellen Sie eine Map, in der Artikelobjekte aufgenommen werden
		 * können. Als Key-Value soll die Artikelnummer verwendet werden.
		 */
		TreeMap<Integer, Artikel> tm = new TreeMap<Integer, Artikel>();

		tm.put(a3.getArtikelnummer(), a3);
		tm.put(a7.getArtikelnummer(), a7);
		tm.put(a1.getArtikelnummer(), a1);
		tm.put(a16.getArtikelnummer(), a16);
		tm.put(a13.getArtikelnummer(), a13);
		tm.put(a20.getArtikelnummer(), a20);

		// int artikelnummer = -1;
		// String eingabe = "j";
		// while (eingabe.equalsIgnoreCase("j")) {
		// try {
		// System.out.println("Bitte geben Sie die Artikelnumer zum gesuchten Artikel an: ");
		// artikelnummer = StdIn.readInt();
		// Artikel artikel = tm.get(artikelnummer);
		// System.out.println(artikel.getArtikelbezeichnung());
		// } catch (NullPointerException npe) {
		// System.err.println("Artikel mit der Artikelnummer " + artikelnummer +
		// " ist nicht bekannt!!!");
		// try {
		// Thread.sleep(200);
		// } catch (InterruptedException e) {
		// // do nothing
		// }
		//
		// } finally {
		// System.out.print("Möchten Sie noch einen weiteren Artikel suchen? (j/n): ");
		// eingabe = StdIn.readString();
		// }
		// }

		int zahl1 = 12;
		int zahl2 = 0;
		try {
			if (zahl2 == 0)
				throw new ArithmeticException("Division durch 0!!!");
			int erg = zahl1 / zahl2;
			System.out.println("Erg: " + erg);
		} catch (ArithmeticException e) {
			System.err.println("Fehlermeldung: " + e.getMessage());
		}

	}

	/**
	 * Schreiben Sie eine Methode, bei der die Liste ausgegeben wird. Übergeben
	 * Sie die Liste als Parameter. Sorgen Sie dafür, dass die Methode alle
	 * Listen des Collection-Framework (ArrayList, LinkedList, etc.) ausgeben
	 * kann.
	 */
	public static void ausgabe(Collection<Artikel> aliste) {
		/*
		 * Ausgabe einer Leerzeile
		 */
		System.out.println();

		/*
		 * Ausgabe der übergebenen Liste mittels einer for-each-Schleife
		 */
		for (Artikel a : aliste)
			System.out.println(a);

		/*
		 * Ausgabe der übergebenen Liste mittels eines Iterators
		 */
		// Iterator<Artikel> it = aliste.iterator();
		// while(it.hasNext()){
		// System.out.println(it.next());
		// }
	}

}
