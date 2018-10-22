package com.example.observer.instance;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.example.observer.Beobachter;
import com.example.observer.Subjekt;

public class TemperaturAnzeigeFahrenheit implements Beobachter {
	private JLabel tempLabel = new JLabel("Temperatur:");
	private JLabel tempValue = new JLabel("UNDEF");
	private JFrame mainWindow = new JFrame("Temperaturanzeige F");
	private FlowLayout flow = new FlowLayout();
	
	public TemperaturAnzeigeFahrenheit(){
		mainWindow.getContentPane().setLayout(flow);
		mainWindow.add(tempLabel);
		mainWindow.add(tempValue);
		mainWindow.pack();
		
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setLocation(200, 200);
		
		mainWindow.setVisible(true);
	} 
	
	@Override
	public void aktualisieren(Subjekt subjekt) {
		// TODO Auto-generated method stub
		String tempText = subjekt.gibZustand();
		
		int wert = (Integer.parseInt(tempText) *9/5)+32;
		tempText=wert+"";
		
		tempValue.setText(tempText);
	}

}
