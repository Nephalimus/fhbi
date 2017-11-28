package programming_internship;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class praktikum4_1b {

	public static void main(String[] args) {
		StdOut.println("Dieses Programm gibt das Maximum eines Integer-Array zurueck.");
		System.out.println();
		
		StdOut.print("Wie viele Werte im Array?");
		int anzahl = StdIn.readInt();
		
		int[] werte = new int[anzahl];
		
		for(int x=1;x<=anzahl;x++) {
			StdOut.print("Geben Sie nun die " + x + " Zahl ein: ");
			int eingabe = StdIn.readInt();
			werte[x-1]=eingabe;
		}
		
		int max = getMaxArray(werte);	
		System.out.println("Das Maximum ist: " + max);	
	}	
	
	public static int getMaxArray(int[] werte) {
		int b=0;
		for(int x=0;x<werte.length;x++) {
			int a = werte[x];
			b = praktikum4_1a.getMax(a,b);
		}
		return b;
	}
}


