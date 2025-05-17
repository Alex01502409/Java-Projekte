/**
 * Diese Klasse zum Speichern von Zeichenketten in RandomAccessFiles
 * liefert Methoden zum Schreiben und Lesen von Strings, die eine 
 * Index-Datei verwenden, um die Positionen der Zeichenketten in 
 * der Datei speichern.
 */

package pac;

import java.io.IOException;
import java.io.RandomAccessFile;

public class StringsSpeichern {

	/**
	     * speichert das uebergebene Zeichenketten-Array in die angegebene Datei. In
	     * einer Index-Datei gleichen Namens (.idx) werden die Startpositionen der
	     * Zeichenketten in der Datei gespeichert.
	     * 
	     * @param dateiname
	     *            Dateiname
	     * @param strarr
	     *            Zeichenketten-Array
	     */
	
	public static void schreibenIn(String dateiname, String[] strarr) {
		RandomAccessFile datenraf = null;
	     RandomAccessFile indexraf = null;
		
		try {
			datenraf = new RandomAccessFile("data/" + dateiname + ".dat", "rw");
	          indexraf = new RandomAccessFile("data/" + dateiname + ".idx", "rw");
			long pos;
			datenraf.setLength(0);
			indexraf.setLength(0);
			
			for (int i = 0; i < strarr.length; i++) {
				pos = datenraf.getFilePointer();
				indexraf.writeLong(pos);
				datenraf.writeUTF(strarr[i]);
			}
			
		} catch (IOException ioex) {
			System.out.println("Fehler : " + ioex.getMessage());
		} finally {
			if (datenraf != null) {
				try {
					datenraf.close();
				} catch (IOException ex) {
					System.out.println("Dateifehler beim Schliessen von " + dateiname + ".dat : " + ex.getMessage());
				}
			}
			if (indexraf != null) {
				try {
					indexraf.close();
				} catch (IOException exc) {
					System.out.println("Dateifehler beim Schliessen von " + dateiname + ".idx : " + exc.getMessage());
				}
			}
		}
	}
	
	/**
	     * liest aus der angegebenen Datei die n. Zeichenkette aus. Deren Position
	     * wird aus der zugehoerigen Index-Datei gelesen.
	     * 
	     * @param dateiname
	     *            der Name der Datei
	     * @param n
	     *            die Nummer der zu lesenden Zeichenkette (0, 1, 2, ...)
	     * @return die Zeichenkette
	     */
	
	public static String liesAus(String dateiname, int n) {
		String s = "";
		RandomAccessFile datenraf = null;
		RandomAccessFile indexraf = null;
		try {
			datenraf = new RandomAccessFile("data/" + dateiname + ".dat", "r");
			indexraf = new RandomAccessFile("data/" + dateiname + ".idx", "r");
			
			long indexpos = n * 8; // 1 long ~ 8 Byte
			indexraf.seek(indexpos); // hier steht der Dateizeiger fuer die Datendatei
			
			long pos = indexraf.readLong();
			datenraf.seek(pos); // hier steht der gewuenschte String
			s = datenraf.readUTF();
			
		} catch (IOException e) {
			System.out.println("Dateifehler : " + e.getMessage());
		} finally {
			if (datenraf != null) {
				try {
					datenraf.close();
				} catch (IOException ex) {
					System.out.println("Dateifehler beim Schliessen von " + dateiname + ".dat : " + ex.getMessage());
				}
			}
			if (indexraf != null) {
				try {
					indexraf.close();
				} catch (IOException exc) {
					System.out.println("Dateifehler beim Schliessen von " + dateiname + ".idx : " + exc.getMessage());
				}
			}
		}
		return s;
	}
	
	public static void main(String[] args) {
		schreibenIn("test", args);
		
		System.out.println("Die Kommandozeilen-Parameter in richtige Reihenfolge:");
		  for (int i = 0; i < args.length; i++) 
			  System.out.println(liesAus("test", i)); 
		
		System.out.println("\nDie Kommandozeilen-Parameter in umgekehrter Reihenfolge:");
		  for (int i = args.length - 1; i >= 0; i--)
	            System.out.println(liesAus("test", i));
		  
		  
			
		
		  
	        
		  
	}
	
}
