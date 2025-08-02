//Problem statement
//Given a sorted integer array A of size n, which contains all unique elements. You need to construct a balanced BST from this input array. Return the root of constructed BST.
//
//Note: If array size is even, take first mid as root.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//Time Limit: 1 second
//Sample Input 1:
//7
//1 2 3 4 5 6 7
//Sample Output 1:
//4 2 1 3 6 5 7 


package BinaryTreeDataStructure;

import java.util.Scanner;

public class ConstructBST {
	public static BinaryTreeNode<Integer> SortedArrayToBSTHelper(int[] arr, int n,int si,int ei){
		if(si>ei){
			return null;
		}
		int rootIndex = (si+ei)/2;
		int rootData= arr[rootIndex];
		BinaryTreeNode<Integer> root = new  BinaryTreeNode<Integer>(rootData);
		BinaryTreeNode<Integer> leftNode = SortedArrayToBSTHelper(arr,n,si,rootIndex-1);
		BinaryTreeNode<Integer> rightNode =  SortedArrayToBSTHelper(arr,n,rootIndex+1,ei);
		root.left=leftNode;
		root.right=rightNode;
		return root;
	}

	public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){
		return  SortedArrayToBSTHelper(arr, n,0,n-1);
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for(int i =0;i<n;i++) {
			arr[i]=s.nextInt();
		}
		SortedArrayToBST(arr,n);
	}
}
