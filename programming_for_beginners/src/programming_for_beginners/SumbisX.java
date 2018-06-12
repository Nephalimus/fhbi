package programming_for_beginners;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class SumbisX {

	public static void main(String[] args) {
	
		StdOut.println("Dieses Programm berechnet die Anzahl der Summanden (n) bis zum Erreichen oder Ueberschreiten eines Wertes x (1+2+3+...+n).");
		StdOut.print("Bitte geben Sie den Wert fuer 'x' ein: ");
		long x = StdIn.readLong();
		long sum = 0;	//Wir beginnen bei 0
		int i = 0;
		
		while(sum<x){			//das +1 ist schon der erste Additionsvorgang
			i++;
			sum = sum + i;
			//zur Kontrolle
			StdOut.println(i +"|"+sum);
		}
		
		StdOut.println("Die Anzahl der notwendigen Summanden ist: " + i);
		
	}

}
