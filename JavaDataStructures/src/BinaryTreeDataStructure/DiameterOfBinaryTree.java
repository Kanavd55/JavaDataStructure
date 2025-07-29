package BinaryTreeDataStructure;

import java.util.Scanner;

public class DiameterOfBinaryTree {
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
	
	public static DiameterHeightNode diameterOfBinaryTreeBetter(BinaryTreeNode<Integer> root) {
		if(root==null) {
			DiameterHeightNode Node = new DiameterHeightNode(0,0);
			return Node;
		}
		DiameterHeightNode leftChild = diameterOfBinaryTreeBetter(root.left);
		DiameterHeightNode rightChild = diameterOfBinaryTreeBetter(root.right);
		int maxDiameter = 1 + leftChild.height + rightChild.height;
		int height = 1 + Math.max(leftChild.height, rightChild.height);
		int diameter = Math.max(maxDiameter, Math.max(leftChild.diameter, rightChild.diameter));
		DiameterHeightNode rootNode = new DiameterHeightNode(height,diameter);
		return rootNode;
	}
	public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
		//Your code goes here
		return diameterOfBinaryTreeBetter(root).diameter;
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = TakeTreeInputBetter(true,0,true);
	}
}
