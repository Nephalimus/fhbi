package programming_for_beginners;

import edu.princeton.cs.introcs.StdOut;

public class FiboZ01 {

	public static void main(String[] args) {
		
		StdOut.println("Dieses Programm gibt die ersten 20 Elemente der Fibonacci Folge aus.");
		int a = 1;
		int b = 1;
		int g;
		System.out.print("1 1 ");
		//quick and dirty!
		for(int i=3;i<=20;i++){
			g = a + b;
			a = b;
			b = g;
			System.out.print(g + " ");
		}
	}

}
