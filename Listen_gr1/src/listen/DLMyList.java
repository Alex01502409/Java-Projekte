package listen;

import java.util.NoSuchElementException;

public class DLMyList <E> {
	// add(2x), remove(3x), toString(for), size
	
	private DLListenElement<E> entry; // Startpunkt fuer die Datenhaltung
	private int size; // Anzahl der Elemente in der Liste
	
	public DLMyList() { // leere Ringliste anlegen
		
		// entry = new DLListenElement<E>(null, entry, entry);
		/* Hinweis: data == null -> Fehlermeldung
		entry ist erst eine Zeile spaeter Einsatzfaehig */
		
		entry = new DLListenElement<E>();
		entry.setNext(entry);
		entry.setPrev(entry);
		// Vorgaengrer und Nachfolger von entry ist entry selbst
		size = 0;
	}
	
	private void add(E data, DLListenElement<E> currentElement) {
		// TODO: Tafelbild 2 (add)
		
		/* Teilschritt 1:
		   	Neues Element anlegen un mit Vorgenger und Nachfolger Verbinden */
		
		DLListenElement<E> newElement = new DLListenElement<E>(data, currentElement.getPrev(), currentElement);
		/* Teilschritt 2:
		   	Vorgenger und Nachfolger mit dem neuem Element verbienden */
		newElement.getPrev().setNext(newElement);
		newElement.getNext().setPrev(newElement);
		size++;
	}
	
	public void addStart(E data) {
		add(data, entry.getNext());
	}
	
	public void addEnde(E data) {
		add(data, entry);
	}
	
	private E remove(DLListenElement<E> currentElement) throws NoSuchElementException {
		if(currentElement == entry) { // hier wirklich auf den Speicher bezogen
			throw new NoSuchElementException(":(");
		}
			
		E data = currentElement.getData();
		
		// Teilschritt 1: Ueberschreiben
		currentElement.getPrev().setNext(currentElement.getNext());
		currentElement.getNext().setPrev(currentElement.getPrev());
		
		// Teilschritt 2: Loeschen
		currentElement.setNext(null);
		currentElement.setPrev(null);
		currentElement.setData(null);
		
		size--;
		return data;
	}

	public E removeStart() {
		return remove(entry.getNext());
	}
	
	public E removeEnde() {
		return remove(entry.getPrev());
	}
	
	public String toString() {
		String erg = "[";
		
		for(DLListenElement<E> currentElement = entry.getNext();
				currentElement != entry; 
				currentElement = currentElement.getNext() ) {
			erg += currentElement.getData() == this ? "Liste selbst" : currentElement.getData().toString();
			
			if(currentElement.getNext() != entry)
				erg += ", ";
		}
		erg += "]";
		return erg;
	}
	
	public String size() {
		return "size: " + size;
	}
	
}
