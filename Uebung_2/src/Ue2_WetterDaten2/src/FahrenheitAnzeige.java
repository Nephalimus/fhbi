package Ue2_WetterDaten2.src;

public class FahrenheitAnzeige implements Anzeige{

	private double temperatur;
	private WetterDaten wetterDaten;
	
	public FahrenheitAnzeige(WetterDaten wetterDaten)
	{
		this.wetterDaten = wetterDaten;
		this.wetterDaten.registriereAnzeige(this);
	}
	
	public void aktualisieren(double temp, double feucht, double luftdruck)
	{
		this.temperatur = (temp*9/5)+32;
		
		anzeigen();
	}

	public void anzeigen() 
	{
		System.out.println("Aktuelle Wetterbedingungen: " + temperatur + " Grad F.");
	}

}
