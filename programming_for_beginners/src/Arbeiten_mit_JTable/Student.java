package Arbeiten_mit_JTable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeMap;

public class Student implements Comparable<Student> {

	private SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
	private int matrikelnummer;
	private String name;
	private String vorname;
	private Date geburtsdatum;

	public Student(int matrikelnummer, String name, String vorname, Date geburtsdatum) {
		this.matrikelnummer = matrikelnummer;
		this.name = name;
		this.vorname = vorname;
		this.geburtsdatum = geburtsdatum;
	}
	
	public Student(String zeile) {
		String temp[] = zeile.split(";");
		try {
			this.matrikelnummer = Integer.parseInt(temp[0]);
			this.name = temp[1];
			this.vorname = temp[2];
			this.geburtsdatum = df.parse(temp[3].trim());
		} catch (NumberFormatException nf){
			System.out.println("Student kommte nicht angelegt werden!\n"
							+ "Input: " + zeile + "\nFehlermeldung: "
							+ nf.getMessage());
		}catch(ParseException e){
			System.out.println("Student kommte nicht angelegt werden!\n"
					+ "Input: " + zeile + "\nFehlermeldung: "
					+ e.getMessage());
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}
	
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public int getMatrikelnummer() {
		return matrikelnummer;
	}
	
	public Date getGeburtsdatum(){
		return this.geburtsdatum;
	}

	public void setGeburtsdatum(Date geburtsdatum){
		this.geburtsdatum = geburtsdatum;
	}
		
	@Override
	public String toString() {
		return this.getMatrikelnummer() + ";" + this.getName() + ";"
				+ this.getVorname() +";" + DateFormat.getDateInstance().format(this.geburtsdatum);
	}

	@Override
	public int compareTo(Student student) {
		return this.getMatrikelnummer() - student.getMatrikelnummer();
	}

	public static TreeMap<Integer, Student> ladeStudenten() {
		TreeMap<Integer, Student> studentenliste = new TreeMap<Integer, Student>();
		File file = new File("Studentenliste.dat");
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(file);

			try {

				br = new BufferedReader(fr);
				String zeile;

				while ((zeile = br.readLine()) != null) {
					try {
						studentenliste.put(
								Integer.parseInt(zeile.split(";")[0]),
								new Student(zeile));
					} catch (NumberFormatException nf) {
						System.err.println("NumberFormat-Fehler!\n"
								+ "Fehlermeldung: " + nf.getMessage());
					}
				}
				
				br.close();
				fr.close();

			} catch (IOException io) {
				System.err.println("IO-Fehler!\n" + "Fehlermeldung: "
						+ io.getMessage());
			}

		} catch (FileNotFoundException fnf) {
			System.err.println("FileNotFound-Fehler!\n" + "Fehlermeldung: "
					+ fnf.getMessage());
		}
		return studentenliste;
	}

	public static boolean sichereStudenten(TreeMap<Integer, Student> studentenliste) {
		File file = new File("Studentenliste.dat");
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(file);

			bw = new BufferedWriter(fw);

			for (Student student : studentenliste.values()) {
				bw.write(student.toString());
				bw.newLine();
			}

			bw.close();
			fw.close();

			return true;
		} catch (IOException io) {
			System.err.println("IO-Fehler!\n" + "Fehlermeldung: "
					+ io.getMessage());
			return false;
		}

	}
	
	

}
