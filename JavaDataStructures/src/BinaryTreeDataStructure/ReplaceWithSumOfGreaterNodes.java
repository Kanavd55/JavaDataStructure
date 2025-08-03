//Problem statement
//Given a binary search tree, you have to replace each node's data with the sum of all nodes which are greater or equal than it. You need to include the current node's data also.
//
//That is, if in given BST there is a node with data 5, you need to replace it with sum of its data (i.e. 5) and all nodes whose data is greater than or equal to 5.
//
//Note: You don't need to return or print, just change the data of each node.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//Time Limit: 1 second
//Sample Input 1 :
//8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
//Sample Output 1 :
//18 
//36 10 
//38 31 
//25 

package BinaryTreeDataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ReplaceWithSumOfGreaterNodes {
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
	 public static int replaceWithLargerNodesSumBetter(BinaryTreeNode<Integer> root,int sum) {
			// Write your code here
			if(root==null){
				return sum;
			}
			sum = replaceWithLargerNodesSumBetter(root.right,sum);
			int newSum = sum+root.data;
			root.data=newSum;
			int leftSum = replaceWithLargerNodesSumBetter(root.left,newSum);
			return leftSum;
		}

		public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
			// Write your code here
			int num = replaceWithLargerNodesSumBetter(root,0);
		}
		public static void PrintBinaryTreeRecursively(BinaryTreeNode<Integer> root) {
			if(root==null) {
				return;
			}
			System.out.println(root.data);
			PrintBinaryTreeRecursively(root.left);
			PrintBinaryTreeRecursively(root.right);
		}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = TakeTreeInputLevelWise();
		replaceWithLargerNodesSum(root);
		PrintBinaryTreeRecursively(root);
	}
}
