import java.util.ArrayList;

public class TestArrayList {
	public static void main (String[] args) {
		int a1 = 3;
		int a2 = 5;
		int a3 = 7;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(a1);
		arr.add(a2);
		arr.add(a3);

		for (int a : arr)
		{
			System.out.println(a);
		}

		System.out.println("arr contains a1 ? " + arr.contains(3));
		System.out.println("Index of a1 : " + arr.indexOf(a1));
	}
}