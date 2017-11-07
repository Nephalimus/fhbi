package programming_internship;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class praktikum2_2b {

	public static void main(String[] args) {
		StdOut.print("Bitte geben Sie die Anzahl der Zeilen ein: ");
		int anzahl = StdIn.readInt();
		for(int i=1;i<=anzahl;i++){
			String sum = "";
			int voll = (2*i) - 1;
			int leer = anzahl-i;
			//StdOut.println(voll +"|"+leer);
			
			for(int j=1;j<=leer;j++){
				sum += " ";	
			}
			for(int k=1;k<=voll;k++){
				sum += "*";	
			}
			StdOut.println(sum);
		}
	}
}
