package programming_for_beginners;

import edu.princeton.cs.introcs.StdOut;

public class Bakterien {

	public static void main(String[] args) {
		
		StdOut.println("Dieses Programm berechnet das Wachstum einer Bakterienkolonie (*4/h).");
			
		long sum = 3;
		for(int i=6;i<17;i++){
			StdOut.println(i +" Uhr|"+sum+"|"+sum*4);
			sum *= 4;
		}

		StdOut.println("Anzahl der Baterienkolonien (Start 6 Uhr (3) - 17 Uhr): " + sum);
	}

}
