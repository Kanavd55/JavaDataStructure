package LinkedList;

import java.util.Scanner;
import java.util.Stack;
public class NextNumber {
	public static Node<Integer> TakeLinkedListInput(){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Node<Integer> head = null;
		Node<Integer> tail = null;
		while(n!=-1) {
			if(head==null) {
				head=new Node<Integer>(n);
				tail=head;
			}else {
				Node<Integer> node= new Node<Integer>(n);
				tail.next=node;
				tail=node;
			}
			n=s.nextInt();
			
		}
		return head;
	}
	
	public static void printRecursive(Node<Integer> head) {
		if(head==null || head.next==null) {
			System.out.println(head.data);
			return;
		}
		System.out.println(head.data);
		printRecursive(head.next);
	}
	//This is not optimized as this solution will only work for 10 digits only bcoz we've used int
	public static Node<Integer> nextLargeNumber(Node<Integer> head) {
		if(head==null) {
			return head;
		}
		Node<Integer> Temp=head;
		int count = 0;
		while(Temp!=null) {
			int num = count*10;
			count=num+Temp.data;
			Temp=Temp.next;
		}
		count=count+1;
		Stack<Integer> nextLargeNumber = new Stack<>();
		while(count>0) {
			int num = count % 10;
			count = count/10;
			nextLargeNumber.add(num);
		}
		Node<Integer> newHead = null;
		Node<Integer> newtail = null;
		while(!nextLargeNumber.isEmpty()) {
			int num = nextLargeNumber.pop();
			Node<Integer> node = new Node<>(num);
			if(newHead==null) {
				newHead=node;
				newtail=node;
			}else {
				newtail.next=node;
				newtail=newtail.next;
				
			}
		}
		return newHead;
		
	}
	public static void main(String[] args) {
		Node<Integer> Head = TakeLinkedListInput();
		Head=nextLargeNumber(Head);
		printRecursive(Head);
	}
}
