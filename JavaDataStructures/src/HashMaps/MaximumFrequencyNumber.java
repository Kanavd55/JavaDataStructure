package HashMaps;

import java.util.Scanner;
import java.util.HashMap;
public class MaximumFrequencyNumber {
	public static int maxFrequencyNumber(int[] arr){ 
		int output = -1;
		HashMap<Integer,Integer> list = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			if(list.containsKey(arr[i])) {
				int value = list.get(arr[i])+1;
				list.put(arr[i], value);
			}else {
				list.put(arr[i], 1);
			}
		}
		int maxCount = Integer.MIN_VALUE;
		for(int i =0;i<arr.length;i++) {
			if(list.get(arr[i])>maxCount) {
				maxCount = list.get(arr[i]);
				output = arr[i];
			}
		}
		return output;
		
    }
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<arr.length;i++) {
			arr[i]=s.nextInt();
		}
		System.out.println(maxFrequencyNumber(arr));
	}
}
