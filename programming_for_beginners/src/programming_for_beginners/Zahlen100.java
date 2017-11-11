package programming_for_beginners;

import edu.princeton.cs.introcs.StdOut;

public class Zahlen100 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StdOut.println("Dieses Programm gibt alle Zahlen von 1 - 100 aus - im 37/1000 Teilerfremd-Rhythmus.");
		int sum = 1;			
		for(int i=1;i<101;i++){
			if(i==21 || i==41 || i==61 || i==81) System.out.println();
			System.out.printf("%2d ",sum);
			sum += 37;
			if(sum>=100)sum-=100;
		}
	}
}
