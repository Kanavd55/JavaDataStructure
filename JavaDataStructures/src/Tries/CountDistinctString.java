package Tries;

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
}
