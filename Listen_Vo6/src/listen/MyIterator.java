package listen;

import java.util.Iterator;

public class MyIterator <E extends Comparable<E>> 
	implements Iterator<E> {
	
	// 2. Schritt: die Klasse MyIterator implementieren
	// - Hinweise: “Wo in der Liste befinde ich mich gerade?”
	
	private ListenElement<E> currentElement; // aktuelles Element (Wo bin ich in der Liste?)
	
	public MyIterator(ListenElement<E> firstElement) {
		currentElement = firstElement;
		// beim Start ist das erste Element such gleichzeitig das aktuelle Element	
	}
	
	public boolean hasNext() {
		return currentElement != null;
		// das naechte Element ist nicht leer
		// falls leer -> Ende(false)
	}
	
	public E next() {
		// 2 Aufgaben:
		// - hole die Daten und gib diese zurueck
		// - gehe auf das naechste Element
		
		E tmp = currentElement.getData(); // hole die Daten
		currentElement = currentElement.getNext(); // gehe auf das narchste Element
		return tmp; // gib die Daten zurueck
	}
	
	public void remove() { // Methode ist optional, kann implementieren werden, muss aber nicht
		throw new UnsupportedOperationException("haben wit leider nicht implementiert :(");	
	}
	
}
