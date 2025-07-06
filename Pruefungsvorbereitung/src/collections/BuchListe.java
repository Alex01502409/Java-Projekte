package collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class BuchListe {
    private TreeMap<String, String> buecher;

    public BuchListe() {
        buecher = new TreeMap<>();
    }

    public void buchHinzufuegen(String isbn, String name) {
        if (buecher.containsKey(isbn)) {
            System.out.println("Eintrag bereits vorhanden für ISBN: " + isbn);
        } else {
            buecher.put(isbn, name);
            System.out.println("Buch hinzugefügt: " + name + " (ISBN: " + isbn + ")");
        }
    }

    public void buchSuchen(String isbn) {
        if (buecher.containsKey(isbn)) {
            System.out.println("Buchtitel: " + buecher.get(isbn));
        } else {
            System.out.println("Kein Buch mit ISBN " + isbn + " gefunden.");
        }
    }

    // Methode mit Iterator
    public void alleBuecherAnzeigen() {
        System.out.println("Gespeicherte Bücher (sortiert nach ISBN):");

        Iterator<Map.Entry<String, String>> iterator = buecher.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> eintrag = iterator.next();
            System.out.println("ISBN: " + eintrag.getKey() + " -> " + eintrag.getValue());
        }
    }
}