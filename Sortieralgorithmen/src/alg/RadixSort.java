package alg;

import java.util.Arrays;

public class RadixSort {
	
	public static void main(String[] args) {
		int[] array = {190, 55, 95, 91, 903, 24, 2, 77};
		
		radixSort(array);

		for(int i : array)
			System.out.print(i + " ");
		
	}

//	Funktion zur Bestimmung des Maximums in einem Array
	private static int getMax(int[] array, int l) {
		int mx = array[0];
		for(int i = 1; i < l; i++) {
			if(array[i] > mx) 
				mx = array[i];
		}
		return mx;
	}
	
//	Eine Funktion, die eine Zählung von array[] entsprechend der der durch "exp" dargestellten Ziffer
	private static void countSort(int[] array , int exp) {
		
		int[] output = new int[array.length]; // output array
		int i;
		int[] count = new int[10];
		Arrays.fill(count, 0);
		
		for(i = 0; i < array.length; i++) // Zählung der Vorkommnisse in count[] speichern
			count[(array[i] / exp) % 10]++;
		
		for(i = 1; i < 10; i++) // Ändere count[i] so, dass count[i] nun die aktuelle Position dieser Zahl in output[] enthält
			count[i] += count[i - 1];
		
		for(i = array.length - 1; i >= 0; i--) { // Aufbau des Ausgabe-Arrays
			output[count[(array[i] / exp) % 10] - 1] = array[i];
			count[(array[i] / exp) % 10]--;
		}
		
		for(i = 0; i < array.length; i++) // Kopiere das Ausgabe-Array nach array[], so dass array[] nun nach der aktuellen Ziffer sortierte Zahlen enthält
			array[i] = output[i];
	}
	
//	Die Hauptfunktion, die array[] der Größe "n" mit Radix Sort sortiert
	private static void radixSort(int[] array) {
		int m = getMax(array, array.length); // Finde die maximale Anzahl an Zahlen, um die Anzahl der Zahlen zu kennen
		
		/**
		 * Führt für jede Zahl eine Zählsortierung durch. Beachte, dass anstelle der Zahl der Ziffern exp übergeben wird. 
		 * exp ist 10^i, wobei i die aktuelle Stellenzahl ist
		 */
		for(int exp = 1; m / exp > 0; exp *= 10)
			countSort(array, exp);
	}
}