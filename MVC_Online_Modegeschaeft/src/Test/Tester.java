package Test;


import view.ArtikelLableView;
import view.ArtikellisteView;
import view.WarenkorbView;
import model.ArtikellisteModel;
import model.BestellungenModel;
import model.KleidungsartikelModel;
import model.KundeModel;
import model.SchuhartikelModel;


public class Tester {
	
	public static void main(String[] args){
	
		//Erstellen eines Objektes der Klasse Bestellungen das die einzelnen Bestellungen verwaltet
		BestellungenModel best = new BestellungenModel();
		
		//Erstellen von 4 Beispielartikeln
		SchuhartikelModel NikeFree = new SchuhartikelModel(1, "Nike Free", 89.99, "Laufschuh", "Kunststoff");
		SchuhartikelModel NewBalanceWi = new SchuhartikelModel(2, "New Balance Wi", 79.99, "Sneaker", "Leder");
		KleidungsartikelModel AdidasJacke = new KleidungsartikelModel(3, "Adidas Jacke", 59.99, "Polyester");
		KleidungsartikelModel TommyHilfigerShirt = new KleidungsartikelModel(4, "Tommy Hilfiger T-Shirt", 24.99, "Baumwolle");
	
		KundeModel Mueller = new KundeModel("1;Mueller;Tom", best);
		
		ArtikellisteModel artikelliste= new ArtikellisteModel(Mueller);
		artikelliste.hinzufuegenArtikelZuArtikelliste(NikeFree);
		artikelliste.hinzufuegenArtikelZuArtikelliste(NewBalanceWi);
		artikelliste.hinzufuegenArtikelZuArtikelliste(AdidasJacke);
		artikelliste.hinzufuegenArtikelZuArtikelliste(TommyHilfigerShirt);
		ArtikellisteView alview = new ArtikellisteView(artikelliste);
		
		Mueller.getWarenkorb().hinzufuegenArtikelZuArtikelliste(NikeFree);
		Mueller.getWarenkorb().hinzufuegenArtikelZuArtikelliste(TommyHilfigerShirt);
		WarenkorbView wkview = new WarenkorbView(Mueller.getWarenkorb());
		
	}
	
}
