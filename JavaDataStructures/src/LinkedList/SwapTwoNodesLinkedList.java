package LinkedList;

import java.util.Scanner;

public class SwapTwoNodesLinkedList {
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
	public static Node<Integer> swapNodes(Node<Integer> head, int i, int j) {
		//Your code goes here
		if(head==null){
			return head;
		}
		Node<Integer> p1=null;
		Node<Integer> p2=null;
		Node<Integer> ithNode=null;
		Node<Integer> jthNode=null;
		Node<Integer> temp=head;
		int count=0;
		while(temp!=null && count<j) {
			while(count<i) {
				count++;
				p1=temp;
				temp=temp.next;
			}
			ithNode=temp;
			count=0;
			temp=head;
			while(count<j) {
				count++;
				p2=temp;
				temp=temp.next;
			}
			jthNode=temp;
		}if(p1!=null) {
			p1.next=jthNode;
		}
		if(p2!=null) {
			p2.next=ithNode;
		}
		if(ithNode!=null && jthNode!=null) {
			temp=ithNode.next;
			ithNode.next=jthNode.next;
			jthNode.next=temp;
		}


		return head;
	}
	public static void main(String[] args) {
		Node<Integer> head = TakeLinkedListInput();
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		head=swapNodes(head,m,n);
		printRecursive(head);
	}
}
