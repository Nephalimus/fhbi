package programming_internship;

public class TelefonbuchEintrag {
	
	private String vorname;
	private String nachname;
	private String telefon;
	
	public TelefonbuchEintrag(String vorname, String nachname, String telefon){
		this.vorname = vorname;
		this.nachname = nachname;
		this.telefon = telefon;
	}
	
	public String getVorname() {
		return vorname;
	}
	
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
	public String getNachname() {
		return nachname;
	}
	
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	
	public String getTelefon() {
		return telefon;
	}
	
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	public String toString() {
		return vorname + ", " + nachname + ": " + telefon;
	}
}
