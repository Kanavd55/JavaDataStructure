package PriorityQueue;
import java.util.PriorityQueue;
public class PriorityQueueUse {
	public static void main(String[] args) {
		int[] arr = {4,3,7,6,9,10,12};
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<arr.length;i++) {
			pq.add(arr[i]);
		}
		while(!pq.isEmpty()) {
			System.out.println(pq.peek());
			pq.poll();
		}
		//By default Priority Queue is Min Priority Queue
	}
}
