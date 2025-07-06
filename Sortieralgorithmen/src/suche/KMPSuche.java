package suche;

public class KMPSuche {

	public static void main(String[] args) {
		String text = "Hallo meine liebe Studierende";
		String muster = "Stu";
		System.out.println(kmpSuche(text, muster));
	}
	
	public static int kmpSuche(String text, String muster) {
		    int n = text.length();
		    int m = muster.length();
		    int[] lps = berechneLPS(muster);

		    int i = 0; // індекс у text
		    int j = 0; // індекс у muster

		    while (i < n) {
		        if (text.charAt(i) == muster.charAt(j)) {
		            i++;
		            j++;
		            if (j == m) return i - j; // знайдено
		        } else {
		            if (j != 0) 
		                j = lps[j - 1];
		             else 
		                i++;
		        }
		    }
		    return -1;
		}

		private static int[] berechneLPS(String muster) {
		    int m = muster.length();
		    int[] lps = new int[m];
		    int len = 0;
		    int i = 1;

		    while (i < m) {
		        if (muster.charAt(i) == muster.charAt(len)) {
		            len++;
		            lps[i] = len;
		            i++;
		        } else {
		            if (len != 0) {
		                len = lps[len - 1];
		            } else {
		                lps[i] = 0;
		                i++;
		            }
		        }
		    }
		    return lps;
		}
}
