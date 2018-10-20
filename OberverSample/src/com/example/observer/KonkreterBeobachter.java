package com.example.observer;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("all")
public class KonkreterBeobachter implements Beobachter {
	private JLabel tempLabel = new JLabel("Temperatur:");
	private JLabel tempValue = new JLabel("UNDEF");
	private JFrame mainWindow = new JFrame("Temperaturanzeige");
	private FlowLayout flow = new FlowLayout();
	
	
	public KonkreterBeobachter()
	{
		mainWindow.getContentPane().setLayout(flow);
		mainWindow.add(tempLabel);
		mainWindow.add(tempValue);
		mainWindow.pack();
		mainWindow.setVisible(true);
		
	}
	
	
	
	/**
	 * Zum aktualisieren kann nun der Beobachter
	 * direkt auf das Subjekt zugreifen und die Methode gibZustand 
	 * aufrufen.
	 * 
	 */
	public void aktualisieren(Subjekt subjekt)
	{	
		String tempText = subjekt.gibZustand();
		tempValue.setText(tempText);
	}
		
	
}
