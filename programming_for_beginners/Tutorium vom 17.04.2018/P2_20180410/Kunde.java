package P2_20180410;

public class Kunde {

	private int lastKundennummer = 10000;
	
	private int kundennummer;
	private String name;
	private String vorname;
	private Adresse adresse;
	private double umsatzBisher;
	
	public Kunde(String name, String vorname, Adresse adresse) {
		this.kundennummer = ++lastKundennummer;
		this.name = name;
		this.vorname = vorname;
		this.adresse = adresse;
		this.umsatzBisher = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public double getUmsatzBisher() {
		return umsatzBisher;
	}

	public void setUmsatzBisher(double umsatzBisher) {
		this.umsatzBisher = umsatzBisher;
	}

	public int getKundennummer() {
		return kundennummer;
	}
	
	public void drucken(){
		System.out.println("\n" + this.kundennummer + ": " + this.name + ", " + this.vorname) ;
		this.adresse.drucken();
		System.out.println("Aktueller Umsatz: " + this.umsatzBisher+ " €\n");
	}
	
	@Override
	public String toString(){
		return this.kundennummer + ";" + this.name + ";" + this.vorname + ";" + this.adresse.toString() + ";" + this.umsatzBisher; 
	}

}
