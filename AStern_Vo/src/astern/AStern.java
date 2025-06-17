package astern;

import java.util.Arrays;

public class AStern {

	private int[][] graph; // Graph als Adjazenzmatrix
	private int[] distanz;
	private double[] prioritaeten;
	private double[][] heuristik;
	private boolean[] besucht;
	
	public AStern(int[][] graph, double[][] heuristik) {
		this.graph = graph;
		this.heuristik = heuristik;
		distanz = new int[graph.length];
		prioritaeten = new double[graph.length];
		besucht = new boolean[graph.length];
		
		// distanz / prioritaeten mit hohen Wert setzen, da BasisInit vom Array 0 ist
		Arrays.fill(distanz, Integer.MAX_VALUE);
		Arrays.fill(prioritaeten, Integer.MAX_VALUE);
	}

	public double berechneWeg(int start, int ziel) {
		distanz[start] = 0; // distanz vom Start ist 0
		prioritaeten[start] = heuristik[start][ziel];
		
		while(true) { // solange noch Knoten zum besuchen da sind -> mach weiter
			double niedrigstePrio = Integer.MAX_VALUE;
			int niedrigsteIndex = -1;
			
			for(int m = 0; m < prioritaeten.length; m++) {
				if(prioritaeten[m] < niedrigstePrio && !besucht[m]) {
					niedrigstePrio = prioritaeten[m];
					niedrigsteIndex = m;
				}
			}
		
			if(niedrigsteIndex == -1) // keine Knoten gefunden, bspw. keine Verbindung
				return -1;
			
			if(niedrigsteIndex == ziel) { // Ziel gefunden
				System.out.println("Ziel gefunden");
				return distanz[niedrigsteIndex];
			}
			
			for(int m = 0; m < graph[niedrigsteIndex].length; m++) {
				if(graph[niedrigsteIndex][m] != 0 && !besucht[m]) { // alle noch nicht besuchten Knoten pruefen
					if(distanz[niedrigsteIndex] + graph[niedrigsteIndex][m] < distanz[m]) { // nur der optimale Weg wird genommen
						distanz[m] = distanz[niedrigsteIndex] + graph[niedrigsteIndex][m];
						prioritaeten[m] = distanz[m] + heuristik[m][ziel];
					}
				}
			}
			besucht[niedrigsteIndex] = true;
		}
	}
}
