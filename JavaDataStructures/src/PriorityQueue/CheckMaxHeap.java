//Problem statement
//Given an array of integers, check whether it represents max-heap or not. Return true if the given array represents max-heap, else return false.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//1 <= N <= 10^5
//1 <= Ai <= 10^5
//Time Limit: 1 sec
//Sample Input 1:
//8
//42 20 18 6 14 11 9 4
//Sample Output 1:
//true


package PriorityQueue;

import java.util.Scanner;

public class CheckMaxHeap {
	
	public static boolean checkMaxHeap(int arr[]) {
		if(arr.length==1) {
			return true;
		}
		for(int i=0;i<arr.length;i++) {
			int leftChild = 2*i + 1;
			int rightChild = 2*i +2;
			if(leftChild<arr.length && arr[leftChild]>arr[i]) {
				return false;
			}
			if(rightChild<arr.length && arr[rightChild]>arr[i]) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = s.nextInt();
		}
		System.out.println(checkMaxHeap(arr));
	}
}
