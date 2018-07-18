package programming_internship;

public class ListQueueNeu<T> implements MyQueue<T>{

	private NodeNeu<T> rootNode;
	private NodeNeu<T> lastNode;
	private NodeNeu<T> currentNode;
	
	public ListQueueNeu() {
		this.rootNode = new NodeNeu<T>(null);
		this.lastNode = this.rootNode;
	}
	
	
	@Override
	public void enqueueData(T t) {
		NodeNeu<T> newNode = new NodeNeu<T>(t);
		System.out.println("\tenqueue " + t);
		this.lastNode.setNextNode(newNode);
		newNode.setPreviousNode(this.lastNode);
		this.lastNode = newNode;
	}

	@Override
	public T dequeueData() {
		if(!isListEmpty()) {
			T returnData = this.rootNode.getNextNode().getData();
			this.rootNode.setNextNode(this.rootNode.getNextNode().getNextNode());
			if(this.rootNode.getNextNode()==null) {
				this.lastNode = this.rootNode;
			}
			System.out.println("\tdequeue " + returnData);
			return returnData;
		} else {
			System.out.println("dequeue empty");
			return null;
		}
	
	}
	
	private boolean isListEmpty() {
		return rootNode == lastNode;
	}
	
	private boolean hasNextNode() {
		return this.currentNode.getNextNode() != null;
	}

	private T getFirstData() {
		this.currentNode = this.rootNode.getNextNode();
		return this.currentNode.getData();
	}
	
	private T getNextData() {
		this.currentNode = this.currentNode.getNextNode();
		return this.currentNode.getData();
	}
	
	public String toString() {
		String ret="";
		if(!isListEmpty()) {
			int pos = 1;
			T t = this.getFirstData();
			ret += pos + " " + t.toString() + "\n";
			pos++;
			while(this.hasNextNode()) {
				t = this.getNextData();
				if(t != null) {
					ret += pos + " " + t.toString() + "\n";
					pos++;
				}
			}
			ret += "\n";
		} else {
			ret = "empty";
		}
		return ret;
	}	

}
