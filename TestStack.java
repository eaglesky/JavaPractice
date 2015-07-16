import java.util.Stack;

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
	}
}