//Problem statement
//Given a Binary tree, find the largest BST subtree. That is, you need to find the BST with maximum height in the given binary tree. You have to return the height of largest BST.
//
//Note :
//The binary tree will be consisting of only unique elements.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//1 ≤ Number of nodes ≤ 10^5
//1 ≤ Data of a node ≤ 10^6
//Time Limit: 1 second
//Sample Input 1:
//5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
//
//
//Sample Output 1:
//2



package BinaryTreeDataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LargestBST {
	
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
	
	public static checkBSTAndHeight largestBSTSubtreeHelper(BinaryTreeNode<Integer> root) {
		// Write your code here
		if(root==null) {
			checkBSTAndHeight node = new checkBSTAndHeight(0,true,Integer.MIN_VALUE,Integer.MAX_VALUE);
			return node;
		}
		checkBSTAndHeight leftNode = largestBSTSubtreeHelper(root.left);
		checkBSTAndHeight rightNode = largestBSTSubtreeHelper(root.right);
		if(leftNode.BSTT && rightNode.BSTT && root.data>leftNode.max && root.data<rightNode.min) {
			int height = Math.max(leftNode.height, rightNode.height)+1;
			int max = Math.max(rightNode.max,root.data);
			int min = Math.min(leftNode.min,root.data);
			checkBSTAndHeight node = new checkBSTAndHeight(height,true,max,min);
			return node;
		}else {
			int height = Math.max(leftNode.height, rightNode.height);
			checkBSTAndHeight node = new checkBSTAndHeight(height,false,Integer.MIN_VALUE,Integer.MAX_VALUE);
			return node;
		}
	}
	
	public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
		// Write your code here
		checkBSTAndHeight node = largestBSTSubtreeHelper(root);
		return node.height;
	}
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = TakeTreeInputLevelWise();
		System.out.println(largestBSTSubtree(root));
	}
}
