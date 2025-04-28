package ea;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class DemoNIO {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Path quelle = Paths.get("data/TextIF.txt");
		Path ziel = Paths.get("data/KopieTextIF.txt");
		
		Files.copy(quelle, ziel, StandardCopyOption.REPLACE_EXISTING);
		
	}

}
