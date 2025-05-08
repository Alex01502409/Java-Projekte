package datenstrukturen;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TesterBibo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Bibo bib = new Bibo("HSB");
		bib.addBuch("Buch A", 49, false);
		bib.addBuch("Buch B", 1200, true);
		bib.addBuch("Buch C", -100, false);
		bib.addBuch("Buch D", 1, false);
		
		GsonBuilder builder = new GsonBuilder();
		Gson arbeiter = builder.create();
		
		String json = arbeiter.toJson(bib);
		System.out.println(json);
		writeToFile(json); // optional
		
		Bibo bib2 = arbeiter.fromJson(json, Bibo.class);
		System.out.println(bib2);

	}

	private static void writeToFile(String json) {
		File file = new File("data/JsonFileFromConsole.json");
		RandomAccessFile raf = null;
		try {
			
			raf = new RandomAccessFile(file, "rw");
			raf.writeChars(json);
//			raf.writeUTF(json);
			raf.seek(0);
			
		} catch (IOException ioex) {
			ioex.printStackTrace();
		} finally {
			if (raf != null) {
				try {
					raf.close();
				} catch (IOException ioex) {
					ioex.printStackTrace();				}
			}
		}
		
 	}
	
	

}
