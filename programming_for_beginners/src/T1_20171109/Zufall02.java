package T1_20171109;


public class Zufall02 {

	public static void main(String[] args) {
		int[] reihe = new int[100];
		int min = 1000;
		int pos = 0;
		int[] hunderter = new int[10];

		// mit Zufallszahlen füllen
		for (int i = 0; i < reihe.length; i++) {
			reihe[i] = (int) (Math.random() * 900 + 100);

			// kleinste Zahl ermitteln
			if (reihe[i] < min) {
				min = reihe[i];
				pos = i;
			}
			// Hunderter ermitteln
			hunderter[reihe[i] / 100]++;

		}

		System.out.println("Der kleinste Wert liegt im Feld '" + pos + "' und hat den Wert: " + min);
		System.out.println();

		for (int i = 1; i < hunderter.length; i++) {
			System.out.println("Zahlen im " + i + "00er Bereich: " + hunderter[i]);
		}
		System.out.println();
		ausgabe(reihe);

		// Reihung umkehren
		for (int wert = 0; wert < reihe.length / 2; wert++) {
			// Hilfsvariable zum Zwischenspeichern
			int tmp = reihe[wert];
			reihe[wert] = reihe[reihe.length - 1 - wert];
			reihe[reihe.length - 1 - wert] = tmp;

		}
		ausgabe(reihe);
	}

	public static void ausgabe(int[] zahlen) {
		// Ausgabe (zehn zahlen pro Reihe)
		for (int wert = 0; wert < zahlen.length; wert++) {
			System.out.print("[" + zahlen[wert] + "]");
			// Nach zehn Werten Zeilenumbruch
			if ((wert + 1) % 10 == 0)
				System.out.println();
		}
		System.out.println();
	}

}
