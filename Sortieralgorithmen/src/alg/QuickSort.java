package alg;

public class QuickSort {
//	 quick sort = moves smaller elements to left of a pivot. recursively divide array in 2 partitions.
	
//	 run-time complexity = Best case O(n log(n))
//	                       Average case O(n log(n))
//	                       Worst case O(n^2) if already sorted
	
//	 space complexity    = O(log(n)) due to recursion 
	
	public static void main(String[] args) {
		int[] array = {5, 3, 0, 7, 1, 8, 6, 4, 2, 9};
		
		System.out.println("Array vor der Sortierung: " + displayArray(array));
		
		quickSort(array, 0, array.length - 1);
		
		System.out.println("Sortiertes Array: " + displayArray(array));
	}

	private static void quickSort(int[] array, int start, int end) {
		if(end <= start) return;
		
		int pivot = Trennwand(array, start, end);
		quickSort(array, start, pivot - 1);
		quickSort(array, pivot + 1, end);
	}
	
	private static int Trennwand(int[] array, int start, int end) {
		int pivot = array[end];
		int i = start - 1;
		
		for(int j = start; j <= end - 1; j++) {
			if(array[j] < pivot) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		
		i++;
		int temp = array[i];
		array[i] = array[end];
		array[end] = temp;
		
		return i; // Pivot location
	}

	private static String displayArray(int[] array) {
		String display = "{ ";
		
		for(int i : array)	
			display += i + " ";
		display += "}";
		return display;
	}
}
