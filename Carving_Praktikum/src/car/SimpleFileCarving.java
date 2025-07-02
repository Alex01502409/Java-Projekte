package car;

import car.utils.HexUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class SimpleFileCarving {

	private int anzahlDateien = 0;
	
	public static void main(String[] args) throws IOException {
		SimpleFileCarving carving = new SimpleFileCarving();
		carving.sucheDateien();
	}
	
	public void sucheDateien() throws IOException {
		RandomAccessFile raf = new RandomAccessFile(new File("img/stick.dd"), "r");
		byte[] image = new byte[(int)raf.length()];
		raf.read(image);
		String inhalt = HexUtils.bytesToHex(image);
		int beginn = inhalt.indexOf("504B0304");
		if(beginn > -1) {
			int ende = inhalt.indexOf("504B0506", beginn);
			String artefakt = inhalt.substring(beginn, ende + 36);
			schreibeDatei("zip", artefakt);
		}
		raf.close();
	}

	public void schreibeDatei(String typ, String artefakt) throws IOException{
		byte[] result = HexUtils.asBytes(artefakt);
		FileOutputStream fos = new FileOutputStream("img/" + anzahlDateien +"." + typ);
		fos.write(result);
		fos.close();
		
		anzahlDateien++;
	}
	
}
