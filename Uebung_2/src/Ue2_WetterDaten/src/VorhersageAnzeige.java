package Ue2_WetterDaten.src;

public class VorhersageAnzeige {

	private double neuerLuftdruck;  
	private double letzterLuftdruck;

	
	public VorhersageAnzeige()
	{
		
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
