package programming_internship;

public class ArrayQueueNeuTest {

	public static void main(String[] args) {
		Student first = new Student("Mueller","Markus",1990,4711);
		Student second = new Student("Meier","michael",1991,4713);
		Student third = new Student("Schmidt","Sebastian",1982,4712);
		
		ArrayQueueNeu<Student> werteot = new ArrayQueueNeu<Student>(10);
		
		try {
			werteot.enqueueData(first);
			werteot.enqueueData(second);
			werteot.enqueueData(third);
		} catch (MyQueueException ex) {
			System.out.println(ex);
		}
		System.out.println(werteot);
		
		try {
			werteot.dequeueData();
			werteot.dequeueData();
			werteot.dequeueData();
//			werteot.dequeue();
		} catch (MyQueueException ex) {
			System.out.println(ex);
		}
		System.out.println(werteot);
		
		try {
			werteot.enqueueData(first);
			werteot.enqueueData(first);
			werteot.enqueueData(first);
			werteot.enqueueData(first);
			werteot.enqueueData(first);
			werteot.enqueueData(first);
		} catch (MyQueueException ex) {
			System.out.println(ex);
		}
		System.out.println(werteot);
		
		try {
			werteot.dequeueData();
			werteot.dequeueData();
			werteot.dequeueData();
			werteot.dequeueData();
			werteot.dequeueData();
			werteot.dequeueData();
			werteot.enqueueData(first);
		} catch (MyQueueException ex) {
			System.out.println(ex);
		}
		System.out.println(werteot);
			
		try {
			werteot.enqueueData(first);
			werteot.enqueueData(first);
			werteot.enqueueData(first);
			werteot.dequeueData();
			werteot.dequeueData();
		} catch (MyQueueException ex) {
			System.out.println(ex);
		}
		System.out.println(werteot);
			
		try {
			werteot.dequeueData();
			werteot.dequeueData();
		} catch (MyQueueException ex) {
			System.out.println(ex);
		}
		System.out.println(werteot);
		
		try {
			werteot.reset();
			werteot.enqueueData(first);
			werteot.enqueueData(second);
			werteot.enqueueData(third);
			werteot.enqueueData(first);
			werteot.enqueueData(second);
			werteot.enqueueData(third);
			werteot.enqueueData(first);
			werteot.enqueueData(second);
			werteot.enqueueData(third);
			werteot.enqueueData(first);
			werteot.enqueueData(second);
		} catch (MyQueueException ex) {
			System.out.println(ex);
		}
		System.out.println(werteot);
	}

}
