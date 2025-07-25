//Problem statement
//You have been given a singly linked list of integers along with an integer 'N'. Write a function to append the last 'N' nodes towards the front of the singly linked list and returns the new head to the list.
//
//Hint:
//Identify how many pointers you require and try traversing them to right places and connect nodes accordingly also don't forget to disconnect what's required else it could create cycles.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//1 <= t <= 10^2
//0 <= M <= 10^5
//0 <= N < M
//Time Limit: 1sec
//
//Where 'M' is the size of the singly linked list.
//Remember/Consider :
//While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
//Sample Input 1 :
//2
//1 2 3 4 5 -1
//3
//10 20 30 40 50 60 -1
//5
//Sample Output 1 :
//3 4 5 1 2
//20 30 40 50 60 10
//Sample Input 2 :
//1
//10 6 77 90 61 67 100 -1
//4
//Sample Output 2 :
//90 61 67 100 10 6 77 
// Explanation to Sample Input 2 :
//We have been required to move the last 4 nodes to the front of the list. Here, "90->61->67->100" is the list which represents the last 4 nodes. When we move this list to the front then the remaining part of the initial list which is, "10->6->77" is attached after 100. Hence, the new list formed with an updated head pointing to 90.

package LinkedList;

import java.util.Scanner;

public class AppendLastNtoFirst {
	
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
	
	public static Node<Integer> appendLastNToFirst(Node<Integer> head, int n) {
		//Your code goes here
		if(n==0) {
			return head;
		}
		if(head==null){
			return head;
		}
		int length = length(head);
		Node<Integer> tail = head;
		while(tail.next!=null) {
			tail=tail.next;
		}
		int pos = length - n;
		Node<Integer> prev=head;
		Node<Integer> next=head.next;
		int i=0;
		while(i!=pos-1) {
			prev=prev.next;
			next=prev.next;
			i++;
		}
		prev.next=null;
		tail.next=head;
		return next;
		
	}
	
	
	public static void main(String[] args) {
		Node<Integer> head = TakeLinkedListInput();
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		head=appendLastNToFirst(head,n);
		PrintLinkedList(head);
	}
}
