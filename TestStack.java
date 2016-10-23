import java.util.*;

public class TestStack {
	public static void main (String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(1);
		st.push(3);
		st.push(5);
		st.push(7);

		while (!st.empty()) {
			System.out.println(st.peek());
			st.pop();
		}

		//Better implentation:
		Deque<Integer> st2 = new ArrayDeque<>();
		st2.push(1);
		st2.push(3);
		st2.push(5);
		st2.push(7);

		System.out.println("Iterating the ArrayDeque:");
		// Output should be "7, 5, 3, 1,"
		for(Iterator<Integer> iter = st2.iterator(); iter.hasNext();) {
			System.out.print(iter.next() + ", ");
		}
		System.out.println("");

		System.out.println("Iterating the ArrayDeque reversely:");
		// Output should be "1, 3, 5, 7,"
		for(Iterator descItr = st2.descendingIterator();descItr.hasNext();) {
			System.out.print(descItr.next() + ", ");
		}
		System.out.println("");

		System.out.println("Popping out all the elements:");
		while(st2.peek() != null) {
			System.out.print(st2.pop() + ", ");
		}
		System.out.println("");
	}
}