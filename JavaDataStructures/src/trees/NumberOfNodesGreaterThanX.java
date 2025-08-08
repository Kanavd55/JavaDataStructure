//Problem statement
//Given a tree and an integer x, find and return number of Nodes which are greater than x.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1 :
//35 10 3 20 30 40 2 40 50 0 0 0 0 
//Sample Output 1 :
//3
//Explanation
//Since x=35, the elements which are greater than 35 are 40, 40, 50, so the output for this is 3.
//Sample Input 2 :
//10 10 3 20 30 40 2 40 50 0 0 0 0 
//Sample Output 2:
//5
//Explanation
//Since x=10, the elements which are greater than 10 are 20, 30, 40,  40, 50, so the output for this is 5.

package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NumberOfNodesGreaterThanX {
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
	
	public static int numNodeGreater(TreeNode<Integer> root,int x){
		if(root==null) {
			return 0;
		}
		int count = 0;
		if(root.data>x) {
			count=count+1;
		}
		for(int i=0;i<root.children.size();i++) {
			int childCount = numNodeGreater(root.children.get(i),x);
			count = count + childCount;
		}
		return count;

	}
	public static void main(String[] args) {
		Scanner s =  new Scanner(System.in);
		int x = s.nextInt();
		TreeNode<Integer> rootNode = TakeTreeInputLevelWise();
		System.out.println(numNodeGreater(rootNode,x));
	}
}
