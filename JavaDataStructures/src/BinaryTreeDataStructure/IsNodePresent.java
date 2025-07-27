//Problem statement
//For a given Binary Tree of type integer and a number X, find whether a node exists in the tree with data X or not.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//1 <= N <= 10^5
//
//Where N is the total number of nodes in the binary tree.
//
//Time Limit: 1 sec.
//Sample Input 1:
//8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
//7
//Sample Output 1:
//true
//Explanation For Output 1:
//Clearly, we can see that 7 is present in the tree. So, the output will be true.
//Sample Input 2:
//2 3 4 -1 -1 -1 -1
//10
//Sample Output 2:
//false

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
