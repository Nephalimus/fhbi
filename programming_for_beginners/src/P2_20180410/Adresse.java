package P2_20180410;

public class Adresse {
	private String strasse;
	private String ort;
	private int plz;
	private int hausnummer;

	public Adresse(String strasse, int hausnummer, String ort, int plz) {
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.ort = ort;
		this.plz = plz;
	}

	public String getStrasse() {
		return this.strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getOrt() {
		return this.ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public int getPlz() {
		return this.plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public int getHausnummer() {
		return this.hausnummer;
	}

	public void setHausnummer(int hausnummer) {
		this.hausnummer = hausnummer;
	}
	
	public void drucken(){
		System.out.println(this.strasse + " " + this.hausnummer + " in " + this.plz + " " + this.ort);
	}
	
	@Override
	public String toString(){
		return this.strasse + ";" + this.hausnummer + ";" + this.plz + ";" + this.ort;
	}
	
	

}
