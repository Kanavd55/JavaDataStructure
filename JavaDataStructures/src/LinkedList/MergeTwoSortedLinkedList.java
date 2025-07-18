package LinkedList;

import java.util.Scanner;

public class MergeTwoSortedLinkedList {
	
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
	
	public static Node<Integer> mergeTwoSorteds(Node<Integer> head1, Node<Integer> head2) {
        //Your code goes here
        if(head1==null){
            return head2;
        }
        if(head2==null){
            return head1;
        }
        Node<Integer> Tail1 = head1;
        Node<Integer> Tail2 = head2;
        Node<Integer> Head = null;
        Node<Integer> Tail = null;
        if(Tail1.data<Tail2.data){
            Head=Tail1;
            Tail=Head;
            Tail1=Tail1.next;
        }else{
            Head=Tail2;
            Tail=Head;
            Tail2=Tail2.next;
        }
        while(Tail1!=null && Tail2!=null){
            if(Tail1.data<Tail2.data){
                Tail.next=Tail1;
                Tail1=Tail1.next;
            }else{
                Tail.next=Tail2;
                Tail2=Tail2.next;
            }
            Tail=Tail.next;
        }
        if(Tail1==null){
            Tail.next=Tail2;
        }else if(Tail2==null){
            Tail.next=Tail1;
        }
        return Head;
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
		Node<Integer> head1=TakeLinkedListInput();
		Node<Integer> head2=TakeLinkedListInput();
		Node<Integer> head=mergeTwoSorteds(head1,head2);
		printRecursive(head);
	}
}
