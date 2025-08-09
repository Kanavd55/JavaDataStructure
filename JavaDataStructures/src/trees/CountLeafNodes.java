//Problem statement
//Given a generic tree, count and return the number of leaf nodes present in the given tree. A node is said to be a leaf node if it's not having any child
//
//
//Leaf nodes in the given tree are 40, 50, 30, 40. So the answer for this is 4.
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1 :
//10 3 20 30 40 2 40 50 0 0 0 0 
//Sample Output 1 :
//4


package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CountLeafNodes {
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
	public static int countLeafNodes(TreeNode<Integer> root){
		if(root==null) {
			return 0;
		}
		if(root.children.size()==0) {
			return 1;
		}
		int childLeafNodeCount=0;
		for(int i=0;i<root.children.size();i++) {
			int count = countLeafNodes(root.children.get(i));
			childLeafNodeCount = childLeafNodeCount + count;
		}
		return childLeafNodeCount;

	}
	public static void main(String[] args) {
		TreeNode<Integer> rootNode = TakeTreeInputLevelWise();
		System.out.println(countLeafNodes(rootNode));
	}
}
