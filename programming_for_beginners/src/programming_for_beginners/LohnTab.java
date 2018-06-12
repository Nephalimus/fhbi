package programming_for_beginners;

import edu.princeton.cs.introcs.StdOut;

public class LohnTab {

		public static void main(String[] args) {
			
			StdOut.println("Dieses Programm berechnet die Sozialabgaben, Steuern und das Netto fuer einen definierten Bruttobetragsbereich.");
				
			double steuer;
			double sozial;
			double brutto;
			double netto;
			
			System.out.println();
			//System.out.printf("Brutto    SozAbg   Steuer    Netto");
			System.out.printf("%-9s %-8s %-9s %-8s\n", "Brutto", "SozAbg", "Steuer", "Netto");
			System.out.println();
			System.out.printf("%9s %8s %9s %8s\n", "---------", "--------", "---------", "--------");
			
			for(brutto=1000;brutto<=2000;brutto+=100){
				sozial = brutto*11.0/100.0;
				steuer = brutto*38.0/100.0;
				//netto = Math.round(100.0 * (brutto - sozial - steuer)) / 100.0;
				netto = brutto - sozial - steuer;
				System.out.printf("%-9d %-8d %-9d %8d\n", (int)brutto, (int)sozial, (int)steuer, (int)netto);
				
			}
		}
}
