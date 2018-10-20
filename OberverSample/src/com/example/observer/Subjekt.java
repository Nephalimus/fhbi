package com.example.observer;

public interface Subjekt {

	public void registriereBeobachter(Beobachter b);
	public void entferneBeobachter(Beobachter b);
	public String gibZustand();
}
