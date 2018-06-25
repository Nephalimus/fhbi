package programming_internship;

import javax.swing.*;

public class PlainWindow {

	static JFrame mainWindow = new JFrame("Mein erstes Fenster");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mainWindow.setBounds(50,100,300,150);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setVisible(true);
	}

}
