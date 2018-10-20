package com.example.observer;

public class KonkretesSubjekt implements Subjekt {
	private int temperature;
	
	private Beobachter anzeige;
	

	@Override
	public void registriereBeobachter(Beobachter b) {
		anzeige = b;	
	}

	@Override
	public void entferneBeobachter(Beobachter b) {
		anzeige = null;
	}

	@Override
	public String gibZustand() {
		return String.valueOf(temperature);
	}
	
	
	public void veraendern() {
		temperature++;	
		
		// Rufe nun alle Beobachter auf, hier ist es nur eine Anzeige
		
		anzeige.aktualisieren(this);
	}
}


