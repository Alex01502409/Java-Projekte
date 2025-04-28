package ea;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class SeminarRAF {
	
	public static void main(String[] args) {
		//TODO Auto-generated method stub
		File file1 = new File("data/ZufallIF.date");
		
		grundlagenRAF();

		int anzahl = 18;
		
		schreibenZufallszahl(anzahl, file1);
		
		int n = 10;
		
		double ergebnis = lieszufallszahl(n, file1);
		
		System.out.println(ergebnis);
		
	}
	
	private static double lieszufallszahl(int n, File file1) {
		
		double erg = -1; // Rueckgabe bei Fehler
		RandomAccessFile raf = null;
		
		try {	
			raf = new RandomAccessFile(file1, "r");
			// bei nur lesen -> r
			
			if( n * 8 + 8 <= raf.length() ) {
				// 8 -> double, n ist 0 startend, +8 -> sind ie naechsten 8 Byte da
				raf.seek(n * 8);
				erg = raf.readDouble();			
			}
		}catch(IOException ioex) {
			ioex.printStackTrace();
		}finally {
			if(raf != null) {
				try {
					raf.close();
				}catch (IOException ioex) {
					// TODO: handle exception
					ioex.printStackTrace();
				}
			}
		}
		return erg;
	}
	
	private static void schreibenZufallszahl(int anzahl, File file1) {
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(file1, "rw");
			 for (int n = 0; n < anzahl; n++) {
				 raf.writeDouble(Math.random());
			 }
		}catch(IOException ioex) {
			ioex.printStackTrace();
		}finally {
			if(raf != null) {
				try {
					raf.close();
				}catch (IOException ioex) {
					// TODO: handle exception
					ioex.printStackTrace();
				}
			}
		}
		
	}
	
	private static void grundlagenRAF() {
		File file2 = new File("data/RAFIF.date");
		RandomAccessFile raf = null;
		try {
			
			raf = new RandomAccessFile(file2, "rw");
			// (Pfad + Dateiname, Modus(r - read, rw - read write))
			
			raf.writeDouble(12345.67890);
			raf.writeUTF("Hallo liebe Studierende.");
			// jede Opeation (lesen, schreiben) setzt den Dateizeiger
			raf.seek(0); // seek aendert den Dateizeiger auf entsprechende Position
			
			System.out.println(raf.readDouble());
			System.out.println(raf.readUTF());
			// Merke bei unterschiedlichen Datentypen auf die Reihenfolgeachten
			 
		}catch(IOException ioex) {
			ioex.printStackTrace();
			// gibt den Fehlerbaum auf der Console aus
		}finally {
			// wird immer ausgefuehrt, auch bei einen Fehler
			if( raf != null ) {
				try {
					raf.close();
				}catch(IOException ioex) {
					ioex.printStackTrace();
				}
			}
			
		}
		
	 
		
	}

}
