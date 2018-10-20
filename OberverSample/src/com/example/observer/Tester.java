package com.example.observer;

public class Tester {

	public static void main(String[] args) {
	
		Beobachter anzeige = new KonkreterBeobachter();
		KonkretesSubjekt fuehler = new KonkretesSubjekt();
		
		fuehler.registriereBeobachter(anzeige);
		
		
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
