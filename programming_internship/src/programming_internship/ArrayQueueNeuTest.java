package programming_internship;

public class ArrayQueueNeuTest {

	public static void main(String[] args) {
		Student first = new Student("Mueller","Markus",1990,4711);
		Student second = new Student("Meier","michael",1991,4713);
		Student third = new Student("Schmidt","Sebastian",1982,4712);
		
		ArrayQueueNeu<Student> werteot = new ArrayQueueNeu<Student>(10);
		werteot.enqueue(first);
		werteot.enqueue(second);
		werteot.enqueue(third);
		
		System.out.println(werteot);
		
		werteot.dequeue();
		werteot.dequeue();
		
		System.out.println(werteot);
		
		werteot.enqueue(first);
		werteot.enqueue(first);
		werteot.enqueue(first);
		werteot.enqueue(first);
		werteot.enqueue(first);
		werteot.enqueue(first);
		
		System.out.println(werteot);
		
		werteot.dequeue();
		werteot.dequeue();
		werteot.dequeue();
		werteot.dequeue();
		werteot.dequeue();
		werteot.dequeue();
		
		werteot.enqueue(first);
		System.out.println(werteot);
		
		werteot.enqueue(first);
		werteot.dequeue();
		System.out.println(werteot);
		
		werteot.dequeue();
		System.out.println(werteot);
	}

}
