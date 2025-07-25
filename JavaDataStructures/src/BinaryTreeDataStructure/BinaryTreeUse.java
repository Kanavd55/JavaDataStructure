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
	
	public static BinaryTreeNode<Integer> TakeTreeinput(){
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		if(rootData==-1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		BinaryTreeNode<Integer> leftChild = TakeTreeinput();
		BinaryTreeNode<Integer> rightChild = TakeTreeinput();
		root.left=leftChild;
		root.right=rightChild;
		return root;
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
		PrintBinaryTreeRecursively(root);
		PrintTreeDetailed(root);
	}
}
