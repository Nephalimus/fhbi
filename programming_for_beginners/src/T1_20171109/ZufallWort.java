package T1_20171109;

import edu.princeton.cs.introcs.StdIn;

public class ZufallWort {

	public static void main(String[] args) {
		System.out.println("Wie viele Zufallsworte möchten Sie erzeugen?");;
		String[] worte = new String[StdIn.readInt()];
		
		for(int i = 0 ; i < worte.length ; i++){
			
			//Wortlänge bestimmen
			char[] wort = new char[(int)(Math.random()*3+3)];
			
			// Buchstaben ermitteln
			for(int c = 0 ; c < wort.length ; c++){
				wort[c] = (char)(Math.random()*26+'A');
			}
			worte[i] = new String(wort);
		}
		
		// Ausgabe
		for(int i = 0 ; i < worte.length ; i++){
			System.out.printf("%5s | ", worte[i]);
			if((i+1)%10 == 0)
				System.out.println();
		}
	}

}
