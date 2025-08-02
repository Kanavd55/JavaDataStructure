package BinaryTreeDataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ElementsBetweenK1AndK2 {
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
	public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root,int k1,int k2){
		if(root==null) {
			return;
		}
		if(root.left!=null) {
			elementsInRangeK1K2(root.left,k1,k2);
		}
		if(root.data>=k1 && root.data<=k2) {
			System.out.print(root.data+" ");
		}
		if(root.right!=null) {
			elementsInRangeK1K2(root.right,k1,k2);
		}
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = TakeTreeInputLevelWise();
		Scanner s = new Scanner(System.in);
		int k1 = s.nextInt();
		int k2 = s.nextInt();
		elementsInRangeK1K2(root,k1,k2);
		
	}
}
