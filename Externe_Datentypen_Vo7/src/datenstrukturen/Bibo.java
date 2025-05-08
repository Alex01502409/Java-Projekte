package datenstrukturen;

import java.util.ArrayList;

public class Bibo {
	
	private String name;
	
	private ArrayList<Buch> buecher;
	
	public Bibo(String name) {
		this.name = name;
		buecher = new ArrayList<Buch>();
	}
	
	public void addBuch(String name, int seitenanzahl, boolean status) {
		buecher.add(new Buch(name, seitenanzahl, status));
	}
	
	public String toString() {
		String erg = "Name der Bibliothek: " + name + "\n";
		erg = erg + "Buecher:\n";
		for (Buch buch : buecher) {
			erg += "\t" + buch.getName() + ", "  + buch.getSeitenanzahl() + "\n";
		}
		return erg;
	}

}
