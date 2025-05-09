package datenstrukturen;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TesterBibo {

	public static void main(String[] args) {
		
		Bibo bib = new Bibo("HSB");
		bib.addBuch("Buch A", 49, false);
		bib.addBuch("Buch B", 1200, true);
		bib.addBuch("Buch C", -100, false);
		bib.addBuch("Buch D", 1, false);
		
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting(); // Optional: makes the JSON more readable
		Gson arbeiter = builder.create();
		
		String json = arbeiter.toJson(bib);
		System.out.println(json);
		
		writeToFileRAF(json); // optional #1
		writeToFile2(json); // optional #2
		
		Bibo bib2 = arbeiter.fromJson(json, Bibo.class);
		System.out.println(bib2);

	}

	private static void writeToFile2(String json) {
		try (FileWriter writer = new FileWriter("data/test.json")) {
			
			writer.write(json);
			System.out.println("JSON file successfully saved.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/* FileWriter writer = null;
		try {
		    writer = new FileWriter("data/test.json");
		    writer.write(json);
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    if (writer != null) {
		        try {
		            writer.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		} */
	}

	private static void writeToFileRAF(String json) {
		File file = new File("data/JsonFileFromConsole.json");
		RandomAccessFile raf = null;
		try {
			
			raf = new RandomAccessFile(file, "rw");
			raf.setLength(0);
			raf.seek(0);
			raf.write(json.getBytes("UTF-8"));
			
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
	
	

}
