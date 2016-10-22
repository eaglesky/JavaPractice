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

		while(st2.peek() != null) {
			System.out.println(st2.pop());
		}
	}
}