import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Logger;

import lotus.domino.DateTime;
import lotus.domino.NotesException;

public class SQLDatabaseConnection {  

	private static Logger log = Logger.getLogger(SQLDatabaseConnection.class.getName());
	
	private String host;
	private String port;
	private String user;
	private String password;
	private String database;
	private String mssqlTable;
	
	private String mssqlColumns;
	
	private String driver = "jdbc:sqlserver";

	private Connection con;
	
	public SQLDatabaseConnection(String host, String port, String user, String password, String database, String mssqlTable, String mssqlColumns) {
		this.host = host;
		this.port = port;
		this.user = user;
		this.password = password;
		this.database = database;
		this.mssqlTable = mssqlTable;
		this.mssqlColumns = mssqlColumns;
		
		log.addHandler(Main.fh);
	}
	
	public void establishConnection() {
		String connectionString =  driver + "://" + host + ":" + port + ";"
				+ "database=" + database + ";" 
				+ "user=" + user + ";" 
				+ "password=" + password;  

		try {  
			con = DriverManager.getConnection(connectionString); 
			
			if (con != null) {
				System.out.println("Verbindung zur MSSQL Datenbank erfolgreich!");
			}
		}  catch (Exception e) {  
			e.printStackTrace();  
		} 
	}
	
	public void sqlQuery(String query) {
//		System.out.println(query);

		if (con != null) {
			PreparedStatement preparedStmt = null;
			
			try {
				preparedStmt = con.prepareStatement(query);
				preparedStmt.execute();
			} catch (SQLException e) {
				e.printStackTrace();
				
			} finally {
				
				if (preparedStmt != null) {
					try { 
						preparedStmt.close();

					} catch (Exception e) {
						e.printStackTrace();
					} 
				}
			}

		} else {
			System.out.println("Es besteht keine Verbindung zur Datenbank.");
		}
	}
	
	public void insertInto(List<String> dataTypes, List<Object> data, String uid) {
		String[] columnList = mssqlColumns.split(",");
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO " + mssqlTable + " (");
				
		for (int i = 0; i < columnList.length; i++) {
			sb.append(columnList[i]).append(", ");
		}
		sb.deleteCharAt(sb.lastIndexOf(",") + 1);
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append(")");
		sb.append(" VALUES (");
		
		for (int i = 0; i < columnList.length; i++) {
			sb.append("?").append(", ");
		}
		sb.deleteCharAt(sb.lastIndexOf(",") + 1);
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append(")");
		String query = sb.toString();
//		System.out.println(sb.toString());
		
		if (con != null) {
			PreparedStatement preparedStmt = null;

			try {
				preparedStmt = con.prepareStatement(query);
				
				for (int i = 0; i < columnList.length; i++) {
					
					switch(dataTypes.get(i)) {
					
						case "String": if (data.get(i).equals("NULL")) {
											preparedStmt.setNull(i + 1, Types.NVARCHAR);
									   } else {
										   preparedStmt.setString (i + 1, (String) data.get(i));										   
									   }
									   break;
						
						case "int":	   preparedStmt.setInt (i + 1, (int) data.get(i));
								       break;
						
						case "Date":   //preparedStmt.setTimestamp(i + 1, convertStringToTimestamp(data.get(i).toString()));
										preparedStmt.setTimestamp(i + 1, convertToTimestamp((DateTime) data.get(i)));
									   break;
									
						default: System.out.println("Data type does not match!");
					}
				}
				preparedStmt.execute();
//				System.out.println("insertInto() erfolgreich ausgefuehrt.");
				
			} catch (SQLException e) {
				log.info("Document Id: " + uid + ". " +  e.getMessage() + " Could not write record to MSSQL DB.");

			} finally {

				if (preparedStmt != null) {
					try { 
						preparedStmt.close();
						
					} catch (Exception e) {
						e.printStackTrace();
					} 
				}
			}
			
		} else {
			System.out.println("Es besteht keine Verbindung zur Datenbank.");
		}
	}
	
	public Connection getConnection() {
		return con;
	}
	
	private Timestamp convertStringToTimestamp(String dateString) {	
		SimpleDateFormat format = null;
		if (dateString.length() < 11) {
			format = new SimpleDateFormat("dd.MM.yyyy");
		} else {
			format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");			
		}
	    java.util.Date parsed = null;
		try {
			parsed = format.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

        return new Timestamp(parsed.getTime());
	}
	
	private Timestamp convertToTimestamp(DateTime dateString) {
		java.util.Date date = null;
		try {
			date = dateString.toJavaDate();
		} catch (NotesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return new Timestamp(date.getTime());
	}
	
	public void select() {
		if (con != null) {
			
			Statement statement = null;
			String name = "";
			
			try {
				statement = con.createStatement();
				ResultSet rs;
				String query = "SELECT Name FROM Personen WHERE Wohnort = 'Bielefeld'";
				
				rs = statement.executeQuery(query);
			
				while (rs.next()) {
					name = rs.getString("Name");

				}
				rs.close();
				
				System.out.println("select() erfolgreich ausgefuehrt.");
				System.out.println("Name: " + name);
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			} finally {
				
				if (statement != null) {
					try { 
						statement.close();

					} catch (Exception e) {
						e.printStackTrace();
					} 
				}
			}
			
		} else {
			System.out.println("Es besteht keine Verbindung zur Datenbank.");
		}
	}
	
	public void update() {
		if (con != null) {
			
			PreparedStatement preparedStmt = null;
			int ID = 1;
			
			try {
				String query = "UPDATE Personen SET Vorname = ? WHERE ID =" + ID;

				preparedStmt = con.prepareStatement(query);
				preparedStmt.setString (1, "Holger");
				preparedStmt.execute();
				
				System.out.println("update() erfolgreich ausgefuehrt.");
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			} finally {

				if (preparedStmt != null) {
					try { 
						preparedStmt.close();

					} catch (Exception e) {
						e.printStackTrace();
					} 
				}
			}
			
		} else {
			System.out.println("Es besteht keine Verbindung zur Datenbank.");
		}
	} 
}