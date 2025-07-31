package BinaryTreeDataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConstructTreeUsingPostOrderAndInOrder {
	public static BinaryTreeNode<Integer> buildTreeHelper(int[] postOrder, int[] inOrder,int siPos,int eiPos,int siIn,int eiIn) {
		//Your code goes here
		if(siPos>eiPos) {
			return null;
		}
		int rootData = postOrder[eiPos];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		int rootIndex = -1;
		for(int i=siIn;i<=eiIn;i++) {
			if(inOrder[i]==rootData) {
				rootIndex=i;
				break;
			}
		}
		int siInLeft = siIn;
		int eiInLeft = rootIndex-1;
		int siInRight = rootIndex+1;
		int eiInRight = eiIn;
		int siPosleft = siPos;
		int eiPosRight = eiPos-1;;
		int InOrderLengthLeft = eiInLeft - siInLeft + 1;
		int eiPosLeft = siPosleft + InOrderLengthLeft -1;
		int siPosRight = eiPosLeft + 1 ;
		BinaryTreeNode<Integer> leftNode = buildTreeHelper(postOrder,inOrder,siPosleft,eiPosLeft,siInLeft,eiInLeft);
		BinaryTreeNode<Integer> rightNode = buildTreeHelper(postOrder,inOrder,siPosRight,eiPosRight,siInRight,eiInRight);
		root.left=leftNode;
		root.right=rightNode;
		return root;
		
	}
	public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {
		//Your code goes here
		BinaryTreeNode<Integer> root = buildTreeHelper(postOrder,inOrder,0,postOrder.length-1,0,inOrder.length-1);
		return root;
	}
	
	public static int[] TakeTreeArrayInput(int length) {
		Scanner s =	new Scanner(System.in);
		int[] arr = new int[length];
		for(int i=0;i<length;i++) {
			arr[i]=s.nextInt();
		}
		return arr;
	}
	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		//Your code goes here
		if(root==null) {
			return;
		}
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()) {
			BinaryTreeNode<Integer> node = queue.poll();
			if(node==null) {
				System.out.println();
				if(queue.isEmpty()) {
					break;
				}else {
					queue.add(null);
				}
			}else {
				System.out.print(node.data+" ");
				if(node.left!=null) {
					queue.add(node.left);
				}
				if(node.right!=null) {
					queue.add(node.right);
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int length = s.nextInt();
		int[] postOrder = TakeTreeArrayInput(length);
		int[] inOrder = TakeTreeArrayInput(length);
		BinaryTreeNode<Integer> root = buildTree(postOrder,inOrder);
		printLevelWise(root);
	}
}
