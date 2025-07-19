package LinkedList;

import java.util.Scanner;

public class SortLinkedList {
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
	
	public static Node<Integer> SortLinkedList(Node<Integer> head){
		if(head==null || head.next == null) {
			return head;
		}
		Node<Integer> smallHead=SortLinkedList(head.next);
		if(head.data<smallHead.data) {
			head.next=smallHead;
			return head;
		}else {
			Node<Integer> tail = smallHead;
			Node<Integer> tail2= smallHead.next;
			while(tail2!=null) {
				if(tail2.data>head.data) {
					tail.next=head;
					head.next=tail2;
					return smallHead;
				}
				tail=tail.next;
				tail2=tail2.next;
			}
			tail.next=head;
			head.next=null;
			return smallHead;
		}
	}
	public static void main(String[] args) {
		Node<Integer> head = TakeLinkedListInput();
		head=SortLinkedList(head);
		printRecursive(head);
	}
}
