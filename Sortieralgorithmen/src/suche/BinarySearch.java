package suche;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		int[] array = new int[100];
		int target = 42; // zum Beispiel
		
		for (int i = 0; i < array.length; i++) // Füllen des Arrays mit Daten 
			array[i] = i;
		
//		int index = Arrays.binarySearch(array, target);
		int index = binarySearch(array, target); // Eigene Version dieser Methode
		
		if (index == -1) 
			System.out.println(target + " not found");
		else
			System.out.println("Element found at: " + index);
	}

	// Eigene Version dieser Methode
	private static int binarySearch(int[] array, int target) {
		int low = 0;
		int high = array.length - 1;
		int steps = 0;
		
		while(low <= high) {
			int middle = low + (high - low) / 2;
			int value = array[middle];
			steps++;
			System.out.println("middle: " + value);
			
			if(value < target) 
				low = middle + 1;
			else if(value > target)
				high = middle - 1;
			else {
				System.out.println("Steps taken to calculate: " + steps);
				return middle; // target found
				}
			
		}
		
		return -1; // target not found
	}

}
