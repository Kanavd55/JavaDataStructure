////Problem statement
//Given a Binary Search Tree and two integers k1 and k2, find and print the elements which are in range k1 and k2 (both inclusive).
//
//Print the elements in increasing order.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Input format:
//The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
//The following line contains two integers, that denote the value of k1 and k2.
//Output Format:
// The first and only line of output prints the elements which are in range k1 and k2 (both inclusive). Print the elements in increasing order.
//Constraints:
//Time Limit: 1 second
//Sample Input 1:
//8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
//6 10
//Sample Output 1:
//6 7 8 10

package BinaryTreeDataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ElementsBetweenK1AndK2 {
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
	public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root,int k1,int k2){
		if(root==null) {
			return;
		}
		if(root.left!=null) {
			elementsInRangeK1K2(root.left,k1,k2);
		}
		if(root.data>=k1 && root.data<=k2) {
			System.out.print(root.data+" ");
		}
		if(root.right!=null) {
			elementsInRangeK1K2(root.right,k1,k2);
		}
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = TakeTreeInputLevelWise();
		Scanner s = new Scanner(System.in);
		int k1 = s.nextInt();
		int k2 = s.nextInt();
		elementsInRangeK1K2(root,k1,k2);
		
	}
}
