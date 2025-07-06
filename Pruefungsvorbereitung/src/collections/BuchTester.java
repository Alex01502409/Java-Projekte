package collections;

public class BuchTester {

	
		    public static void main(String[] args) {
		        BuchListe liste = new BuchListe();

		        liste.buchHinzufuegen("978-3-16-148410-0", "Java Programmieren");
		        liste.buchHinzufuegen("978-0-13-110362-7", "C Programming Language");
		        liste.buchHinzufuegen("978-3-16-148410-0", "Doppelte ISBN");

		        liste.buchSuchen("978-3-16-148410-0");
		        liste.buchSuchen("123-4-56-789012-3");

		        liste.alleBuecherAnzeigen();
		    }
		
	
}
