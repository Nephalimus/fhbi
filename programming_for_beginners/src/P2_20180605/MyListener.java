package P2_20180605;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyListener extends WindowAdapter implements ActionListener{

	private MyGui gui;
	
	public MyListener(MyGui gui) {
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.gui.getBtnButton()){
			System.out.println(this.gui.getTfEingabe().getText());
		}
		if(e.getSource() == this.gui.getTfEingabe()){
			System.out.println(this.gui.getTfEingabe().getText());
		}
		
	}
	@Override
	public void windowClosing(WindowEvent e){
		System.out.println("und Tschüss!");
		this.gui.dispose();
	}

}
