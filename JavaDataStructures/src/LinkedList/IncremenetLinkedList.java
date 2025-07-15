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
