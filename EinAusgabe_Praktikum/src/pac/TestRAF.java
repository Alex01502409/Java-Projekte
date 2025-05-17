package pac;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TestRAF {
	
	public static void main(String[] args) {
		File file = new File("data/testfile.data");
		zahlenSchreiben(file);
		
	}

	private static void zahlenSchreiben(File file) {

		try(RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
			// Teil: 1
			System.out.println("Datei \"" + file.getName() + "\" wurde geoeffnet");
			raf.setLength(0); // make file empty
			for (int i = 0; i <= 100; i++) { // Quadrate der ganzen Zahlen von 0 bis 100
				raf.writeInt(i * i);
				System.out.println("In die Datei \"" + file.getName() + "\" wurde geschrieben: " + i * i);
			}
			// Teil: 2
			raf.seek(0); // Dateizeiger an den Dateianfang zurück
			 System.out.println("Dateizeiger in \"" + file.getName() + "\" wurde zurueck zum Anfang gesetzt.");
			 
			// Teil: 3
			for (int i = 0; i <= 100; i++) { // geschriebenen Zahlen wieder auslesen
				System.out.print("an Dateiposition " + raf.getFilePointer());
				System.out.println(" beginnt " + raf.readInt());
			}
			 
			 
			
		} catch (IOException ioex) {
			 System.out.println("Dateifehler in " + file.getName() + " : " + ioex);
		}
		
	}

}
