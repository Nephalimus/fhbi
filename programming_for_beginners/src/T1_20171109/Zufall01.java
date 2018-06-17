package T1_20171109;

public class Zufall01 {

	public static void main(String[] args) {
		int anzahl=0;
		
		for(int durchlauf = 1 ; durchlauf <= 1000 ; durchlauf++){
			int summe = 0;
			
			for(int zufall = 1 ; zufall <= 10; zufall++){
				summe += (int) (Math.random()*10+1);
			}
			
			if(summe/10 > 7)
				anzahl++;
		}
		
		System.out.println("Bei 1000 Simulationen wurde der Mittelwert '7' " + anzahl + " mal überschrittem!");

	}

}
