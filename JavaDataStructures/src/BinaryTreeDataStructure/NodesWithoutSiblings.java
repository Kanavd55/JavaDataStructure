//Problem statement
//For a given Binary Tree of type integer, print all the nodes without any siblings.
//
//Example Input :
//1 4 5 6 -1 -1 7 20 30 80 90 -1 -1 -1 -1 -1 -1 -1 -1
//Explanation:
//The input tree when represented in a two-dimensional plane, it would look like this:     
//alt txt
//
//In respect to the root, node data in the left subtree that satisfy the condition of not having a sibling would be 6, taken in a top-down sequence. Similarly, for the right subtree, 7 is the node data without any sibling.
//
//Since we print the siblings in the left-subtree first and then the siblings from the right subtree, taken in a top-down fashion, we print 6 7.
//Example Output:
//6 7  
//Detailed explanation ( Input/output format, Notes, Images )
// Constraints:
//1 <= N <= 10^5
//Where N is the total number of nodes in the binary tree.
//
//Time Limit: 1 second
//Sample Input 1:
//5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
//Sample Output 1:
//9 


package BinaryTreeDataStructure;

import java.util.Scanner;

public class NodesWithoutSiblings {
	public static BinaryTreeNode<Integer> TakeTreeInputBetter(boolean isRoot,int parentData,boolean isLeft){
		if(isRoot) {
			System.out.println("Enter the root data");
		}
		else{
			if(isLeft) {
				System.out.println("Enter left child of "+ parentData);
			}else {
				System.out.println("Enter right child of "+ parentData);
			}
		}
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		if(rootData==-1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		BinaryTreeNode<Integer> leftChild = TakeTreeInputBetter(false,rootData,true);
		BinaryTreeNode<Integer> rightChild = TakeTreeInputBetter(false,rootData,false);
		root.left=leftChild;
		root.right=rightChild;
		return root;
	}
	public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
		//Your code goes here
		if(root==null){
			return;
		}
		if(root.right==null && root.left!=null){
			System.out.print(root.left.data+" ");
		}
		if(root.left==null && root.right!=null){
			System.out.print(root.right.data+" ");
		}
		printNodesWithoutSibling(root.left);
		printNodesWithoutSibling(root.right);
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = TakeTreeInputBetter(true,0,true);
		printNodesWithoutSibling(root);
	}
}
