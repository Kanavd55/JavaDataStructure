//Problem statement
//You have been given a singly linked list of integers, an integer value called 'data' and a position with the name 'pos.'
//
// Write a function to add a node to the list with the 'data' at the specified position, 'pos.'
//
//Note :
//Assume that the Indexing for the singly linked list always starts from 0.
//
//If the position is greater than the length of the singly linked list, you should return the same linked list without any change.
// Illustration :
//The following images depict how the insertion has been taken place.
//Image-I :
//
//Alt txt
//
//Image-II :
//
//Alt txt
//
//Image-III :
//
//Alt txt
//
//Image-IV :
//
//Alt txt
//
//Detailed explanation ( Input/output format, Notes, Images )
// Constraints :
//1 <= t <= 10^2
//0 <= N <= 10^5
//pos >= 0
//Time Limit: 1sec
//Sample Input 1 :
//1
//3 4 5 2 6 1 9 -1
//3 100
//Sample Output 1 :
//3 4 5 100 2 6 1 9
//Sample Input 2 :
//2
//3 4 5 2 6 1 9 -1
//0 20
//10 98 7 66 8 -1
//5 99
//Sample Output 2 :
//20 3 4 5 2 6 1 9
//10 98 7 66 8 99 

package LinkedList;

import java.util.Scanner;

public class InsertNode {
	
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
	
	public static Node<Integer> insert(Node<Integer> head, int pos, int data){
		//Your code goes here
		Node<Integer> current=head;
		Node<Integer> next=head.next;
		int count=0;
		if(pos==0) {
			current=new Node<Integer>(data);
			current.next=head;
			return current;
		}
		while(current!=null) {
			if(count+1==pos) {
				Node<Integer> node = new Node<Integer>(data);
				current.next=node;
				node.next=next;
				break;
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
		Node<Integer> head=TakeLinkedListInput();
		Scanner s = new Scanner(System.in);
		int position = s.nextInt();
		int data = s.nextInt();
		head=insert(head,position,data);
	}
}
