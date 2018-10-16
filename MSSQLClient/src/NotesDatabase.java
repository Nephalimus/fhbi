import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import lotus.domino.*;

public class NotesDatabase implements Runnable {
	
	private static final Logger log = Logger.getLogger(NotesDatabase.class.getName());
	
    private Database db;
    
	private String host;
	private String port;
	private String user;
	private String password;
	private String database;
	private String viewName;
	private String columns;
	
	private SQLDatabaseConnection mssql;
	
    public NotesDatabase(String host, String port, String user, String password, String database, String viewName, String columns, SQLDatabaseConnection mssql) {  
    	this.host = host;
    	this.port = port;
    	this.user = user;
    	this.password = password;
    	this.database = database;
    	this.viewName = viewName;
    	this.columns = columns;
    	this.mssql = mssql;
    	
        log.addHandler(Main.fh);
        log.setUseParentHandlers(false);
    }    
    
    public boolean init() {
        try {        
        	Session session = NotesFactory.createSession(host + ":" + port, user, password);
  
//        	String plattform = session.getPlatform();
//        	System.out.println("Platform = " + plattform);

        	db = session.getDatabase(host.split("\\.")[0], database);
               
            if (!db.isOpen()) {
                return false;
            } else {
            	return true;
            }
         
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void dbInfo() {
        try {
            System.out.println("..." + db.getFileName() + " geöffnet ...");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
	// Felder gezielt abfragen. Ist Feld vorhanden? hasItem() x
	// Prüfen des Feldtyps x
	// Ggf. Exklusivwörter 
	// Konvertieren auf Zielformat x
	// in DB schreiben x
	// Felder die nicht vorhanden sind werden genullt x
    // multivalues mit semikolon imploden x
    
    // Null Not Null Fehler -> gesamten DS überspringen. Log Datei mit doc.universalId() + Fehlermeldung
    // Konvertierungsfehler => null in Spalte, bei not null Spalte Log Datei und DS überspringen 
    // nullen in log, überspringen in log, konvertierungsfehler in log
    public void readNotesDbAndInsertIntoMssql() {
    	List<String> columnList = Arrays.asList(columns.split(","));
    	String uid = null;

        try {
        	View view = db.getView(viewName);
        	ViewEntryCollection viewEntryCollection = view.getAllEntries();
        	ViewEntry viewEntry = viewEntryCollection.getFirstEntry();

        	int n = Main.numberOfRecords > 0 ? Main.numberOfRecords:Integer.MAX_VALUE;
        	long start = System.currentTimeMillis();
        	
    		while (n > 0 && viewEntry != null) {
  	
				List<String> dataTypes = new ArrayList<>();
				List<Object> data = new ArrayList<>();
				
				Document doc = viewEntry.getDocument();
				uid = doc.getUniversalID();
									
				for (String itemName : columnList) {
		
					if (doc.hasItem(itemName)) {
						Item item = doc.getFirstItem(itemName);

//						System.out.print("itemName=" + item.getName() + " itemType=" + item.getType() + " "); 
						
						switch (item.getType()) {
							case 1:
							case 1075:
							case 1280: if (item.getText().equals("")) {
								  		   dataTypes.add("String");
								  		   data.add("NULL");
									   } else {
										   dataTypes.add("String");
										   // E1 ist 256 Zeichen lang, rest 20 Zeichen. Alle sind zu kurz
										   //20180827 OT auskommentiert
										   //20180827 OT - Stunde sp�ter wieder einkommentiert und auf 1024 Zeichen gesetzt :-)
										   	
										   if (item.getName().equals("FB_cloc") || item.getName().equals("FB_course") || item.getName().equals("code") || item.getName().equals("D_D") || 
											  item.getName().equals("D_F") || item.getName().equals("D_text") || item.getName().equals("D_5") || item.getName().equals("D_D_Z") ||
											  item.getName().equals("D_F_Z") || item.getName().equals("drehen") || item.getName().equals("fraesen") || item.getName().equals("E1")) {
											   
											  String substring = item.getText(); 
											  if(substring.length() > 1024) {
												  substring = substring.substring(0, 1020) + "...";
											  }
											  data.add(substring);
										   } else {
											   data.add(item.getText());							        	   											   
										   }
									   }
		
//									   System.out.println("itemValue= " + item.getText());
									   break;
							
							case 768:  dataTypes.add("int");
									   data.add(item.getValueInteger());
//									   System.out.println("itemValue= " + item.getValueInteger());
									   break;
							
							case 1024: dataTypes.add("Date");
//									   System.out.println("itemValue= " + item.getDateTimeValue());
									   data.add(item.getDateTimeValue());
									   break;
						
							default:   System.out.println("No data type matched.");
						}
						
					} else {
						dataTypes.add("String");
				  		data.add("NULL");
//						log.info("Document Id: " + uid + ". Item " + itemName + " not found. Value set to NULL");
					}
					
				}
				mssql.insertInto(dataTypes, data, uid);
				viewEntry = viewEntryCollection.getNextEntry();
				n--;
			}
    		
    		long end = System.currentTimeMillis();
    		
    		log.info("Elapsed time: " + getElapsedTime(start, end));

        } catch (Exception e) {
        	log.info("Document " + uid + " " +  e.getMessage());
        }
        try {
			mssql.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        Main.fh.close();
    }
    
    private String getElapsedTime(long start, long end) {
    	long totalTime = end - start;
    	
        int millis  = (int) (totalTime) % 1000 ;
        int seconds = (int) (totalTime / 1000) % 60 ;
        int minutes = (int) ((totalTime / (1000*60)) % 60);
        int hours   = (int) ((totalTime / (1000*60*60)) % 24);
        return hours +  " hours " + minutes + " minutes " + seconds + " seconds " + millis + " ms (" + totalTime + " ms)";
    }

    public void run() {
    	if (init()) {
    		dbInfo();
    		readNotesDbAndInsertIntoMssql();	
    	}	
    }
}

//StringBuilder sb = new StringBuilder();
//for (Item item : items) {
//	if (item.getName().equals("FB_TextDate") || item.getName().equals("testreader") || item.getName().equals("Status") || 
//		item.getName().equals("TN_Telefon") || item.getName().equals("TN_Mail") || item.getName().equals("TN_MIS") || 
//		item.getName().equals("TN_Briefanrede") || item.getName().equals("TN_Bemerkung") || item.getName().equals("tmpName") || 
//		item.getName().equals("D_1") || item.getName().equals("D_2") || item.getName().equals("D_tel") || item.getName().equals("D_mail") || 
//		item.getName().equals("FB_Funktion_alt") || item.getName().equals("D_1_1") || item.getName().equals("D2_1") || item.getName().equals("D_33_1") || 
//		item.getName().equals("D_34_1")) {
//		
//		continue;
//	}
//	sb.append(item.getName()).append(",");
//}
//System.out.println(sb.toString());
