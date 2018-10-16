package Ue2_WetterDaten2.src;

import java.util.ArrayList;

public class WetterDatenImp implements WetterDaten {

	private ArrayList anzeigenListe = new ArrayList();
	private double temperatur;
	private double feuchtigkeit;
	private double luftdruck;
	
	@Override
	public void registriereAnzeige(Anzeige anzeige) {
		anzeigenListe.add(anzeige);
		
	}

	@Override
	public void entferneAnzeige(Anzeige anzeige) {
		anzeigenListe.remove(anzeige);
		
	}

	@Override
	public void benachrichtigeAnzeigen() {
		for (int i = 0; i< anzeigenListe.size(); i++)
		{
			Anzeige anzeige = (Anzeige) anzeigenListe.get(i);
			anzeige.aktualisieren(temperatur, feuchtigkeit, luftdruck);
		}
	}
	
	public void setMesswerte(double temp, double feucht, double druck)
	{
		this.temperatur = temp;
		this.feuchtigkeit = feucht;
		this.luftdruck = druck;
		benachrichtigeAnzeigen();
	}
	

}
