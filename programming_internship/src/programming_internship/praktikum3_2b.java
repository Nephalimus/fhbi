package programming_internship;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class praktikum3_2b {

	public static void main(String[] args) {
		StdOut.println("Dieses Programm nutzt eine Methode zur Ausgabe eines Zeichen");
		System.out.println();
		
		StdOut.print("Welches Zeichen?");
		char eingabe = StdIn.readChar();
		
		StdOut.print("Bitte geben Sie die Anzahl der Zeilen ein: ");
		int anzahl = StdIn.readInt();
		
		System.out.println();
		System.out.println("Ausgabe: ");
		
		for(int i=1;i<=anzahl;i++){
			int voll = (2*i) - 1;
			int leer = anzahl-i;
			wiederholeZeichen((char)32,leer);	//32 = Leerzeichen
			wiederholeZeichen(eingabe,voll);
			System.out.println();
		}
	}
	
	//Diese Methode wiederholt ein Zeichen c für die eine bestimmte anzahl
	public static void wiederholeZeichen(char c, int anzahl) {
		for(int x=1;x<=anzahl;x++){
			StdOut.print(c);	
		}
	}
	
}
