package programming_internship;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Add5Integers {

	public static void main(String[] args) {
		StdOut.println("Dieses Programm addiert fünf ganze Zahlen.");
		int sum=0;
		for(int i=1;i<=5;i++){
			StdOut.print("Bitte die "+ i +". Zahl eingeben: ");
			sum += StdIn.readInt();;
		}
		StdOut.println("Die Summe ist " + sum + ".");
	}

}
