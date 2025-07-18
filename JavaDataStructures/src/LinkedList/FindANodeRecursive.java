package LinkedList;

import java.util.Scanner;

public class FindANodeRecursive {
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
	
	public static int findNodeRec(Node<Integer> head, int n) {
    	//Your code goes here
        if(head==null ){
            return -1;
        }
        if(head.data==n){
            return 0;
        }
        int smallOutput = findNodeRec(head.next,n);
        if(smallOutput==-1){
            return -1;
        }else{
            return smallOutput+1;
        }
	}
	public static void main(String[] args) {
		Node<Integer> Head = TakeLinkedListInput();
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(findNodeRec(Head,n));
	}
}
