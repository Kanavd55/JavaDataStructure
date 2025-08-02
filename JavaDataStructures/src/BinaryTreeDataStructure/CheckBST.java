//Problem statement
//Given a binary tree with N number of nodes, check if that input tree is BST (Binary Search Tree). If yes, return true, return false otherwise.
//
//Note:
//Duplicate elements should be kept in the right subtree.
//Detailed explanation ( Input/output format, Notes, Images )
//Input format :
//The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have a left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
//Output format :
//The first and only line of output contains either true or false.
//Constraints :
//0 <= Number of edges <= 10^5
//Time Limit: 1 second
//Sample Input 1 :
//3 1 5 -1 2 -1 -1 -1 -1
//
//
//Sample Output 1 :
//true
//Sample Input 2 :
//5 2 10 0 1 -1 15 -1 -1 -1 -1 -1 -1
//
//
//Sample Output 2 :
//false


package BinaryTreeDataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CheckBST {
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

	public static isBST isBSTHelper(BinaryTreeNode<Integer> root) {
		if(root==null) {
			isBST node = new isBST(true,Integer.MIN_VALUE,Integer.MAX_VALUE);
			return node;
		}
		isBST isLeftBST = isBSTHelper(root.left);
		isBST isRightBST = isBSTHelper(root.right);
		isBST ans = new isBST(true, Integer.MIN_VALUE,Integer.MAX_VALUE);
		ans.maximum= Math.max(root.data,Math.max(isLeftBST.maximum,isRightBST.maximum));
		ans.minimum=Math.min(root.data, Math.min(isLeftBST.minimum, isRightBST.minimum));
		if(!isLeftBST.isBST || !isRightBST.isBST) {
			ans.isBST=false;
		}
		if(isLeftBST.maximum>=root.data || root.data>isRightBST.minimum) {
			ans.isBST=false;
			return ans;
		}
		return ans;
	}

	public static boolean isBST(BinaryTreeNode<Integer> root) {
		isBST node = isBSTHelper(root);
		return node.isBST;
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = TakeTreeInputLevelWise();
		System.out.println(isBST(root));
	}
}
