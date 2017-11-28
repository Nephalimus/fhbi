package programming_internship;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class praktikum4_1c {

	public static void main(String[] args) {
		StdOut.println("Dieses Programm gibt das Maximum eines Integer-Array zurueck und nutzt verschiedene Methoden.");
		System.out.println();
		
		StdOut.print("Wie viele Werte im Array?");
		int anzahl = StdIn.readInt();
		
		int[] werte = praktikum3_3c.abfrage(anzahl);
		int max = praktikum4_1b.getMaxArray(werte);	

		System.out.println("Das Maximum ist: " + max);	
	}	
}


