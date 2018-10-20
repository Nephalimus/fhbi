package programming_internship;

@SuppressWarnings("all")

public class MyQueueFullException extends MyQueueException {

	private String message = "Array ist voll!";
	
	public MyQueueFullException() {
		
	}
	
	public MyQueueFullException(int size) {
		message += " " + size + " Pl�tze sind vollst�ndig belegt.";
	}
	
	public String getMessage() {
		return message;
	}

}