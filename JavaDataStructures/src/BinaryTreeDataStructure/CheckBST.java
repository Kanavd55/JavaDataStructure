package BinaryTreeDataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CheckBST {
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

	public static isBST isBSTHelper(BinaryTreeNode<Integer> root) {
		if(root==null) {
			isBST node = new isBST(true,Integer.MIN_VALUE,Integer.MAX_VALUE);
			return node;
		}
		isBST isLeftBST = isBSTHelper(root.left);
		isBST isRightBST = isBSTHelper(root.right);
		isBST ans = new isBST(true, Integer.MIN_VALUE,Integer.MAX_VALUE);
		ans.maximum= Math.max(root.data,Math.max(isLeftBST.maximum,isRightBST.maximum));
		ans.minimum=Math.min(root.data, Math.min(isLeftBST.minimum, isRightBST.minimum));
		if(!isLeftBST.isBST || !isRightBST.isBST) {
			ans.isBST=false;
		}
		if(isLeftBST.maximum>=root.data || root.data>isRightBST.minimum) {
			ans.isBST=false;
			return ans;
		}
		return ans;
	}

	public static boolean isBST(BinaryTreeNode<Integer> root) {
		isBST node = isBSTHelper(root);
		return node.isBST;
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = TakeTreeInputLevelWise();
		System.out.println(isBST(root));
	}
}
