package T1_20171130;

public class Test {

	public static void main(String[] args) {

		Artikel a = new Artikel(2,"Hemd",23.90);
		System.out.println(a);
		
		double d = 23.347;
		double x = Math.round(d*100)/100.0;
		System.out.println(x);
	}

}
