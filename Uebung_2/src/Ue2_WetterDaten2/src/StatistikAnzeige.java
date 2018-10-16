package Ue2_WetterDaten2.src;

public class StatistikAnzeige implements Anzeige {
	
	private double maxTemperatur;
	private double minTemperatur;
	private double tempSumme;
	private int anzahl;
	
	private WetterDaten wetterDaten;
	
	public StatistikAnzeige(WetterDaten wetterDaten)
	{
		this.wetterDaten = wetterDaten;
		this.wetterDaten.registriereAnzeige(this);
	}
	
	public void aktualisieren(double temp, double feucht, double luftdruck)
	{
		tempSumme += temp;
		anzahl++;
		
		if (temp > maxTemperatur)
		{
			maxTemperatur = temp;
		}
		
		if (temp < minTemperatur)
		{
			minTemperatur = temp;
		}
		
		anzeigen();
	}

	public void anzeigen() 
	{
		System.out.println("Statistische Wetterbedingungen (Durchschnitt, Maximal, Minimal): " + 
				tempSumme / anzahl + "   " + maxTemperatur + "   " + minTemperatur);
	}

}
