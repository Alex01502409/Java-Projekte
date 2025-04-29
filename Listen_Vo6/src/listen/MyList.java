package listen;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyList <E extends Comparable<E>> 
	implements Iterable<E> {
	
	// 3. Schritt: Verwaltungsklasse MyList implementieren
	// - iterator, add, remove, toString(Iteration)
	// Hinweis auf das 1. Element
	
	private ListenElement<E> firstElement;
	// die Verwaltungsklasse kennt nut das 1. Element
	
	public MyList() {
		firstElement = null;
		// zum Start ist die Liste leer
	}
	
	public Iterator<E> iterator() {
		return new MyIterator<E>(firstElement);
	}
	
	public void add(E data) {
		// neves Element am Anfang der Liste einfuegen
		
		// Teilschritt 1: Neues ListeneElement anlegen mit data und firstElement
		ListenElement<E> newElement = new ListenElement<E> (firstElement, data);
		
		// Teilschritt 2: neues Listenelement wird neues firstElement
		firstElement = newElement;
	}
	
	public E remove() throws NoSuchElementException {
		if(firstElement != null) {
			throw new NoSuchElementException("keine Elemente mehr");
		}
		
		ListenElement<E> tmp = firstElement;
		firstElement = tmp.getNext();
		return tmp.getData();
	}
	
	public String toString() {
		String erg = "";
		ListenElement<E> currentElement = firstElement;
		// beim Durchlaufen: Start beim firstElement
		
		
		while(currentElement != null) {
			erg = erg + "->" + currentElement.getData();
			// toString ist bei getData geeignet implementiert
			currentElement = currentElement.getNext();
		}
		return erg;
	}
}
