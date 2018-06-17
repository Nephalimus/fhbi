package T1_20171109;

import edu.princeton.cs.introcs.StdIn;

public class Wuerfeln02 {

	public static void main(String[] args) {
		System.out.println("Wie viele Spielrunden soll gespielt werden?");
		System.out.print("Eingabe: ");

		int runden = StdIn.readInt();
		int summe = 0;
		
		for (int runde = 1; runde <= runden; runde++) {

			int anzahlWuerfe = 1;

			while ((int) (Math.random() * 6 + 1) != (int)(Math.random()*6+1))
				anzahlWuerfe++;

			System.out.println("Es musste " + anzahlWuerfe + " Mal geworfen werden, um ein Pasch zu würfeln.");
			summe += anzahlWuerfe;
		}
		
		System.out.println("Im Durchschnitt wurden " + (summe/runden) + " würfe benötigt.");
	}

}
