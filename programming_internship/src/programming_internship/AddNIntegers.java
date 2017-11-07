package programming_internship;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class AddNIntegers {

	public static void main(String[] args) {
		StdOut.println("Dieses Programm addiert eine definierbare Anzahl ganzer Zahlen.");
		StdOut.print("Bitte geben Sie die Anzahl der zu addierenden Zahlen ein: ");
		int anzahlAdd = StdIn.readInt();
		
		int sum=0;
		for(int i=1;i<=anzahlAdd;i++){
			StdOut.print("Bitte die "+ i +". Zahl eingeben: ");
			sum += StdIn.readInt();
		}
		StdOut.println("Die Summe der eingegebenen "+anzahlAdd+" Zahlen ist: " + sum + ".");
	}

}
