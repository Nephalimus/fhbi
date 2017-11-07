package programming_internship;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class praktikum2_3c {

	public static void main(String[] args) {
		int anzahl =0;
		do {
			StdOut.print("Bitte geben Sie die Anzahl der Exponenten neu ein: ");
			anzahl = StdIn.readInt();
		} while(anzahl<1 || anzahl>30);
		
		int sum = 1;
		for(int i=1;i<=anzahl;i++){
			sum *= 2;
			StdOut.println("Ergebnis mit Exponent: " + i);
			StdOut.println(sum);	
		}
	}


}
