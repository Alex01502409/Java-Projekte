package sam;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeSet;

public class Sammlungen {

	public static void main(String[] args) {
//		 benutzungTreeSet();
//		 benutzungHashSet();
//		 benutzungHashMap();

		benutzungHashTable();
	}

	public static void benutzungHashTable() {
		Hashtable<Integer, String> tabelle = new Hashtable<Integer, String>();
		tabelle.put(1, "Informatik");
		tabelle.put(2, "Mathematik");
		tabelle.put(3, "Theo. Inf");

		Iterator<Entry<Integer, String>> iterator = tabelle.entrySet().iterator();

		while (iterator.hasNext()) {
			Entry<Integer, String> eintrag = iterator.next();
			System.out.println(eintrag.getKey() + ": " + eintrag.getValue());
		}
	}

	public static void benutzungHashMap() {
		// Key-Value-Pairs
		// Hash wird ueber den Key bestimmt - Einordnung

		HashMap<String, String> mails = new HashMap<String, String>();
		// <Key, Value>
		mails.put("Alex", "alex@mustermail.com");
		// put(Key, Value)
		mails.put("Max", "max@mustermail.com");
		mails.put("Misha", "misha@mustermail.com");
		mails.put("Knut", "knut@mustermail.com");

		System.out.println(mails.get("Misha"));
		System.out.println("-----------");

		// get(Key) - holt den Wert an Stell des Keys
		// Key - Hash erzeugt - "gesucht" in der Map
		// falls der Key nicht enthalten ist, auch bei Schreibfehlern - null

		Iterator<Entry<String, String>> iterator = mails.entrySet().iterator();

		while (iterator.hasNext()) {
			// NICHT BENUTZEN
			// System.out.println(iterator.next().getKey() + " - " +
			// iterator.next().getValue());
			// MERKE: Elemente mit mehr als einer Information Inhalt erst zwischenspeichern
			// und dann weiter nutzen
			Entry<String, String> eintrag = iterator.next();
			System.out.println(eintrag.getKey() + " - " + eintrag.getValue());
		}
		
		System.out.println("-----------");
		mails.remove("Klaus Dohmen");
		iterator = mails.entrySet().iterator();
		
		while (iterator.hasNext()) {
			Entry<String, String> eintrag = iterator.next();
			System.out.println(eintrag.getKey() + " - " + eintrag.getValue());
		}
	}

	public static void benutzungHashSet() {
		HashSet<Double> zahlen = new HashSet<Double>();
		zahlen.add(5.46);
		zahlen.add(5.45);
		zahlen.add(5.47);
		zahlen.add(5.48);
		zahlen.add(5.49);
		zahlen.add(5.44);// keine doppelten Werte im Set
		zahlen.add(5.44);
		zahlen.add(5.43);
		// die Werte werden mittels eines HashWerts(-funktion) bestimmt - gespeichert
		System.out.println("--------");
		Iterator<Double> iterator = zahlen.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	public static void benutzungTreeSet() {

		TreeSet<Double> zahlen = new TreeSet<Double>();
		zahlen.add(5.46);
		zahlen.add(5.45);
		zahlen.add(5.47);

		Iterator<Double> iterator = zahlen.iterator();

		while (iterator.hasNext()) {
			// hasNext - ist noch ein weiteres Element vorhanden
			System.out.println(iterator.next());
			// next - gibt den Inhalt zurueck und geht auf das naechste Element

		}

		System.out.println("----");
		zahlen.add(5.48);
		zahlen.add(5.49);
		zahlen.add(5.44);// keine doppelten Werte im Set
		zahlen.add(5.44);
		zahlen.add(5.43);

		iterator = zahlen.iterator(); // neu laden, da add aufgerufen
		// Merke: sobald eine Aenderung der Menge erfolgt - Iterator neu laden

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		System.out.println("----");
		zahlen.remove(5.45);
		iterator = zahlen.iterator(); // neu laden, da remove

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		System.out.println("----");
		iterator = zahlen.descendingIterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}

}