package programming_for_beginners;

import edu.princeton.cs.introcs.StdOut;

public class Zahlen02 {
	//Eine Anzeige hat i.d.R. 80 Zeichen wir definieren diese Größe einmal zentral
	public static int size = 80;
	
	public static void main(String[] args) {
		StdOut.println("Dieses Programm gibt eine Zahlenpyramide zentriert auf dem Bildschirm aus.");
		System.out.println();
		
		String text = "";
		for (int i = 1; i < 10; i+=2) {
			for (int x = 1; x <= i; x++) {
				text += " "+Integer.toString(x)+"  ";
		    } 
			printer(text);
			text="";
	    }
		
	}

	//Diese Methode misst die Länge des eingegebenen String und platziert diesen mittig auf eine definierte Breite (size)
	static void printer(String str) {
	    int left = (size - str.length()) / 2;
	    String ausgabe = "";
	    for (int a = 0; a < left; a++) {
	        ausgabe+=" ";
	    }
	   ausgabe+=str;
	   System.out.println(ausgabe);
	}
}
