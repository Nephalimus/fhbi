package programming_internship;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class praktikum3_1c {

	public static void main(String[] args) {
		
		StdOut.println("Dieses Programm erfasst die Blutzuckerwerte von n Personen und liefert die Anzahl der gefaehrdeten Personen aus.");
		System.out.println();
		
		StdOut.print("Fuer wie viele Personen sollen Werte erfasst werden?");
		int anzahl = StdIn.readInt();
		
		Double[] werte = new Double[anzahl];
		
		for(int x=1;x<=anzahl;x++) {
			StdOut.print("Geben Sie nun den Wert fuer Patient " + x + " ein: ");
			double eingabe = StdIn.readDouble();
			werte[x-1]=eingabe;
		}
		
		System.out.println();
		StdOut.println("Vielen Dank, die Auswertung ergab, dass ");
		int ueber=0;
		int unter=0;
		String sueber="";
		String sunter="";
		
		for(int c=0; c<anzahl; c++) {
			if(werte[c]<80) {
				unter+=1;
				if(sunter=="") {
					sunter = sunter + (c+1) ;		
				}else {
					sunter = sunter + ", " + (c+1);
				}
			
			}
			if(werte[c]>120) {
				ueber+=1;
				if(sueber=="") {
					sueber = sueber + (c+1) ;		
				}else { 
					sueber = sueber + ", " + (c+1);
				}			
			};
		}		
		
		double pwertueber = ueber * 100.00 / anzahl;
		double pwertunter = unter * 100.00 / anzahl;
		
		StdOut.println(unter + " Patienten unterzuckert sind und");
		StdOut.println(ueber + " Patienten an Ueberzuckerung leiden.");
		System.out.println();
		StdOut.println("Dies entspricht " +  pwertunter + "% (Unterzuckerung) bzw. " + pwertueber + "% (Ueberzuckerung) Patientenanteil an allen Patienten." );
		System.out.println();
		StdOut.println("Bitte nehmen Sie hinsichtlich einer Behandlung Kontakt zu folgenden Patienten auf: " );
		StdOut.println("Unterzuckerung: " + sunter);
		StdOut.println("Ueberzuckerung: " + sueber);
		
	}
}
