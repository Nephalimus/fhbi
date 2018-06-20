package programming_internship;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class ArrayQueue<T> implements Queue<T> {
	private int capacity = 0;
	private T[] queue;
	private int first = 0;
	private int last = capacity-1;
	private int size = 0;
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int size) 
	{
		this.capacity = size;
		queue = (T[]) new Object[size];
	}
	
	public void enqueue(T t)
	{
		if(size < capacity)
		{
			if(last >= capacity-1)
			{
				queue[0]=t;
				last = 0;
			}
			else
			{
				queue[last+1]=t;
				last++;
			}
			size++;
		}
	}
	public T dequeue()
	{
		if(size > 0)
		{

			T t = queue[first];
			if(first >= capacity-1)
			{
				first = 0;
			}
			else
			{
				first++;
			}
			size--;
			return t;
		}
		else
		{
			return null;
		}
	}

	@Override
	public boolean addAll(Collection<? extends T> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(T arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean offer(T arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

}
