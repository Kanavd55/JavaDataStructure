package HashMaps;
import java.util.*;
public class RemoveDuplicates {
	public static ArrayList<Integer> removeDuplicates(int[] arr){
		ArrayList<Integer> output = new ArrayList<>();
		HashMap<Integer,Boolean> list = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			if(list.containsKey(arr[i])) {
				continue;
			}
			output.add(arr[i]);
			list.put(arr[i], true);
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
		ArrayList<Integer> output = removeDuplicates(arr);
	}
}
