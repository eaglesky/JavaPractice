import java.util.*;

public class TestSet {
	public static void main (String[] args) {
		Set<Integer> testSet = new TreeSet<Integer>();
		//Set<Integer> testSet = new HashSet<Integer>();
		//Set<Integer> testSet = new LinkedHashSet<Integer>();

		testSet.add(1);
		testSet.add(3);
		testSet.add(5);
		testSet.add(7);
		boolean checkDuplicate = testSet.add(5);
		if (!checkDuplicate)
			System.out.println("No adding!");

		System.out.println("Size now = " + testSet.size());

		if (testSet.contains(7)) {
			System.out.println("7 is in the set!");
		} else {
			System.out.println("7 is not in the set!");
		}

		testSet.remove(5);
		if (testSet.contains(5)) {
			System.out.println("5 is in the set!");
		} else {
			System.out.println("5 is not in the set!");
		}

		//1, 3, 7
		for (int i : testSet)
			System.out.println(i);

		//Test iterator
		//Iterator.next() method advances the iterator to the next element
		Iterator iter = testSet.iterator();
		System.out.println("Value returned by the current iterator = " + iter.next());
		System.out.println("Value returned by the current iterator = " + iter.next());
	}
}