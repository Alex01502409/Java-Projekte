package probleme;

import java.util.ArrayList;

public class DynamischeProgrammierung {

	private int anzahl;
	private int maxgewicht;
	private ArrayList<Integer> gewichte;
	private ArrayList<Integer> preise;
	
	
	public DynamischeProgrammierung(int anzahl, int maxgewicht, 
			ArrayList<Integer> gewichte, ArrayList<Integer> preise) {
		this.anzahl = anzahl;
		this.maxgewicht = maxgewicht;
		this.gewichte = gewichte;
		this.preise = preise;
	}
	
	public void bestimmeRucksack() {
		int[][] hilfstabelle = new int[anzahl + 1][maxgewicht + 1];
		
		// Tabelle fuellen
		
		for(int m = 0; m < anzahl + 1; m++) {
			for(int k = 0; k < maxgewicht + 1; k++) {
				if(m == 0 || k == 0) {
					hilfstabelle[m][k] = 0;
				}else {
					int f1 = hilfstabelle[m - 1][k];
					int f2 = -1;
					if(k - gewichte.get(m - 1) < 0) {
						f2 = 0;
					}else {
						f2 = hilfstabelle[m - 1][k - gewichte.get(m - 1)] + preise.get(m - 1);
					}
					
					hilfstabelle[m][k] = (f1 > f2) ? f1 : f2;
				}
			}
		}
		
		// Rucksack fuellen
		
		ArrayList<Integer> rucksack = new ArrayList<Integer>();
		int m = anzahl;
		int k = maxgewicht;
		
		while(m > 0 && k > 0) {
			if(hilfstabelle[m][k] > hilfstabelle[m - 1][k]) {
				rucksack.add(m - 1);
				k -= gewichte.get(m - 1);
				m--;
			}else {
				m--;
			}
		}
		
		// Ausgabe:
		
		int maxWert = 0;
		int maxGewichtberechnet = 0;
		
		System.out.println("Rucksack:");
		for(k = 0; k < rucksack.size(); k++) {
			int objID = rucksack.get(k);
			System.out.println(k + ". " + objID + ", " + gewichte.get(objID) + ", " + preise.get(objID));
			
			maxWert += preise.get(objID);
			maxGewichtberechnet += gewichte.get(objID);
		}
		
		System.out.println("Maximaler Wert: " + maxWert);
		System.out.println("maximales Gewicht: " + maxGewichtberechnet);
	}
	
	
}
