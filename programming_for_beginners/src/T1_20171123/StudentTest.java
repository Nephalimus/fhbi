package T1_20171123;

import edu.princeton.cs.introcs.StdIn;

public class StudentTest {

	public static void main(String[] args) {
		// Datenstruktur für Studenten erzeugen
		Student[] studenten;
		
		System.out.println("Wie viele Studenten sollen angelegt werden?");
		System.out.print("Anzahl: ");
		studenten = new Student[StdIn.readInt()];
		
		for(int i = 0 ; i < studenten.length ; i++){
			// Studenten mit dem Defaultkonstruktor erzeugen
			studenten[i] = new Student();
			
			
			// Studenten mit dem benutzerdefinierten Konstruktor erzeugen
//			System.out.print("Bitte Matrikelnummer eingeben: ");
//			int matrikelnummer = StdIn.readInt();
//			System.out.print("Bitte den Nachnamen eingeben: ");
//			String  name = StdIn.readString();
//			System.out.print("Bitte den Vornamen eingeben: ");
//			String vorname = StdIn.readString();
			
//			studenten[i] = new Student(matrikelnummer,name, vorname);
		}
		ausgabe(studenten);
		studenten[0].setName("Trottel");
		ausgabe(studenten);
		
		
	}
	public static void ausgabe(Student[] studenten){
		System.out.println();
		for(int i = 0 ; i < studenten.length ; i++){
			System.out.println(studenten[i].toString());
		}
	}

}
