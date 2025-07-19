package LinkedList;
import java.util.LinkedList;
public class LinkedListUse {
	
	public static<T> void printLinkedList(Node<T> node) {
		Node<T> temp=node;
		while(temp!=null) {
			System.out.println(temp.data);
			temp=temp.next;
		}
	}
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(50);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		list.remove();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		list.remove(1);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
	}
}
