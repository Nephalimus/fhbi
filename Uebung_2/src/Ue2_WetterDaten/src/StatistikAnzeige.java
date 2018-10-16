package Ue2_WetterDaten.src;

public class StatistikAnzeige {

	private double maxTemperatur;
	private double minTemperatur;
	private double tempSumme;
	private int anzahl;
	
	
	
	public StatistikAnzeige()
	{
		
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
