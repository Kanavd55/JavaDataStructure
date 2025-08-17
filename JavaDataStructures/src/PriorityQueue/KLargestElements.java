//Problem statement
//You are given with an integer k and an array of integers that contain numbers in random order. Write a program to find k largest numbers from given array. You need to save them in an array and return it.
//
//Time complexity should be O(nlogk) and space complexity should be not more than O(k).
//
//Order of elements in the output is not important.
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input :
//13
//2 12 9 16 10 5 3 20 25 11 1 8 6 
//4
//Sample Output :
//12
//16
//20
//25

package PriorityQueue;
import java.util.*;
public class KLargestElements {
	
	public static ArrayList<Integer> kLargest(int input[], int k) {
		ArrayList<Integer> output = new ArrayList<>();
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int i=0;i<input.length;i++) {
			queue.add(input[i]);
		}
		for(int i =0;i<(input.length-k);i++) {
			queue.poll();
		}
		while(!queue.isEmpty()) {
			output.add(queue.poll());
		}
		return output;
		
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for(int i = 0;i<n;i++) {
			arr[i] = s.nextInt();
		}
		int k = s.nextInt();
		ArrayList<Integer> output = kLargest(arr,k);
	}
}
