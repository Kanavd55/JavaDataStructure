package LinkedList;

public class LinkedListUse {
	
	public static<T> void printLinkedList(Node<T> node) {
		Node<T> temp=node;
		while(temp!=null) {
			System.out.println(temp.data);
			temp=temp.next;
		}
	}
	public static void main(String[] args) {
		Node<Integer> n1 = new Node<Integer>(10);
		Node<Integer> n2 = new Node<Integer>(20);
		Node<Integer> n3 = new Node<Integer>(30);
		Node<Integer> n4 = new Node<Integer>(40);
		Node<Integer> n5 = new Node<Integer>(50);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		printLinkedList(n1);
	}
}
