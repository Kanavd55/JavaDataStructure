package BinaryTreeDataStructure;
import java.util.Scanner;
public class BinaryTreeUse {
	
	public static void PrintBinaryTreeRecursively(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		System.out.println(root.data);
		PrintBinaryTreeRecursively(root.left);
		PrintBinaryTreeRecursively(root.right);
	}
	
	public static void PrintTreeDetailed(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+":");
		if(root.left!=null) {
			System.out.print("L"+root.left.data+" ");
		}
		if(root.right!=null) {
			System.out.print("R"+root.right.data+" ");
		}
		System.out.println();
		PrintTreeDetailed(root.left);
		PrintTreeDetailed(root.right);
	}
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
		BinaryTreeNode<Integer> left = new BinaryTreeNode<>(2);
		BinaryTreeNode<Integer> right = new BinaryTreeNode<>(3);
		root.left=left;
		root.right=right;
		BinaryTreeNode<Integer> Node = new BinaryTreeNode<>(4);
		BinaryTreeNode<Integer> SecondNode = new BinaryTreeNode<>(5);
		left.right = Node;
		right.left = SecondNode;
		PrintBinaryTreeRecursively(root);
		PrintTreeDetailed(root);
	}
}
