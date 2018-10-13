package Ue2_WetterDaten2.src;

public class VorhersageAnzeige implements Anzeige {
	private double neuerLuftdruck;  
	private double letzterLuftdruck;

	private WetterDaten wetterDaten;
	
	public VorhersageAnzeige(WetterDaten wetterDaten)
	{
		this.wetterDaten = wetterDaten;
		this.wetterDaten.registriereAnzeige(this);
	}
	
	public void aktualisieren(double temp, double feucht, double druck)
	{
		this.letzterLuftdruck = neuerLuftdruck;
		this.neuerLuftdruck = druck;
		anzeigen();
	}

	public void anzeigen() 
	{
		String ausgabe = "";
		if (neuerLuftdruck > letzterLuftdruck)
		{
			ausgabe = "Das Wetter verbessert sich";
		}
		else
		{
			ausgabe = "Das Wetter wird schlechter";
		}
			
			
		System.out.println("Vorhersage: " + ausgabe);
	}

}
