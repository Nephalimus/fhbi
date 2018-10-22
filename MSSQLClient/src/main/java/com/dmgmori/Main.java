package com.dmgmori;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

import com.lexicalscope.jewel.cli.ArgumentValidationException;
import com.lexicalscope.jewel.cli.CliFactory;

public class Main {
	private static final String MSSQL_PROPERTIES = "mssql.properties";
	private static final String NOTES_PROPERTIES = "notes.properties";
	
	private String mssqlHost;
	private String mssqlPort;
	private String mssqlUser;
	private String mssqlPassword;
	private String mssqlDatabase;
	private String mssqlTable;
	private String mssqlColumns;
	private String mssqlDatatypes;
	
	private String notesHost;
	private String notesPort;
	private String notesUser;
	private String notesPassword;
	private String notesDatabase;
	private String notesView;
	private String notesColumns;
	private String notesColumnDataTypes;
	
	private SQLDatabaseConnection mssql;
	private NotesDatabase notes;
	
	public static int numberOfRecords;
	public static FileHandler fh;
	
	private static Options options;
	
	public static void main(String[] args) {
		try {
            options = CliFactory.parseArgumentsUsingInstance(new Options(), args);

		} catch (ArgumentValidationException  e) {
	   		System.out.println(e.getMessage());
	     	System.exit(0);
        }
		
		if (options.getRecords() == 0) {
			numberOfRecords = Integer.MAX_VALUE;			
		} else {
			numberOfRecords = options.getRecords();	
		}
				
		Main main = new Main();
		main.createFileHandler();
		main.loadProperties();
		main.getMssqlConnection();
		main.clearMssqlDb();
		main.getNotesConnection();
	}
	
	public static Options getOptions() {
		return options;
	}
	
