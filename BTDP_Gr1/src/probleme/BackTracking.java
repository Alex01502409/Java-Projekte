package probleme;
//Rucksackproblem

import java.util.ArrayList;

public class BackTracking {
	
	private int anzahl; // Anzahl der Elemente die gepackt werden koennen
	private ArrayList<Integer> gewichte; // Einzelgewichte der Gegenstaende
	private ArrayList<Integer> preise; // Einzelpreise der Gegenstaende
	
	public BackTracking(int anzahl, int maxgewicht, ArrayList<Integer> gewichte, ArrayList<Integer> preise) {
		this.anzahl = anzahl;
		this.gewichte = gewichte;
		this.preise = preise;
		
		int erg = berechne(maxgewicht, 0);
		System.out.println(erg);
	}

	private int berechne(int aktuellesGewicht, int m) {
		if(m < anzahl) { // es sind noch Gegenstaende da
			// Berechne den Wert ohne den aktuellen Gegenstand
			int ohne = berechne(aktuellesGewicht, m + 1);
			
			// Berechne den Wert mit den aktuellen Gegenstand, falls noch Platz dafuer ist
			int mit = 0;
			if(aktuellesGewicht - gewichte.get(m) >= 0)
				mit = preise.get(m) + berechne(aktuellesGewicht - gewichte.get(m), m + 1);
			
			return Math.max(ohne, mit);
		}
		return 0; // kein Gegenstand -> Preis = 0
	}
}
