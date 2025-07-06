package graph;

import java.util.ArrayList;

public class Breitensuche {
	private boolean[] marked;
	private int[] edgeTo;
	
	public Breitensuche(UnserGraph ug, int startknoten){
		marked = new boolean[ug.getKnotenAnzahl()];
		edgeTo = new int[ug.getKnotenAnzahl()];
		suche(ug, startknoten);
	}

	private void suche(UnserGraph ug, int aktuellerKnoten) {
		ArrayList<Integer> warteschlange = new ArrayList<Integer>(); // enthaelt die Liste der "Wege"(Knoten) die noch bearbeitet werden muessen
		marked[aktuellerKnoten] = true;
		warteschlange.add(aktuellerKnoten); // who soll gestartet werden
		while(!warteschlange.isEmpty()) { // solange die Warteschlange nicht leer ist -> mache weiter
			int ersterKnotenInWarteschlange = warteschlange.remove(0); // hole den ersten Knoten aus der Warteschlange
			for(int nachbarKnoten : ug.getNachbarn(ersterKnotenInWarteschlange)) { // hole Alle Nachbarknoten fuer den ersten Knoten in der Warteschlange
				if(!marked[nachbarKnoten]) { // ist der Nachbarknoten noch nicht besucht -> mache weiter
					marked[nachbarKnoten] = true;
					edgeTo[nachbarKnoten] = ersterKnotenInWarteschlange;
					warteschlange.add(nachbarKnoten); // den Machbarknoten in die Warteschlange aufnehmen
				}
			} 
		}
	}
	
	public void gibWegAus(int start, int ende){ // ende -> start;
		String erg = "->" + ende;
		int aktuellerWert = ende;
		while(aktuellerWert != start) {
			aktuellerWert = edgeTo[aktuellerWert];
			erg = "->" + aktuellerWert + erg;
		}
		System.out.println(erg);
	}
}