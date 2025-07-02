package nio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class HexDumpTool {

	public static String dump(String filename) throws IOException {
		final int breite = 16;
		String dump = "";
		String hexline = "";
		String txtline = "";
		Path pfad = Paths.get(filename);
		InputStream in = Files.newInputStream(pfad, StandardOpenOption.READ);
		int b = in.read();
		int i = 1;
		
		while (b != -1) {
			if (b <= 15) 
				hexline += 0;
			hexline += Integer.toHexString(b);
			
			if(b >= 32 && b < 127) 
				txtline += (char)b;
			else
				txtline += '.';
			
			if(i == breite) {
				dump += hexline + "\t" + txtline + "\n";
				i = 0;
				hexline = "";
				txtline = "";
			}
			b = in.read();
			i++;
		}
		in.close();
		
		if(i < breite) {
			for(int k = i; k <= breite; k++) {
				hexline += "00";
				txtline += ".";
			}
			dump += hexline + "\t" + txtline + "\n";
		}
		return dump;
	}
	
	public static void main(String[] args) {
		
		try {
			System.out.println(dump(args[0]));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
}
