package programming_for_beginners;

import edu.princeton.cs.introcs.StdOut;

public class Zahlen04 {
	//Eine Anzeige hat i.d.R. 80 Zeichen wir definieren diese Größe einmal zentral
	public static int size = 80;
	
	public static void main(String[] args) {
		StdOut.println("Dieses Programm gibt ein Fibonacci-Dreieck mittig auf dem Bildschirm aus.");
		System.out.println();
		
		String ausgabe="1";
		int a = 1;
		int b = 1;
		int g;
		
		for(int i=1;i<=8;i++){
			if(i==1)printer(ausgabe);
			if(i==2)printer(ausgabe = ausgabe + "  1");

			if(i>2) {
				g = a + b;
				a = b;
				b = g;
				ausgabe = ausgabe + "  " + g;
				printer(ausgabe);
			}	
		}
	}

	//Diese Methode misst die Länge des eingegebenen String und platziert diesen mittig auf eine definierte Breite (size)
	static void printer(String str) {
	   // int left = (size - str.length()) / 2;
		int left = 20;	//einfach 20 Leerzeichen vornem da keine Pyramide sondern Dreieck
	    String ausgabe = "";
	    for (int a = 0; a < left; a++) {
	        ausgabe+=" ";
	    }
	   ausgabe+=str;
	   System.out.println(ausgabe);
	}
}
