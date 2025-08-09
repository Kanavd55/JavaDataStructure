//Problem statement
//Given a generic tree and an integer x, check if x is present in the given tree or not. Return true if x is present, return false otherwise.
//
//Input format :
//
//Line 1 : Integer x
//
//Line 2 : Elements in level order form separated by space (as per done in class). Order is -
//
//Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element
//
//Output format : true or false
//
//Sample Input 1 :
//40
//10 3 20 30 40 2 40 50 0 0 0 0 
//
//Sample Output 1 :
//true
//Explanation
//Since, 40 is present in the given tree, so the answer will be true.
//Sample Input 2 :
//4
//10 3 20 30 40 2 40 50 0 0 0 0 
//
//Sample Output 2:
//false
//Explanation
//Since, 4 is not present in the given tree, so the answer is false.

package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CheckIgGenericTreeContainsX {
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
	public static boolean checkIfContainsX(TreeNode<Integer> root, int x){
		// Write your code here
		if(root==null) {
			return false;
		}
		if(root.data==x) {
			return true;
		}
		for(int i=0;i<root.children.size();i++) {
			boolean isChildPresent = checkIfContainsX(root.children.get(i),x);
			if(isChildPresent) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		TreeNode<Integer> rootNode = TakeTreeInputLevelWise();
		System.out.println(checkIfContainsX(rootNode,x));
	}
}
