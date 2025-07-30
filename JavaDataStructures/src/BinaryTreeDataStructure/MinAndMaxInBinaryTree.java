//Problem statement
//For a given a Binary Tree of type integer, find and return the minimum and the maximum data values.
//
//Return the output as an object of Pair class, which is already created.
//
//Note:
//All the node data will be unique and hence there will always exist a minimum and maximum node data.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//2 <= N <= 10^5
//Where N is the total number of nodes in the binary tree.
//
//Time Limit: 1 sec
//Sample Input 1:
//8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
//Sample Output 1:
//1 14
//Sample Input 2:
//10 20 60 -1 -1 3 50 -1 -1 -1 -1 
//Sample Output 2:
//3 60


package BinaryTreeDataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MinAndMaxInBinaryTree {
	public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
		//Your code goes here
		if(root==null){
			Pair<Integer, Integer> node = new Pair<>(Integer.MAX_VALUE,Integer.MIN_VALUE);
			return node;
		}
		Pair<Integer, Integer> leftNode = getMinAndMax(root.left);
		Pair<Integer,Integer> rightNode = getMinAndMax(root.right);
		int minimum = Math.min(root.data, Math.min(leftNode.minimum, rightNode.minimum));
		int maximum = Math.max(root.data, Math.max(leftNode.maximum, rightNode.maximum));
		Pair<Integer, Integer> newNode = new Pair<Integer, Integer>(minimum,maximum);
		return newNode;
	}
		
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
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = TakeTreeInputLevelWise();
		Pair<Integer,Integer> node = getMinAndMax(root);
		System.out.println(node.minimum);
		PrintBinaryTreeRecursively(root);
	}
}
