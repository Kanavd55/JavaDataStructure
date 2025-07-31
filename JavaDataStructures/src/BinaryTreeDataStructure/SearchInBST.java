//Problem statement
//Given a BST and an integer k. Find if the integer k is present in given BST or not. You have to return true, if node with data k is present, return false otherwise.
//
//Note:
//Assume that BST contains all unique elements.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//Time Limit: 1 second
//Sample Input 1 :
//8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
//2
//Sample Output 1 :
//true
//Sample Input 2 :
//8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
//12
//Sample Output 2 :
//false

package BinaryTreeDataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SearchInBST {
	public static BinaryTreeNode<Integer> TakeTreeInputLevelWise(){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the root data");
		int n = s.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(n);
		if(root.data==-1) {
			return root;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode data = queue.poll();
			System.out.println("Enter the leftChild of "+data.data);
			int leftNodeData = s.nextInt();
			if(leftNodeData==-1) {
				data.left=null;
			}else {
				BinaryTreeNode<Integer> leftNode = new BinaryTreeNode<>(leftNodeData);
				data.left=leftNode;
				queue.add(leftNode);
			}
			System.out.println("Enter the rightChild of "+data.data);
			int rightNodeData = s.nextInt();
			if(rightNodeData==-1) {
				data.right=null;
			}else {
				BinaryTreeNode<Integer> rightNode = new BinaryTreeNode<>(rightNodeData);
				data.right=rightNode;
				queue.add(rightNode);
			}
		}
		return root;
	}
	public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
		if(root==null){
			return false;
		}
		if(root.data==k){
			return true;
		}
		if(root.data>k){
			return searchInBST(root.left,k);
		}else{
			return searchInBST(root.right,k);	
		}
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = TakeTreeInputLevelWise();
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		System.out.println(searchInBST(root,k));
	}
}
