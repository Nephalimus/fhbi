package T1_20171123;

import edu.princeton.cs.introcs.StdIn;

public class Student {

	private int matrikelnummer;
	private String name;
	private String vorname;
	
	public Student() {
		System.out.print("Bitte Matrikelnummer eingeben: ");
		this.matrikelnummer = StdIn.readInt();
		System.out.print("Bitte den Nachnamen eingeben: ");
		this.name = StdIn.readString();
		System.out.print("Bitte den Vornamen eingeben: ");
		this.vorname = StdIn.readString();
	}

	public Student(int matrikelnummer, String name, String vorname) {
		this.matrikelnummer = matrikelnummer;
		this.name = name;
		this.vorname = vorname;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMatrikelnummer() {
		return this.matrikelnummer;
	}

	public String getVorname() {
		return this.vorname;
	}

	@Override
	public String toString() {
		return "Student [matrikelnummer=" + matrikelnummer + ", name=" + name + ", vorname=" + vorname + "]";
	}
	
	
	
	

}
