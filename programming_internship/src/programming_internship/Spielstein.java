package programming_internship;

public class Spielstein {

	private boolean isRot;
	
	public Spielstein(boolean isRot) {
		// TODO Auto-generated constructor stub
		this.isRot=isRot;
	}

	public boolean isRot() {
		return isRot;
	}
	
	public String toString() {
		return "Spielstein: " + isRot; 
	}

}
