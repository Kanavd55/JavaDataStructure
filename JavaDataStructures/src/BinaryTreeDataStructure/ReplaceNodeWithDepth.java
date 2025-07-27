//Problem statement
//For a given a Binary Tree of integers, replace each of its data with the depth of the tree.
//
//Root is at depth 0, hence the root data is updated with 0. Replicate the same further going down the in the depth of the given tree.
//
//The modified tree will be printed in the in-order fashion.
//
//Example:
//Alt text
//
//The above tree after updating will look like this:
//Alt text
//
//Output: 2 1 2 0 2 1 2 (printed in the in-order fashion)
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//1 <= N <= 10^5
//Where N is the total number of nodes in the binary tree.
//
//Time Limit: 1sec
// Sample Input 1:
//2 35 10 2 3 5 2 -1 -1 -1 -1 -1 -1 -1 -1 
//Sample Output 1:
//2 1 2 0 2 1 2 
// Sample Input 2:
//1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
//Sample Output 2:
//2 1 2 0 2 1 2 


package BinaryTreeDataStructure;

import java.util.Scanner;

public class ReplaceNodeWithDepth {
	public static void changeToDepthTreeImproved(BinaryTreeNode<Integer> root,int depth) {
	    //Your code goes here
		if(root==null){
			return;
		}
		root.data=depth;
		changeToDepthTreeImproved(root.left,depth+1);
		changeToDepthTreeImproved(root.right,depth+1);
	}

	public static void changeToDepthTree(BinaryTreeNode<Integer> root) {
	    //Your code goes here
		changeToDepthTreeImproved(root,0);
	}
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
	public static void PrintBinaryTreeRecursively(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		System.out.println(root.data);
		PrintBinaryTreeRecursively(root.left);
		PrintBinaryTreeRecursively(root.right);
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = TakeTreeInputBetter(true,0,true);
		changeToDepthTree(root);
		PrintBinaryTreeRecursively(root);
	}
}
