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
	}
}