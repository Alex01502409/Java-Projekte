package collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CollectionsTest {
	public static void main(String[] args) {
//		arrayListMethode();
//		linodekedListMeth();
//		QueueBeispiel();
//		DequeBeispiel();
//		hashSetBeispiel();
		hashTableBeispiel();
		}
		
	public static void hashTableBeispiel() {
		Hashtable<Integer, String> hashtable = new Hashtable<>(11);
		hashtable.put(100, "Spongebob");
		hashtable.put(123, "Patrick");
		hashtable.put(321, "Sandy");
		hashtable.put(555, "Squidward");
		hashtable.put(777, "Gary");
		
		for(Integer key : hashtable.keySet()) {
			System.out.println(key.hashCode() % 11 + " " + key + " " + hashtable.get(key));
			
		}
		
	}

	

	private static void DequeBeispiel() {
		Deque<String> namen = new ArrayDeque<>();
		namen.add("Misha");
		namen.addFirst("Alex");
		namen.addLast("Knut");
		System.out.println(namen);
		System.out.println(namen.removeLast() + " " + namen.removeLast());
		System.out.println(namen);
	}

	public static void hashSetBeispiel() {
		Set<String> names = new HashSet<>();
		names.add("Maik");
		names.add("Gas");
		names.add("Poll");
		names.add("Stasik");
		
		Iterator<String> namesIterator = names.iterator();
		while (namesIterator.hasNext()) 
			System.out.println(namesIterator.next());
		
		List<Integer> numberList = new ArrayList<>();
		numberList.add(3);
		numberList.add(4);
		numberList.add(1);
		numberList.add(2);
		numberList.add(5);
		numberList.add(5);
		
		Set<Integer> numberSet = new HashSet<>(numberList);
		numberSet.forEach(System.out::println);
//		System.out.println(numberSet);
	}


	public static void QueueBeispiel() {
		Queue<String> warteschlange = new LinkedList<>();
		warteschlange.offer("Kunde 1");
		warteschlange.offer("Kunde 2");
		warteschlange.offer("Kunde 3");
		System.out.println(warteschlange.poll()); // переглядає перший елемент і видаляє його нахуй (полупокер)
		System.out.println(warteschlange);
		System.out.println(warteschlange.peek()); // переглядає перший елемент без видалення
	}
	
	private static void linodekedListMeth() {
		LinkedList<Integer> num = new LinkedList<Integer>();
		num.add(9);
		num.add(7);
		num.add(5);
		num.add(2);
		num.add(8);
		num.add(1);
		num.add(4);
//		num.add(0);
		num.add(3);
		num.add(6);
		Collections.sort(num);
//		num.remove();
		System.out.println(Arrays.asList(num));
		System.out.print("index of 4 is: ");
		System.out.print(Collections.binarySearch(num, 4));
	}

	private static void arrayListMethode() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Tom");
		list.add("Alex");
		list.add("Clara");
		list.add("Bernard");
		list.add("Dom");
		list.add("Abdul");
		Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
		System.out.println(Arrays.asList(list));
	}
	
	
}
