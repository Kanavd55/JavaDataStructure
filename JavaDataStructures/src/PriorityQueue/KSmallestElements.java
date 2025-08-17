//Problem statement
//You are given with an integer k and an array of integers that contain numbers in random order. Write a program to find k smallest numbers from given array. You need to save them in an array and return it.
//
//Notes :
//1. Time complexity should be O(n * logk) and space complexity should not be more than O(k).
//2. Order of elements in the output is not important.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//Time Limit: 1 sec
//Sample Input 1 :
//13
//2 12 9 16 10 5 3 20 25 11 1 8 6 
//4
//Sample Output 1 :
//1 2 3 5

package PriorityQueue;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KSmallestElements {
	
	public static ArrayList<Integer> kSmallest(int n, int[] input, int k) {
		ArrayList<Integer> output = new ArrayList<>();
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int i=0;i<input.length;i++) {
			queue.add(input[i]);
		}
		for(int i=0;i<k;i++) {
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
		ArrayList<Integer> output = kSmallest(n,arr,k);
	}
}
