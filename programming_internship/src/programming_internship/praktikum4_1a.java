package programming_internship;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class praktikum4_1a {

	public static void main(String[] args) {
		StdOut.println("Dieses Programm gibt das Maximum von zwei Integern zurueck.");
		System.out.println();
		
		StdOut.print("Bitte erste Zahl eingeben:");
		int a = StdIn.readInt();
		StdOut.print("Bitte zweite Zahl eingeben:");
		int b = StdIn.readInt();
		System.out.println();

		int ausgabe = getMax(a,b);	//Methodenaufruf
		System.out.println("Das Maximum ist: " + ausgabe);	
	}
	
	public static int getMax(int a,int b) {
		if(a<=b)return b;
		else return a;
	}
	
}
