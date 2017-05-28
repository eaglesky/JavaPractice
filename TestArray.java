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
		//http://stackoverflow.com/questions/12231453/syntax-for-creating-a-two-dimensional-array
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
		int[][] nums2 = new int[4][7];
		for (int i = 0; i < nums2.length; ++i) {
			for (int j = 0; j < nums2[i].length; ++j) {
				System.out.print("(" + i + ", " + j + ")=" + nums2[i][j] + "   ");
			}
			System.out.println("");
		}

		//Can the length of second dimension be 0? Yes!
		int[][] nums3 = new int[4][0];
		//int[][] nums3 = new int[0][0]; //First dimension can also have 0 length
		System.out.println("nums3: 4 x 0: ");
		for (int i = 0; i < nums3.length; ++i) {
			System.out.print("Row " + i + ": ");
			for (int j = 0; j < nums3[i].length; ++j) {
				System.out.print("(" + i + ", " + j + ")=" + nums3[i][j] + "   ");
			}
			System.out.println("");
		}

		//Array of super types
		Animal[] animals = new Animal[3];
		for (int i = 0; i < animals.length; ++i) {
			animals[i] = new Cat(i, i*2, i+3);
		}
		for (Animal animal : animals) {
			//Should output cat's info
			System.out.println("Animal = " + animal);
		}

		//Cast array of T to array of T's super class
		Cat[] cats = new Cat[3];
		for (int i = 0; i < cats.length; ++i) {
			cats[i] = new Cat(i, i*3, i+4);
		}
		Animal[] newAnimals = (Animal[])cats;
		for (Animal newAnimal : newAnimals) {
			//Should output cat's info too
			System.out.println("New animal = " + newAnimal);
		}

		Object[] strings = new String[2];
		strings[0] = "hi";   // OK
		strings[1] = 100;    // A run-time ArrayStoreException is thrown.
	}
}