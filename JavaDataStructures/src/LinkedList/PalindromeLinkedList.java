package LinkedList;

import java.util.Scanner;

public class PalindromeLinkedList {
	
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
	
	public static int length(Node head){
        //Your code goes here
		int length=0;
		Node<Integer> temp=head;
		while(temp!=null) {
			length++;
			temp=temp.next;
		}
		return length;
    }
	
	public static Node<Integer> Reverse(Node<Integer> root) {
		//Your code goes here
		if(root==null || root.next==null) {
			return root;
		}
		Node<Integer> head = Reverse(root.next);
		root.next.next=root;
		root.next=null;
		return head;
	}
	public static boolean isPalindrome(Node<Integer> head) {
		//Your code goes here
		if(head==null || head.next==null) {
			return true;
		}
		int length = length(head);
		Node<Integer> tail1 = head;
		Node<Integer> tail2 = head.next;
		for(int i=0;i<(length/2)-1;i++) {
			tail1=tail1.next;
			tail2=tail1.next;
		}
		tail1.next=null;
		Node<Integer> reverse = Reverse(tail2);
		while(head!=null && reverse!=null) {
			if(head.data!=reverse.data) {
				return false;
			}
			head=head.next;
			reverse=reverse.next;
		}
		return true;
		
	}
	public static void main(String[] args) {
		Node<Integer> head = TakeLinkedListInput();
		System.out.println(isPalindrome(head));
	}
}
