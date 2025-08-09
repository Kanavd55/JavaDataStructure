//Problem statement
//Given a generic tree, find and return the height of given tree. The height of a tree is defined as the longest distance from root node to any of the leaf node. Assume the height of a tree with a single node is 1.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//Time Limit: 1 sec
//Sample Input 1:
//10 3 20 30 40 2 40 50 0 0 0 0 
//Sample Output 1:
//3

package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HeightOfGenericTree {
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
	
	public static int getHeight(TreeNode<Integer> root){
		if(root==null) {
			return 0;
		}
		int Height = 0;
		for(int i=0;i<root.children.size();i++) {
			int childHeight=getHeight(root.children.get(i));
			if(childHeight>Height) {
				Height=childHeight;
			}
		}
		return Height+1;
	}
	public static void main(String[] args) {
		TreeNode<Integer> rootNode = TakeTreeInputLevelWise();
		System.out.println(getHeight(rootNode));
	}
}
