package programming_for_beginners;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bestand = 10;
			
		while(bestand>0) {
			System.out.print("Warenbestand: "+bestand);
			if(bestand==5) {
				System.out.print(" Neue Ware besatellen!");
			}
			System.out.println("");
			bestand = bestand--;
		}
	}
}
