package programming_internship;

import edu.princeton.cs.introcs.StdIn;

@SuppressWarnings("all")

public class Student implements Comparable<Student> {
//public class Student{
	private String name;
	private String vorname;
	private int jahrgang;
	private int matrikelnummer;
	private int creditpoints;
	private boolean isimmatirkuliert;
	
	public Student() {
		System.out.print("Bitte Matrikelnummer eingeben: ");
		this.matrikelnummer = StdIn.readInt();
		System.out.print("Bitte den Nachnamen eingeben: ");
		this.name = StdIn.readString();
		System.out.print("Bitte den Vornamen eingeben: ");
		this.vorname = StdIn.readString();
		System.out.print("Bitte Jahrgang eingeben: ");
		this.jahrgang = StdIn.readInt();
		
	}

	public Student(String name, String vorname, int jahrgang, int matrikelnummer) {
		this.jahrgang = jahrgang;
		this.name = name;
		this.vorname = vorname;
		this.matrikelnummer = matrikelnummer;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public int getJahrgang() {
		return jahrgang;
	}
	public void setJahrgang(int jahrgang) {
		this.jahrgang = jahrgang;
	}
	public int getCreditpoints() {
		return creditpoints;
	}
	public void setCreditpoints(int creditpoints) {
		this.creditpoints = creditpoints;
	}
	public int getMatrikelnummer() {
		return matrikelnummer;
	}
	public boolean isIsimmatirkuliert() {
		return isimmatirkuliert;
	}

	public static void addiere(int zahl1, int zahl2) {
		int ergebnis =  zahl1 * zahl2;
		Mathematik.addiere(zahl1, zahl2);
	}
	
	//@Override
	public String toString() {
		return "Student [matrikelnummer=" + matrikelnummer + ", name=" + name + ", vorname=" + vorname + ", jahrgang=" + jahrgang+", creditpoints=" + creditpoints+"]";
	}

	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.getJahrgang() - o.getJahrgang();
	}
	
}
