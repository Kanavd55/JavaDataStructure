package Tries;

public class Node2 {
	Node2 links[] = new Node2[26];
	int cntEndsWith = 0;
	int cntPrefix = 0;
	
	public Node2() {
		
	}
	
	boolean containsKey(char ch) {
		return links[ch-'a']!=null;
	}
	
	Node2 get(char ch) {
		return links[ch-'a'];
	}
	
	void put(char ch,Node2 node) {
		links[ch-'a']=node;
	}
	
	void increaseEnd() {
		cntEndsWith++;
	}
	
	void increasePrefix() {
		cntPrefix++;
	}
	
	void deleteEnd() {
		cntEndsWith--;
	}
	
	void decreasePrefix() {
		cntPrefix--;
	}
}
