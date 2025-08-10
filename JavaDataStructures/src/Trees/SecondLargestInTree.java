package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SecondLargestInTree {
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
	public static LargestAndSecondLargest<Integer> findSecondLargestHelper(TreeNode<Integer> root){
		if(root==null) {
			LargestAndSecondLargest<Integer> node = new LargestAndSecondLargest<>();
			return node;
		}
		LargestAndSecondLargest<Integer> ans = new LargestAndSecondLargest<>();
		ans.LargestNode=root;
		for(int i=0;i<root.children.size();i++) {
			LargestAndSecondLargest<Integer> childNode = findSecondLargestHelper(root.children.get(i));
			if(childNode.LargestNode!=null && childNode.LargestNode.data>ans.LargestNode.data) {
				ans.SecondLargestNode=ans.LargestNode;
				ans.LargestNode=childNode.LargestNode;
			}
			if(childNode.SecondLargestNode!=null && (ans.SecondLargestNode==null || childNode.SecondLargestNode.data > ans.SecondLargestNode.data)) {
				ans.SecondLargestNode=childNode.SecondLargestNode;
			}
			if(childNode.LargestNode!=null && ans.SecondLargestNode==null && childNode.LargestNode.data<ans.LargestNode.data) {
				ans.SecondLargestNode=childNode.LargestNode;
			}
			if(childNode.LargestNode!=null && ans.SecondLargestNode!=null && childNode.LargestNode.data < ans.LargestNode.data && childNode.LargestNode.data>ans.SecondLargestNode.data) {
				ans.SecondLargestNode=childNode.LargestNode;
			}
			
		}
		return ans;
	}

	public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){
		LargestAndSecondLargest<Integer> node = findSecondLargestHelper(root);
		return node.SecondLargestNode;
	}
	public static void main(String[] args) {
		TreeNode<Integer> root = TakeTreeInputLevelWise();

	}
}
