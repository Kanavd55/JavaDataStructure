//Implementation Trie | Insert | countWordsEqualTo | countWordsStartingWith | erase

package Tries;

public class Trie2 {
	private Node2 root;
	
	Trie2(){
		root = new Node2();
	}
	
	//Inserts a word into the trie
	public void insert(String word) {
		Node2 node = root;
		for(int i=0;i<word.length();i++) {
			if(!node.containsKey(word.charAt(i))) {
				node.put(word.charAt(i), new Node2());
			}
			node = node.get(word.charAt(i));
			node.increasePrefix();
		}
		node.increaseEnd();
	}
	
	public int countWordsEqualTo(String word) {
		Node2 node = root;
		for(int i=0;i<word.length();i++) {
			if(node.containsKey(word.charAt(i))) {
				node = node.get(word.charAt(i));
			}else {
				return 0;
			}
			
		}
		return node.getEnd();
	}
	
	public int countWordsStartingWith(String word) {
		Node2 node = root;
		for(int i=0;i<word.length();i++) {
			if(node.containsKey(word.charAt(i))) {
				node = node.get(word.charAt(i));
			}else {
				return 0;
			}
		}
		return node.getPrefix();
	}
	
	public void erase(String word) {
		Node2 node = root;
		for(int i=0;i<word.length();i++) {
			if(node.containsKey(word.charAt(i))) {
				node = node.get(word.charAt(i));
				node.reducePrefix();
			}else {
				return;
			}
		}
		node.deleteEnd();
	}
}
