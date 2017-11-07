package programming_internship;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class SternchenQuadrat
{
	public static void main(String[] args)
	{
		StdOut.println("Bitte Anzahl eingeben: ");
		int n = StdIn.readInt();
		
		// Oberste Zeile
		for(int s=1; s<=n; s++)
			StdOut.print('*');
		StdOut.println();
		
		// Mittelteil
		for(int z=1; z<=n-2; z++)
		{
			StdOut.print('*');
			for(int s=1; s<=n-2; s++)
				StdOut.print(' ');
			StdOut.println("*");
		}
		
		// Unterste Zeile
		for(int s=1; s<=n; s++)
			StdOut.print('*');
		StdOut.println();
	}
}
