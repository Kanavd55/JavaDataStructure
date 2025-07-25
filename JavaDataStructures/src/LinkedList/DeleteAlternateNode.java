package LinkedList;

import java.util.Scanner;

public class DeleteAlternateNode {
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
	public static void deleteAlternateNodes(Node<Integer> head) {
        //Your code goes here
		if(head==null || head.next==null) {
			return;
		}
		Node<Integer> tail=head;
		while(tail.next!=null && tail.next.next!=null) {
			tail.next=tail.next.next;
			tail=tail.next;
		}
		tail.next=null;
    }
	public static void main(String[] args) {
		Node<Integer> Head = TakeLinkedListInput();
		deleteAlternateNodes(Head);
		printRecursive(Head);
	}

}
