package StacksDataStructure;
import java.util.Stack;
import java.util.Scanner;

public class RedundantBrackets {
	public static boolean checkRedundantBrackets(String expression) {
		//Your code goes here
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<expression.length();i++) {
			if(expression.charAt(i)==')') {
				int count = 0;
				char d=(char)stack.peek();
				while(!stack.isEmpty() && d!='(') {
					d=stack.pop();
					count++;
				}
				if(count<3) {
					return true;
				}
			}else {
				stack.push(expression.charAt(i));
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String word = s.next();
		System.out.println(checkRedundantBrackets(word));
	}
}
