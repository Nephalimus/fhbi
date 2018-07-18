package programming_internship;

public interface MyQueue<T> {

	public void enqueueData(T t) throws MyQueueFullException;
	
	public T dequeueData() throws MyQueueEndeException, MyQueueAbgezogenException;
	
}
