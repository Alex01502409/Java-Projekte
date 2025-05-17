package pac;

import java.io.IOException;
import java.io.RandomAccessFile;

public class NterIntWertInDatei {
	public static void main(String[] args) {
		if (!(args.length == 2)) {
			   System.out.println("Aufruf: java NterIntWertInDatei <filename> <n>");
			   System.exit(1);
		}
		
		String filename = args[0];
		int n = Integer.parseInt(args[1]);
		
		try(RandomAccessFile raf = new RandomAccessFile(filename, "r")) {
			
			raf.seek(4 * (n - 1)); // 4, da in unserer Datei alle Zahlen mit dem Datentyp Integer
			System.out.println("Die " + n + ". Zahl in \"" + filename + "\" ist " + raf.readInt());
			
		} catch (IOException ioex) {
	            System.out.println("Dateifehler in " + filename + " : " + ioex);
		}
		
	}
}
