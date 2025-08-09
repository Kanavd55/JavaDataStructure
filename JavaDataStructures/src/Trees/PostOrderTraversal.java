//Problem statement
//Given a generic tree, print the post-order traversal of given tree.
//
//The post-order traversal is: visit child nodes first and then root node.
//
//
//For the given tree, the post order traversal will be 40 50 20 30 40 10
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//Time Limit: 1 sec
//Sample Input 1:
//10 3 20 30 40 2 400 50 0 0 0 0 
//Sample Output 1:
//400 50 20 30 40 10
//Explanation
//For 10 , total 3 children are there : 20 30 40
//For  20, total 2 children are there : 400 50
//So, the output will be 400 50 20 30 40 10

package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PostOrderTraversal {
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
	public static void printPostOrder(TreeNode<Integer> root){
		if(root==null) {
			return;
		}
		for(int i =0;i<root.children.size();i++) {
			printPostOrder(root.children.get(i));
		}
		System.out.print(root.data+" ");
	}
	public static void main(String[] args) {
		TreeNode<Integer> rootNode = TakeTreeInputLevelWise();
		printPostOrder(rootNode);
	}
}
