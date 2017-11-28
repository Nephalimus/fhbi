package programming_internship;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class praktikum4_2b {

	public static void main(String[] args) {
		StdOut.println("Dieses Programm gibt ein Integer-Array in umgekehrter Reihenfolge zurueck und nutzt verschiedene Methoden.");
		System.out.println();
		
		StdOut.print("Wie viele Werte im Array?");
		int anzahl = StdIn.readInt();
		
		int[] werte = praktikum3_3c.abfrage(anzahl);
		
		System.out.println("Die eingegebene Zahlen sind - zur Kontrolle: ");
		for(int c=0; c<werte.length; c++) {
			System.out.printf("%-4s ",werte[c]);
		}		
		
		int[] neu = praktikum4_2a.changeArray(werte);

		System.out.println("Die eingegebene Zahlen sind: ");
		for(int c=0; c<neu.length; c++) {
			System.out.printf("%-4s ",neu[c]);
		}		
	}	
}


