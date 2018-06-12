
import java.sql.*;

public class B1_07 {

	public static void main(String[] args) {

		try{
			Connection con = DriverManager.getConnection(
			"jdbc:oracle:thin:@aix1.fh-bielefeld.de:1521:d2","dvi693","fh1880");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select name,str,plz,ort from ku where kunr = 4");
			rs.next();
			System.out.println("Name: "+ rs.getString("name"));
			System.out.println("Anschrift: "+ rs.getString("str") + " "	+ rs.getInt("plz") + " "+ rs.getString("ort"));
			rs.close(); 
			stmt.close();
			con.close();
		} catch(SQLException e) {
			System.out.println("Fehler: "+ e.getMessage());
		}
	}

}
