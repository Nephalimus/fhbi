package otrappe;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class praktikum2_2a {

	public static void main(String[] args) {
		StdOut.print("Bitte geben Sie die Anzahl der Zeilen ein: ");
		int anzahl = StdIn.readInt();
			
		String sum = "";
		for(int i=1;i<=anzahl;i++){
			sum += "*";
			StdOut.println(sum);
		}
	}


}
