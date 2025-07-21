package LinkedList;

import java.util.Scanner;

public class BubbleSort {
	
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
	
	public static Node<Integer> bubbleSort(Node<Integer> head) {
		//Your code goes here
		if(head==null || head.next==null) {
			return head;
		}
		
		int count=0;
		Node<Integer> tail =head;
		while(tail!=null) {
			tail=tail.next;
			count++;
		}
		for(int i=0;i<count;i++) {
			tail=head;
			while(tail.next!=null) {
				Node<Integer> temp=tail.next;
				System.out.println("tempdata"+temp.data);
				if(tail.data > temp.data) {
					if(tail==head) {
						tail.next=temp.next;
						temp.next=tail;
						head=temp;
					}else {
						tail.next=temp.next;
						temp.next=tail;
					}
				}else {
					tail=tail.next;
				}
			}
		}
		return head;
	}
	public static void main(String[] args) {
		Node<Integer> head = TakeLinkedListInput();
		head=bubbleSort(head);
		printRecursive(head);
	}
}
