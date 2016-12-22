import java.util.*;

class TestListIterator {
	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>();
		l1.add(1);
		l1.add(3);
		l1.add(5);
		l1.add(7);
		l1.add(9);
		ListIterator<Integer> iter = l1.listIterator();

		System.out.println("Traversing the list in forward direction:");
		while (iter.hasNext()) {
			System.out.println(iter.nextIndex() + ": " + iter.next());
		}

		System.out.println("\nTraversing the list in backward direction:");
    	while (iter.hasPrevious()){
       		System.out.println(iter.previousIndex() + ": " + iter.previous());
    	}

    	System.out.println("\nAdding an element while iterating: ");
		while (iter.hasNext()) {
			if (iter.nextIndex() == 2) {
				iter.add(4);
			}
			System.out.println(iter.nextIndex() + ": " + iter.next());
		}
		System.out.println("After inserting 4 after the second element: " + l1);

		System.out.println("\nRemoving an element while iterating: ");
		iter = l1.listIterator();
		while (iter.hasNext()) {
			int id = iter.nextIndex();
			int cur = iter.next();
			if (cur == 4) {
				iter.remove();
			}
			System.out.println(id + ": " + cur);
		}
		System.out.println("After removing 4 from the list: " + l1);
	}
}