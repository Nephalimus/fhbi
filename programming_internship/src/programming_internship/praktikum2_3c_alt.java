package programming_internship;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class praktikum2_3c_alt {

	public static void main(String[] args) {
		StdOut.print("Bitte geben Sie die Anzahl der Exponenten ein: ");
		int anzahl = StdIn.readInt();
		while(anzahl<1 || anzahl>30){
			StdOut.println("Der von Ihnen eingegebene Exponent liegt nicht im zulässigen Bereich 1-30!");		
			StdOut.print("Bitte geben Sie die Anzahl der Exponenten neu ein: ");
			anzahl = StdIn.readInt();
		} 
		int sum = 1;
		for(int i=1;i<=anzahl;i++){
			sum *= 2;
			StdOut.println("Ergebnis mit Exponent: " + i);
			StdOut.println(sum);	
		}
	}


}
