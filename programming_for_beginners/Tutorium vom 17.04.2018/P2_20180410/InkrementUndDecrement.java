package P2_20180410;

public class InkrementUndDecrement {

	public static void main(String[] args) {
		
		// Aufgabe a)
		System.out.println("Teilaufgabe a)");
		String x;
		double j = 2.5;
		int i = 1;
		String k = "11";
		
		x = k + ++i +j--;
		System.out.println("i: " + i + " | j: " + j + " | k: " + k + " | x: " + x);

		x = null;
		j = 2.5;
		i = 1;
		k = "11";
		
		x = ++i + ++i + ++j + "";
		System.out.println("i: " + i + " | j: " + j + " | k: " + k + " | x: " + x);

		
		// Aufgabe b)
		System.out.println("Teilaufgabe b)");
		i = 4;
		j = 3.5;
		k = "Hallo";
		x = null;
		
		x = k + j-- + k;
		System.out.println("i: " + i + " | j: " + j + " | k: " + k + " | x: " + x);
		
		i = 4;
		j = 3.5;
		k = "Hallo";
		x = null;
		
		x = --i + --j * i++ + "";
		System.out.println("i: " + i + " | j: " + j + " | k: " + k + " | x: " + x);
		
		i = 4;
		j = 3.5;
		k = "Hallo";
		x = null;
		
		k = i++  + ++j + j++ + "";
		System.out.println("i: " + i + " | j: " + j + " | k: " + k + " | x: " + x);
		
		// Aufgabe c)
		System.out.println("Teilaufgabe c)");
		i = 2;
		j = 1.5;
		k ="11";
		x = null;
				
		x = k + --j + k;
		System.out.println("i: " + i + " | j: " + j + " | k: " + k + " | x: " + x);
		
		i = 2;
		j = 1.5;
		k ="11";
		x = null;
				
		x = "" + --i + ++i;
		System.out.println("i: " + i + " | j: " + j + " | k: " + k + " | x: " + x);
		
		
		// Aufgabe d)
		System.out.println("Teilaufgabe d)");
		i = 4;
		j = 3.5;
		k ="Hallo";
		x = null;
				
		x = k + j-- + k;
		System.out.println("i: " + i + " | j: " + j + " | k: " + k + " | x: " + x);
		
		i = 4;
		j = 3.5;
		k ="Hallo";
		x = null;
				
		x = "" + --i * --j;
		System.out.println("i: " + i + " | j: " + j + " | k: " + k + " | x: " + x);
		
		i = 4;
		j = 3.5;
		k ="Hallo";
		x = null;
				
		k = ++j + j++ + "";
		System.out.println("i: " + i + " | j: " + j + " | k: " + k + " | x: " + x);
		
		
		// Aufgabe e)
		System.out.println("Teilaufgabe e)");
		i = 6;
		j = 1.5;
		k ="Hallo";
		x = null;
				
		x = i + j + k;
		System.out.println("i: " + i + " | j: " + j + " | k: " + k + " | x: " + x);
		
		i = 6;
		j = 1.5;
		k ="Hallo";
		x = null;
				
		x = i * j-- + "";
		System.out.println("i: " + i + " | j: " + j + " | k: " + k + " | x: " + x);
		
		i = 6;
		j = 1.5;
		k ="Hallo";
		x = null;
				
		k +=k;
		System.out.println("i: " + i + " | j: " + j + " | k: " + k + " | x: " + x);
		
		i = 6;
		j = 1.5;
		k ="Hallo";
		x = null;
				
		x = i++ + ++j + "";
		System.out.println("i: " + i + " | j: " + j + " | k: " + k + " | x: " + x);
	}

}
