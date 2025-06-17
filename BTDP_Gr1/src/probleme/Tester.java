package probleme;

import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) {
		int anzahl = 10;
		int maxgewicht = 120;
		ArrayList<Integer> gewichte = new ArrayList<Integer>();
		ArrayList<Integer> preis = new ArrayList<Integer>();
		
		gewichte.add(10);
		gewichte.add(11);
		gewichte.add(12);
		gewichte.add(13);
		gewichte.add(14);
		gewichte.add(15);
		gewichte.add(16);
		gewichte.add(17);
		gewichte.add(18);
		gewichte.add(19);
		
		preis.add(18);
		preis.add(20);
		preis.add(17);
		preis.add(19);
		preis.add(25);
		preis.add(21);
		preis.add(27);
		preis.add(23);
		preis.add(25);
		preis.add(24);
		
		new BackTracking(anzahl, maxgewicht, gewichte, preis);
		
		DynamischeProgrammierung dp = new DynamischeProgrammierung(anzahl, maxgewicht, gewichte, preis);
		dp.bestimmeRucksack();
 	}
}