	public void closeMssqlConnection() {
		try {
			
			mssql.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void createFileHandler() {
		try {
			fh = new FileHandler("log.log");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		
		SimpleFormatter formatter = new SimpleFormatter();  
		fh.setFormatter(formatter);  
	}
	
	public void getMssqlConnection() {
		mssql = new SQLDatabaseConnection(getMssqlHost(), getMssqlPort(), getMssqlUser(),
				getMssqlPassword(), getMssqlDatabase(), getMssqlTable(), getMssqlColumns());
		mssql.establishConnection();
	}
	
	public void getNotesConnection() {
		notes = new NotesDatabase(getNotesHost(), getNotesPort(), getNotesUser(),
				getNotesPassword(), getNotesDatabase(), getNotesView(), getNotesColumns(), mssql); 
        new Thread(notes).start(); 
	}
	
	public void clearMssqlDb() {
		String query = "DELETE FROM " + mssqlTable;
		
		mssql.sqlQuery(query);
	}

	public void loadProperties() {
		Properties properties = new Properties();

		try {
			BufferedInputStream stream = new BufferedInputStream(new FileInputStream("src/main/config/" + MSSQL_PROPERTIES));
			properties.load(stream);
			
			mssqlHost = properties.getProperty("host");
			mssqlPort = properties.getProperty("port");
			mssqlUser = properties.getProperty("user");
			mssqlPassword = properties.getProperty("password");
			mssqlDatabase = properties.getProperty("database");
			mssqlTable = properties.getProperty("table");
			mssqlColumns = properties.getProperty("columns");
//			mssqlDatatypes = properties.getProperty("datatypes");
			
			stream = new BufferedInputStream(new FileInputStream("src/main/config/" + NOTES_PROPERTIES));
			properties.load(stream);
			
			notesHost = properties.getProperty("host");
			notesPort = properties.getProperty("port");
			notesUser = properties.getProperty("user");
			notesPassword = properties.getProperty("password");
			notesDatabase = properties.getProperty("database");
			notesView = properties.getProperty("view");
			notesColumns = properties.getProperty("columns");
			notesColumnDataTypes = properties.getProperty("columnDataTypes");
			
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getNotesColumnDataTypes() {
		return notesColumnDataTypes;
	}

	public void setNotesColumnDataTypes(String notesColumnDataTypes) {
		this.notesColumnDataTypes = notesColumnDataTypes;
	}

	public void setMssqlDatatypes(String mssqlDatatypes) {
		this.mssqlDatatypes = mssqlDatatypes;
	}
	
	public String getMssqlDatatypes() {
		return mssqlDatatypes;
	}
	
	public String getMssqlHost() {
		return mssqlHost;
	}

	public void setMssqlHost(String mssqlHost) {
		this.mssqlHost = mssqlHost;
	}

	public String getMssqlPort() {
		return mssqlPort;
	}

	public void setMssqlPort(String mssqlPort) {
		this.mssqlPort = mssqlPort;
	}

	public String getMssqlUser() {
		return mssqlUser;
	}

	public void setMssqlUser(String mssqlUser) {
		this.mssqlUser = mssqlUser;
	}

	public String getMssqlPassword() {
		return mssqlPassword;
	}

	public void setMssqlPassword(String mssqlPassword) {
		this.mssqlPassword = mssqlPassword;
	}

	public String getMssqlDatabase() {
		return mssqlDatabase;
	}

	public void setMssqlDatabase(String mssqlDatabase) {
		this.mssqlDatabase = mssqlDatabase;
	}

	public String getMssqlTable() {
		return mssqlTable;
	}

	public void setMssqlTable(String mssqlTable) {
		this.mssqlTable = mssqlTable;
	}

	public String getMssqlColumns() {
		return mssqlColumns;
	}

	public void setMssqlColumns(String mssqlColumns) {
		this.mssqlColumns = mssqlColumns;
	}

	public String getNotesHost() {
		return notesHost;
	}

	public void setNotesHost(String notesHost) {
		this.notesHost = notesHost;
	}

	public String getNotesPort() {
		return notesPort;
	}

	public void setNotesPort(String notesPort) {
		this.notesPort = notesPort;
	}

	public String getNotesUser() {
		return notesUser;
	}

	public void setNotesUser(String notesUser) {
		this.notesUser = notesUser;
	}

	public String getNotesPassword() {
		return notesPassword;
	}

	public void setNotesPassword(String notesPassword) {
		this.notesPassword = notesPassword;
	}

	public String getNotesDatabase() {
		return notesDatabase;
	}

	public void setNotesDatabase(String notesDatabase) {
		this.notesDatabase = notesDatabase;
	}

	public String getNotesView() {
		return notesView;
	}

	public void setNotesView(String notesView) {
		this.notesView = notesView;
	}

	public String getNotesColumns() {
		return notesColumns;
	}

	public void setNotesColumns(String notesColumns) {
		this.notesColumns = notesColumns;
	}

	public static String getMssqlProperties() {
		return MSSQL_PROPERTIES;
	}

	public static String getNotesProperties() {
		return NOTES_PROPERTIES;
	}
}

//public void createMssqlTable() {
//	String[] columnList = mssqlColumns.split(",");
//	String[] datatypeList = mssqlDatatypes.split(",");
//	
//	StringBuilder sb = new StringBuilder();
//	sb.append("CREATE TABLE " + mssqlTable + " (");
//			
//	for (int i = 0; i < columnList.length; i++) {
//		sb.append(columnList[i]).append(" ").append(datatypeList[i]).append(", ");
//	}
//	sb.deleteCharAt(sb.lastIndexOf(",") + 1);
//	sb.deleteCharAt(sb.lastIndexOf(","));
//	sb.append(")");
//	
//	System.out.println(sb.toString());
//	mssql.sqlQuery(sb.toString());
//}

//public void insertIntoMssqlTable() {
//	String[] columnList = mssqlColumns.split(",");
//	String[] datatypeList = mssqlDatatypes.split(",");
//	String[] dummyData = {"test1", "2", "test3", "test146"};
//	
//	StringBuilder sb = new StringBuilder();
//	sb.append("INSERT INTO " + mssqlTable + " (");
//			
//	for (int i = 0; i < columnList.length; i++) {
//		sb.append(columnList[i]).append(", ");
//	}
//	sb.deleteCharAt(sb.lastIndexOf(",") + 1);
//	sb.deleteCharAt(sb.lastIndexOf(","));
//	sb.append(")");
//	sb.append(" VALUES (");
//	
//	for (int i = 0; i < columnList.length; i++) {
//		sb.append("?").append(", ");
//	}
//	sb.deleteCharAt(sb.lastIndexOf(",") + 1);
//	sb.deleteCharAt(sb.lastIndexOf(","));
//	sb.append(")");
//	System.out.println(sb.toString());
//	mssql.insertInto(sb.toString(), datatypeList, dummyData);
//}