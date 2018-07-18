package programming_internship;

public class NodeNeu<T> {
	private T data;
	private NodeNeu<T> next;
	private NodeNeu<T> previous;
	
	public NodeNeu(T data) {
		this.data = data;
		this.next = null;
		this.previous = null;
	}
	
	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public NodeNeu<T> getNextNode() {
		return this.next;
	}
	
	public NodeNeu<T> getPreviousNode() {
		return this.previous;
	}

	public void setNextNode(NodeNeu<T> next) {
		this.next = next;
	}
	
	public void setPreviousNode(NodeNeu<T> previous) {
		this.previous = previous;
	}

	
}
