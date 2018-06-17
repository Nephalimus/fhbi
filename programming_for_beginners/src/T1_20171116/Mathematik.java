package T1_20171116;

import edu.princeton.cs.introcs.StdIn;

public class Mathematik {

	public static void main(String[] args) {
		char weiter;
		char operator;
		int zahl1;
		int zahl2;
		int ergebnis;

		do {
			System.out.print("Bitte geben Sie die Rechenoperation (+, -, *, /) an: ");
			operator = EAM.rChar();

			if (operator == '+') {
				System.out.print("Bitte geben Sie den ersten Summand ein: ");
				zahl1 = StdIn.readInt();
				System.out.print("Bitte geben Sie den zweiten Summand ein: ");
				zahl2 = StdIn.readInt();
				ergebnis = addiere(zahl1, zahl2);
				druckeErgebnis(operator, zahl1, zahl2, ergebnis);
			} else if (operator == '-') {
				System.out.print("Bitte geben Sie den Minuend ein: ");
				zahl1 = StdIn.readInt();
				System.out.print("Bitte geben Sie den Subtrahend ein: ");
				zahl2 = StdIn.readInt();
				ergebnis = subtrahiere(zahl1, zahl2);
				druckeErgebnis(operator, zahl1, zahl2, ergebnis);
			} else if (operator == '*') {
				System.out.print("Bitte geben Sie den ersten Faktor ein: ");
				zahl1 = StdIn.readInt();
				System.out.print("Bitte geben Sie den zweiten Faktor ein: ");
				zahl2 = StdIn.readInt();
				ergebnis = multipliziere(zahl1, zahl2);
				druckeErgebnis(operator, zahl1, zahl2, ergebnis);
			} else if (operator == '/') {
				System.out.print("Bitte geben Sie den Divident ein: ");
				zahl1 = StdIn.readInt();
				System.out.print("Bitte geben Sie den Divisor ein: ");
				zahl2 = StdIn.readInt();
				if (zahl2 == 0)
					System.out.println("Division durch 0 geht nicht!!!");
				else {
					ergebnis = dividiere(zahl1, zahl2);
					druckeErgebnis(operator, zahl1, zahl2, ergebnis);
				}
			}else{
				System.out.println("Falscher Operator angegeben!!!");
			}

			System.out.print("Moechten Sie eine weitere Aufgabe berechnen? (j/n):");
			weiter = StdIn.readChar();
			//System.out.println("Info: "+weiter + "!");
			System.out.println();
		} while (weiter != 'n');

	}

	public static int addiere(int zahl1, int zahl2) {
		return zahl1 + zahl2;
	}

	public static int subtrahiere(int zahl1, int zahl2) {
		return zahl1 - zahl2;
	}

	public static int multipliziere(int zahl1, int zahl2) {
		return zahl1 * zahl2;
	}

	public static int dividiere(int zahl1, int zahl2) {
		return zahl1 / zahl2;
	}

	public static void druckeErgebnis(char operator, int zahl1, int zahl2, int ergebnis) {
		System.out.println("Die Berechnung von " + zahl1 + " " + operator + " " + zahl2 + " ergibt " + ergebnis);
		System.out.println();
	}

}
