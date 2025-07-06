package graph;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class UnserGraph {
	private ArrayList<Set<Integer>> liste;
	private int anzahlKnoten;

	public UnserGraph(int anzahlKnoten) {
		this.anzahlKnoten = anzahlKnoten;
		liste = new ArrayList<Set<Integer>>();
		
		for (int n = 0; n < anzahlKnoten; n++)
			liste.add(new TreeSet<Integer>());
	}
	
	public void addKante(int start , int ziel) {
		if (start >= 1 && ziel >= 1 && start < anzahlKnoten && ziel < anzahlKnoten) {
			// start und ziel Knoten sind in der Liste vorhanden
			liste.get(start).add(ziel);
			liste.get(ziel).add(start); // entfaellt bei einen gerichteten Graphen
		}
	}

	public int getKnotenAnzahl() {
		return anzahlKnoten;
	}
	
	public Set<Integer> getNachbarn(int knoten){
		return liste.get(knoten);
	}
}