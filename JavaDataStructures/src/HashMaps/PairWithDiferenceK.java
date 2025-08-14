//Problem statement
//You are given with an array of integers and an integer K. You have to find and print the count of all such pairs which have difference K.
//
//Note: Take absolute difference between the elements of the array.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//0 <= n <= 10^4
//Time Limit: 1 sec
//Sample Input 1 :
//4 
//5 1 2 4
//3
//Sample Output 1 :
//2
//Explanation
//(5,2) and (1,4) are the possible combinations as their absolute difference is 3.
//Sample Input 2 :
//4
//4 4 4 4 
//0
//Sample Output 2 :
//6

package HashMaps;

import java.util.Scanner;
import java.util.HashMap;
public class PairWithDiferenceK {
	public static int factorial(int n) {
		if(n==0) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		int value = factorial(n-1);
		return n + value;
	}
	public static int[] TakeArrayInput() {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<arr.length;i++) {
			arr[i]=s.nextInt();
		}
		return arr;
	}
	
	public static int getPairsWithDifferenceK(int arr[], int k) {
		HashMap<Integer,Integer> map = new HashMap<>();
		int count =0;
		for(int i =0 ;i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				int value = map.get(arr[i])+1;
				map.put(arr[i], value);
			}else {
				map.put(arr[i], 1);
			}
		}
		for(Integer i : new HashMap<>(map).keySet()) {
			if(k==0) {
				int num = map.get(i);
				int numSet = factorial(num-1);
				count = count + numSet;
				map.remove(i);
			}else {
				int num1 = i - k;
				int num2 = i + k;
				if(map.containsKey(num1)) {
					int value1 = map.get(num1);
					int value2 = map.get(i);
					count = count + (value1*value2);
				}
				if(map.containsKey(num2)) {
					int value1 = map.get(i);
					int value2 = map.get(num2);
					count = count + (value1*value2);
				}
				map.remove(i);
			}
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int [] arr = TakeArrayInput();
		int k = s.nextInt();
		System.out.println(getPairsWithDifferenceK(arr,k));
	}
}
