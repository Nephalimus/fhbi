package Arbeiten_mit_JTable;

import java.awt.EventQueue;
import java.util.TreeMap;

public class MainStudentenverwaltung {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreeMap<Integer,Student> studentenliste = Student.ladeStudenten();
					new Studentenverwaltung(studentenliste);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
