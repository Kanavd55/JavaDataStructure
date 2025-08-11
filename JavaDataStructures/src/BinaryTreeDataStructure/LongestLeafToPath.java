//Problem statement
//Given a binary tree, return the longest path from leaf to root. Longest means, a path which contain maximum number of nodes from leaf to root.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1 :
// 5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
//Input Graph
//
//Sample Output 1 :
//9
//3
//6
//5
//Input Graph

package BinaryTreeDataStructure;
import java.util.*;
public class LongestLeafToPath {
	public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root){
		// Write your code here
		if(root==null){
			ArrayList<Integer> leafPath = new ArrayList<>();
        return leafPath;
		}
		if(root.left==null && root.right == null){
			ArrayList<Integer> leafPath = new ArrayList<>();
        leafPath.add(root.data);
        return leafPath;
		}
		ArrayList<Integer> leftPath = longestRootToLeafPath(root.left);
		ArrayList<Integer> rightPath = longestRootToLeafPath(root.right);

		if(leftPath.size()>rightPath.size()){
			leftPath.add(root.data);
			return leftPath;
		}else{
			rightPath.add(root.data);
			return rightPath;
		}
	}
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
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = TakeTreeInputLevelWise();
		ArrayList<Integer> leafPath = longestRootToLeafPath(root);
	}
}
