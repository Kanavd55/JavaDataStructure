//Problem statement
//Given two Generic trees, return true if they are structurally identical i.e. they are made of nodes with the same values arranged in the same way.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1 :
//10 3 20 30 40 2 40 50 0 0 0 0 
//10 3 20 30 40 2 40 50 0 0 0 0
//Sample Output 1 :
//true
//Explanation
//If we draw the tree for the above inputs, both the trees will look like this. So the answer for this is true.
//
//
//Sample Input 2 :
//10 3 20 30 40 2 40 50 0 0 0 0 
//10 3 2 30 40 2 40 50 0 0 0 0
//Sample Output 2:
//false

package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StructurallyIdentical {
	
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
	
	public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){
		// Write your code here
		if(root1==null && root2==null){
			return true;
		}
		if(root1==null && root2!=null) {
			return false;
		}
		if(root2==null && root1!=null) {
			return false;
		}
		if(root1.data!=root2.data) {
			return false;
		}
		int child1Length=root1.children.size();
		int child2Length=root2.children.size();
		if(child1Length!=child2Length) {
			return false;
		}
		for(int i=0;i<child1Length;i++) {
			boolean isChildIdentical = checkIdentical(root1.children.get(i),root2.children.get(i));
			if(!isChildIdentical) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		TreeNode<Integer> rootNode1 = TakeTreeInputLevelWise();
		TreeNode<Integer> rootNode2 = TakeTreeInputLevelWise();
		System.out.println(checkIdentical(rootNode1,rootNode2));
	}
}
