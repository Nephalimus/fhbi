package programming_internship;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class praktikum2_1b {

	public static void main(String[] args) {
		StdOut.print("Bitte geben Sie die Anzahl der Sternchen ein: ");
		int anzahl = StdIn.readInt();
			
		String sum = "";
		for(int i=1;i<=anzahl;i++){
			sum = "";
			for(int x=1;x<=anzahl;x++){
				sum += "*";
			}
			StdOut.println(sum);
		}
	}


}
