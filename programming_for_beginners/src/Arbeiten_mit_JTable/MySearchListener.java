package Arbeiten_mit_JTable;

import java.awt.Color;
import java.util.regex.PatternSyntaxException;

import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

@SuppressWarnings("all")
public class MySearchListener implements DocumentListener{
	
	private Studentenverwaltung gui;

	public MySearchListener(Studentenverwaltung gui) {
		this.gui = gui;
	}

	/*
	 * Wenn in der Suchmaske Eingaben vorgenommen werden, wird die Tabelle dynamisch
	 * angepasst. Dazu wird in den nachfolgenden (drei Methoden) die Methode aktualisiereTabelle()
	 * aufgerufen.
	 * @see javax.swing.event.DocumentListener#changedUpdate(javax.swing.event.DocumentEvent)
	 */
	@Override
	public void changedUpdate(DocumentEvent de) {
		aktualisiereTabelle();
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		aktualisiereTabelle();
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		aktualisiereTabelle();
	}
	/*
	 * Tabellenansicht wird dynamisch angepasst.
	 */
	public void aktualisiereTabelle(){
		gui.tabelle.clearSelection();
		gui.showMatrikelnummer.setText(null);
		gui.showName.setText(null);
		gui.showVorname.setText(null);
		gui.showDatum.setText(null);
		gui.searchText.setForeground(Color.BLACK);
		
//		 TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(); 
//		 gui.tabelle.setRowSorter(sorter); 
//         sorter.setModel(gui.dtm); 
       
         if(gui.searchText.getText()!= null && gui.searchText.getText().length()>0)
        	 try{
        		 gui.sorter.setRowFilter(RowFilter.regexFilter(gui.searchText.getText()));
        	 }catch(PatternSyntaxException pe){
        		 gui.searchText.setForeground(Color.RED);
        	 }
         else
        	 gui.sorter.setRowFilter(null);
	}

}
