//Problem statement
//For a given a Binary Tree of type integer, duplicate every node of the tree and attach it to the left of itself.
//
//The root will remain the same. So you just need to insert nodes in the given Binary Tree.
//
//Example:
//alt txt
//
//After making the changes to the above-depicted tree, the updated tree will look like this.
//alt txt
//
//You can see that every node in the input tree has been duplicated and inserted to the left of itself.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//1 <= N <= 10^5
//Where N is the total number of nodes in the binary tree.
//
//Time Limit: 1 sec
//Sample Input 1:
//10 20 30 40 50 -1 60 -1 -1 -1 -1 -1 -1
//Sample Output 1:
//10 
//10 30 
//20 30 60 
//20 50 60 
//40 50 
//40 
//Sample Input 2:
//8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
//Sample Output 2:
//8 
//8 10 
//5 10 
//5 6 
//2 6 7 
//2 7


package BinaryTreeDataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CreateAndInsertDuplicateNode {
	public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
		//Your code goes here
		if(root==null){
			return;
		}
		insertDuplicateNode(root.left);
		insertDuplicateNode(root.right);
		BinaryTreeNode<Integer> temp = root.left;
		BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(root.data);
		root.left=newNode;
		newNode.left=temp;
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
		insertDuplicateNode(root);
		PrintBinaryTreeRecursively(root);
	}
}
