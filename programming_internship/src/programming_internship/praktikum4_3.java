package programming_internship;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;


public class praktikum4_3 {

	public static void main(String[] args) {
		StdOut.println("Dieses Programm gibt ein Quadrat mit einer definierten Kantenlänge aus.");
		System.out.println();
		
		StdOut.print("Wie viele Zeichen sollen verwendet werden?");
		int anzahl = StdIn.readInt();
		
		if(anzahl<2) {
			StdOut.println("Die Mindestanzahl muss 2 sein. Ende!");
		}else {
			for(int i=1;i<=anzahl;i++) {
				praktikum3_2a.wiederholeZeichen('*',anzahl);
				System.out.println();
			}
		}
	}

}
