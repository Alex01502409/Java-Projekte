package suche;

public class StringIndexOf {

	public static void main(String[] args) {
		String text = "Hallo meine liebe Studierende";
		String muster = "Stu";
		System.out.println(indexOfSuche(text, muster));
	}
	
	public static int indexOfSuche(String text, String muster) {
		    return text.indexOf(muster);
		}
	
}
