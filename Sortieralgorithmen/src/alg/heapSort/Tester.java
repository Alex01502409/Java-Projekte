package alg.heapSort;

public class Tester {

	public static void main(String[] args) {

		BinaryHeapSearch tree = new BinaryHeapSearch();
		
		tree.insert(new Node(5));
		tree.insert(new Node(1));
		tree.insert(new Node(9));
		tree.insert(new Node(2));
		tree.insert(new Node(7));
		tree.insert(new Node(3));
		tree.insert(new Node(0));
		tree.insert(new Node(6));
		tree.insert(new Node(4));
		tree.insert(new Node(8));
		
//		tree.remove(10);
		tree.remove(3);
		tree.display();
		
//		System.out.println(tree.search(10));
//		tree.remove(10);
		
	}

}
