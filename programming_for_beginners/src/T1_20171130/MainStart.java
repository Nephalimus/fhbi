package T1_20171130;

public class MainStart {

	public static void main(String[] args) {
		// Artikelliste als Array erstellen
				Artikel[] artliste = new Artikel[15];
				
				// Array mit neuen Artikeln füllen
				artliste[0] = new Artikel(10001,"Handschuhe", 12.99);
				artliste[1] = new Artikel(10002,"Stiefel", 25.66);
				artliste[2] = new Artikel(10003,"Schaal", 5.99);
				artliste[3] = new Artikel(10004,"Mütze", 6.2);
				artliste[4] = new Artikel(10005,"Telefon", 299.90);
				artliste[5] = new Artikel(10006,"Teller", 2.99);
				artliste[6] = new Artikel(10007,"Kartoffeln", 2.55);
				artliste[7] = new Artikel(10008,"Haribo Gummibärchen", 0.95);
				artliste[8] = new Artikel(10009,"Turnschuhe Addischlapp", 149.5);
				artliste[9] = new Artikel(10010,"Pullover", 12.99);
				artliste[10] = new Artikel(10011,"Hemd Sport", 12.33);
				artliste[11] = new Artikel(10012,"Tesafilm 10er", 7.50);
				artliste[12] = new Artikel(10013,"Früchtetee",1.89);
				artliste[13] = new Artikel(10014,"Tischlampe",26.99);
				artliste[14] = new Artikel(10015,"Stempelkissen",2.89);
				
				// Kundenliste als Array erstellen
				Kunde[] kdliste= new Kunde[2];
				// Array mit neuen Kunden  füllen
				kdliste[0] = new Kunde(50001,"Frau","Walther","Edeltraut","Kurfürstenstraße 12a","32049","Herford");
				kdliste[1] = new Kunde(50002,"Herr","Thielmeier","Tim","Universitätsstraße 45","33615","Bielefeld");
				
				// Warenkorb für den Kunden Walther erzeugen
				Warenkorb ww = new Warenkorb(1001,kdliste[0]);
				
				// Warenkorb für Kunden Thielmeier erzeugen
				Warenkorb wt = new Warenkorb(1002,kdliste[1]);
			
				// Bestellungen für Thielmeier ausführen
				wt.addBestellung(new Bestellung(artliste[3], 2));
				wt.addBestellung(new Bestellung(artliste[5], 3));
				wt.addBestellung(new Bestellung(artliste[11], 1));
				wt.addBestellung(new Bestellung(artliste[4], 1));
				wt.addBestellung(new Bestellung(artliste[11], 1));
				
				// Bestellungen für Walther ausführen
				ww.addBestellung(new Bestellung(artliste[3], 2));
				ww.addBestellung(new Bestellung(artliste[5], 3));
				ww.addBestellung(new Bestellung(artliste[1], 12));
				ww.addBestellung(new Bestellung(artliste[2], 2));
				ww.addBestellung(new Bestellung(artliste[1], 3));
				ww.addBestellung(new Bestellung(artliste[8], 1));
				ww.addBestellung(new Bestellung(artliste[5], 3));
				ww.addBestellung(new Bestellung(artliste[6], 1));
				ww.addBestellung(new Bestellung(artliste[7], 3));
				ww.addBestellung(new Bestellung(artliste[9], 1));
				ww.addBestellung(new Bestellung(artliste[13], 3));
			
				// Ausgabe des aktuellen Warenkorbes von Thielmeier 
				wt.druckeListe();
				
				// Bestellung für Thielmeier erfassen
				wt.addBestellung(new Bestellung(artliste[11],5));
				
				// Ausgabe des aktuellen Warenkorbs von Thielmeier
				wt.druckeListe();
				
				// Ausgabe des aktuellen Warenkorbes von Walther 
				ww.druckeListe();
				
				// Artikel aus dem Warenkorb für Walther entfernen
				System.out.println();
				System.out.println("Position 3 - " + ww.getListe()[2] + " wird entfernt.");
				ww.removeBestellung(3);
				
				// Ausgabe des aktuellen Warenkorbes von Walther 
				ww.druckeListe();
				
				// Neuen Artikel für Walther bestellen
				Bestellung bestellung = new Bestellung(artliste[14], 5);
				ww.addBestellung(bestellung);
				System.out.println();
				System.out.println("Bestellung - " + ww.getListe()[2] + " wurde hinzugefügt.");
				
				// Ausgabe des aktuellen Warenkorbes von Walther 
				ww.druckeListe();
			}

}
