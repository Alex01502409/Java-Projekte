package sam;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class AnwendungSetMap {

	private Map<String, Set<String>> emails;// Vorbereitung fuer 1:n

	public AnwendungSetMap() {
		emails = new TreeMap<String, Set<String>>();
	}

	public void einfuegen(String name, String email) {
		if (emails.containsKey(name)) {
			// Name vorhanden - "nur" noch die "neue" E-Mail hinzufuegen
			Set<String> emailliste = emails.get(name);// vorhandene Werte laden
			emailliste.add(email);// "neue" E-Mail hinzufuegen
		} else {
			// Name nicht vorhanden - neuen Kontakt anlegen
			HashSet<String> emailliste = new HashSet<String>();
			emailliste.add(email);// neue E-Mail hinzufuegen
			emails.put(name, emailliste);
		}
	}

	public String toString() {
		String erg = "leer";

		if (emails.size() > 0) {
			erg = "";
			Iterator<Entry<String, Set<String>>> iterator = emails.entrySet().iterator();

			while (iterator.hasNext()) {
				Entry<String, Set<String>> eintrag = iterator.next();
				erg = erg + eintrag.getKey() + ":\n" + eintrag.getValue() + "\n";
			}
		}
		return erg;
	}

}