package StacksDataStructure;
import java.util.Stack;
import java.util.Scanner;
public class BracketsBalanced {
	 public static boolean isBalanced(String expression) {
	        //Your code goes here
		 if(expression.length()==1) {
			 return false;
		 }
		 Stack<Character> balanced = new Stack<>();
		 for(int i=0;i<expression.length();i++) {
			 if(expression.charAt(i)=='(') {
				 balanced.push('(');
			 }else {
				 if(balanced.isEmpty()) {
					 balanced.push(')');
				 }else {
					 if((char)balanced.peek()=='(') {
						 balanced.pop();
					 }else {
						 balanced.push(')');
					 }
				 }
			 }
		 }
		 return balanced.isEmpty();
	    }
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String word = s.next();
		System.out.println(isBalanced(word));
	}
}
