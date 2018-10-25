package com.example.csvadapter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 * 
 * CSVLeser zum Einlesen von Personendaten
 *
 */

public class CSVLeser {

	public Vector<String []> lesePersonenDatei (String file)
	{
		Vector<String []> personen = new Vector<String[]>();
		
		try
		{
			BufferedReader input = new BufferedReader (new FileReader (file));
			String strLine;
			while ((strLine = input.readLine()) != null)
			{
				String[] splitted = strLine.split(",");
				if (splitted.length>= 2)
					personen.add(new String [] {splitted[0],splitted[1]});				
			}
			input.close();
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		return personen;
	}
	
}
