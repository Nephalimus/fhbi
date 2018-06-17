package Arbeiten_mit_JTable;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Datumtest {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
//	    String sDate = "12.08.1974";  
//	    
//	    
	    SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		Date date = df.parse("01.11.2009");
		System.out.println(date);
		
//		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
//		System.out.println(sqlDate);
		
		System.out.println(DateFormat.getDateInstance().format(date));
		
	}

}
