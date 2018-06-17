package P2_20180410;

public class MainTest {

	public static void main(String[] args) {

		Adresse adresse1 = new Adresse("Musterweg",11,"Musterhausen",12345);
		Kunde kunde1 = new Kunde("Mustermann","Andreas",adresse1);
		Artikel artikel1 = new Artikel("Hose",12.99);
		Artikel artikel2 = new Artikel("Schuhe",32.99);
		Artikel artikel3 = new Artikel("T-Shirt",9.99);
		Artikel artikel4 = new Artikel("Socken",3.99);
		
		Warenkorb w1 = new Warenkorb(kunde1);
		
		w1.addBestellung(new Bestellung(artikel1,1));
		w1.addBestellung(new Bestellung(artikel2,2));
		w1.addBestellung(new Bestellung(artikel3,1));
		w1.addBestellung(new Bestellung(artikel4,4));
		w1.addBestellung(new Bestellung(artikel1,1));
		
		w1.druckeRechnung();

	}

}
