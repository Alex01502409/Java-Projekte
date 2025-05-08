package datenstrukturen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class BrowserTester {

	private Connection conn; // Repraesentiert die Verbiendung zur Datenbank
	
	public void connectDB() {
		try {
			
			Class.forName("org.sqlite.JDBC"); // String siehe Anbieter Datenbank
			
			conn = DriverManager.getConnection("jdbc:sqlite:data/places.sqlite"); // String siehe Anbieter Datenbank
			
		} catch (ClassNotFoundException cnfex) {
			cnfex.printStackTrace();
		}catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
	}
	
	public void closeConnection() {
		try {
			
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	public void select() {
		try {
			
			Statement st = conn.createStatement();
			st.setQueryTimeout(30); // zur Absicherung: Abbruch nach spaetestens 30 Sekunden
			
			ResultSet rs = st.executeQuery("SELECT * FROM moz_places");
			 /*SELECT <spalten> FROM <tabellen> 
			      <spalten> -> mit , getrennt oder * fuer alle Spalter
			      <tabellen> -> mit Komma getrennt bei mehreren */
			
			ResultSetMetaData meta = rs.getMetaData(); // z.b. Anzahl der Spalten, Name der Spalte, Datentyp der Spalter, ...
			
			for (int i = 1; i <= meta.getColumnCount(); i++)  // in Datenbanken ist der Startindex 1
				System.out.println(meta.getColumnName(i) + " - " + meta.getColumnTypeName(i));
			
			while(rs.next()) // wir wollen nur die id und die url
				System.out.println(rs.getInt("id") + " : " + rs.getString("url"));
			
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		BrowserTester bt = new BrowserTester();
		bt.connectDB();
		bt.select();
		bt.closeConnection();
	}

}
