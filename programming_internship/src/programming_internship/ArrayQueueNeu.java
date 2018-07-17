package programming_internship;

public class ArrayQueueNeu<T> implements MyQueue<T>{

	private T[] data;
	private int last=0;
	private int first=0;
	private int size=10;
	
	public ArrayQueueNeu(int size){
		this.size=size;
		this.data = (T[])(new Object[size]);
	}
	
	@Override
	public void enqueue(T t) {
		if(!arrayFull()) {
			this.data[last]=t;
			last++;
		} else {
			System.out.println("Array ist voll");
		}
	}

	@Override
	public T dequeue() {
		T wert=this.data[first];
		this.data[first]=null;
		first++;
		if(arrayFull() && first==last) {
			System.out.println("Schlange abgezogen!");
		}
		return wert;

	}
	
	public boolean arrayFull() {
		return last==size;	
	}
	
	
	public String toString() {
		String ret="";
		for(int i=first;i<last;i++) {
			ret += i + " "  +data[i].toString()+"\n";
		}
		return ret;
		//return "Student [matrikelnummer=" + matrikelnummer + ", name=" + name + ", vorname=" + vorname + ", jahrgang=" + jahrgang+", creditpoints=" + creditpoints+"]";
	}
	
}
