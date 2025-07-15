package LinkedList;
import java.util.Scanner;
public class IncremenetLinkedList {
	public static void PrintLinkedList(Node<Integer> head) {
		Node<Integer> temp = head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	
	public static void Increment(Node<Integer> head) {
		Node<Integer> temp = head;
		while(temp!=null) {
			temp.data=temp.data+1;
			temp=temp.next;
		}
	}
	
	public static Node<Integer> TakeLinkedListInput(){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Node<Integer> head = new Node<Integer>(n);
		Node<Integer> tail = head;
		while(n!=-1) {
			n=s.nextInt();
			if(n==-1) {
				break;
			}
			Node<Integer> node= new Node<Integer>(n);
			tail.next=node;
			tail=node;
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
	
	 public static void printIthNode(Node<Integer> head, int i){
		 Node<Integer> tail=head;
		 int index=0;
		 while(tail!=null) {
			 if(index==i) {
				 System.out.println(tail.data);
				 break;
			 }
			 index++;
			 tail=tail.next;
		 }
	  }
	
	public static void main(String[] args) {
		Node<Integer> head=TakeLinkedListInput();
		PrintLinkedList(head);
		Increment(head);
		PrintLinkedList(head);
		System.out.println(length(head));
	}
}
