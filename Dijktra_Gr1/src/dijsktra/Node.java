package dijsktra;

import java.util.ArrayList;

public class Node implements Comparable<Node> { // Comparable fuer die Sortierung
	private String name;
	private ArrayList<Node> nachbarn;
	private Node vorgaenger;
	private boolean startpunkt;
	private boolean besucht; // "hab ich schon besucht?"
	private double x;
	private double y;
	
	public Node(String name, double x, double y, boolean startpunkt) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.startpunkt = startpunkt;
		nachbarn = new ArrayList<Node>();
	}
	
	public void addNachbar(Node nachbar) { // gegenseitige Nachbarschaft
		if(!nachbarn.contains(nachbar)) 
			nachbarn.add(nachbar); // Knoten hinzufuegen, falls noch nicht vorhanden
		
		if(!nachbar.nachbarn.contains(this)) 
			nachbar.addNachbar(this);
	}
	
	public double berechneDistanz(Node aktuellerNachbar) { 
		// 71,5 -> Abstand von zwei Laendenkreisen in Mitteleuropa
		// 111,3 -> Abstand von zwei breitenkreisen in Mitteleuropa
		double dx = (x - aktuellerNachbar.x) * 71.5;
		double dy = (y - aktuellerNachbar.y) * 111.3;
		return Math.sqrt(dx * dx + dy * dy); // Pythagoras
	}
	
	public double berechneEntfernung() {
		double entfernung = 0;
		
		if(vorgaenger != null) { // es existiert eine moegliche Verbindung
			entfernung += vorgaenger.berechneDistanz(this);
			double entfernungVorgaenger = vorgaenger.berechneEntfernung();
			
			if (entfernungVorgaenger != -1) {
				entfernung += entfernungVorgaenger;
			}else {
				entfernung = entfernungVorgaenger;
			}
		}else if(!startpunkt) {
			entfernung = -1;
		}else {
			entfernung = 0; // Startpunkt
		}
		return entfernung;
	}
	
	public int compareTo(Node k) {
		double diff = this.berechneEntfernung() - k.berechneEntfernung();
		
		if(diff > 0) {
			return 1;
		}else if(diff < 0){
			return -1;
		}else {
			return 0;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Node> getNachbarn() {
		return nachbarn;
	}

	public void setNachbarn(ArrayList<Node> nachbarn) {
		this.nachbarn = nachbarn;
	}

	public Node getVorgaenger() {
		return vorgaenger;
	}

	public void setVorgaenger(Node vorgaenger) {
		this.vorgaenger = vorgaenger;
	}

	public boolean isStartpunkt() {
		return startpunkt;
	}

	public void setStartpunkt(boolean startpunkt) {
		this.startpunkt = startpunkt;
	}

	public boolean isBesucht() {
		return besucht;
	}

	public void setBesucht(boolean besucht) {
		this.besucht = besucht;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	
	
}
