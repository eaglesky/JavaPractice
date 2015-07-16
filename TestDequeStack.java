import java.util.*;
public class TestDequeStack {
	public static void main (String[] args) {
		Deque<Integer> stack = new ArrayDeque<Integer>();
		stack.push(1);
		stack.push(3);
		stack.push(5);
		stack.push(7);
	    while (stack.peek() != null) {
	    	int curElement = stack.pop();
	    	System.out.println(curElement);
	    }
	}
}