package programming_internship;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Mathematik {

	
	public static void main(String[] args) {
		int zahl1;
		int zahl2;
		String jn = "j";
		
		while (jn.equals("j")){
			StdOut.println("Dieses Programm fuehrt einfache Rechenoperationen durch und gibt das Ergebnis aus");
			StdOut.println("Bitte geben Sie die Rechenoperation (+,-,*,/) an: ");
			String op = StdIn.readString();
			
			switch(op){
				case "+":
				StdOut.println("Bitte geben Sie den ersten Summanden an: ");
				zahl1 = StdIn.readInt();
				StdOut.println("Bitte geben Sie den zweiten Summanden an: ");
				zahl2 = StdIn.readInt();
				addiere(zahl1,zahl2);
				break;
			case "-":
				StdOut.println("Bitte geben Sie den ersten Summanden an: ");
				 zahl1 = StdIn.readInt();
				StdOut.println("Bitte geben Sie den zweiten Summanden an: ");
				zahl2 = StdIn.readInt();
				subtrahiere(zahl1,zahl2);
				break;
			case "*":
				StdOut.println("Bitte geben Sie die erste Zahl an: ");
				zahl1 = StdIn.readInt();
				StdOut.println("Bitte geben Sie den Multiplikator an: ");
				zahl2 = StdIn.readInt();
				multipliziere(zahl1,zahl2);
				break;
			case "/":
				StdOut.println("Bitte geben Sie die erste Zahl an: ");
				zahl1 = StdIn.readInt();
				StdOut.println("Bitte geben Sie den Divisor an: ");
				zahl2 = StdIn.readInt();
				if(zahl2==0) {
					StdOut.println("Division durch 0 geht nicht!!!");
				}else {
					dividiere(zahl1,zahl2);
				}
				break;
			case "else":
				StdOut.println("Keine gueltige Rechoperation eingegeben. Ende!");
				break;
			}
		
			StdOut.println("Moechten Sie eine weitere Aufgabe berechnen? (j/n): ");
			jn = StdIn.readString();

		}; 
		StdOut.println("Programm beendet");
		
	}
	
	public static void addiere(int zahl1, int zahl2) {
		double ergebnis=zahl1+zahl2;
		ausgabe(zahl1,zahl2,ergebnis, "+");
	}
	
	public static void subtrahiere(int zahl1, int zahl2) {
		double ergebnis=zahl1-zahl2;
		ausgabe(zahl1,zahl2,ergebnis, "-");
	}
	
	public static void multipliziere(int zahl1, int zahl2) {
		double ergebnis=zahl1*zahl2;
		ausgabe(zahl1,zahl2,ergebnis, "*");
	}
	
	public static void dividiere(int zahl1, int zahl2) {
		double ergebnis=zahl1/zahl2;
		ausgabe(zahl1,zahl2,ergebnis,"/");
	}
	
	public static void ausgabe(int zahl1, int zahl2, double ergebnis, String op) {
		StdOut.println("Die Berechnung von " + zahl1 + " " + op + " "+ zahl2 + " ergibt " + ergebnis);
	}

}
