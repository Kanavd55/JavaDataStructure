//Problem statement
//You are given a Binary Tree of type integer, a integer value of target node's data, and an integer value K.
//
//Print the data of all nodes that have a distance K from the target node. The order in which they would be printed will not matter.
//
//Example:
//For a given input tree(refer to the image below):
//1. Target Node: 5
//2. K = 2
//alt txt
//
//Starting from the target node 5, the nodes at distance K are 7 4 and 1.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//1 <= N <= 10^5
//Where N is the total number of nodes in the binary tree.
//1 ≤ data of node ≤ 10^9
//1 ≤ target ≤ 10^9
//
//Time Limit: 1 sec
//Sample Input 1:
//5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
//3 1
//Sample Output 1:
//9
//6
//Sample Input 2:
//1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
//3 3
//Sample Output 2:
//4
//5

package BinaryTreeDataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrintNodesAtDistanceKFromNode {
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
	
	public static BinaryTreeNode<Integer> FindNode(BinaryTreeNode<Integer> root,int node){
		if(root==null) {
			return root;
		}
		if(root.data==node) {
			return root;
		}
		BinaryTreeNode<Integer> leftNode = FindNode(root.left,node);
		BinaryTreeNode<Integer> rightNode =FindNode(root.right,node);
		if(leftNode==null) {
			return rightNode;
		}else {
			return leftNode;
		}
	}
	public static void nodesAtDistanceKHelper(BinaryTreeNode<Integer> root, int node, int k) {
		if(root==null) {
			return;
		}
		if(k==0) {
			System.out.println(root.data);
		}
		nodesAtDistanceKHelper(root.left,node,k-1);
		nodesAtDistanceKHelper(root.right,node,k-1);
	}
	public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
	    //Your code goes here
		BinaryTreeNode<Integer> rootNode = FindNode(root,node);
		nodesAtDistanceKHelper(rootNode,node,k);
		NodeAndDistance leftNode = findNodeAndDistance(root.left,node);
		NodeAndDistance rightNode = findNodeAndDistance(root.right,node);
		if(leftNode.isNode) {
			if(k-leftNode.distance-1<0) {
				printNodesAtDepthK(root.left,k-leftNode.distance);
			}else if(k-leftNode.distance-1>0) {
				printNodesAtDepthK(root.right,k-leftNode.distance-2);
			}else {
				System.out.println(root.data);
				return;
			}
		}else {
			if(k-rightNode.distance-1<0) {
				printNodesAtDepthK(root.right,k-rightNode.distance);
			}else if(k-rightNode.distance-1>0) {
				printNodesAtDepthK(root.left,k-rightNode.distance-2);
			}else {
				System.out.println(root.data);
				return;
			}
		}
	}
	public static void printNodesAtDepthK(BinaryTreeNode<Integer> root,int k) {
		if(root==null) {
			return;
		}
		if(k==0) {
			System.out.print(root.data+" ");
		}
		printNodesAtDepthK(root.left,k-1);
		printNodesAtDepthK(root.right,k-1);
	}
	
	public static NodeAndDistance findNodeAndDistance(BinaryTreeNode<Integer> root,int node){
		if(root==null) {
			NodeAndDistance rootNode = new NodeAndDistance();
			rootNode.isNode=false;
			rootNode.distance=0;
			return rootNode;
		}
		if(root.data==node) {
			NodeAndDistance rootNode = new NodeAndDistance();
			rootNode.isNode=true;
			rootNode.distance=0;
			return rootNode;
		}
		NodeAndDistance leftNode = findNodeAndDistance(root.left,node);
		NodeAndDistance rightNode = findNodeAndDistance(root.right,node);
		if(leftNode.isNode) {
			NodeAndDistance newNode = new NodeAndDistance();
			newNode.isNode=leftNode.isNode;
			newNode.distance=1+leftNode.distance;
			return newNode;
		}else {
			NodeAndDistance newNode = new NodeAndDistance();
			newNode.isNode=rightNode.isNode;
			newNode.distance=1+rightNode.distance;
			return newNode;
		}
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = TakeTreeInputLevelWise();
		Scanner s = new Scanner(System.in);
		int node = s.nextInt();
		int k = s.nextInt();
		nodesAtDistanceK(root,node,k);
	}
}
