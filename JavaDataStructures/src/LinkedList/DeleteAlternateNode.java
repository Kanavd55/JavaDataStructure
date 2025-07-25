//Problem statement
//Given a Singly Linked List of integers, delete all the alternate nodes in the list.
//
//Example:
//List: 10 -> 20 -> 30 -> 40 -> 50 -> 60 -> null
//Alternate nodes will be:  20, 40, and 60.
//
//Hence after deleting, the list will be:
//Output: 10 -> 30 -> 50 -> null
//Note :
//The head of the list will remain the same. Don't need to print or return anything.
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1:
//1 2 3 4 5 -1
//Sample Output 1:
//1 3 5
//Explanation of Sample Input 1:
//2, 4 are alternate nodes so we need to delete them 
//Sample Input 2:
//10 20 30 40 50 60 70 -1
//Sample Output 2:
//10 30 50 70 


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
