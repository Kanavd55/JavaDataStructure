//Problem statement
//For a given Binary Tree of integers, find and return the height of the tree. Height is defined as the total number of nodes along the longest path from the root to any of the leaf node.
//
//Example:
//ALTIMAGE
//
//Height of the given tree is 3. 
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//0 <= N <= 10^5
//Where N is the total number of nodes in the binary tree.
//
//Time Limit: 1 sec
//Sample Input 1:
//10 20 30 40 50 -1 -1 -1 -1 -1 -1
//Sample Output 1:
//3
//Sample Input 2:
//3 -1 -1
//Sample Output 2:
//1

package BinaryTreeDataStructure;

import java.util.Scanner;

public class HeightOfBinaryTree {
	
	public static int height(BinaryTreeNode<Integer> root) {
		//Your code goes here
		if(root==null){
			return 0;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		int maxChildHeight = Math.max(leftHeight,rightHeight);
		return 1+maxChildHeight;
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
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = TakeTreeInputBetter(true,0,true);
		System.out.println(height(root));
	}
}
