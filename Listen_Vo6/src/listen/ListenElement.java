package listen;

public class ListenElement <E extends Comparable<E>> {
	/* der gen. Datentyp E wird eigenschraenkt auf Datentypen 
	 die das Interface Comparable implementieren */
	
	// 1. Schritt: die Klasse ListenElement implementieren
	// - Hinweise auf dem Nachfolger
	// - Hinweise auf die Daten
	
	private ListenElement<E> next = null; // Nachfolger (Verweis)
	private E data = null; // Daten
	
	public ListenElement(ListenElement<E> next, E data) {
		// Werte für Nachfolger und Daten
		this.next = next;
		this.data = data;
	}

	public ListenElement<E> getNext() {
		return next;
	}
	
	public E getData() {
		return data;
	}
}