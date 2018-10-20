package P2_20180424;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

@SuppressWarnings("all")
public class Artikeltest {

	public static void main(String[] args) {
		
		/*
		 *  Artikel erstellen
		 */
		Artikel a1 = new Artikel(10001,"Fueller",29.99);
		Artikel a2 = new Artikel(10002,"Glas",6.99);
		Artikel a3 = new Artikel(10003,"Kaffeetasse",5.99);
		Artikel a4 = new Artikel(10004,"Tischleuchte",29.50);
		Artikel a5 = new Artikel(10005,"Kugelschreiber",1.99);
		Artikel a6 = new Artikel(10006,"Bleistift",0.99);
		Artikel a7 = new Artikel(10007,"Tischkalender",10.00);
		Artikel a8 = new Artikel(10009,"Folienschreiber Set",4.89);
		Artikel a9 = new Artikel(10008,"Tafelmagnet",0.59);
		Artikel a10 = new Artikel(10010,"Lineal 30 cm",3.99);
		Artikel a11 = new Artikel(10012,"Scheere",2.50);
		Artikel a12 = new Artikel(10011,"Locher",7.99);
		Artikel a13 = new Artikel(10014,"Hefter",14.69);
		Artikel a14 = new Artikel(10013,"Schnellhefter",0.79);
		Artikel a15 = new Artikel(10015,"Anspitzer",6.09);
		Artikel a16 = new Artikel(10016,"Radiergummi",1.99);
		Artikel a17 = new Artikel(10017,"Klebestift",2.49);
		Artikel a18 = new Artikel(10020,"Stempelkissen",4.29);
		Artikel a19 = new Artikel(10019,"Textmarker",0.99);
		Artikel a20 = new Artikel(10018,"Ordner, breit",4.99);
		Artikel a21 = new Artikel(10021,"Ordner schmal",3.99);		
		Artikel a22 = new Artikel(10025,"Notitzblock",3.39);
		Artikel a23 = new Artikel(10023,"Büroklammern",5.55);
		Artikel a24 = new Artikel(10024,"Heftklammern",2.29);
		Artikel a25 = new Artikel(10022,"Schreibunterlage",12.99);
		
		/*
		 *  Erstellen Sie eine Collection, in der  Artikelobjekte augenommen werden können.
		 */
		LinkedList<Artikel> aliste = new LinkedList<Artikel>();
		aliste.add(a3);
		aliste.add(a13);
		aliste.add(a23);
		aliste.add(a4);
		aliste.add(a11);
		
		/*
		 *  Sortieren Sie die Objekte in der Liste nach dem Sortieralgorithmus, wie er in der Klasse Artikel definiert ist.
		 */
		Collections.sort(aliste);
		/*
		 *  Ausgabe der sortierten Liste
		 */
		ausgabe(aliste);
		
		/*
		 *  Nutzen Sie für die Sortierung die von Ihnen erstellte Komparatorklasse
		 */
		Collections.sort(aliste, new MyComp());
		/*
		 *  Ausgabe der sortierten Liste
		 */
		ausgabe(aliste);
		
		
		
		// Sortieren Sie die Liste und lassen Sie die Liste auf der Konsole ausgeben.
	}
	
	/**
	 * Schreiben Sie eine Methode, bei der die Liste ausgegeben wird.
	 * Übergeben Sie die Liste als Parameter
	 */
	public static void ausgabe(LinkedList<Artikel> aliste){
		/*
		 *  Ausgabe einer Leerzeile
		 */
		System.out.println();
		
		/*
		 *  Ausgabe der übergebenen Liste mittels einer for-each-Schleife
		 */
		for(Artikel a: aliste)
			System.out.println(a);
		
		/* 
		 * Ausgabe der übergebenen Liste mittes eines Iterators
		 */
//		Iterator<Artikel> it = aliste.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
	}

}
