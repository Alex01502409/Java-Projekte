package listen;

public class Tester {

	public static void main(String[] args) {
		
		DLMyList<String> meineliste = new DLMyList<String>();
		
		System.out.println(meineliste);
		
		meineliste.addStart("Heute");
		System.out.println(meineliste);
		
		meineliste.addStart("Dienstag");
		System.out.println(meineliste);
		
		meineliste.addEnde("Hallo");
		System.out.println(meineliste);
		
		meineliste.addEnde("April");
		System.out.println(meineliste);
		
		System.out.println(meineliste.size());
		
		System.out.println(meineliste.removeStart());
		System.out.println(meineliste.removeStart());
		System.out.println(meineliste.removeEnde());
		System.out.println(meineliste.removeStart());
		System.out.println(meineliste.size());
		
		System.out.println(meineliste.removeEnde());
		
	}

}
