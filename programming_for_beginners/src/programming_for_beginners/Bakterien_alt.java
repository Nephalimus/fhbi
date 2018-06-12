package programming_for_beginners;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Bakterien_alt {

	public static void main(String[] args) {
		
		StdOut.println("Dieses Programm berechnet das Wachstum einer Bakterienkolonie.");
		StdOut.print("Bitte den Wachstumsmultiplikator eingeben: ");
		double wachstum = StdIn.readDouble();
		StdOut.print("Bitte die Startzeit eingeben (volle Stunde): ");
		int start = StdIn.readInt();
		StdOut.print("Bitte die Endzeit eingeben (volle Stunde): ");
		int ende = StdIn.readInt();
		StdOut.print("Bitte die Anzahl der Kolonien zu Beginn eingeben: ");
		double anzahl = StdIn.readDouble();
		
		
		double sum = anzahl;
		for(int i=start;i<ende;i++){
			StdOut.println(i +" Uhr|"+sum+"|"+sum*wachstum);
			sum *= wachstum;
		}

		StdOut.println("Anzahl der Baterienkolonien (Start 6 Uhr (3) - 17 Uhr): " + sum);
	}

}
