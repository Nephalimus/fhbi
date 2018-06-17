package Arbeiten_mit_JTable;
/* ColoredTableCellRenderer.java */

import java.awt.*;
import java.text.DateFormat;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class ColoredTableCellRenderer implements TableCellRenderer {
	private Color lightBlue = new Color(160, 160, 255);
	private Color darkBlue = new Color(64, 64, 128);

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		// Label erzeugen
		JLabel label;
		if(value instanceof java.util.Date){
			label = new JLabel((String)DateFormat.getDateInstance().format(value));
		}
		else{
			label = new JLabel((String) value);
		}
//		try{
//			label = new JLabel((String) value);
//		}catch(ClassCastException cce){
//			if(value instanceof java.util.Date){
//				label = new JLabel((String)DateFormat.getDateInstance().format(value));
//			}
//			else
//				label = new JLabel
//		}
		
		label.setOpaque(true);
		Border b = BorderFactory.createEmptyBorder(1, 1, 1, 1);
		label.setBorder(b);
		label.setFont(table.getFont());
		label.setForeground(table.getForeground());
		label.setBackground(table.getBackground());
		if (hasFocus) {
			label.setBackground(Color.YELLOW);
			label.setForeground(Color.RED);
//			label.setBackground(lightBlue);
//			label.setForeground(darkBlue);
		} else if (isSelected) {
			label.setBackground(Color.YELLOW);
			label.setForeground(Color.RED);
//			label.setBackground(lightBlue);
//			label.setForeground(darkBlue);
		} else {
			if(row%2 == 0){
				label.setBackground(Color.LIGHT_GRAY);
				//label.setForeground(Color.WHITE);
			}
		}
		return label;
	}
}
