package Praktikum_jdbc_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySimpleTranaction {

	// Instanzvariablen
	private Connection con = null;
	private Statement stmt = null;
	// Datenbank-URL
	private String url = "jdbc:oracle:thin:@aix1.fh-bielefeld.de:1521:d2";

	/**
	 * Aufgabenstellung:
	 * 
	 * Ergänzen Sie den Konstruktor so, dass die als Parameter übergebenen
	 * SQL-Anweisungen nacheinander ausgeführt werden. Nach dem Anlegen des
	 * neuen Kunden ist der Buchungsdatensatz anzulegen. Nach erfolgreicher
	 * Ausführung der beiden SQL-Anweisungen ist eine Erfolgsmedung auf der
	 * Konsole auszugeben. Stellen Sie sicher, das das Autocommit deaktiviert
	 * ist, bevor die SQL-Anweisungen ausgeführt werden.
	 * 
	 * Sollte es bei der Ausführung einer SQL-Anweisung zu einer Fehlermeldung
	 * kommen, müssen alle Daten, die im Rahmen dieser Transaktion in die
	 * Datenbank geschrieben wurden, wieder aus der Datenbank entfernt werden.
	 * Nutzen Sie dazu die global deklarierten Instanzvariablen und
	 * initialisieren Sie diese entsprechend.
	 * 
	 * Fangen Sie mögliche Fehler einer SQLException ab und sorgen Sie in jedem
	 * Fall dafür, dass unabhängig von der erfolgreichen Ausführung der
	 * Anweisungen alle belegten Ressourcen wieder freigegeben werden. Stellen
	 * Sie sicher, dass das Autocommit abschließend wieder aktiviert wird.
	 * 
	 * @param user
	 * @param password
	 * @param newKunde
	 * @param newAusleihe
	 */
	public MySimpleTranaction(String user, String password, String newKunde, String newAusleihe) {

		
	}

	public static void main(String[] args) {
		// Nutzerdaten Datenbankuser
		String user = "dvi693";
		String password = "fh1880"; 

		// SQL-Anweisungen
		String newKunde = "insert into ku values(6,'Mustermann','Im Weiher 2','14556','Musterhausen')";
		String newAusleihe = "insert into bg values(32,6,'18.06.2018',7)";

		// String failAusleihe ="insert into bg values(88,6,'18.06.2018',7)";

		new MySimpleTranaction(user, password, newKunde, newAusleihe);
		// new MySimpleTranaction(user,password,newKunde,failAusleihe);
	}

}
