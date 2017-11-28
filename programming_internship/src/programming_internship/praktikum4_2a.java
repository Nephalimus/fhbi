package programming_internship;

public class praktikum4_2a {

	public static int[] changeArray(int[] werte) {	
		int max = werte.length;		//z.B: 5
		int[] neu = new int[max];	
		max=max-1;					//als Zaehlvariable wieder -1
		
		for(int x=0;x<=max;x++) {
			neu[max-x]=werte[x];	//Array drehen
		}
		return neu;	
	}	
}


