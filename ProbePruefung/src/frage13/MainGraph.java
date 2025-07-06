package frage13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MainGraph {
	private ArrayList<Kante> nachbarschaften;
	
	public MainGraph() {
		nachbarschaften = new ArrayList<Kante>();
	}
	
	public void addKante(int start, int ziel) {
		nachbarschaften.add(new Kante(start, ziel));
	}
	
	public int getAnzahlKante() {
		return nachbarschaften.size();
	}
	
	public ArrayList<Kante> getNachbarschaften() {
		return nachbarschaften;
	}
	
	public void speicherNachbarschaften() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/frage13/Graph01.csv"))){
			oos.writeObject(nachbarschaften);
			System.out.println("ist gespeichert!");
		}catch (IOException ioex) {
			ioex.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void ladeNachbarschaften() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/frage13/Graph01.csv"))){
			nachbarschaften = (ArrayList<Kante>) ois.readObject();
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void gibListeAus() {
		try(PrintWriter writer = new PrintWriter(new FileWriter("data/frage13/Graph01.csv"))){
			for(Kante k : nachbarschaften)
				writer.println(k.getVon() + " -> " + k.getNach());
				//System.out.println(k.getVon() + " -> " + k.getNach());
		}catch (IOException ioex) {
			ioex.printStackTrace();
		}
	}
}
