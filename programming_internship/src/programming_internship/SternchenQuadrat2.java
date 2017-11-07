package programming_internship;

import edu.princeton.cs.introcs.StdIn;

public class SternchenQuadrat2 {

	public static void main(String[] args) {
		System.out.println("Bitte Anzahl eingeben: ");
		int anzahl = StdIn.readInt();
	
		for(int zeile=1; zeile<=anzahl; zeile++) {
			if(zeile==1 || zeile==anzahl) {
				// Erste und letzte Zeile
				for(int i=1; i<=anzahl; i++) {
					System.out.print("*");
				}
				System.out.println();
			}
			else {
				// Mittelteil
				System.out.print("*");
				for(int l=1; l<=anzahl-2; l++)
					System.out.print(" ");
				System.out.println("*");
			}
		}
		
		
	}
}
