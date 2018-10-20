package com.example.observer.instance;

import java.util.List;

import com.example.observer.Beobachter;
import com.example.observer.Subjekt;

public class TemperaturFuehler implements Subjekt {
	private int temperature;
	private List<Beobachter> anzeige;
	
	@Override
	public void registriereBeobachter(Beobachter b) {
		// TODO Auto-generated method stub
		anzeige.add(b);	
	}

	@Override
	public void entferneBeobachter(Beobachter b) {
		// TODO Auto-generated method stub
		anzeige.remove(b);
	}

	@Override
	public String gibZustand() {
		// TODO Auto-generated method stub
		return String.valueOf(temperature);
	}
	
	
	public void veraendern() {
		temperature++;	
		
		// Rufe nun alle Beobachter auf, hier ist es nur eine Anzeige
		
		//anzeige.stream().forEach(::aktualisieren);	
	}

}
