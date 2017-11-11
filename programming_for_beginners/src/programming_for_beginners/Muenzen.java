package programming_for_beginners;

import edu.princeton.cs.introcs.StdOut;

public class Muenzen {
	public static void main(String[] args) {
		// Grundidee "extern" gesichert von http://matheplanet.com/matheplanet/nuke/html/article.php?sid=272
		//Die notwendige Mathematik muss Prof. Tamm erst noch in der Vorlesung nutzen und Prof. Förster muss noch Methoden, Rückgabewerte und Rekursion erläutern
		StdOut.println("Dieses Programm gibt alle moeglichen Kombinationen aus, wie eine 1 Euro Muenze ausgezahlt werden kann.");
		StdOut.println("Zur Verfuegung stehen 1, 2, 5, 10, 20 , 50 Cent Muenzen und 1 Euro - je in ausreichender Anzahl.");
		System.out.println();
		
		StdOut.println("Die Anzahl der moeglichen Kombinationen liegt bei: " + zerlegungen(100, 6));
	}
	
	static int zerlegungen(int betrag, int max_muenze) {
		int muenzwerte[] = {1, 2, 5, 10, 20, 50, 100};
		if(betrag==0) {
		   return 1;
		}else if(betrag < 0) {
		   return 0;
		}else{
		   int zaehler = 0, i = max_muenze;
		   while(true){
		     zaehler += zerlegungen(betrag - muenzwerte[i], i);
		     if (i == 0)break;
		     --i;
		    }
		    return zaehler;
		 }
	}
}




