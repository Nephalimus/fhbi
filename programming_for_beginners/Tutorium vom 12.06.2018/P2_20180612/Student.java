package P2_20180612;

public class Student implements Comparable<Student>{
	
	private int matrikelnummer;
	private String name;
	private String vorname;
	private String studiengang;
	private boolean status;

	public Student(int matrikelnummer, String name, String vorname, String studiengang, boolean status) {
		this.matrikelnummer = matrikelnummer;
		this.name = name;
		this.vorname = vorname;
		this.studiengang = studiengang;
		this.status = status;
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

	public String getStudiengang() {
		return studiengang;
	}

	public void setStudiengang(String studiengang) {
		this.studiengang = studiengang;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getMatrikelnummer() {
		return matrikelnummer;
	}
	
	public void setMatrikelnummer(int matrikelnummer){
		this.matrikelnummer = matrikelnummer;
	}
	
	

	@Override
	public String toString() {
		return this.matrikelnummer + ";" + this.name + ";" + this.vorname + ";" + this.studiengang + ";" + this.status;
	}

	@Override
	public int compareTo(Student s) {
		return this.getMatrikelnummer() - s.getMatrikelnummer();
	}
	
	

}
