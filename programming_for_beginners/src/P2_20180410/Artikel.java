package P2_20180410;

public class Artikel {

	private String bezeichnung;
	private double preis;
	
	public Artikel(String bezeichnung, double preis) {
		this.bezeichnung = bezeichnung;
		this.preis = preis;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}
	
	public void drucken(){
		System.out.println("Artikelbezeichnung: " + this.bezeichnung + " Artikelpreis: " + this.preis);
	}
	
	@Override
	public String toString(){
		return this.bezeichnung + ";" + this.preis;
	}

}
