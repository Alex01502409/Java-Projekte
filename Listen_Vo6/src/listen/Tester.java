package listen;

import java.util.Iterator;

public class Tester { 

	public static void main(String[] args) {
		MyList<String> meineListe = new MyList<String>();
		meineListe.add("Hallo");
		meineListe.add("Dienstag");
		
		System.out.println(meineListe);
		
		Iterator<String> iterator = meineListe.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println(meineListe.remove()); // Dienstag
		System.out.println(meineListe.remove()); // Hallo
		System.out.println(meineListe.remove()); 
		
		
		
	}
}