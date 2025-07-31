//Problem statement
//For a given preorder and inorder traversal of a Binary Tree of type integer stored in an array/list, create the binary tree using the given two arrays/lists. You just need to construct the tree and return the root.
//
//Note: Assume that the Binary Tree contains only unique elements.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//1 <= N <= 10^3
//Where N is the total number of nodes in the binary tree.
//
//Time Limit: 1 sec
//Sample Input 1:
//7
//1 2 4 5 3 6 7 
//4 2 5 1 6 3 7 
//Sample Output 1:
//1 
//2 3 
//4 5 6 7 
//Sample Input 2:
//6
//5 6 2 3 9 10 
//2 6 3 9 5 10 
//Sample Output 2:
//5 
//6 10 
//2 3 
//9 

package BinaryTreeDataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConstructTreeUisngPreOrderAndInOrder {
	public static BinaryTreeNode<Integer> buildTreeHelper(int[] preOrder, int[] inOrder,int siPre,int eiPre,int siIn,int eiIn) {
		//Your code goes here
		if(siPre>eiPre) {
			return null;
		}
		int rootData = preOrder[siPre];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		int rootIndex = -1;
		for(int i=siIn;i<inOrder.length;i++) {
			if(inOrder[i]==rootData) {
				rootIndex=i;
				break;
			}
		}
		int siInLeft = siIn;
		int eiInLeft = rootIndex-1;
		int siInRight = rootIndex+1;
		int eiInRight = eiIn;
		int siPreleft = siPre+1;
		int eiPreRight = eiPre;
		int InOrderLengthLeft = eiInLeft - siInLeft + 1;
		int eiPreLeft = siPreleft + InOrderLengthLeft -1;
		int siPreRight = eiPreLeft + 1 ;
		BinaryTreeNode<Integer> leftNode = buildTreeHelper(preOrder,inOrder,siPreleft,eiPreLeft,siInLeft,eiInLeft);
		BinaryTreeNode<Integer> rightNode = buildTreeHelper(preOrder,inOrder,siPreRight,eiPreRight,siInRight,eiInRight);
		root.left=leftNode;
		root.right=rightNode;
		return root;
		
	}
	public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
		//Your code goes here
		BinaryTreeNode<Integer> root = buildTreeHelper(preOrder,inOrder,0,preOrder.length-1,0,inOrder.length-1);
		return root;
	}
	
	public static int[] TakeTreeArrayInput(int length) {
		Scanner s =	new Scanner(System.in);
		int[] arr = new int[length];
		for(int i=0;i<length;i++) {
			arr[i]=s.nextInt();
		}
		return arr;
	}
	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		//Your code goes here
		if(root==null) {
			return;
		}
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()) {
			BinaryTreeNode<Integer> node = queue.poll();
			if(node==null) {
				System.out.println();
				if(queue.isEmpty()) {
					break;
				}else {
					queue.add(null);
				}
			}else {
				System.out.print(node.data+" ");
				if(node.left!=null) {
					queue.add(node.left);
				}
				if(node.right!=null) {
					queue.add(node.right);
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int length = s.nextInt();
		int[] preOrder = TakeTreeArrayInput(length);
		int[] inOrder = TakeTreeArrayInput(length);
		BinaryTreeNode<Integer> root = buildTree(preOrder,inOrder);
		printLevelWise(root);
	}
}
