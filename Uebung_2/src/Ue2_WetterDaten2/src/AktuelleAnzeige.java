package Ue2_WetterDaten2.src;

public class AktuelleAnzeige implements Anzeige {
	private double temperatur;
	private double feuchtigkeit;
	private WetterDaten wetterDaten;
	
	public AktuelleAnzeige(WetterDaten wetterDaten)
	{
		this.wetterDaten = wetterDaten;
		this.wetterDaten.registriereAnzeige(this);
	}
	
	public void aktualisieren(double temp, double feucht, double luftdruck)
	{
		this.temperatur = temp;
		this.feuchtigkeit = feucht;
		anzeigen();
	}

	public void anzeigen() 
	{
		System.out.println("Aktuelle Wetterbedingungen: " + temperatur + " Grad C und Luftfeuchtigkeit % " + feuchtigkeit);
	}
}
