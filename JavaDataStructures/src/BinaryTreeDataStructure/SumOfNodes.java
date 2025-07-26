package BinaryTreeDataStructure;

import java.util.Scanner;

public class SumOfNodes {
	public static void PrintBinaryTreeRecursively(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		System.out.println(root.data);
		PrintBinaryTreeRecursively(root.left);
		PrintBinaryTreeRecursively(root.right);
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
	
	public static int getSum(BinaryTreeNode<Integer> root) {
		//Your code goes here.
		if(root==null){
			return 0;
		}
		if(root.left==null && root.right == null){
			return root.data;
		}
		int leftSum = getSum(root.left);
		int rightSum = getSum(root.right);
		return root.data+leftSum+rightSum;
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = TakeTreeInputBetter(true,0,true);
		System.out.println(getSum(root));
	}
}
