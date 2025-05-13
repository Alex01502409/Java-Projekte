package baeume;

public class MyTree <E extends Comparable<E>> {
	
	private Node<E> root; // der Baum kennt nur die Wurzel

	public MyTree() {
		root = null; // leerer Baum
	}
	
	public MyTree(E data) {
		root = new Node<E>(data); 
		/* erzeugt einen Baum der aus der Wurzel besteht
		der Baum besteht nur aus einen Blatt */
	}
	
	public MyTree(Node<E> root) {
		this.root = root; // zum durchlaufen des Baumes
	}
	
	public void insert(E data) {
		if(root == null) { // noch kein Baum vorhanden -> nur leerer Baum -> Daten sind die neue Wurzel
			root = new Node<E>(data);
		}else { // in der Wurzel steht etwas
			if (data.equals(root.getData())) {
				System.out.println("keine doppelten Werte");
			}else { // Daten sindnicht die Wurzel
				// Daten muessen entweder in den linken Teilbaum oder rechten Teilbaum
				if (data.compareTo(root.getData()) < 0) { // linker Teilbaum
					MyTree<E> leftTree = new MyTree<E>(root.getLeftTree());
					leftTree.insert(data);
					root.setLeftTree(leftTree.root);
				}
				if (data.compareTo(root.getData()) > 0) { // rechter Teilbaum
					MyTree<E> rightTree = new MyTree<E>(root.getRightTree());
					rightTree.insert(data);
					root.setRightTree(rightTree.root);
				}
				
			}
		}
	}
	
	public String preOrder() {
		if (root == null) {
			return "";
		}else {
			MyTree<E> left = new MyTree<E>(root.getLeftTree());
			MyTree<E> right = new MyTree<E>(root.getRightTree());
			return root.getData().toString() + " " + left.preOrder() + " " + right.preOrder(); 
		}
	}
	
}
