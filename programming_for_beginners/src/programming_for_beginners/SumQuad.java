package programming_for_beginners;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class SumQuad {

	public static void main(String[] args) {
		
		StdOut.println("Dieses Programm berechnet die Summe der ersten n Quadratzahlen, wobei n definiert wird (1^2+2^2+3^2+...+n^2).");
		StdOut.print("Bitte geben Sie den Wert fuer 'n' ein: ");
		int anzahl = StdIn.readInt();
			
		long sum = 0;
		for(int i=1;i<=anzahl;i++){
			sum = sum + (i*i);
			//zur Kontrolle
			StdOut.println(i +"|"+(i*i) +"|"+sum);
		}
		
		StdOut.println("Die Endsumme ist: " + sum);
		
	}

}
