//Problem statement
//For a given a Binary Tree of type integer, print it in a level order fashion where each level will be printed on a new line. Elements on every level will be printed in a linear fashion and a single space will separate them.
//
//Example:
//alt txt
//
//For the above-depicted tree, when printed in a level order fashion, the output would look like:
//
//10
//20 30 
//40 50 60
//Where each new line denotes the level in the tree.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//1 <= N <= 10^5
//Where N is the total number of nodes in the binary tree.
//
//Time Limit: 1 sec
//Sample Input 1:
//10 20 30 40 50 -1 60 -1 -1 -1 -1 -1 -1 
//Sample Output 1:
//10 
//20 30 
//40 50 60 
//Sample Input 2:
//8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
//Sample Output 2:
//8 
//3 10 
//1 6 14 
//4 7 13 


package BinaryTreeDataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LevelOrderTraversal {
	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		//Your code goes here
		if(root==null) {
			return;
		}
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()) {
			BinaryTreeNode<Integer> node = queue.poll();
			if(node==null) {
				System.out.println();
				if(queue.isEmpty()) {
					break;
				}else {
					queue.add(null);
				}
			}else {
				System.out.print(node.data+" ");
				if(node.left!=null) {
					queue.add(node.left);
				}
				if(node.right!=null) {
					queue.add(node.right);
				}
			}
		}
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
		printLevelWise(root);
	}

}
