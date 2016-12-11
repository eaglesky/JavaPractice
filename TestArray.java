import java.util.*;

public class TestArray {

	private static int[] returnArray(int a, int b, int c) {
		// Using {a, b, c} only won't work!
		return new int[]{a, b, c};
	}

	// Using Enhanced For-Loops
	private static void printArray(int[] array) {
		System.out.print("Array content: ");
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}

	public static void main (String[] args) {
		int a1 = 3;
		int a2 = 5;
		int a3 = 7;
		int[] arr = {a1, a2, a3};

		System.out.println("Array length = " + arr.length);		
		printArray(arr);
		
		int[] arr2 = returnArray(2, 4, 6);
		printArray(arr2);

		System.out.println("Second element = " + arr[1]);

		int[] arr3 = new int[4];
		printArray(arr3);

		List<Integer> convertedList = Arrays.asList(4, 5, 6);
		System.out.println("Converted List = " + convertedList);
		Integer[] arr4 = {7, 8, 9}; //not int[]!
		convertedList = Arrays.asList(arr4);
		System.out.println("Converted List = " + convertedList);
		//If the content of arr4 changes, so does that of the convertedList,
		//because Arrays.asList returns a wrapper of original array, not a copy.
		arr4[0] = -1;
		System.out.println("Converted List = " + convertedList);

		//Test 2d Array:
		int[][] nums = new int[][]{
			{},
			{1},
			{1, 3, 5, 7},
			{9, 8, 3, 11, -55},
			{4, 4, 8, 12, 55, 3, 8, -3, 4}
		};
		for (int[] array : nums) {
			System.out.println("Original array: " + Arrays.toString(array));
		}
	}
}