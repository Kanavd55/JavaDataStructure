package Tries;
import java.util.HashMap;

public class CountDistinctString {
	public static int CountDistinctString(String word) {
		Node root = new Node();
		int n = word.length();
		int count = 0;
		for(int i=0;i<n;i++) {
			Node node=root;
			for(int j=i;j<n;j++) {
				if(!node.containsKey(word.charAt(j))) {
					node.put(word.charAt(j),new Node());
					count++;
				}
				node=node.get(word.charAt(j));
			}
		}
		return count+1;
	}
	
	public static int CountDistinctStringBruteForce(String word) {
		int n = word.length();
		int count =0;
		HashMap<String,Boolean> map = new HashMap<>();
		for(int i=0;i<=n;i++) {
			for(int j =i+1;j<=n;j++) {
				if(!map.containsKey(word.substring(i,j))) {
					map.put(word.substring(i, j), true);
					count++;
				}
			}
		}
		return count+1;
	}
}
