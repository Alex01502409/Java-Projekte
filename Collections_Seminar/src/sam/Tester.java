package sam;

public class Tester {

	public static void main(String[] args) {

		AnwendungSetMap asm = new AnwendungSetMap();
		System.out.println(asm);

		asm.einfuegen("Anton", "Anton-1@mustermail.com");
		System.out.println(asm);

		asm.einfuegen("Misha", "misha@mustermail.com");
		System.out.println(asm);

		asm.einfuegen("Anton", "a.Anton-2@mustermail.com");
		asm.einfuegen("Anton", "a.Anton-3-test@mustermail.com");
		System.out.println(asm);
	}

}