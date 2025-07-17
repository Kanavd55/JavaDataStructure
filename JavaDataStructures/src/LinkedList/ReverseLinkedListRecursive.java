package LinkedList;

import java.util.Scanner;

public class ReverseLinkedListRecursive {
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
	
	public static Node<Integer> reverseLinkedList(Node<Integer> head){
		if(head==null || head.next==null) {
			return head;
		}
		Node<Integer> reverse = reverseLinkedList(head.next);
		head.next.next=head;
		head.next=null;
		return reverse;
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
		Node<Integer> Head = TakeLinkedListInput();
		Head=reverseLinkedList(Head);
		printRecursive(Head);
	}
}
