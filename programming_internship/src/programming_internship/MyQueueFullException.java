package programming_internship;

@SuppressWarnings("all")

public class MyQueueFullException extends MyQueueException {

	private String message = "Array ist voll!";
	
	public MyQueueFullException() {
		
	}
	
	public MyQueueFullException(int size) {
		message += " " + size + " Plätze sind vollständig belegt.";
	}
	
	public String getMessage() {
		return message;
	}

}