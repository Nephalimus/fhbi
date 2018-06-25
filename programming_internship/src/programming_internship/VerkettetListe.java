package programming_internship;

public class VerkettetListe {
		private Node root;
		private Node last;
		private Node current;
		
		public VerkettetListe() {
			root = new Node(null);
			last = root;
		}
		
		public boolean isEmpty() {
			return root == last;
		}
		
		public void append(Student data) {
			Node newNode = new Node(data);
			last.setNext(newNode);
			last = newNode;
		}
		
		public Student getfirst() {
			current = root.getNext();
			if(current == null)
				return null;
			return current.getData();
		}
		
		public boolean hasNext() {
			return current.getNext() != null;
		}
	
		public Student getNext() {
			current = current.getNext();
			return current.getData();
		}
	
}
