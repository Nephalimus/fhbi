package T1_20171109;

import edu.princeton.cs.introcs.StdIn;

public class Zufall03 {

	public static void main(String[] args) {
		
		System.out.println("Wie viele Zufallszahlen zwischen 0 und 9 solln ermittelt werden?");;
		System.out.print("Eingabe: " );
		int anzahl = StdIn.readInt();
		int[] ergebnis = new int[10];
		
		for(int i = 0 ; i < anzahl ; i++){
			ergebnis[(int)(Math.random()*10)]++;
		}
		
		for(int i = 0 ; i < ergebnis.length ; i++){
			System.out.println("Die Zahl " + i + " wurde " + ergebnis[i] + " Mal gezogen.");
		}
	}

}
