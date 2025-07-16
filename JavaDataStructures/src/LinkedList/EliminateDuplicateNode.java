//Problem statement
//You have been given a singly linked list of integers where the elements are sorted in ascending order. Write a function that removes the consecutive duplicate values such that the given list only contains unique elements and returns the head to the updated list.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//1 <= t <= 10^2
//0 <= M <= 10^5
//Time Limit: 1sec
//
//Where 'M' is the size of the singly linked list.
// Remember/Consider :
//While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
//Sample Input 1 :
//1
//1 2 3 3 3 3 4 4 4 5 5 7 -1
//Sample Output 1 :
//1 2 3 4 5 7 
//Sample Input 2 :
//2
//10 20 30 40 50 -1
//10 10 10 10 -1
//Sample Output 2 :
//10 20 30 40 50
//10

package LinkedList;

import java.util.Scanner;

public class EliminateDuplicateNode {
	
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
	
	public static void PrintLinkedList(Node<Integer> head) {
		Node<Integer> temp = head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	
	public static Node<Integer> removeDuplicates(Node<Integer> head) {
		//Your code goes here
		Node<Integer> prev=head;
		if(head==null || head.next==null) {
			return head;
		}
		Node<Integer> next=head;
		while(next!=null) {
				if(prev.data<next.data) {
					prev.next=next;
					prev=next;
				}
				next=next.next;
		}
		if(prev!=null){
            prev.next=null;
        }
		return head;
	}
	
	public static void main(String[] args) {
		Node<Integer> head = TakeLinkedListInput();
		head=removeDuplicates(head);
		PrintLinkedList(head);
	}
}
