package programming_internship;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class praktikum3_2a {
		
	public static void main(String[] args) {
		StdOut.println("Dieses Programm nutzt eine Methode zur Ausgabe eines Zeichen");
		System.out.println();
		
		StdOut.print("Welches Zeichen?");
		char eingabe = StdIn.readChar();
		
		StdOut.print("Wie viele Wiederholungen?");
		int anzahl = StdIn.readInt();
		
		System.out.println();
		System.out.println("Ausgabe: ");
		
		wiederholeZeichen(eingabe,anzahl);		
	}

	//Diese Methode wiederholt ein Zeichen c für die eine bestimmte anzahl
	public static void wiederholeZeichen(char c, int anzahl) {
		for(int x=1;x<=anzahl;x++){
			StdOut.print(c);	
		}
	}
}
