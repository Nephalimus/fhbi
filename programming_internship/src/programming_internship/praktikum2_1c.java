package programming_internship;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class praktikum2_1c {

	public static void main(String[] args) {
		StdOut.print("Bitte geben Sie die Anzahl der Zeilen ein: ");
		int anzahl = StdIn.readInt();
			
		String sum = "";
		for(int i=1;i<=anzahl;i++){
			sum = "";
			if(i==1 || i==anzahl){
				for(int x=1;x<=anzahl;x++){
					sum += "*";
				}
			}else{
				for(int x=1;x<=anzahl;x++){
					if(x==1 || x==anzahl){		
						sum += "*";
					}else{
						sum += " ";
					}
				}
			}	
			StdOut.println(sum);
		}
	}


}
