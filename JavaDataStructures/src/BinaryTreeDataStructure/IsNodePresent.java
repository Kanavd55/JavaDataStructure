package BinaryTreeDataStructure;

import java.util.Scanner;

public class IsNodePresent {
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
	
	public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
	    //Your code goes here
		if(root==null){
			return false;
		}
		if(root.data==x){
			return true;
		}
		boolean isLeftNodePresent=isNodePresent(root.left,x);
		boolean isRightNodePresent=isNodePresent(root.right,x);
		return isLeftNodePresent || isRightNodePresent;
	}
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = TakeTreeInputBetter(true,0,true);
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		System.out.println(isNodePresent(root,x));
	}
}
