//Problem statement
//For a given a binary tree of integers and an integer X, find and return the total number of nodes of the given binary tree which are having data greater than X.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//1 <= N <= 10^5
//Where N is the total number of nodes in the binary tree.
//
//Time Limit: 1 sec
//Sample Input 1:
//1 4 2 3 -1 -1 -1
//2
//Sample Output 1:
//2
//Explanation for Sample Input 1:
//Out of the four nodes of the given binary tree, [3, 4] are the node data that are greater than X = 2.
//Sample Input 2:
//5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
//5
//Sample Output 2:
//3

package BinaryTreeDataStructure;

import java.util.Scanner;

public class NodesGreaterThanX {
	public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
		//Your code goes here
		if(root==null){
			return 0;
		}
		int leftCount = countNodesGreaterThanX(root.left,x);
		int rightCount = countNodesGreaterThanX(root.right,x);
		if(root.data>x){
			return leftCount+rightCount+1;
		}else{
			return leftCount+rightCount;
		}
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
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(countNodesGreaterThanX(root,n));
	}
}
