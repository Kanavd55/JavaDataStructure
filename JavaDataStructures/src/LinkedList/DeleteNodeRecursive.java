package LinkedList;

import java.util.Scanner;

public class DeleteNodeRecursive {
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
	
	public static Node<Integer> deleteNodeRecursive(Node<Integer> head,int pos){
		if(head==null && pos>0) {
			return head;
		}
		if(pos==0) {
			return head.next;
		}else {
			Node<Integer> newNode = deleteNodeRecursive(head.next,pos-1);
			head.next=newNode;
			return head;
		}
	}
	public static void main(String[] args) {
		Node<Integer> head = TakeLinkedListInput();
		Scanner s = new Scanner(System.in);
		int pos = s.nextInt();
		deleteNodeRecursive(head,pos);
		printRecursive(head);
	}
}
