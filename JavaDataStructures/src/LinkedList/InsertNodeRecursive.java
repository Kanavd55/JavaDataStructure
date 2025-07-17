package LinkedList;

import java.util.Scanner;

public class InsertNodeRecursive {
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
	
	public static Node<Integer> insertRecursive(Node<Integer> head,int element,int pos){
		if(head==null && pos>0) {
			return head;
		}
		if(pos==0) {
			Node<Integer> newNode = new Node<Integer>(element);
			newNode.next=head;
			return newNode;
		}else {
			Node<Integer> newNode = insertRecursive(head.next,element,pos-1);
			head.next=newNode;
			return head;
		}
	}
	public static void main(String[] args) {
		Node<Integer> head = TakeLinkedListInput();
		Scanner s = new Scanner(System.in);
		int element = s.nextInt();
		int pos = s.nextInt();
		head = insertRecursive(head,element,pos);
		printRecursive(head);
	}
}
