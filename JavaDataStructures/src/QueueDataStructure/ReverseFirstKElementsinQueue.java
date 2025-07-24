//Problem statement
//For a given queue containing all integer data, reverse the first K elements.
//
//You have been required to make the desired change in the input queue itself.
//
//Example:
//alt txt
//
//For the above input queue, if K = 4 then after reversing the first 4 elements, the queue will be updated as:
//alt txt
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//1 <= N <= 10^6
//1 <= K <= N
//-2^31 <= data <= 2^31 - 1
//
// Time Limit: 1sec
//Sample Input 1:
//5 3
//1 2 3 4 5
//Sample Output 1:
//3 2 1 4 5
//Sample Input 2:
//7 7
//3 4 2 5 6 7 8
//Sample Output 2:
//8 7 6 5 2 4 3

package QueueDataStructure;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
public class ReverseFirstKElementsinQueue {
	public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
		//Your code goes here
		if(k==0 || input.isEmpty() || input.size()==1) {
			return input;
		}
		Stack<Integer> stack = new Stack<>();
		int count = 0;
		while(count<k) {
			stack.push(input.poll());
			count++;
		}
		int size = input.size();
		while(!stack.isEmpty()) {
			input.add(stack.pop());
		}
		for(int i=0;i<size;i++) {
			input.add(input.poll());
		}
		return input;
		
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Queue<Integer> task = new LinkedList<>();
		for(int i=0;i<n;i++) {
			int m = s.nextInt();
			task.add(m);
		}
		int k = s.nextInt();
		Queue<Integer> reversed = reverseKElements(task,k);
		while(!reversed.isEmpty()) {
			System.out.print(task.poll()+" ");
		}
	}

}
