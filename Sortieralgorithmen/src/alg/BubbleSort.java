package alg;

public class BubbleSort {
	
	public static void main(String[] args) {
		
		// Ein numerisches Array erstellen und die Daten durch ein Leerzeichen getrennt ausgeben
		int[] array = {9, 1, 8, 0, 2, 7, 3, 6, 4, 5};
		
		// Anzeige unseres Arrays auf dem Bildschirm
		System.out.print("Erstens, ein unsortiertes Array: { ");
		for(int i : array) {
			System.out.print(i + " ");
		}
		System.out.print("}\n");
		
		// Sortieren nach Bubble-Methode 
		bubbleSort(array);
		
		// Anzeige unseres Arrays auf dem Bildschirm
		System.out.print("Und jetzt das sortierte Array: { ");
		for(int i : array) {
			System.out.print(i + " ");
		}
		System.out.print("}\n");
		
	}

	private static void bubbleSort(int[] array) {
		
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if(array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
}
