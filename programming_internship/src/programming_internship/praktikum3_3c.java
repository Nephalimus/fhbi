package programming_internship;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class praktikum3_3c {

	public static void main(String[] args) {
		StdOut.println("Dieses Programm nutzt eine Methode zur Abfrage mehrerer Zahlen mit Parameter und Methodenaufruf");
		System.out.println();
		
		StdOut.print("Wie viele Zahlen sollen eingegeben werden? ");
		int anzahl = StdIn.readInt();
		String eingabe = "Bitte geben Sie nun die einzelnen Werte ein.";
		
		System.out.println();
		System.out.println("Ausgabe: ");
		
		int[] ausgabe = abfrage(eingabe,anzahl);
		System.out.println("Die eingegebene Zahlen sind: ");
		for(int c=0; c<ausgabe.length; c++) {
			System.out.printf("%-4s ",ausgabe[c]);
		}		
		
		
		
	}
	
	public static int[] abfrage(String frage, int anzahl) {		
		int[] werte = new int[anzahl];
		
		for(int x=1;x<=anzahl;x++) {
			StdOut.print("Geben Sie nun den " + x + " Wert ein: ");	
			werte[x-1]=StdIn.readInt();
		}
		return werte;
	}
}
