package Arbeiten_mit_JTable;

import java.text.DateFormat;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MyListSelectionListener implements ListSelectionListener{
	
	private Studentenverwaltung gui;

	public MyListSelectionListener(Studentenverwaltung gui) {
		this.gui = gui;
	}

	@Override
	public void valueChanged(ListSelectionEvent lse) {
		if(lse.getSource() == gui.listmodel){
			/*
			 * Wenn in der Tabelle eine Zeile markiert ist, sollen die Detailinformationen
			 * zu der markierten Zeile in den Textfeldern angezeigt werden.
			 */
			if(gui.tabelle.getSelectedRow()>=0){
				gui.showMatrikelnummer.setText((String) gui.tabelle.getValueAt(gui.tabelle.getSelectedRow(), 0));
				gui.showName.setText((String) gui.tabelle.getValueAt(gui.tabelle.getSelectedRow(), 1));
				gui.showVorname.setText((String) gui.tabelle.getValueAt(gui.tabelle.getSelectedRow(), 2));
				gui.showDatum.setText(DateFormat.getDateInstance().format(gui.tabelle.getValueAt(gui.tabelle.getSelectedRow(), 3)));
			}
		}
	}

}
