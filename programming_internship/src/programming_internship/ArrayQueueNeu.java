package programming_internship;

public class ArrayQueueNeu<T> implements MyQueue<T>{

	private T[] data;
	private int last=0;
	private int first=0;
	private int size=10;
	
	@SuppressWarnings("unchecked")
	public ArrayQueueNeu(int size){
		this.size=size;
		this.data = (T[])(new Object[size]);
	}
	
	@Override
	public void enqueueData(T t) throws MyQueueFullException {
		System.out.println("\tenqueue " + t);
		if(!arrayFull()) {
			this.data[last]=t;
			if(last < size) {
				last++;
			}
		} else {
			//System.out.println("Array ist voll"); // Exception: Kein Platz mehr
			throw new MyQueueFullException(size);
		}
	}

	@Override
	public T dequeueData() throws MyQueueEndeException, MyQueueAbgezogenException {
		if(first==last) {
			//System.out.println("Schlange am Ende!"); // Exception: Schlange hat kein weiteres Element mehr 
			throw new MyQueueEndeException();
			//return null;
		} else {
			T wert=this.data[first];
			System.out.println("\tdequeue " + wert);
			this.data[first]=null;
			if(first < last) {
				first++;
			}
			if(arrayFull()/* || first==last*/) {
				//System.out.println("Schlange abgezogen!"); // Exception: Hat keinen Platz
				throw new MyQueueAbgezogenException();
			}
			return wert;
		}
	}
	
	public boolean arrayFull() {
		return last==size;	
	}

	public void reset() {
		this.first = 0;
		this.last = 0;
		for (int i = 0; i < size; i++) {
			this.data[i] = null;
		}
		System.out.println("Array reset");
	}
	
	public String toString() {
		String ret="-:-\n";
		for(int i=first;i<last;i++) {
			ret += i + " "  +data[i].toString()+"\n";
		}
		return ret;
	}
	
}
