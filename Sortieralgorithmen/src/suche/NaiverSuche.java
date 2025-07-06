package suche;

public class NaiverSuche {
	
	public static void main(String[] args) {
		String text = "Hallo meine liebe Studierende";
		String muster = "Stu";
		System.out.println(naiveSuche(text, muster));
	}
	
	public static int naiveSuche(String text, String muster) {
		    int n = text.length();
		    int m = muster.length();
		    for (int i = 0; i <= n - m; i++) {
		        int j = 0;
		        while (j < m && text.charAt(i + j) == muster.charAt(j))
		            j++;
		        if (j == m) return i; // знайдено
		    }
		    return -1; // не знайдено
		}
	
}
