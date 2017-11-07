package programming_internship;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class praktikum2_4b {

	public static void main(String[] args) {
		StdOut.print("Für welche Zahl sollen die Teiler ermittelt werden? ");
		long zahl = StdIn.readInt();
		for(long a=1;a<=zahl;a++){
			String ausgabe = "";
			for(long i=1;i<=a;i++){
				if(a%i==0) {
					if(ausgabe=="") {
						ausgabe += i;
					}else {
						ausgabe += ", "+ i;
					}
					
				}
			}
			StdOut.println("Die Teiler von " + a + " sind {"+ ausgabe +"}");
		}
	}
}
