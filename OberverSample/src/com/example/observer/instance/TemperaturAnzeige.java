package com.example.observer.instance;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.example.observer.Beobachter;
import com.example.observer.Subjekt;

public class TemperaturAnzeige implements Beobachter {
	private static final int EXIT_ON_CLOSE = 0;
	private JLabel tempLabel = new JLabel("Temperatur:");
	private JLabel tempValue = new JLabel("UNDEF");
	private JFrame mainWindow = new JFrame("Temperaturanzeige");
	private FlowLayout flow = new FlowLayout();
	
	public TemperaturAnzeige(){
		mainWindow.getContentPane().setLayout(flow);
		mainWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainWindow.add(tempLabel);
		mainWindow.add(tempValue);
		mainWindow.pack();
		mainWindow.setVisible(true);
		
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setLocation(100, 100);
	} 
	
	@Override
	public void aktualisieren(Subjekt subjekt) {
		// TODO Auto-generated method stub
		String tempText = subjekt.gibZustand();
		tempValue.setText(tempText);
	}

}
