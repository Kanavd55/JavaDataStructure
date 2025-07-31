//Problem statement
//For a given Binary Tree of type integer and a number K, print out all root-to-leaf paths where the sum of all the node data along the path is equal to K.
//
//Example:
//alt txt
//
//If you see in the above-depicted picture of Binary Tree, we see that there are a total of two paths, starting from the root and ending at the leaves which sum up to a value of K = 13.
//
//The paths are:
//a. 2 3 4 4
//b. 2 3 8
//
//One thing to note here is, there is another path in the right sub-tree in reference to the root, which sums up to 13 but since it doesn't end at the leaf, we discard it.
//The path is: 2 9 2(not a leaf)
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1:
//2 3 9 4 8 -1 2 4 -1 -1 -1 6 -1 -1 -1 -1 -1
//13
// Sample Output 1:
//2 3 4 4 
//2 3 8
//Sample Input 2:
//5 6 7 2 3 -1 1 -1 -1 -1 9 -1 -1 -1 -1
//13
// Sample Output 2:
//5 6 2
//5 7 1
///*
//	
//	Following is the structure used to represent the Binary Tree Node
//
//	class BinaryTreeNode<T> {
//		T data;
//		BinaryTreeNode<T> left;
//		BinaryTreeNode<T> right;
//
//		public BinaryTreeNode(T data) {
//
//
//
//
//
//
//
//
//
//



package BinaryTreeDataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PathSumRootToLeaf {
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
	
	public static void rootToLeafPathsSumToKHelper(BinaryTreeNode<Integer> root, int k,String s) {
		//Your code goes here
		if(root==null) {
			return;
		}
		if(root.data==k && root.left==null && root.right==null) {
			s=s+root.data;
			System.out.println(s);
			return;
		}
		s=s+root.data+" ";
		rootToLeafPathsSumToKHelper(root.left,k-root.data,s);
		rootToLeafPathsSumToKHelper(root.right,k-root.data,s);
	}
	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
		//Your code goes here
		String s = "";
		rootToLeafPathsSumToKHelper(root,k,s);
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = TakeTreeInputLevelWise();
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		rootToLeafPathsSumToK(root,k);
	}
}
