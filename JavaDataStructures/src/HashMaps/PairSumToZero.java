//Problem statement
//Given a random integer array A of size N. Find and print the count of pair of elements in the array which sum up to 0.
//
//
//
//Note:
//Array A can contain duplicate elements as well.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//0 <= N <= 10^4
//Time Limit: 1 sec
//Sample Input 1:
//5
//2 1 -2 2 3
//Sample Output 1:
//2
//Explanation
//(2,-2) , (-2,2) will result in 0 , so the answer for the above problem is 2.
package HashMaps;

import java.util.Scanner;
import java.util.HashMap;
public class PairSumToZero {
	public static int factorial(int n) {
		if(n==0) {
			return 1;
		}
		int value = factorial(n-1);
		return n + value;
	}
	public static int PairSum(int[] input, int size) {
		HashMap<Integer,Integer> map = new HashMap<>();
		int count = 0;
		for(int i=0;i<size;i++) {
			if(map.containsKey(input[i])) {
				int value = map.get(input[i])+1;
				map.put(input[i],value);
			}else {
				map.put(input[i],1);
			}
		}
		for(Integer i : new HashMap<>(map).keySet()) {
			int key = - i;
			if(map.containsKey(key)) {
				int value1 = map.get(key);
				int value2 = map.get(i);
				if(key==0) {
					count = count + factorial(value1);
				}else {
					count = count + (value1 * value2);
				}
				map.remove(key);
				map.remove(i);
			}
		}
		return count;
	}
	public static int[] TakeArrayInput(int n) {
		Scanner s = new Scanner(System.in);
		int[] arr = new int[n];
		for(int i=0;i<arr.length;i++) {
			arr[i]=s.nextInt();
		}
		return arr;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = TakeArrayInput(n);
		System.out.println(PairSum(arr,n));
	}
}
