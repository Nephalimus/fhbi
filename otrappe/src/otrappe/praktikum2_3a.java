package otrappe;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class praktikum2_3a {

	public static void main(String[] args) {
		StdOut.print("Bitte geben Sie die Anzahl der Exponenten ein: ");
		int anzahl = StdIn.readInt();
			
		int sum = 1;
		for(int i=1;i<=anzahl;i++){
			sum *= 2;
			StdOut.println("Ergebnis mit Exponent: " + i);
			StdOut.println(sum);
		}
	}


}
