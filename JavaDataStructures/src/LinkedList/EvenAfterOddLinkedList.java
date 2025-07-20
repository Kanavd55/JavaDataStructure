//Problem statement
//For a given singly linked list of integers, arrange the nodes such that all the even number nodes are placed after the all odd number nodes. The relative order of the odd and even terms should remain unchanged.
//
//Note :
//1. No need to print the linked list, it has already been taken care. Only return the new head to the list.
//2. Don't create a new linked list.
//3.  Just change the data, instead rearrange the provided list.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//1 <= t <= 10^2
//0 <= M <= 10^5
//Where M is the size of the singly linked list.
//
//Time Limit: 1sec
//Sample Input 1 :
//1
//1 4 5 2 -1
//Sample Output 1 :
//1 5 4 2 
//Sample Input 2 :
//2
//1 11 3 6 8 0 9 -1
//10 20 30 40 -1
//Sample Output 2 :
//1 11 3 9 6 8 0
//10 20 30 40

package LinkedList;

import java.util.Scanner;

public class EvenAfterOddLinkedList {
	public static Node<Integer> evenAfterOdd(Node<Integer> head) {
		//Your code goes here
		if(head==null || head.next==null) {
			return head;
		}
		Node<Integer> OddHead = null;
		Node<Integer> EvenHead = null;
		Node<Integer> OddTail = null;
		Node<Integer> EvenTail = null;
		Node<Integer> Tail = head;
		while(Tail!=null) {
			if(Tail.data%2==0) {
				if(EvenHead==null) {
					EvenHead=Tail;
					EvenTail=Tail;
				}else {
					EvenTail.next=Tail;
					EvenTail=Tail;
				}
				Tail=Tail.next;
			}else {
				if(OddHead==null) {
					OddHead=Tail;
					OddTail=Tail;
				}else {
					OddTail.next=Tail;
					OddTail=Tail;
				}
				Tail=Tail.next;
			}
		}
		if(OddTail!=null) {
			OddTail.next=EvenHead;
		}
		if(EvenTail!=null) {
			EvenTail.next=null;
		}
		if(OddHead==null) {
			return EvenHead;
		}else {
			return OddHead;
		}
	}
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
	
	public static void main(String[] args) {
		Node<Integer> head = TakeLinkedListInput();
		head=evenAfterOdd(head);
		printRecursive(head);
	}
}
