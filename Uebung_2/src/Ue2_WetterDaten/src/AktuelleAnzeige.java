package Ue2_WetterDaten.src;

public class AktuelleAnzeige {

	private double temperatur;
	private double feuchtigkeit;
	
	public AktuelleAnzeige()
	{
		
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
