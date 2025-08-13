//Problem statement
//You have been given two integer arrays/lists (ARR1 and ARR2) of size N and M, respectively. You need to print their intersection; An intersection for this problem can be defined when both the arrays/lists contain a particular value or to put it in other words, when there is a common value that exists in both the arrays/lists.
//
//Note :
//Input arrays/lists can contain duplicate elements.
//
//The intersection elements printed would be in the order they appear in the second array/list (ARR2).
//
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//0 <= N <= 10^6
//0 <= M <= 10^6
//
//Time Limit: 1 sec 
//Sample Input 1 :
//6
//2 6 8 5 4 3
//4
//2 3 4 7 
//Sample Output 1 :
//2
//3 
//4
//Sample Input 2 :
//4
//2 6 1 2
//5
//1 2 3 4 2
//Sample Output 2 :
//1 
//2 
//2

package HashMaps;

import java.util.Scanner;
import java.util.HashMap;

public class PrintIntersection {
	public static void printIntersection(int[] arr1,int[] arr2){
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<arr1.length;i++) {
			if(map.containsKey(arr1[i])) {
				int value = map.get(arr1[i])+1;
				map.put(arr1[i],value);
			}else {
				map.put(arr1[i], 1);
			}
		}
		for(int i=0;i<arr2.length;i++) {
			if(map.containsKey(arr2[i])) {
				System.out.println(arr2[i]);
				int value = map.get(arr2[i]);
				if(value-1 ==0) {
					map.remove(arr2[i]);
				}else {
					map.put(arr2[i], value-1);
				}
			}
		}
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

	public static void main(String[] args) {
		int[] arr1 = TakeArrayInput();
		int[] arr2 = TakeArrayInput();
		printIntersection(arr1,arr2);
	}
}
