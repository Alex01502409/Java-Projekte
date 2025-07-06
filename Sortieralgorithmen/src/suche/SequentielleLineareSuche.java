package suche;

public class SequentielleLineareSuche {

	public static void main(String[] args) {
		int[] array = {9, 7, 8, 5, 4, 6, 2, 1, 3};
		int index = lineareSuche(array, 4); 
		if(index != -1) 
			System.out.println("Element found at index: " + index);
		else 
			System.out.println("Element not found");
	}

	private static int lineareSuche(int[] array, int value) {
		for(int i = 0; i < array.length; i++)
			if(array[i] == value) return i;
		return -1;
	}
}
