package programming_internship;

import java.util.LinkedList;

@SuppressWarnings("all")

public class TestListen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student first = new Student("Mueller","Markus",1990,4711);
		Student second = new Student("Meier","michael",1991,4713);
		Student third = new Student("Schmidt","Sebastian",1982,4712);
		
		LinkedList studenten = new LinkedList();
		studenten.add(first);
		studenten.add(second);
		studenten.add(third);
		studenten.add(first);
		
		if(studenten.isEmpty())
			return;
		Student s = (Student) studenten.getFirst();
		
		for(int i=0;i<studenten.size();i++) {
			Student s1 = (Student) studenten.get(i);
			s1.addiere(s1.getMatrikelnummer(), 2);
			
			System.out.println(studenten.get(i));
		}
	}

}
