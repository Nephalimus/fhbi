package P2_20180612;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("all")
public class StudentTableModel extends AbstractTableModel {

	private LinkedList<Student> slist;
	private String[] columnNames = { "Matrikelnummer", "Name", "Vorname", "Studiengang", "aktiv/inaktiv" };

	public StudentTableModel(LinkedList<Student> slist) {
		this.slist = slist;
	}

	@Override
	public int getColumnCount() {
		return this.columnNames.length;
	}

	@Override
	public int getRowCount() {
		return this.slist.size();
	}

	public String getColumnName(int col) {
		return this.columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		switch (col) {
		case 0: // Matrikelnummer
			return this.slist.get(row).getMatrikelnummer();
		case 1: // Name
			return this.slist.get(row).getName();
		case 2: // Vorname
			return this.slist.get(row).getVorname();
		case 3: // Studiengang
			return this.slist.get(row).getStudiengang();
		case 4: // Status
			return this.slist.get(row).getStatus();
		default:
			return null;
		}
	}

	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	public boolean isCellEditable(int row, int col) {
		if(col == 0)
			return false;
		return true;
	}

	public void setValueAt(Object value, int row, int col) {
		Student student = slist.get(row);

		switch (col) {
		case 0: // Matrikelnummer
			student.setMatrikelnummer((int) value);
			break;
		case 1: // Name
			student.setName((String) value);
			break;
		case 2: // Vorname
			student.setVorname((String) value);
			break;
		case 3: // Studiengang
			student.setStudiengang((String) value);
			break;
		case 4: // Status
			student.setStatus((boolean)value);
			break;
		}

	}
	
	public void addRow(Student student){
		this.slist.add(student);
		super.fireTableRowsInserted(this.slist.size()-1, this.slist.size()-1);
	}
	
	public void removeRow(int row){
		if(row >= 0){
			this.slist.remove(row);
			super.fireTableRowsDeleted(row, this.slist.size()-1);
		}
	}
	
	public Student getData(int row){
		if(row >= 0)
			return this.slist.get(row);
		return null;
	}
	
	public void setSlist(LinkedList<Student> slist){
		this.slist = slist;
	}

}
