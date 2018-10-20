package com.example.observer.instance;

public class Tester {
	public static void main(String[] args) {
		
		TemperaturAnzeige anzeige = new TemperaturAnzeige();
		TemperaturAnzeigeFahrenheit anzeige2 = new TemperaturAnzeigeFahrenheit();
		TemperaturFuehler fuehler = new TemperaturFuehler();
		
		fuehler.registriereBeobachter(anzeige);
		fuehler.registriereBeobachter(anzeige2);
		
		
		for (int i = 1; i<5; i++) {
			fuehler.veraendern();
			sleep();
		}
		
	}
		
	private static void sleep() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
