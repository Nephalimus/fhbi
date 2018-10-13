package Ue2_Online_Modegeschaeft;

public class Tester {
	
	public static void main(String[] args){
	
		//Erstellen eines Objektes der Klasse Bestellungen das die einzelnen Bestellungen verwaltet
		Bestellungen best = new Bestellungen();
		
		//Erstellen von 4 Beispielartikeln
		Schuhartikel NikeFree = new Schuhartikel(1, "Nike Free", 89.99, "Laufschuh", "Kunststoff");
		Schuhartikel NewBalanceWi = new Schuhartikel(2, "New Balance Wi", 79.99, "Sneaker", "Leder");
		Kleidungsartikel AdidasJacke = new Kleidungsartikel(3, "Adidas Jacke", 59.99, "Polyester");
		Kleidungsartikel TommyHilfigerShirt = new Kleidungsartikel(4, "Tommy Hilfiger T-Shirt", 24.99, "Baumwolle");
	
		Kunde Mueller = new Kunde("1;Mueller;Tom");
		
		
		//Erstellen des 1. Warenkorbes mit anschlieﬂendem Bestellvorgang
		Mueller.getWarenkorb().hinzufuegenArtikelZuWarenkorb(NikeFree);
		Mueller.getWarenkorb().hinzufuegenArtikelZuWarenkorb(AdidasJacke);
		int best1 = Mueller.getWarenkorb().bestellen(best);
		
		
		//Systemausgaben der 1. Bestellung 
		System.out.println("Bestellung: " + best.getBestellung(best1).getBestellNr());
		System.out.println(best.getBestellung(best1).getKunde().getNachname());
		System.out.println(best.getBestellung(best1).getGesamtbetrag() + "Ä");
		
		for(int i = 0; i < best.getBestellung(best1).getArtikelpositionen().size(); i++){
			System.out.println(best.getBestellung(best1).getArtikelpositionen().get(i).getBezeichnung());
		}
		
		
		//Erstellen des 2. Warenkorbes mit anschlieﬂendem Bestellvorgang
		Mueller.getWarenkorb().hinzufuegenArtikelZuWarenkorb(NewBalanceWi);
		Mueller.getWarenkorb().hinzufuegenArtikelZuWarenkorb(NikeFree);
		Mueller.getWarenkorb().hinzufuegenArtikelZuWarenkorb(TommyHilfigerShirt);
		Mueller.getWarenkorb().hinzufuegenArtikelZuWarenkorb(AdidasJacke);
		Mueller.getWarenkorb().loescheArtikelAusWarenkorb(NikeFree);
		int best2 = Mueller.getWarenkorb().bestellen(best);
		
		
		//Systemausgaben der 2. Bestellung
		System.out.println("Bestellung " + best.getBestellung(best2).getBestellNr());
		System.out.println(best.getBestellung(best1).getKunde().getNachname());
		System.out.println(best.getBestellung(best2).getGesamtbetrag() + "Ä");
		
		for(int i = 0; i < best.getBestellung(best2).getArtikelpositionen().size(); i++){
			System.out.println(best.getBestellung(best2).getArtikelpositionen().get(i).getBezeichnung());
		}
		
	}
	
}
