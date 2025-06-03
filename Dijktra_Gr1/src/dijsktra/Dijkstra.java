package dijsktra;

import java.util.ArrayList;
import java.util.Collections;

public class Dijkstra {
	
	private Node startpunkt;
	private Node zielpunkt;
	
	private ArrayList<Node> zubearbeitenListe; // Loste von Knoten sortiert nach der Entfernung
	
	public Dijkstra(Node startpunkt, Node zielpunkt) {
		this.startpunkt = startpunkt;
		this.zielpunkt = zielpunkt;
		
		zubearbeitenListe = new ArrayList<Node>();
		
		sucheWeg();
	}
	
	private void sucheWeg() {
		zubearbeitenListe.add(startpunkt);
		
		while(!zubearbeitenListe.isEmpty()) 
			berechneNaechstenKnoten(zubearbeitenListe.get(0)); // da die Liste sortiert ist, ist der aktuelle Weg am Index 0
	}

	private void berechneNaechstenKnoten(Node aktuellerKnoten) {
		zubearbeitenListe.remove(aktuellerKnoten);
		aktuellerKnoten.setBesucht(true);
		
		if(!aktuellerKnoten.equals(zielpunkt)) { // solange Ziel nicht arreicht -> mache weiter
			ArrayList<Node> nachbarKnotenReihenfolge = new ArrayList<Node>();
			nachbarKnotenReihenfolge.addAll(aktuellerKnoten.getNachbarn());
			nachbarKnotenReihenfolge.remove(aktuellerKnoten.getVorgaenger());
			Collections.sort(nachbarKnotenReihenfolge);
			
			for(Node aktuellerNachbar : nachbarKnotenReihenfolge) {
				double distanz = aktuellerKnoten.berechneDistanz(aktuellerNachbar);
				
				if(aktuellerNachbar.berechneEntfernung() > aktuellerKnoten.berechneEntfernung() + distanz || aktuellerNachbar.berechneEntfernung() == -1)
					aktuellerNachbar.setVorgaenger(aktuellerKnoten);
				
				if(!zubearbeitenListe.contains(aktuellerNachbar) && !aktuellerNachbar.isBesucht())
					zubearbeitenListe.add(aktuellerNachbar);
				
				Collections.sort(zubearbeitenListe);
			}
		}
	}

	public ArrayList<Node> getReihenfolge() { // von Ziel zum Start
		ArrayList<Node> erg = new ArrayList<Node>();
		Node k = zielpunkt;
		while(k != null) {
			erg.add(0, k);
			k = k.getVorgaenger();
		}
		return erg;
	}
}
