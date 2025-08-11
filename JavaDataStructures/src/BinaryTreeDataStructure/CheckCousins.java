//Given the binary Tree and two nodes say ‘p’ and ‘q’. Determine whether the two nodes are cousins of each other or not. Two nodes are said to be cousins of each other if they are at same level of the Binary Tree and have different parents.
//
//Do it in O(n).
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//1 <= N <= 10^5
//
//Sample Input :
//5 6 10 2 3 4 -1 -1 -1 -1 9 -1 -1 -1 -1
//2
//4
//Sample Output :
//true

package BinaryTreeDataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CheckCousins {
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
	
	public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q) {
		// Write your code here
		if(root==null) {
			return false;
		}
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		boolean isP=false;
		boolean isQ=false;
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()) {
			BinaryTreeNode<Integer> node = queue.poll();
			if(node==null) {
				if(queue.isEmpty()) {
					break;
				}else {
					queue.add(null);
					isP=false;
					isQ=false;
				}
			}else {
				if(node.data==p) {
					isP=true;
				}else if(node.data==q) {
					isQ=true;
				}
				if(isP && isQ) {
					return true;
				}
				if(node.left!=null) {
					queue.add(node.left);
				}if(node.right!=null) {
					queue.add(node.right);
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = TakeTreeInputLevelWise();
		Scanner s = new Scanner(System.in);
		int P = s.nextInt();
		int Q = s.nextInt();
		System.out.println(isCousin(root,P,Q));
	}
}
