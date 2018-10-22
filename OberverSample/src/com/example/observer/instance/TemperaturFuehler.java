package com.example.observer.instance;

import java.util.ArrayList;
import java.util.List;

import com.example.observer.Beobachter;
import com.example.observer.Subjekt;

public class TemperaturFuehler implements Subjekt {
	private int temperature;
	private List<Beobachter> anzeige = new ArrayList<Beobachter>();
		
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
		for(int i=0;i<anzeige.size();i++) {
			Beobachter s1 = anzeige.get(i);
			s1.aktualisieren(this);
		}
	}

}
