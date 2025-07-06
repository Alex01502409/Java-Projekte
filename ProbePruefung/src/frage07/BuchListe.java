package frage07;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class BuchListe {
	private TreeMap<String, String> buecher;
		
	public BuchListe(){
		buecher = new TreeMap<>();
	}
	
	public void addBuch(String isbn, String name) {
		if(buecher.containsKey(isbn))
			System.out.println("Buch bereit exiestiert: " + isbn);
		else {
			buecher.put(isbn, name);
			System.out.println("das Buch ist hinzugehuegt: ISBN( " + isbn + " ) und name( " + name + " )" );
		}
	}
	
	public void sucheBuch(String isbn) {
		if(buecher.containsKey(isbn))
			System.out.println("Buch ist gefunden mit ISBN: " + isbn + ": " + buecher.get(isbn));
		else
			System.out.println("Buch ist nicht gefunden :(");
	}
	
	public void alleBucheAnzeigen() {
		Iterator<Entry<String, String>> iterator = buecher.entrySet().iterator();
		
		System.out.println("Hier sind alle buecher: ");
		while(iterator.hasNext()) {
			Entry<String, String> eintrag = iterator.next();
			System.out.println(eintrag.getValue() + " , ISBN:" + eintrag.getKey());
		}
		
	}
	public static void main(String[] args) {
		BuchListe bl = new BuchListe();
		bl.addBuch("978-3-16-148410-0", "Java Programmieren");
		bl.addBuch("978-0-13-110362-7", "C Programming Language");
		bl.addBuch("978-3-16-148410-0", "Doppelte ISBN");
		
		bl.sucheBuch("978-3-16-148410-0");
		
		bl.alleBucheAnzeigen();
	}
	
}
