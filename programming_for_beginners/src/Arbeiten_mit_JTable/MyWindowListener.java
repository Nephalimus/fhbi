package Arbeiten_mit_JTable;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindowListener extends WindowAdapter{
	
	private Studentenverwaltung gui;

	public MyWindowListener(Studentenverwaltung gui) {
		this.gui = gui;
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		new MessageDialog(gui,Student.sichereStudenten( gui.studentenliste));
		gui.setVisible(false);
		gui.dispose();
	}
	
}
