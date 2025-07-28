//Problem statement
//For a given Binary Tree of type integer, update it with its corresponding mirror image.
//
//Example:
//Alt text
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//1 <= N <= 10^5
//Where N is the total number of nodes in the binary tree.
//
//Time Limit: 1 sec
//Sample Input 1:
//1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
//Sample Output 1:
//1 
//3 2 
//7 6 5 4
//Sample Input 2:
//5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
//Sample Output 2:
//5 
//6 10 
//3 2 
//9

package BinaryTreeDataStructure;

import java.util.Scanner;

public class MirrorABinaryTree {
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
	public static void MirrorBinaryTree(BinaryTreeNode<Integer> root){
		if(root==null) {
			return ;
		}
		BinaryTreeNode<Integer> temp = root.left;
		root.left=root.right;
		root.right=temp;
		MirrorBinaryTree(root.left);
		MirrorBinaryTree(root.right);
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = TakeTreeInputBetter(true,0,true);
		MirrorBinaryTree(root);
		PrintBinaryTreeRecursively(root);
	}
}
