package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NextLargerElement {
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
	public static NodeAndMinDiff<Integer> findNextLargerNodeHelper(TreeNode<Integer> root, int n){
		if(root==null) {
			NodeAndMinDiff<Integer> node = new NodeAndMinDiff<>(Integer.MAX_VALUE);
			return node;
		}
		NodeAndMinDiff<Integer> ans = new NodeAndMinDiff<>(Integer.MAX_VALUE);
		if(root.data>n) {
			ans.Node=root;
			ans.minDiff=root.data-n;
		}
		for(int i =0;i<root.children.size();i++) {
			NodeAndMinDiff<Integer> childNode = findNextLargerNodeHelper(root.children.get(i),n);
			if(childNode.minDiff<ans.minDiff) {
				ans.Node=childNode.Node;
				ans.minDiff=childNode.minDiff;
			}
		}
		return ans;
	}
	public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){
		NodeAndMinDiff<Integer> node = findNextLargerNodeHelper(root,n);
		return node.Node;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		TreeNode<Integer> rootNode = TakeTreeInputLevelWise();
		TreeNode<Integer> node = findNextLargerNode(rootNode,n);
	}
}
