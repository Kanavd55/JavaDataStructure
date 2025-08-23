package Tries;

public class Trie3 {
	private static Node root;

	Trie3(){
		root = new Node();
	}

	//Inserts a word into the trie
	public static void insert(String word) {
		Node node = root;
		for(int i =0;i<word.length();i++) {
			if(!node.containsKey(word.charAt(i))) {
				node.put(word.charAt(i), new Node());
			}
			node = node.get(word.charAt(i));
		}
		node.setEnd();
	}
	
	boolean checkIfPrefixExists(String word) {
		boolean flag = true;
		Node node = root;
		for(int i =0;i<word.length() && flag;i++) {
			if(node.containsKey(word.charAt(i))) {
				node=node.get(word.charAt(i));
				flag=flag && node.isEnd();
			}else {
				return false;
			}
		}
		return flag;
	}
}
