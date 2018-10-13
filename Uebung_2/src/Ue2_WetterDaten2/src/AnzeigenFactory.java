package Ue2_WetterDaten2.src;

public class AnzeigenFactory {
	
	public Anzeige createAktuelleAnzeige(WetterDaten wetterDaten)
	{
		Anzeige anzeige = (Anzeige) new AktuelleAnzeige(wetterDaten);
		return anzeige;
	}
	
	public Anzeige createStatistikAnzeige(WetterDaten wetterDaten)
	{
		Anzeige anzeige = (Anzeige) new StatistikAnzeige(wetterDaten);
		return anzeige;
	}
	
	public Anzeige createVorhersageAnzeige(WetterDaten wetterDaten)
	{
		Anzeige anzeige = (Anzeige) new VorhersageAnzeige(wetterDaten);
		return anzeige;
	}
	
	

}
