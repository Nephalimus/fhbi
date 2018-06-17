package P2_20180410;

public class Bestellung {
	
	private Artikel artikel;
	private int bestellmenge;
	private double gesamtpreis;

	public Bestellung(Artikel artikel, int bestellmenge) {
		this.artikel = artikel;
		this.bestellmenge = bestellmenge;
		this.gesamtpreis = this.artikel.getPreis() * this.bestellmenge;
	}

	public Artikel getArtikel() {
		return artikel;
	}

	public void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}

	public int getBestellmenge() {
		return bestellmenge;
	}

	public void setBestellmenge(int bestellmenge) {
		this.bestellmenge = bestellmenge;
		this.gesamtpreis = this.artikel.getPreis() * this.bestellmenge; 
	}

	public double getGesamtpreis() {
		return gesamtpreis;
	}
	
	public void drucken(){
		this.artikel.drucken();
		System.out.println("Bestellmenge: " + this.bestellmenge);
		System.out.println("Gesamtpreis Artikel (" + artikel.getBezeichnung() + "): " + this.gesamtpreis + " €");
	}
	
	@Override
	public String toString(){
		return this.artikel.toString() + ";" + this.bestellmenge + ";" + this.gesamtpreis; 
	}
	

}
