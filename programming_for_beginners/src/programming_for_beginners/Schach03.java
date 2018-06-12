package programming_for_beginners;

import edu.princeton.cs.introcs.StdOut;

public class Schach03 {
	public static void main(String[] args) {
		
		StdOut.println("Dieses Programm gibt ein Schachbrettmuster aus.");
		System.out.println();
		
		for(int i=1;i<=8;i++){
			for(int j=1;j<=8;j++){
				String ausgabe=(char)(i+64) + Integer.toString(j);	
				System.out.printf("%-4s ",ausgabe);
			}
			System.out.print("      ");
			for(int j=1;j<=8;j++){
				String ausgabe=(char)(73-j) + Integer.toString(i);	
				System.out.printf("%-4s ",ausgabe);
			}
			
			
			System.out.println();
		}
	}
}




