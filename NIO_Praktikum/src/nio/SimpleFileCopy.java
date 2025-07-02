package nio;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class SimpleFileCopy {

	public static void main(String[] args) throws IOException, URISyntaxException {
		copyFile("data/testFile.txt","data/KOPIEtestFile.txt");
		
		String dir = "data/Kopien";
		Files.createDirectory(Paths.get(dir));
		moveFile("data/KOPIEtestFile.txt", dir + "/" + "KOPIEtestFile.txt");
		
		copyURL("https://www.staff.hs-mittweida.de/~altrogge/Beispiel_NIO.txt", dir + "/" + "Beispiel_NIO.txt");
	}
	
	public static void copyFile(String source, String target) throws IOException {
		Path quelle = Paths.get(source);
		Path ziel = Paths.get(target);
		
		Files.copy(quelle, ziel, StandardCopyOption.REPLACE_EXISTING);
	}
	
	public static void moveFile(String source, String target) throws IOException {
		Path quelle = Paths.get(source);
		Path ziel = Paths.get(target);
		
		Files.move(quelle, ziel, StandardCopyOption.REPLACE_EXISTING);
	}
	
	public static void copyURL(String source, String target) throws IOException, URISyntaxException {
		URI uri = new URI(source);
		InputStream is = uri.toURL().openStream();
		Path ziel = Paths.get(target);
		
		Files.copy(is, ziel, StandardCopyOption.REPLACE_EXISTING);
		
		if(is != null)
			is.close();

		// Optional
		if(Files.exists(ziel))
			System.out.println("Die URL "+ source + " wurde in das Verzeichnis " + ziel.getParent() + " unter dem Namen " + ziel.getFileName() +" kopiert!");
	}
	
}
