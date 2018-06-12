package Praktikum_jdbc_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySimpleFirstDML {

	// Instanzvariablen
	private Connection con = null;
	private Statement stmt = null;
	// Datenbank-URL
	private String url = "jdbc:oracle:thin:@aix1.fh-bielefeld.de:1521:d2";

	/**
	 * Aufgabenstellung:
	 * 
	 * Ergänzen Sie den Konstruktor so, dass die als Parameter übergebene
	 * SQL-Anweisung ausgeführt werden kann. Das Ergebnis der SQL-Anweisung ist
	 * in einer lokal deklarierten Variablen vom Datentyp int zu speichern.
	 * Nutzen Sie dazu die global deklarierten Instanzvariablen und
	 * initialisieren Sie diese entsprechend.
	 * 
	 * Geben Sie nach der Ausführung der SQL-Anweisung aus, wie viele Datesätze
	 * eingefügt wurden. Ausgabe sollte wie folgt gestaltet sein:
	 * 
	 * Anzahl bearbeiteter Datensätze: 1
	 * 
	 * Fangen Sie mögliche Fehler einer SQLException ab und sorgen Sie in jedem
	 * Fall dafür, dass unabhängig von der erfolgreichen Ausführung der
	 * Anweisungen alle belegten Ressourcen wieder freigegeben werden.
	 * 
	 * @param user
	 * @param password
	 * @param dml
	 */
	
	private ResultSet rs = null;
	
	public MySimpleFirstDML(String user, String password, String dml) throws SQLException {
		try {
			con = DriverManager.getConnection(url, user,password);
			stmt = con.createStatement();
			rs = stmt.executeQuery(dml);
			Integer rows = stmt.getMaxRows();  

			System.out.println("Anzahl bearbeiteter Datensätze: " + rows);
			
		} catch (SQLException e) {
			
			System.out.println("Fehler: " + e.getMessage());
			
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(stmt != null)
					stmt.close();
				if(con!= null)
					con.close();
			} catch (SQLException e) {
				System.out.println("Datenbankverbindung konnte nicht beendet werde. Genereller Fehler! " + e.getMessage());
			}
			
		}
	}

	public static void main(String[] args) throws SQLException {
		// Nutzerdaten Datenbankuser
		String user = "dvi693";
		String password = "fh1880";

		// SQL-Anweisungen
		String dml = "insert into ku values(6,'Mustermann','Im Weiher 2','14556','Musterhausen')";
		String delete = "delete from ku where kunr = 6";

		// Konstruktoraufruf
		
		for(int i=1; i<3; i++){
			if(i==1){
				System.out.println("Einfügen");
				new MySimpleFirstDML(user,password,dml);
			}else{
				System.out.println("Löschen");
				new MySimpleFirstDML(user, password, delete);
			}
		}
	}

}
