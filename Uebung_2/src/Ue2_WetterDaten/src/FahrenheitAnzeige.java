package Ue2_WetterDaten.src;

public class FahrenheitAnzeige {

	private double temperatur;
	
	public FahrenheitAnzeige()
	{
		
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
