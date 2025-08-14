//Problem statement
//Given a string S, you need to remove all the duplicates. That means, the output string should contain each character only once. The respective order of characters should remain same, as in the input string.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//0 <= Length of S <= 10^8
//Time Limit: 1 sec
//Sample Input 1 :
//ababacd
//Sample Output 1 :
//abcd
//Sample Input 2 :
//abcde
//Sample Output 2 :
//abcde

package HashMaps;
import java.util.HashMap;
import java.util.Scanner;
public class ExtractUniqueCharacters {
	public static String uniqueChar(String str){
		HashMap<Character,Boolean> list = new HashMap<>();
		String output="";
		for(int i=0;i<str.length();i++) {
			if(!list.containsKey(str.charAt(i))) {
				list.put(str.charAt(i), true);
				output=output+str.charAt(i);
			}
		}
		return output;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.next();
		System.out.println(uniqueChar(str));
	}
}
