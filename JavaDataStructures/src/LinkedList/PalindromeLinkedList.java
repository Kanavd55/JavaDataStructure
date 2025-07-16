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
//	public static boolean isPalindrome(Node<Integer> head) {
//		//Your code goes here
//		if(head==null || head.next==null) {
//			return true;
//		}
//		Node<Integer> reverse = Reverse(head);
//		Node<Integer> tail1 = head;
//		Node<Integer> tail2 = reverse;
//		while(tail1!=null && tail2!=null) {
//			if(tail1.data!=tail2.data) {
//				return false;
//			}
//			tail1=tail1.next;
//			tail2=tail2.next;
//		}
//		return true;
//	}
	public static void main(String[] args) {
		Node<Integer> head = TakeLinkedListInput();
		//System.out.println(isPalindrome(head));
	}
}
