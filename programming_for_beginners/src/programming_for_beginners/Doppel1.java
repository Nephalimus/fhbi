package programming_for_beginners;

import edu.princeton.cs.introcs.StdOut;

public class Doppel1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StdOut.println("Dieses Programm berechnet die Anzahl der notwendigen Verdoppelungen von 1 bis zum Erreichen oder Ueberschreiten des Wertes 1000000");
		long ende = 1000000;
		long sum = 1;	
		int i = 0;
		
		while(sum<=ende){
			i++;
			sum *= 2;
			//zur Kontrolle
			StdOut.println(i +"|"+sum);
		}
		
		StdOut.println("Die Anzahl der notwendigen Verdoppelungen ist: " + i);
		
	}
}
