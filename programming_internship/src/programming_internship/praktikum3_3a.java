package programming_internship;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class praktikum3_3a {

	public static void main(String[] args) {
		StdOut.println("Dieses Programm nutzt eine Methode zur Abfrage einer Zahl mit Parameter (Fragetext)");
		System.out.println();
		
		//Die nächsten 4 Zeilen könnten auch ersetzt werden durch   String eingabe = "<FRAGETEXT>";
		StdOut.print("Bitte den Fragetext eingeben:");
		String eingabe = StdIn.readLine();
		System.out.println();
		System.out.println("Ausgabe: ");
		
		int ausgabe = abfrage(eingabe);	//Methodenaufruf

		System.out.println();
		System.out.println("Die eingegebene Zahl ist: " + ausgabe);
		
	}
	
	public static int abfrage(String frage) {
		StdOut.print(frage);
		return StdIn.readInt();
	}
	
}
