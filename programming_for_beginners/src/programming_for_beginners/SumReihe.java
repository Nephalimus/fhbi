package programming_for_beginners;

import edu.princeton.cs.introcs.StdOut;

public class SumReihe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StdOut.println("Dieses Programm berechnet die Anzahl der notwendigen Glieder (n) bis zum Erreichen oder Ueberschreiten des Wertes 5 (1/1+1/2+1/3+...+1/n).");
		double ende = 5.0;
		double sum = 0.0;	
		double i = 0.0;
		while(sum<ende) {
			i++;
			sum = sum + (1.0/i);
			//zur Kontrolle
			StdOut.println(i+"|"+ (1.0/i) +"|"+sum);
		}

		StdOut.println("Die Anzahl der notwendigen Glieder ist: " + (int)i);	//hier casten wir "schmutzig" einen int, damit keine Kommazahl in der Antwort kommt.
		
	}

}
