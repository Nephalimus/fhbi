package programming_for_beginners;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class KreditTab {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			StdOut.println("Dieses Programm berechnet die Ratenzahlung eines Kredits (extended Version).");
				
			StdOut.print("Bitte geben Sie die Kreditsumme (1000) ein: ");
			double summe = StdIn.readDouble();
			StdOut.print("Bitte geben Sie die gewuenschte Rate (100) ein: ");
			double rate = StdIn.readDouble();
			StdOut.print("Bitte geben Sie den Zinssatz / Monat (1) ein: ");
			double zins = StdIn.readDouble();
			
			System.out.println();
			System.out.printf("%15s%15s%-20s\n", "", "", "Restschuld Anfang");
			System.out.printf("%15s%15s%-20s\n", "Monat     ", "Rate     ", "des Monats nach");
			System.out.printf("%15s%15s%-20s\n", "", "", "Zahlung der Rate");
			System.out.printf("%15s%15s%-20s\n", "---------------", "---------------", "--------------------");
						
			int monat=1;
			System.out.printf("%9d    %13.2f  %15.2f\n", monat, 0.00, summe);	//Erste Zeile
			while(summe>rate){
				monat++;
				summe+=(summe/100.00*zins);
				summe-=rate;
				System.out.printf("%9d    %13.2f  %15.2f\n", monat, rate, summe);	
				if(summe<rate) {
					//für letzte Aufzinsung
					summe+=(summe/100.00*zins);
					rate=summe;
					monat++;
				}
			}
			System.out.printf("%9d    %13.2f  %15.2f\n", monat, rate, 0.00);	//Letzte Zeile

		}
}
