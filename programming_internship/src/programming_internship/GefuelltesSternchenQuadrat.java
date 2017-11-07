package programming_internship;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class GefuelltesSternchenQuadrat
{
	public static void main(String[] args)
	{
		StdOut.println("Bitte Anzahl eingeben: ");
		int n = StdIn.readInt();
		
		for(int z=1; z<=n; z++)
		{
			for(int s=1; s<=n; s++)
				StdOut.print('*');
			StdOut.println();
		}
	}
}
