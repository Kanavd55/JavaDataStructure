package QueueDataStructure;
import java.util.Queue;
import java.util.LinkedList;
public class QueueUse {
	public static void main(String[] args) {
		Queue<Integer> test = new LinkedList<Integer>();
		//Queue is an interface and not an class
		test.add(5);
		test.add(10);
		test.add(15);
		System.out.println(test.size());
		while(!test.isEmpty()) {
			System.out.println(test.poll());
		}
	}
}
