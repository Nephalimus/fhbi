package programming_internship;

public class ListQueueNeuTest {

	public static void main(String[] args) {
		Student first = new Student("Mueller","Markus",1990,4711);
		Student second = new Student("Meier","michael",1991,4713);
		Student third = new Student("Schmidt","Sebastian",1982,4712);
		
		ListQueueNeu<Student> werteot = new ListQueueNeu<Student>();
		werteot.enqueueData(first);
		werteot.enqueueData(second);
		werteot.enqueueData(third);
		
		System.out.println(werteot);
		
		werteot.dequeueData();
		werteot.dequeueData();
		
		System.out.println(werteot);
		
		werteot.enqueueData(first);
		werteot.enqueueData(first);
		werteot.enqueueData(first);
		werteot.enqueueData(first);
		werteot.enqueueData(first);
		werteot.enqueueData(second);
		
		System.out.println(werteot);
		
		werteot.dequeueData();
		werteot.dequeueData();
		werteot.dequeueData();
		werteot.dequeueData();
		werteot.dequeueData();
		werteot.dequeueData();
		werteot.dequeueData();
		System.out.println(werteot);
		
		werteot.enqueueData(first);
		System.out.println(werteot);
		
		werteot.enqueueData(first);
		werteot.dequeueData();
		System.out.println(werteot);
		
		werteot.dequeueData();
		System.out.println(werteot);
	}

}
