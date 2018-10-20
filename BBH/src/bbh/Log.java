package bbh;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import lotus.domino.*;

public class Log {
	private boolean do_log_hinweise = false;
	private boolean do_log_fehler = false;
	private boolean do_log_debug = false;
	private boolean can_log = false;
	
	private String log_datei = "";
	
	private Database db;
	
	
	public Log() {
		try {
			
			
			Session session = NotesFactory.createSession();
			db = session.getCurrentDatabase();
			
			View viewK = db.getView("viewKonfiguration");
			Document docKonfig = viewK.getDocumentByKey("formKonfiguration",true);
			if(docKonfig != null) {
				if(docKonfig.hasItem("konfig_loghinweise")) {
					if(docKonfig.getItemValueString("konfig_loghinweise").equals("1") || docKonfig.getItemValueString("konfig_loghinweise").equals("Ja")) {
						do_log_hinweise = true;
						can_log = true;
					}
				}
				if(docKonfig.hasItem("konfig_logdebug")) {
					if(docKonfig.getItemValueString("konfig_logdebug").equals("1") || docKonfig.getItemValueString("konfig_logdebug").equals("Ja")) {
						do_log_debug = true;
						can_log = true;
					}
				}
				if(docKonfig.hasItem("konfig_logfehler")) {
					if(docKonfig.getItemValueString("konfig_logfehler").equals("1") || docKonfig.getItemValueString("konfig_logfehler").equals("Ja")) {
						do_log_fehler = true;
						can_log = true;
					}
				}
				if(docKonfig.hasItem("konfig_logdatei")) {
					log_datei = docKonfig.getItemValueString("konfig_logdatei");
					File f = new File(log_datei);
					if(!f.exists()) {
						f.mkdir();
					}
					DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
					Date date = new Date();
					log_datei = log_datei + "\\UBK_" + dateFormat.format(date) + ".log";
				}
			} else {
				System.out.println("--> do_log(JAVA) - Keine Konfiguration gefunden!");
			}
			
		} catch (NotesException e) {
			e.printStackTrace();
			
		}
	}
	
	public void do_log(int art,int fehlernummer,String callName,String errMsg,Thread currentThread) {
		String fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
	    String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
	    String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
	    int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
		do_log(art,fehlernummer,lineNumber,callName+" "+className + "." + methodName + "():" + lineNumber + " "+errMsg);
	}
	
	
	public void do_log(int art,int fehlernummer,int fehlerzeile,String s) {
		try {
			if(can_log) {
				if ((art == 0 && do_log_hinweise == true) || (art == 1 && do_log_fehler == true) || (art == 2 && do_log_debug == true)) {
					//============================ START DB LOG ================================
					DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
					Date date = new Date();
					String strDate = dateFormat.format(date);
					String strWrite = "";
					if(art==1) {
						strWrite += strDate + ": Err: " + fehlernummer + ", Erl: " + fehlerzeile + ": " + s;
					} else {
						strWrite += strDate + " " + s;
					}
					
					//OT 17.08.2018 neue Systematik - erst Einzeldokumente und dann im 5 Minuten Agent in großes Log überführen,
					//damit keine Log-Einträge mehr verloren gehen - gleichzeitiges Speichern durch unterschiedliche Funktionen
					/*dateFormat = new SimpleDateFormat("dd.MM.yyyy");	
					strDate = dateFormat.format(date);
					View viewLog = db.getView("(lookupLogDatum)");
					Document docLog = viewLog.getDocumentByKey(strDate,true);
					
					if(docLog != null) {
						RichTextItem rItem = (RichTextItem) docLog.getFirstItem("Log");
						rItem.addNewLine(1);
						rItem.appendText(strWrite);
					} else {*/
						Document docLog = db.createDocument();
						//docLog.replaceItemValue("Form", "formLog");
						docLog.replaceItemValue("Form", "formLogTemp");
						//RichTextItem rItem = docLog.createRichTextItem("Log");
						//rItem.appendText(strWrite);
						docLog.replaceItemValue("Log", strWrite);
					//}
					docLog.computeWithForm(true,true);
					docLog.save(true, true);
					
					//============================= ENDE DB LOG ================================
					
					//=========================== START DATEI LOG ==============================
					
					
					
					if(!log_datei.equals("")) {
						BufferedWriter bw = null;
						 
					    try {
					         // APPEND MODE SET HERE
					    	bw = new BufferedWriter(new FileWriter(log_datei, true));
					        bw.write(strWrite);
					        bw.newLine();
					        bw.flush();
					    } catch (IOException ioe) {
					    	ioe.printStackTrace();
					    } finally {                       // always close the file
					    	if (bw != null) try {
					    		bw.close();
					    	} catch (IOException ioe2) {
					    	}	
					    } // end try/catch/finally
					 
					   
						  
					}
					//=========================== ENDE DATEI LOG ===============================
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}