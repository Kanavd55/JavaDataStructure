//Problem statement
//Given a large number represented in the form of a linked list. Write code to increment the number by 1 in-place(i.e. without using extra space).
//
//Note: You don't need to print the elements, just update the elements and return the head of updated LL. Input Constraints:
//1 <= Length of Linked List <=10^6.
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1 :
//3 9 2 5 -1
//Sample Output 1 :
//3 9 2 6
//Sample Input 2 :
//9 9 9 -1
//Sample Output 1 :
//1 0 0 0 


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
	public static Node<Integer> reverseLinkedList(Node<Integer> head){
		if(head==null || head.next==null) {
			return head;
		}
		Node<Integer> reverse = reverseLinkedList(head.next);
		head.next.next=head;
		head.next=null;
		return reverse;
	}
	public static Node<Integer> nextLargeNumber(Node<Integer> head) {
		if(head==null) {
			return head;
		}
		head = reverseLinkedList(head);
		Node<Integer> prev = null;
		Node<Integer> temp = head;
		int carry=1;
		while(temp!=null) {
			int sum = temp.data+carry;
			int num = sum%10;
			carry=sum/10;
			temp.data=num;
			prev=temp;
			temp=temp.next;
		}
		if(carry==1) {
			Node<Integer> node = new Node<>(carry);
			prev.next=node;
		}
		head=reverseLinkedList(head);
		return head;
	}
	//This is not optimized as this solution will only work for 10 digits only bcoz we've used int
//	public static Node<Integer> nextLargeNumber(Node<Integer> head) {
//		if(head==null) {
//			return head;
//		}
//		Node<Integer> Temp=head;
//		int count = 0;
//		while(Temp!=null) {
//			int num = count*10;
//			count=num+Temp.data;
//			Temp=Temp.next;
//		}
//		count=count+1;
//		Stack<Integer> nextLargeNumber = new Stack<>();
//		while(count>0) {
//			int num = count % 10;
//			count = count/10;
//			nextLargeNumber.add(num);
//		}
//		Node<Integer> newHead = null;
//		Node<Integer> newtail = null;
//		while(!nextLargeNumber.isEmpty()) {
//			int num = nextLargeNumber.pop();
//			Node<Integer> node = new Node<>(num);
//			if(newHead==null) {
//				newHead=node;
//				newtail=node;
//			}else {
//				newtail.next=node;
//				newtail=newtail.next;
//				
//			}
//		}
//		return newHead;
//		
//	}
	public static void main(String[] args) {
		Node<Integer> Head = TakeLinkedListInput();
		Head=nextLargeNumber(Head);
		printRecursive(Head);
	}
}
