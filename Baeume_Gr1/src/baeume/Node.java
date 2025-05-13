package baeume;

public class Node <E extends Comparable<E>> {
	/* Achtung bei der umsetzung eines binaeren Suchbaums -> unterstuetzung von Ordnungen 
	   muss vorhanden sein bspw. mittels Comparable */
	private E data; // zur Speicherung der Daten
	private Node<E> leftTree; // linker Teibaum
	private Node<E> rightTree; // rechter Teibaum
	
	public Node(E data) {
		this.data = data;
		leftTree = null;
		rightTree = null;
		// nur ein Blatt
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public Node<E> getLeftTree() {
		return leftTree;
	}

	public void setLeftTree(Node<E> leftTree) {
		this.leftTree = leftTree;
	}

	public Node<E> getRightTree() {
		return rightTree;
	}

	public void setRightTree(Node<E> rightTree) {
		this.rightTree = rightTree;
	}
	
}
