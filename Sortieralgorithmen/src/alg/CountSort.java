package alg;

public class CountSort {
	
	public static void main(String[] args) {
		int[] inputArray = { 5, 3, 0, 7, 1, 8, 6, 4, 2, 9, 0, 8, 0, 4, 2, 0, 2, 5, 1, 0, 3, 7};
		int[] outputArray = countSort(inputArray);
		
		for (int i = 0; i < inputArray.length; i++) {
			System.out.print(outputArray[i] + " ");
		}
	}
	
	public static int[] countSort(int[] inputArray) {
		int l = inputArray.length;
		int x = 0;

		for (int i = 0; i < l; i++) {
			x = Math.max(x, inputArray[i]);
		}

		int[] countArray = new int[x + 1];

		for (int i = 0; i < l; i++) {
			countArray[inputArray[i]]++;
		}

		for (int i = 1; i <= x; i++) {
			countArray[i] += countArray[i - 1];
		}

		int[] outputArray = new int[l];

		for (int i = l - 1; i >= 0; i--) {
			outputArray[countArray[inputArray[i]] - 1] = inputArray[i];
			countArray[inputArray[i]]--;
		}

		return outputArray;
	}
}
