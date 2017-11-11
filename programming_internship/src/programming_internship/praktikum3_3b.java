package programming_internship;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class praktikum3_3b {

	public static void main(String[] args) {
		StdOut.println("Dieses Programm nutzt eine Methode zur Abfrage einer Zahl mit Parameter");
		System.out.println();
		
		StdOut.print("Bitte den Fragetext eingeben:");
		String eingabe = StdIn.readLine();
			
		System.out.println();
		System.out.println("Ausgabe: ");
		
		double ausgabe = abfrage(eingabe);

		System.out.println();
		System.out.println("Die eingegebene Zahl ist: " + ausgabe);
		
	}
	
	public static double abfrage(String frage) {
		StdOut.print(frage);
		return StdIn.readDouble();
	}
	
}
