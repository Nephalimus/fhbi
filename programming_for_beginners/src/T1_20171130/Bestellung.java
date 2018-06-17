package T1_20171130;

public class Bestellung {
	private Artikel artikel;
	private int anzahl;

	public Bestellung(Artikel artikel, int anzahl) {
		this.artikel = artikel;
		this.anzahl = anzahl;
	}

	public int getAnzahl() {
		return anzahl;
	}

	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

	public Artikel getArtikel() {
		return artikel;
	}

	@Override
	public String toString() {
		return this.artikel + " Betsellmenge: " + this.anzahl + " Gesamtpreis: " + (int)(this.artikel.getPreis() * this.anzahl*100+0.5)/100.0 + " €";
	}
	
	

}
