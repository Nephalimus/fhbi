package programming_internship;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("all")

public class TestGenerics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student first = new Student("Mueller","Markus",1990,4711);
		Student second = new Student("Meier","michael",1991,4713);
		Student third = new Student("Schmidt","Sebastian",1982,4712);
		
		List <Student>studenten = new ArrayList<Student>();
		studenten.add(first);
		studenten.add(second);
		studenten.add(third);
		studenten.add(first);
		
		if(studenten.isEmpty())
			return;
		
		Collections.sort(studenten);
		//Collections.sort(studenten, new SortJahrgang());
		
		for(int i=0;i<studenten.size();i++) {
			Student s1 = studenten.get(i);
			
			System.out.println(s1);
		}
	}

}
