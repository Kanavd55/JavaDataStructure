//Problem statement
//You are given an array of unique integers that contain numbers in random order. You have to find the longest possible sequence of consecutive numbers using the numbers from given array.
//
//You need to return the output array which contains starting and ending element. If the length of the longest possible sequence is one, then the output array must contain only single element.
//
//Note:
//1. Best solution takes O(n) time.
//2. If two sequences are of equal length, then return the sequence starting with the number whose occurrence is earlier in the array.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//0 <= n <= 10^6
//Time Limit: 1 sec
//Sample Input 1 :
//13
//2 12 9 16 10 5 3 20 25 11 1 8 6 
//Sample Output 1 :
//8 12 
//Explanation:The longest consecutive sequence here is [8, 9, 10, 11, 12]. So the output is the start and end of this sequence: [8, 12].
//Sample Input 2 :
//7
//3 7 2 1 9 8 41
//Sample Output 2 :
//7 9
//Explanation:There are two sequences of equal length here: [1,2,3] and [7,8,9]. But since [7,8,9] appears first in the array (7 comes before 1), we return this sequence. So the output is [7,9].
//Sample Input 3 :
//7
//15 24 23 12 19 11 16
//Sample Output 3 :
//15 16
//Explanation:The longest consecutive sequence here is [15,16]. So the output is [15,16].

package HashMaps;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
public class LongestConsecutiveSequence {
	public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
		HashMap<Integer,Boolean> map = new HashMap<>();
		HashMap<Integer,Boolean> vis = new HashMap<>();
		for(int i =0;i<arr.length;i++) {
			map.put(arr[i], true);
		}
		int maxLength = Integer.MIN_VALUE;
		int start = 0;
		int end = 0;
		for(int i=0;i<arr.length;i++) {
			vis.put(arr[i],true);
			if(!map.get(arr[i])) {
				continue;
			}
			int element = arr[i];
			int tempStart = arr[i];
			int tempEnd = arr[i];
			int tempLength = 1;
			map.put(element, false);
			while(map.containsKey(element+1)) {
				tempLength++;
				tempEnd = element+1;
				map.put(element+1, false);
				element = element+1;
			}
			element = arr[i];
			while(map.containsKey(element-1)) {
				tempLength++;
				tempStart = element-1;
				map.put(element-1, false);
				element = element-1;
			}
			if(tempLength == maxLength){
				if(vis.containsKey(tempStart) && vis.get(tempStart)){
					maxLength = tempLength;
				start=tempStart;
				end = tempEnd;
				}
			}
			if(tempLength>maxLength) {
				maxLength = tempLength;
				start=tempStart;
				end = tempEnd;
			}
		}
		ArrayList<Integer> output = new ArrayList<>();
		output.add(start);
		output.add(end);
		return output;
    }

	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int [] arr = new int[n];
		ArrayList<Integer> list = longestConsecutiveIncreasingSequence(arr);
	}
}
