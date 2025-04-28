package alg;

public class InsertionSort {

	public static void main(String[] args) {
		int[] array = {5, 3, 0, 7, 1, 8, 6, 4, 2, 9};
		
		System.out.print("Ein unsortiertes Array: { ");
		for(int i : array)
			System.out.print(i + " ");
		System.out.print("}\n");
		
		insertionSort(array);
		
		System.out.print("Ein sortiertes Array: { ");
		for(int i : array)
			System.out.print(i + " ");
		System.out.print("}");
	}

	private static void insertionSort(int[] array) {
		for(int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j = i - 1;
			
			while(j >= 0 && array[j] > temp) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = temp;
		}
	}
}
