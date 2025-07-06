package suche;

import java.util.HashMap;

public class BMSuche {

	public static void main(String[] args) {
		String text = "Hallo meine liebe Studierende";
		String muster = "Stu";
		System.out.println(bmSuche(text, muster));
	}
	
	public static int bmSuche(String text, String muster) {
	    int n = text.length();
	    int m = muster.length();

	    if (m == 0) return 0;

	    HashMap<Character, Integer> last = new HashMap<>();
	    for (int i = 0; i < m; i++)
	        last.put(muster.charAt(i), i);
	    
	    int s = 0; // зсув у тексті
	    while (s <= n - m) {
	        int j = m - 1;

	        // порівнюємо справа наліво
	        while (j >= 0 && muster.charAt(j) == text.charAt(s + j))
	            j--;

	        if (j < 0) return s; // знайдено
	         else {
	            char c = text.charAt(s + j);
	            int l = last.getOrDefault(c, -1);
	            s += Math.max(1, j - l);
	        }
	    }
	    return -1;
	}
}
