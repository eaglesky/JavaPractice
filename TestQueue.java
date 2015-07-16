// Java Queue interface
// Result: 2 4 6 8
import java.util.*;
public class TestQueue {
	public static void main (String[] args) {
		Queue<Integer> q = new ArrayDeque<Integer>();

		// Can also use LinkedList as the implementation, but slower, 
		// according to Java docs.
		//Queue<Integer> q = new LinkedList<Integer>();
		q.offer(2);
		q.offer(4);
		q.offer(6);
		q.offer(8);
		while (q.peek() != null) {
			int curInteger = q.poll();
			System.out.println(curInteger);
		}
	}
}