package StacksDataStructure;
import java.util.Stack;
import java.util.Scanner;

public class ReverseAStack {
	public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {
		//Your code goes here
		if(input.isEmpty() || input.size()==1) {
			return;
		}
		int temp = input.pop();
		reverseStack(input,extra);
		while(!input.isEmpty()) {
			extra.push(input.pop());
		}
		input.push(temp);
		while(!extra.isEmpty()) {
			input.push(extra.pop());
		}
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Stack<Integer> input =  new Stack<>();
		Stack<Integer> extra = new Stack<>();
		for(int i =0;i<n;i++) {
			int num = s.nextInt();
			input.push(num);
		}
		reverseStack(input,extra);
		while(input.isEmpty()) {
			System.out.println(input.pop());
		}
	}
}
