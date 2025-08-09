//Problem statement
//Given a tree, find and return the node for which sum of data of all children and the node itself is maximum. In the sum, data of node itself and data of immediate children is to be taken.
//
//Input format :
//
//Line 1 : Elements in level order form separated by space (as per done in class). Order is -
//
//Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element
//
//Output format : Node with maximum sum.
//
//Sample Input 1 :
//5 3 1 2 3 1 15 2 4 5 1 6 0 0 0 0
//Representation of input
//
//
//Sample Output 1 :
//1
//Explanation
//Sum of node 1 and it's child (15) is maximum among all the nodes, so the output for this is 1.

package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NodeIshavingSumOfChildrenAndNodeIsMax {
	public static TreeNode<Integer> TakeTreeInputLevelWise(){
		Scanner s = new Scanner(System.in);
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		System.out.println("Enter the root data");
		int rootData = s.nextInt();
		if(rootData==-1) {
			return null;
		}
		TreeNode<Integer> rootNode = new TreeNode<>(rootData);
		queue.add(rootNode);
		while(!queue.isEmpty()) {
			TreeNode<Integer> Node = queue.poll();
			System.out.println("Enter the Number of children of " + Node.data);
			int numOfChildren = s.nextInt();
			for(int i=0;i<numOfChildren;i++) {
				System.out.println("Enter the data of "+i+"th child data of " + Node.data);
				int numData = s.nextInt();
				TreeNode<Integer> childNode = new TreeNode<>(numData);
				Node.children.add(childNode);
				queue.add(childNode);
			}
		}
		return rootNode;
		
	}
	
	public static MaxSumAndNode<Integer> maxSumNodeHelper(TreeNode<Integer> root){
		// Write your code here
		if(root==null) {
			MaxSumAndNode<Integer> node = new MaxSumAndNode<Integer>(Integer.MIN_VALUE);
			return node;
		}
		MaxSumAndNode<Integer> ans = new MaxSumAndNode<Integer>(Integer.MIN_VALUE);
		int NodeDataCount = root.data;
		for(int i=0;i<root.children.size();i++) {
			NodeDataCount = NodeDataCount + root.children.get(i).data;
		}
		ans.maxSum=NodeDataCount;
		ans.Node=root;
		for(int i = 0 ;i < root.children.size();i++) {
			MaxSumAndNode<Integer> childNode = maxSumNodeHelper(root.children.get(i));
			if(childNode.maxSum>ans.maxSum) {
				ans.maxSum=childNode.maxSum;
				ans.Node=childNode.Node;
			}
		}
		return ans;
		
	}
	public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
		// Write your code here
		MaxSumAndNode<Integer> node = maxSumNodeHelper(root);
		return node.Node;
	}
	public static void main(String[] args) {
		TreeNode<Integer> rootNode = TakeTreeInputLevelWise();
		TreeNode<Integer> node = maxSumNode(rootNode);
	}
}
