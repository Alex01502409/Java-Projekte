package rafPack;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Hauptklasse
 */
public class Main {
	/**
	 * mainMethode
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File("date/DateiTest.txt");
		grundlagenRAF(file);
		
		File file2 = new File("date/File-rw.date");
		readWriteRAF(file2);
	}
	
	private static void readWriteRAF(File file2) {
		RandomAccessFile raf = null;
		try {
			
			raf = new RandomAccessFile(file2, "rw");
			raf.writeChars("Hallo World!");
			raf.seek(0);
			
			System.out.println(raf.readLine());
			
		} catch (IOException ioex) {
			ioex.printStackTrace();
		} finally {
			if (raf != null) {
				try {
					raf.close();
				} catch (IOException ioex) {
					ioex.printStackTrace();
				}
			}	
		} 
 		
		
	}

	/**
	 * Die Datei, die wir lesen, enthält bereits ein int und ein utf
	 * @param file
	 */
	private static void grundlagenRAF(File file) {
		
		RandomAccessFile dateiNurLesen = null;
		try {
			
			dateiNurLesen = new RandomAccessFile(file, "r");
			
			dateiNurLesen.seek(0);
			
			System.out.println(dateiNurLesen.readInt());
			System.out.println(dateiNurLesen.readUTF());
			
			
		} catch (IOException ioex) {
			ioex.printStackTrace();
		} finally {	
			if (dateiNurLesen != null) {
				try {
					dateiNurLesen.close();
				} catch (IOException ioex) {
					ioex.printStackTrace();
				}
			}
		}
		
	}
	

}
