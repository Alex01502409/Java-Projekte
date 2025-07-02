package ea;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class InputStreamTest {

	public static void main(String[] args) {
//		System.out.println(liesText());
		String txt = "Hallo my friend";
		schreibeText(txt); 
		
	}
	
	private static String liesText() {
	        String erg = null;
	        InputStream inputStream = null;

	        try {
	            inputStream = Files.newInputStream(Paths.get("data/ea/TextFile.txt"), StandardOpenOption.READ);
	            erg = "";
	            int x = inputStream.read();// lies das naechste Byte aus
	            //read gibt -1 am Ende der Datei zurueck
	            while (x != -1) {
	                erg += (char)x;
	                x = inputStream.read();
	            }
	        } catch (IOException ioex) {
	            ioex.printStackTrace();
	        }finally {
	            if (inputStream != null){
	                try {
	                    inputStream.close();
	                }catch (IOException ioex){
	                    ioex.printStackTrace();
	                }
	            }
	        }
	        return erg;
	    }
	
	private static void schreibeText(String text) {
	        try(OutputStream out = new FileOutputStream("data/ea/TextFile2.txt")) {
	        char[] zeichen = text.toCharArray();

	        for (int n = 0; n < zeichen.length; n++)
	            out.write(zeichen[n]);
	        } catch (IOException ioException) {
	            ioException.printStackTrace();
	        }
	    }
}
