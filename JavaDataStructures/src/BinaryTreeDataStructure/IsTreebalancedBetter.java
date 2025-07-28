package BinaryTreeDataStructure;

import java.util.Scanner;

public class IsTreebalancedBetter {
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
	
	public static BinaryTreeNodeBetter isTreeBalancedImproved(BinaryTreeNode<Integer> root) {
		if(root==null) {
			BinaryTreeNodeBetter Node = new BinaryTreeNodeBetter();
			Node.height=0;
			Node.isBalanced=true;
			return Node;
		}
		BinaryTreeNodeBetter leftChild = isTreeBalancedImproved(root.left);
		BinaryTreeNodeBetter rightChild = isTreeBalancedImproved(root.right);
		int height = 1 + Math.max(leftChild.height,rightChild.height);
		boolean isBalanced = true;
		if(leftChild.height!=rightChild.height) {
			isBalanced=false;
		}
		if(!leftChild.isBalanced || !rightChild.isBalanced) {
			isBalanced=false;
		}
		BinaryTreeNodeBetter rootNode = new BinaryTreeNodeBetter();
		rootNode.height=height;
		rootNode.isBalanced=isBalanced;
		return rootNode;
	}
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = TakeTreeInputBetter(true,0,true);
		BinaryTreeNodeBetter rootNode = isTreeBalancedImproved(root);
		System.out.println(rootNode.isBalanced);
	}

}
