package PriorityQueue;

import java.util.Scanner;
import java.util.PriorityQueue;
public class KthLargestElement {
	
	public static int kthLargest(int n, int[] input, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int i=0;i<n;i++) {
			queue.add(input[i]);
		}
		int m = n-k;
		for(int i=0;i<m;i++) {
			queue.poll();
		}
		return queue.poll();
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=s.nextInt();
		}
		int k = s.nextInt();
		System.out.println(kthLargest(n,arr,k));
	}
}
