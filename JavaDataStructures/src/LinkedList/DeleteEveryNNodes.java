package LinkedList;

import java.util.Scanner;

public class DeleteEveryNNodes {
	public static Node<Integer> skipMdeleteN(Node<Integer> head, int M, int N) {
		//Your code goes here
		if(head==null) {
			return head;
		}
		if(M==0){
			return null;
		}
		if(N==0){
			return head;
		}
		Node<Integer> tail = head;
		Node<Integer> newHead=head;
		Node<Integer> newTail=head;
		boolean isSkip=true;
		boolean isDelete=false;
		int count=0;
		while(tail!=null) {
			if(isSkip) {
				if(count==M) {
					isSkip=false;
					isDelete=true;
					count=0;
				}else {
					count++;
					newTail=tail;
					tail=tail.next;
					
				}
			}else {
				if(count==N) {
					isSkip=true;
					isDelete=false;
					count=0;
					newTail.next=tail;
					newTail=newTail.next;
				}else {
					count++;
					tail=tail.next;
				}
			}
		}
		newTail.next=null;
		return newHead;
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
		Node<Integer> Head = TakeLinkedListInput();
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		Head=skipMdeleteN(Head,m,n);
		printRecursive(Head);
	}
}
