package Tries;

public class CompleteString {
	public static String CompleteString(int n ,String[] arr) {
		Trie3 obj = new Trie3();
		String Longest="";
		for(int i=0;i<n;i++) {
			obj.insert(arr[i]);
		}
		for(int i=0;i<n;i++) {
			if(obj.checkIfPrefixExists(arr[i])) {
				if(arr[i].length()>Longest.length()) {
					Longest=arr[i];
				}else if(arr[i].length()==Longest.length() && arr[i].compareTo(Longest)<0) {
					Longest=arr[i];
				}
			}
		}
		if(Longest=="") return "None";
		return Longest;
	}
}
