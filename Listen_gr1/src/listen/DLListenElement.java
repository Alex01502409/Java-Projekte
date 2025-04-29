package listen;

public class DLListenElement <E> {
	// DL - Doppelte Liste
	// Hinweise: Daten, Vorgaenger, Nachfolger
	
	private E data; // Speicherobjeckt fuer die Daten
	private DLListenElement<E> next; // Nachfoger
	private DLListenElement<E> prev; // Vorgaenger
	
	public DLListenElement() { // fuer die Initialisierung der Liste
		data = null;
		prev = null;
		next = null;
	}

	public DLListenElement(E data, DLListenElement<E> prev, DLListenElement<E> next) throws IllegalArgumentException {
		if (data == null) {
			throw new IllegalArgumentException("keine daten");
			// darf nur verwendet werden, 
		}
		
		this.data = data;
		this.next = next;
		this.prev = prev;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public DLListenElement<E> getNext() {
		return next;
	}

	public void setNext(DLListenElement<E> next) {
		this.next = next;
	}

	public DLListenElement<E> getPrev() {
		return prev;
	}

	public void setPrev(DLListenElement<E> prev) {
		this.prev = prev;
	}
	
}
