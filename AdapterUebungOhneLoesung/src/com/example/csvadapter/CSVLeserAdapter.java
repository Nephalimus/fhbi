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
		Vector<Person> personen = new Vector<Person>();
		Vector<String []> importPersonen = importCSV.lesePersonenDatei(file);
		
		for (String[] stringPerson : importPersonen){
			personen.add(new Person(stringPerson[0],stringPerson[1]));
		}

		//hier von Vektor String auf Vektor Person umwandeln
		//return new Vector<Person>();
		return personen;
	}
}
