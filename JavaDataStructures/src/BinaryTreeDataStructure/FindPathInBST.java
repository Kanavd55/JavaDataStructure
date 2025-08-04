//Problem statement
//Given a BST and an integer k. Find and return the path from the node with data k and root (if a node with data k is present in given BST) in a list. Return empty list otherwise.
//
//Note: Assume that BST contains all unique elements.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//Time Limit: 1 second   
//Sample Input 1:
//8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
//2
//
//
//Sample Output 1:
//2 5 8

package BinaryTreeDataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;

public class FindPathInBST {
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
	
    public static PathAndIsPresent<Integer> getPathHelper(BinaryTreeNode<Integer> root, int data){
		if(root==null) {
			PathAndIsPresent<Integer> node = new PathAndIsPresent<>();
			return node;
		}
		if(root.data==data) {
			PathAndIsPresent<Integer> node = new PathAndIsPresent<>();
			node.Path.add(root.data);
			node.isPresent=true;
			return node;
		}
		PathAndIsPresent<Integer> ans = new PathAndIsPresent<>();
		
		if(data<root.data) {
			PathAndIsPresent<Integer> leftNode = getPathHelper(root.left,data);
			if(leftNode.isPresent) {
				ans.Path=leftNode.Path;
				ans.Path.add(root.data);
				ans.isPresent=true;
				return ans;
			}
		}
		if(data>=root.data) {
			PathAndIsPresent<Integer> rightNode = getPathHelper(root.right,data);
			if(rightNode.isPresent) {
				ans.isPresent=true;
				ans.Path=rightNode.Path;
				ans.Path.add(root.data);
				return ans;
			}
		}
		 return ans;
	}
	
	public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data){
		PathAndIsPresent<Integer> node = getPathHelper(root,data);
		return node.Path;
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = TakeTreeInputLevelWise();
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
	    ArrayList<Integer> list = getPath(root,data);
	    for(int i =0;i<list.size();i++) {
	    	System.out.print(list.get(i)+" ");
	    }
	}
}
