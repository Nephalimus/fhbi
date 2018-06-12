package Praktikum_jdbc_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySimpleFirstQuery {

	// Instanzvariablen
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	// Datenbank-URL
	private String url = "jdbc:oracle:thin:@aix1.fh-bielefeld.de:1521:d2";

	/**
	 * Aufgabenstellung:
	 * 
	 * Ergänzen Sie den Konstruktor so, dass die als Parameter übergebene
	 * SQL-Query ausgeführt werden kann. Das Ergebnis der SQL-Query ist im
	 * ResultSet zu speichern. Nutzen Sie dazu die global deklarierten
	 * Instanzvariablen und initialisieren Sie diese entsprechend.
	 * 
	 * Geben Sie nach der Ausführung der SQL-Query den Inhalt der einzelnen
	 * Datensätze auf der Konsole aus. Ausgabe sollte wie folgt gestaltet sein:
	 * 
	 * Meier Querweg 6 33100 Bremen 
	 * Karl AG Ostring 5 44300 Kassel 
	 * Schulz Am Hof 9 10310 Berlin 
	 * Hog GmbH Leoplatz 1 10310 Berlin 
	 * Kunze Kudamm 2 10340 Berlin
	 * 
	 * Fangen Sie mögliche Fehler einer SQLException ab und sorgen Sie in jedem
	 * Fall dafür, dass unabhängig von der erfolgreichen Ausführung der
	 * Anweisungen alle belegten Ressourcen wieder freigegeben werden.
	 * 
	 * @param user
	 * @param password
	 * @param query
	 * @throws SQLException 
	 */
	public MySimpleFirstQuery(String user, String password, String query) throws SQLException {
			try {
				con = DriverManager.getConnection(url, user,password);
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);
				rs.next();
				
				do	{
					System.out.println(rs.getString("name")+" "+rs.getString("str")+" "+rs.getString("plz")+" "+rs.getString("ort"));
					} while(rs.next());
				
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

		// SQL-Query
		String query = "select name, str, plz, ort from ku";

		// Aufruf Konstruktor
		new MySimpleFirstQuery(user, password, query);

	}
}
