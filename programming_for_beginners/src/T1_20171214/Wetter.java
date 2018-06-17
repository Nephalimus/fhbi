package T1_20171214;

/**
 * 
 * @author sleonardo
 *
 */
public class Wetter {

	public static void main(String[] args) {
		int[][] messwerte = new int[24][10];
		datenErfassen(messwerte);
		berechneMittelwert(messwerte);

	}
	
	public static void datenErfassen(int[][] messwerte){
		// Zufallswerte generieren
		for(int zeit = 0 ; zeit < messwerte.length ; zeit++){
			for(int wert = 0 ; wert < messwerte[zeit].length ; wert++){
				// Zufallswert ermitten Temperaturbereich zwischen 20 und (inkl.)30 
				messwerte[zeit][wert] = (int)(Math.random() *11 + 20);
			}
		}
		
		//Ausgabe der Messwerte
		for(int zeit = 0 ; zeit < messwerte.length ; zeit++){
			System.out.print("Messreihe um " + zeit + ":00 Uhr: ");
			for(int wert = 0 ; wert < messwerte[zeit].length ; wert++){
				// Ausgabe eines einzelnen Messwertes zu einer bestimmten Zeit
				System.out.print("[" + messwerte[zeit][wert] + "]");
			}
			// Manueller Zeilenumbruch
			System.out.println();
		}
	}
	
	public static void berechneMittelwert(int[][]messwerte){
		
		for(int zeit = 0 ; zeit < messwerte.length ; zeit++){
			double mittelwert = 0;
			for(int wert = 0 ; wert < messwerte[zeit].length ; wert++){
				// Temperaturen aufaddieren
				mittelwert += messwerte[zeit][wert];
			}
			// Mittelwert ermitteln Summe/AnzahlWerte
			mittelwert /= messwerte[zeit].length;
			
			// Auf eine Stelle nach dem Komma runden
			mittelwert = Math.round(mittelwert*10)/10.0;
			
			// Ergebnisausgabe
			System.out.println("Ermittelter Mittelwert der Temperaturen um " + zeit + ":00 Uhr: " + mittelwert + "°C");
		}
	}

}
