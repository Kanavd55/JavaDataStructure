package LinkedList;

import java.util.Scanner;

public class MidPointLinkedList {
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
	
	public static int MidPoint(Node<Integer> head) {
		if(head==null) {
			return -1;
		}
		Node<Integer> mid = head;
		Node<Integer> tail = head;
		while(tail.next!=null && tail.next.next!=null) {
			tail=tail.next.next;
			mid=mid.next;
		}
		return mid.data;
	}
	public static void main(String[] args) {
		Node<Integer> head = TakeLinkedListInput();
		System.out.println();
	}
}
