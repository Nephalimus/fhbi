package T1_20171130;

public class Kunde {

	private int kundennummer;
	private String anrede;
	private String name;
	private String vorname;
	private String anschrift;
	private String plz;
	private String ort;
	
	public Kunde(int kundennummer, String anrede, String name, String vorname, String anschrift, String plz, String ort) {
		this.kundennummer = kundennummer;
		this.anrede = anrede;
		this.name = name;
		this.vorname = vorname;
		this.anschrift = anschrift;
		this.plz = plz;
		this.ort = ort;
	}

	public String getAnschrift() {
		return anschrift;
	}

	public void setAnschrift(String anschrift) {
		this.anschrift = anschrift;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public int getKundennummer() {
		return kundennummer;
	}

	public String getAnrede() {
		return anrede;
	}

	public String getName() {
		return name;
	}

	public String getVorname() {
		return vorname;
	}
	
	@Override
	public String toString() {
		return "Kunde [kundennummer=" + kundennummer + ", anrede=" + anrede + ", name=" + name + ", vorname=" + vorname
				+ ", anschrift=" + anschrift + ", plz=" + plz + ", ort=" + ort + "]";
	}

}
