package model;

import model.WarenkorbModel;

/**
* Nutzer des Modegeschäfts. Haben einen Warenkorb in den
* sie Artikel hinzufügen und löschen können. Können aus 
* dem Warenkorb Bestellungen auslösen.
*/
public class KundeModel {

	private int kundenID;
	private String nachname;
	private String vorname;
	private WarenkorbModel waren;
	
	public KundeModel(String s, BestellungenModel best){
		String[] teil = s.split(";");
		this.kundenID = Integer.parseInt(teil[0]);
		this.nachname = teil[1];
		this.vorname = teil[2];	
		waren = new WarenkorbModel(this, best);
	}
	
	public int getKundenID() {
		return kundenID;
	}

	public void setKundenID(int kundenID) {
		this.kundenID = kundenID;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public WarenkorbModel getWarenkorb() {
		return waren;
	}
	
}
