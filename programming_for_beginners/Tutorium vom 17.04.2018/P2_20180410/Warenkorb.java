package P2_20180410;

public class Warenkorb {

	private Kunde kunde;
	private Bestellung[] warenkorb;
	
	
	public Warenkorb(Kunde kunde) {
		this.kunde = kunde;
		this.warenkorb = new Bestellung[10];
	}
	
	public void addBestellung(Bestellung bestellung){
		for(int i = 0 ; i < this.warenkorb.length ; i++){
			if(warenkorb[i] == null){
				warenkorb[i] = bestellung;
				return;
			}		
			else if(warenkorb[i].getArtikel().getBezeichnung().equals(bestellung.getArtikel().getBezeichnung())){
				warenkorb[i].setBestellmenge(warenkorb[i].getBestellmenge()+bestellung.getBestellmenge());
				return;
			}
		}
		System.out.println("Warenkorb ist voll!!!");
		
	}
	
	public void druckeRechnung(){
		double gesamtpreis = 0;
		this.kunde.drucken();
		for(int i = 0 ; i < this.warenkorb.length && warenkorb[i] != null; i++){
			warenkorb[i].drucken();
			gesamtpreis += warenkorb[i].getGesamtpreis();
		}
		System.out.println("Gesamtpreis: " + gesamtpreis + " €");
		kunde.setUmsatzBisher(gesamtpreis);
		kunde.drucken();
	}

}
