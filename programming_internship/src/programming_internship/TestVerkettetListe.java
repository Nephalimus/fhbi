package programming_internship;

public class TestVerkettetListe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student first = new Student("Mueller","Markus",1990,4711);
		Student second = new Student("Meier","michael",1991,4713);
		Student third = new Student("Schmidt","Sebastian",1982,4712);
		
		VerkettetListe studenten = new VerkettetListe();
		studenten.append(first);
		studenten.append(second);
		studenten.append(third);
		studenten.append(first);
		
		if(studenten.isEmpty())
			return;
		Student s = studenten.getfirst();
		System.out.println(s);
		
		while(studenten.hasNext()) {
			s = studenten.getNext();
			System.out.println(s);
		}
	}

}
