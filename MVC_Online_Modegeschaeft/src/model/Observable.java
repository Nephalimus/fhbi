package model;

public interface Observable {

	public void register(Observer view);
	public void removeObserver(Observer view);
	public void notifyObservers();
	
}
