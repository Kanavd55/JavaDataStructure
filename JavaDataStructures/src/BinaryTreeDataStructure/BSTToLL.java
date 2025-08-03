package BinaryTreeDataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BSTToLL {
	public static BinaryTreeNode<Integer> TakeTreeInputLevelWise(){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the root data");
		int n = s.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(n);
		if(root.data==-1) {
			return root;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode data = queue.poll();
			System.out.println("Enter the leftChild of "+data.data);
			int leftNodeData = s.nextInt();
			if(leftNodeData==-1) {
				data.left=null;
			}else {
				BinaryTreeNode<Integer> leftNode = new BinaryTreeNode<>(leftNodeData);
				data.left=leftNode;
				queue.add(leftNode);
			}
			System.out.println("Enter the rightChild of "+data.data);
			int rightNodeData = s.nextInt();
			if(rightNodeData==-1) {
				data.right=null;
			}else {
				BinaryTreeNode<Integer> rightNode = new BinaryTreeNode<>(rightNodeData);
				data.right=rightNode;
				queue.add(rightNode);
			}
		}
		return root;
	}
	public static void PrintBinaryTreeRecursively(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		System.out.println(root.data);
		PrintBinaryTreeRecursively(root.left);
		PrintBinaryTreeRecursively(root.right);
	}
	
    public static DetailsNode<Integer> constructLinkedListHelper(BinaryTreeNode<Integer> root) {
		if(root==null) {
			DetailsNode<Integer> node = new DetailsNode<>();
			return node;
		}
		DetailsNode<Integer> ans = new DetailsNode<>();
		LinkedListNode<Integer> node = new LinkedListNode<Integer>(root.data);
		ans.head=node;
		ans.tail=node;
		DetailsNode<Integer> leftNode = constructLinkedListHelper(root.left);
		DetailsNode<Integer> rightNode = constructLinkedListHelper(root.right);
		if(leftNode.head!=null) {
			ans.head=leftNode.head;
			leftNode.tail.next=node;
			ans.tail=node;
		}
		if(rightNode.head!=null) {
			ans.tail.next=rightNode.head;
			ans.tail=rightNode.tail;
		}
		return ans;
	}
	
	public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
		 DetailsNode<Integer> node = constructLinkedListHelper(root);
		 return node.head;
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = TakeTreeInputLevelWise();
		
	}
}
