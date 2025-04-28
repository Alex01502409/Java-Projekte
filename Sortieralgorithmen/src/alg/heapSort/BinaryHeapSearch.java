package alg.heapSort;

public class BinaryHeapSearch {
	Node root;

	public void insert(Node node) {

		root = insertHelper(root, node);
	}

	private Node insertHelper(Node root, Node node) {

		int date = node.date;

		if (root == null) {
			root = node;
			return root;
		} else if (date < root.date) {
			root.left = insertHelper(root.left, node);
		} else {
			root.right = insertHelper(root.right, node);
		}

		return root;
	}

	public void display() {
		displayHelper(root);
	}

	private void displayHelper(Node root) {
		
		if(root != null) {
			displayHelper(root.left);
			System.out.println(root.date);
			displayHelper(root.right);
		}
			
	}

	public boolean search(int date) {
		return searchHelper(root, date);
	}

	private boolean searchHelper(Node root, int date) {
	
		if (root == null) {
			return false;
		}else if (root.date == date) {
			return true;
		}else if (root.date > date) {
			return searchHelper(root.left, date);
		}else {
			return searchHelper(root.right, date);
		}
		
	}

	public void remove(int date) {
		if (search(date)) {
			removeHelper(root, date);
		}else {
			System.out.println(date + " could not be found");
		}
	}

	public Node removeHelper(Node root, int date) {
		if (root == null) {
			return root;
		}else if (date < root.date) {
			root.left = removeHelper(root.left, date);
		}else if (date > root.date) {
			root.right = removeHelper(root.right, date);
		}else { // node found
			
			if (root.left == null && root.right == null) {
				root = null;
			}else if (root.right != null) { // find a successor to replace this node
				root.date = successor(root);
				root.right = removeHelper(root.right, root.date);
			}else { // find a predecessor to replace this node
				root.date = predecessor(root);
				root.left = removeHelper(root.left, root.date);
			}
		}
		
		return root;
	}

	private int successor(Node root) { // find least value below the right child of this root node
		root = root.right;
		while (root.left != null) {
			root = root.left;
		}
		return root.date;
	}

	private int predecessor(Node root) { // find greatest value below the left child of this root node
		root = root.left;
		while (root.right != null) {
			root = root.right;
		}
		return root.date;
	}

}
