package graph;

import java.util.Iterator;

public class Tiefensuche {
	
	private int[] edgeTo; // von welchen Knoten aus wurde ein anderere Knoten erreicht
	private boolean[] marked; // Feld fuer besuchte Knoten
	
	public Tiefensuche(UnserGraph ug, int startKnoten) {
		edgeTo = new int[ug.getKnotenAnzahl()];
		marked = new boolean[ug.getKnotenAnzahl()];
		
		suche(ug, startKnoten);
	}

	private void suche(UnserGraph ug, int aktuellenKnoten) {
		marked[aktuellenKnoten] = true; // aktueller Knoten wird besucht
		
		for(int knotenNachbar : ug.getNachbarn(aktuellenKnoten)) { // lade jeden nachbarknoten des aktuellen Knoten und bearbeite den Knoten falls moeglich
			if (!marked[knotenNachbar]) { // falls Nachbarknoten noch nicht besucht -> dann diesen nutzen
				edgeTo[knotenNachbar] = aktuellenKnoten; // der nachbarknoten wurde ueber den aktuellen Knoten erreicht
				suche(ug, knotenNachbar);
			}
		}
		
	}
	
	public void gibWegAus(int start, int ziel) {
		// einfache Umsetzung: ziel -> start
		String erg = "->" + ziel;
		
		int aktuellerWert = ziel;
		
		while(aktuellerWert != start) {
			// solange start noch nicht erreicht -> mache weiter
			aktuellerWert = edgeTo[aktuellerWert]; // hole den Knoten ueber welchen der aktuelle Knoten erreicht wurde
			
			erg = "->" + aktuellerWert + erg;
		}
		System.out.println(erg);
	}
	
	
	
	
}
