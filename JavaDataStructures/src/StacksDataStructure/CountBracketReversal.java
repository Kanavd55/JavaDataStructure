//Problem statement
//For a given expression in the form of a string, find the minimum number of brackets that can be reversed in order to make the expression balanced. The expression will only contain curly brackets.
//
//If the expression can't be balanced, return -1.
//
//Example:
//Expression: {{{{
//If we reverse the second and the fourth opening brackets, the whole expression will get balanced. Since we have to reverse two brackets to make the expression balanced, the expected output will be 2.
//
//Expression: {{{
//In this example, even if we reverse the last opening bracket, we would be left with the first opening bracket and hence will not be able to make the expression balanced and the output will be -1.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//0 <= N <= 10^6
//Where N is the length of the expression.
//
//Time Limit: 1sec
//Sample Input 1:
//{{{
//Sample Output 1:
//-1
//Sample Input 2:
//{{{{}}
//Sample Output 2:
//1

package StacksDataStructure;

import java.util.Scanner;
import java.util.Stack;
public class CountBracketReversal {
	
	public static int countBracketReversals(String input) {
		//Your code goes here
		if(input.length()==1) {
			return -1;
		}
		Stack<Character> stack= new Stack<>();
		for(int i =0;i<input.length();i++) {
			if(stack.isEmpty()) {
				stack.push(input.charAt(i));
			}else if(input.charAt(i)=='}') {
				char d = (char)stack.peek();
				if(d=='{') {
					stack.pop();
				}else {
					stack.push(input.charAt(i));
				}
			}
			else {
				stack.push(input.charAt(i));
			}
		}
		if(stack.size()%2!=0) {
			return -1;
		}
		int count=0;
		while(!stack.isEmpty()) {
			char c1=stack.pop();
			char c2=stack.pop();
			if(c1==c2) {
				count++;
			}else if(c1!=c2){
				count=count+2;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String word = s.next();
		System.out.println(countBracketReversals(word));
	}
}
