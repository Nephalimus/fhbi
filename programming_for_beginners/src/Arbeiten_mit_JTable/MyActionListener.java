package Arbeiten_mit_JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("all")
public class MyActionListener implements ActionListener{
	
	private SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
	Studentenverwaltung gui;

	public MyActionListener(Studentenverwaltung gui) {
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		/*
		 * Die Textfelder showName und showNachname können editiert werden. Wenn Änderungen dauerhaft
		 * gespeichert werden sollen, dann kann dies durch den Klick des Buttons aendern durchgeführt werden.
		 * Die Änderungen werden zum einen in der tabellarischen Anzeige angepasst und zum anderen beim 
		 * jeweiligen Objekt in der TreeMap durchgeführt. Änderungen werden allerdings erst dann durchgeführt,
		 * wenn die Eingaben mindestens ein Zeichen lang sind
		 */
		if(ae.getSource() == gui.aendern){
			/*
			 * Sicherstellen, dass Änderungsanweisungen nur dann durchgeführt werden können, wenn 
			 * eine Zeile markiert wurde.
			 */
			if( gui.tabelle.getSelectedRow()>=0){
				/*
				 * Änderungen werden erst dann durchgeführt, wenn die jeweilige Eingabelänge 
				 * mindestens den Wert 1 hat.
				 */
				if( gui.showName.getText().length()>0 &&  gui.showVorname.getText().length()>0){
					try {
						Date date = df.parse(gui.showDatum.getText());
						/*
						 * Ändern der Anzeige in der Tabelle
						 */
						 gui.tabelle.setValueAt( gui.showName.getText(), gui.tabelle.getSelectedRow(), 1);
						 gui.tabelle.setValueAt( gui.showVorname.getText(), gui.tabelle.getSelectedRow(), 2);
						 gui.tabelle.setValueAt( date, gui.tabelle.getSelectedRow(),3);

						/*
						 * Ändern des Objektes in der TreeMap.
						 */
						 gui.studentenliste.get(Integer.parseInt((String)  gui.tabelle.getValueAt( gui.tabelle.getSelectedRow(),0))).setName( gui.showName.getText());
						 gui.studentenliste.get(Integer.parseInt((String)  gui.tabelle.getValueAt( gui.tabelle.getSelectedRow(),0))).setVorname( gui.showVorname.getText());
						 gui.studentenliste.get(Integer.parseInt((String)  gui.tabelle.getValueAt( gui.tabelle.getSelectedRow(),0))).setGeburtsdatum(date);
					} catch (ParseException e1) {
						gui.showDatum.requestFocus();
						gui.showDatum.selectAll();
					}
					
				}
			}
				
				
		}
		/*
		 *Wenn markierte Zeile und das dazugehörige Objekt gelöscht werden soll, kann dieses
		 *mit einem Klick auf den Buttom loeschen durchgeführt werden. Es werden die Anzeige aus der 
		 *tabellarischen Darstellung und das entsprechende Objekt aus der TreeMap entfernt.
		 */
		if(ae.getSource()==  gui.loeschen){
			/*
			 * Sicherstellen, dass Löschanweisungen nur dann durchgeführt werden können,
			 * wenn eine Zeile markiert wurde
			 */
			if( gui.tabelle.getSelectedRow()>=0){
				/*
				 * Objekt aus der TreeMap entfernen.
				 */
				 gui.studentenliste.remove(Integer.parseInt((String)  gui.tabelle.getValueAt( gui.tabelle.getSelectedRow(), 0)));
				/*
				 * Zeile aus der Tabelle entfernen.
				 */
				 gui.dtm.removeRow( gui.tabelle.getSelectedRow());
				/*
				 * Textfelder zurücksetzen.
				 */
				 gui.showMatrikelnummer.setText(null);
				 gui.showName.setText(null);
				 gui.showVorname.setText(null);
				 gui.showDatum.setText(null);
			}
		}
		/*
		 * Ein neuer Student soll hinzugefügt werden. Dazu werden die Buttons loeschen, 
		 * aendern, hinzufuegen und beenden ausgeblendet und die Buttons speichern und 
		 * abbrechen eingeblendet.
		 */
		if(ae.getSource()==  gui.hinzufuegen){
			/*
			 * Setzen der nächsten freien Matrikelnummer
			 */
			if(gui.studentenliste.size() > 0)
				gui.showMatrikelnummer.setText(Integer.toString( gui.studentenliste.lastKey()+1));
			else
				gui.showMatrikelnummer.setText("10001");
			/*
			 * Zurücksetzen der Textfelder showName und showVorname.
			 */
			 gui.showName.setText(null);
			 gui.showVorname.setText(null);
			 gui.showDatum.setText(null);
			 /*
			  * Setzen des Cursors
			  */
			 gui.showName.requestFocus();
			/*
			 * Selection in der Tabelle verhindern
			 */
			 gui.tabelle.setEnabled(false);
			/*
			 * Aktuelle Selektion in der Tabelle zurücksetzen.
			 */
			 gui.tabelle.clearSelection();
			/*
			 * Ausblenden der nich erforderlichen Steuerelemente.
			 */
			 gui.aendern.setVisible(false);
			 gui.loeschen.setVisible(false);
			 gui.beenden.setVisible(false);
			 gui.hinzufuegen.setVisible(false);
			/*
			 * Hinzufügen der für dieErfassung erforderlichen Steuerelemente.
			 */
			 gui.speichern.setVisible(true);
			 gui.abbrechen.setVisible(true);
		}
		/*
		 * Wenn Daten für den neuen Studenten eingegeben wurden und der Button 
		 * speicher gedrückt wird, werden in der Tabelle eine neue Zeile angelegt 
		 * und in der TreeMap ein neues Objekt hizugefügt. Allerding werden die Aktionen 
		 * nur dann ausgeführt, wenn die Eingaben mindestens ein Zeichen lang sind.
		 */
		if(ae.getSource()== gui.speichern){
			/*
			 * Einblenden der zuvor ausgeblendeten Steuerelemente (Button hinzufügen).
			 */
			 gui.aendern.setVisible(true);
			 gui.loeschen.setVisible(true);
			 gui.beenden.setVisible(true);
			 gui.hinzufuegen.setVisible(true);
			/*
			 * Ausblenden,der Steuerelemente, die für das Anlegen eines neuen 
			 * Studenten erforderlich waren.
			 */
			 gui.speichern.setVisible(false);
			 gui.abbrechen.setVisible(false);
			if( gui.showName.getText().length() > 0 &&  gui.showVorname.getText().length()>0 && gui.showDatum.getText().length()>0){
				/*
				 * Daten für die Tabelle in einem Array zusammenstellen
				 */
				try {
					Object rowData[] = { gui.showMatrikelnummer.getText(), gui.showName.getText(),gui.showVorname.getText(), df.parse(gui.showDatum.getText())};
					/*
					 * Daten in die Tabelle schreiben
					 */
					 gui.dtm.addRow(rowData);
					/*
					 * Neues Objekt in der TreeMap anlegen
					 */
					 gui.studentenliste.put(Integer.parseInt( gui.showMatrikelnummer.getText().trim()), new Student(Integer.parseInt( gui.showMatrikelnummer.getText().trim()), gui.showName.getText(), gui.showVorname.getText(),df.parse(gui.showDatum.getText())));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}		
			/*
			 * Zurücksetzen der Textfelder
			 */
			 gui.showMatrikelnummer.setText(null);
			 gui.showName.setText(null);
			 gui.showVorname.setText(null);
			 gui.showDatum.setText(null);
			 gui.searchText.requestFocus();
			/*
			 * Selektionsoption für die Tabelle wieder freigeben.
			 */
			 gui.tabelle.setEnabled(true);
		}
		/*
		 * Falls die Eingabe von Daten für einen neuen Studenten abgebrochen werden sollen,
		 * kann der Button abbrechen angeklickt werden.
		 */
		if(ae.getSource()== gui.abbrechen){
			/*
			 * Einblenden der zuvor ausgeblendeten Steuerelemente (Button hinzufügen).
			 */
			 gui.aendern.setVisible(true);
			 gui.loeschen.setVisible(true);
			 gui.beenden.setVisible(true);
			 gui.hinzufuegen.setVisible(true);
			/*
			 * Ausblenden,der Steuerelemente, die für das Anlegen eines neuen 
			 * Studenten erforderlich waren.
			 */
			 gui.speichern.setVisible(false);
			 gui.abbrechen.setVisible(false);
			/*
			 * Zurücksetzen der Textfelder
			 */
			 gui.showMatrikelnummer.setText(null);
			 gui.showName.setText(null);
			 gui.showVorname.setText(null);
			 gui.showDatum.setText(null);
			 gui.searchText.requestFocus();
			/*
			 * Selektionsoption für die Tabelle wieder freigeben.
			 */
			 gui.tabelle.setEnabled(true);			
		}
		/*
		 * Wenn das Programm über den Button beenden beendet wird, werden 
		 * alle in der TreeMap befindlichen Objekte in eine Datei geschrieben,
		 * bevor das Programm endgültig beendet wird.
		 */
		if(ae.getSource()== gui.beenden){
			new MessageDialog(gui,Student.sichereStudenten( gui.studentenliste));
			gui.setVisible(false);
			gui.dispose();
		}
	}
}
