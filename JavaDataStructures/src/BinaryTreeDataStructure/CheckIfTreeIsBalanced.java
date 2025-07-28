package BinaryTreeDataStructure;

import java.util.Scanner;

public class CheckIfTreeIsBalanced {
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
	
	public static boolean isBalanced(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return true;
		}
		int leftHeight=height(root.left);
		int rightHeight=height(root.right);
		if(leftHeight != rightHeight) {
			return false;
		}
		return isBalanced(root.left) && isBalanced(root.right);
	}
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = TakeTreeInputBetter(true,0,true);
		
	}

}
