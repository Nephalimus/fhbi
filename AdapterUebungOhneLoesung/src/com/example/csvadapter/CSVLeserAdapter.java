package com.example.csvadapter;
import java.util.Vector;


public class CSVLeserAdapter implements IPersonenLeser {
	private String file;
	CSVLeser importCSV = new CSVLeser();
	
		
	public CSVLeserAdapter(String file)
	{
		this.file = file;
	}
	
	@Override
	public Vector<Person> lesePersonen() {
		importCSV.lesePersonenDatei(file);
		
		Vector<Person> personen = new Vector<Person>();
		//hier von Vektor String auf Vektor Person umwandeln
		return new Vector<Person>();
		
	}

}
