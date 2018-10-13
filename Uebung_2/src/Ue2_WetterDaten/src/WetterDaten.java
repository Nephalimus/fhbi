package Ue2_WetterDaten.src;

public class WetterDaten {

	private AktuelleAnzeige aktuelleAnzeige = new AktuelleAnzeige();
	private StatistikAnzeige statistikAnzeige = new StatistikAnzeige();
	private VorhersageAnzeige vorhersageAnzeige = new VorhersageAnzeige();
	
	private double temperatur;
	private double feuchtigkeit;
	private double luftdruck;
	
	public void neueMesswerte()
	{
		// Neue Messungen holen
		
		double temp = getTemperatur();
		double feuchtigkeit = getLuftfeuchtigkeit();
		double druck = getLuftdruck();
			
		// Anzeigen aktualisieren
		
		aktuelleAnzeige.aktualisieren(temp, feuchtigkeit, druck);
		statistikAnzeige.aktualisieren(temp, feuchtigkeit, druck);
		vorhersageAnzeige.aktualisieren(temp, feuchtigkeit, druck);
	}
	
	private double getTemperatur()
	{
		return temperatur;
	}
	
	private double getLuftfeuchtigkeit()
	{
		return feuchtigkeit;
	}
	
	private double getLuftdruck()
	{
		return luftdruck;
	}
	
	public void setMesswerte(double temp, double feucht, double druck)
	{
		this.temperatur = temp;
		this.feuchtigkeit = feucht;
		this.luftdruck = druck;
		this.neueMesswerte();
	}
	
	
}
