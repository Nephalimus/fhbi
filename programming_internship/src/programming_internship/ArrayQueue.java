package programming_internship;


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

}
