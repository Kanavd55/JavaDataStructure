// PreOrder Binary Tree Traversals
//Problem statement
//You are given a ‘Binary Tree’.
//
//
//
//Return the preorder traversal of the Binary Tree.
//
//
//
//Example:
//Input: Consider the following Binary Tree:
//Example
//
//Output: 
//Following is the preorder traversal of the given Binary Tree: [1, 2, 5, 3, 6, 4]
//
//
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1:
//1 2 3 5 4 6 7 -1 -1 -1 -1 -1 -1 -1 -1
//
//
// Sample Output 1:
//1 2 5 4 3 6 7
//
//
//Explanation of Sample Input 1:
//The Binary Tree given in the input is as follows:
//Sample1
//
//Sample Input 2:
//5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
//
//
// Sample Output 2:
//5 6 2 3 9 10
//
//
//Explanation of Sample Input 2:
//The Binary Tree given in the input is as follows:
//Sample2
//
//Expected Time Complexity:
//Try to do this in O(n).
//
//
//Constraints:
//1 <= n <= 100000
//where 'n' is the number of nodes in the binary tree.
//
//Time Limit: 1 sec

//Post Order Tree traversals
//Problem statement
//For a given Binary Tree of integers, print the post-order traversal.
//
//ALTIMAGE
//
//The postorder traversal for the given binary tree will be 40 50 20 30 10
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//1 <= N <= 10^6
//Where N is the total number of nodes in the binary tree.
//
//Time Limit: 1 sec
//Sample Input 1:
//1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
// Sample Output 1:
//4 5 2 6 7 3 1 
//Sample Input 2:
//5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
// Sample Output 1:
//2 9 3 6 10 5 

package BinaryTreeDataStructure;

import java.util.Scanner;

public class BinaryTreeTraversals {
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
	public static void preOrder(BinaryTreeNode<Integer> root) {
		//Your code goes here
        if(root==null){
            return ;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
	public static void postOrder(BinaryTreeNode<Integer> root) {
		//Your code goes here
		if(root==null){
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = TakeTreeInputBetter(true,0,true);
		preOrder(root);
		postOrder(root);
	}
}
