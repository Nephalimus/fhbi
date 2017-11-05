package otrappe;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class praktikum2_4a {

	public static void main(String[] args) {
		StdOut.print("Für welche Zahl sollen die Teiler ermittelt werden? ");
		long zahl = StdIn.readInt();
			
		String ausgabe = "";
		for(long i=1;i<=zahl;i++){
			if(zahl%i==0) {
				if(ausgabe=="") {
					ausgabe += i;
				}else {
					ausgabe += ", "+ i;
				}
				
			}
		}
		StdOut.println("Die Teiler von " + zahl + " sind {"+ ausgabe +"}");
	}

}
