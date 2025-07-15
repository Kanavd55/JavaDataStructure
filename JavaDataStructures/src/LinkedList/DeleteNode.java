//Problem statement
//You have been given a linked list of integers. Your task is to write a function that deletes a node from a given position, 'POS'.
//
//Note :
//Assume that the Indexing for the linked list always starts from 0.
//
//If the position is greater than or equal to the length of the linked list, you should return the same linked list without any change.
//Illustration :
//The following images depict how the deletion has been performed.
//Image-I :
//
//Alt txt
//
//Image-II :
//
//Alt txt
//
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1 :
//3 4 5 2 6 1 9 -1
//3
//Sample Output 1 :
//3 4 5 6 1 9
//Explanation of Sample Output 1 :
//The data in the node with index 3 is 2 which has been removed.
//Sample Input 2 :
//3 4 5 2 6 1 9 -1
//0
//Sample Output 2 :
//4 5 2 6 1 9
//Constraints :
//0 <= N <= 10^5
//POS >= 0
//
//Time Limit: 1sec
//Expected Complexity :
//Time Complexity  : O(N)
//Space Complexity  : O(1)

package LinkedList;

import java.util.Scanner;

public class DeleteNode {
	
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
	
	public static Node<Integer> deleteNode( Node<Integer> head, int pos) {
		// Write your code here.
		Node<Integer> current=head;
		Node<Integer> next=head.next;
		int count =0;
		if(pos==0) {
			return head.next;
		}
		while(current!=null) {
			if(count+1==pos) {
				if(next!=null) {
					current.next=next.next;
				}else {
					current.next=null;
				}
				return head;
			}else {
				count++;
				current=next;
				if(current!=null) {
					next=current.next;
				}
			}
		}
		return head;
	}
	
	public static void main(String[] args) {
		Node<Integer> head = TakeLinkedListInput();
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		head = deleteNode(head,n);
	}
}
