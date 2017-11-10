package programming_for_beginners;

import edu.princeton.cs.introcs.StdOut;

public class Sterne01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StdOut.println("Dieses Programm gibt ein Rechteck mit 5 * 13 Sternen in der Mitte des Bildschirms aus.");
		for(int i=1;i<6;i++){
			//20 Leerzeichen um in die Mitte des Bildschirms zu kommen (Anmerkung: SL-Praktikum)
			//Das ist quick & dirty!
			System.out.printf("%21s","*");
			//13 Sterne insgesmat, also noch 12 zeichnen
			for(int x=1;x<13;x++){
				System.out.print("*");
			}
			System.out.println();	//Leerzeile
		}
	}

}
