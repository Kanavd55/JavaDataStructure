//Problem statement
//For a given a Binary Tree of type integer, print the complete information of every node, when traversed in a level-order fashion.
//
//To print the information of a node with data D, you need to follow the exact format :
//
//           D:L:X,R:Y
//
//Where D is the data of a node present in the binary tree. 
//X and Y are the values of the left(L) and right(R) child of the node.
//Print -1 if the child doesn't exist.
//Example:
//alt text
//
//For the above depicted Binary Tree, the level order travel will be printed as followed:
//
//1:L:2,R:3
//2:L:4,R:-1
//3:L:5,R:6
//4:L:-1,R:7
//5:L:-1,R:-1    
//6:L:-1,R:-1
//7:L:-1,R:-1
//
//Note: There is no space in between while printing the information for each node.
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//1 <= N <= 10^5
//Where N is the total number of nodes in the binary tree.
//
//Time Limit: 1 sec
//Sample Input 1:
//8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
// Sample Output 1:
//8:L:3,R:10
//3:L:1,R:6
//10:L:-1,R:14
//1:L:-1,R:-1
//6:L:4,R:7
//14:L:13,R:-1
//4:L:-1,R:-1
//7:L:-1,R:-1
//13:L:-1,R:-1
//Sample Input 2:
//1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
// Sample Output 2:
//1:L:2,R:3
//2:L:4,R:5
//3:L:6,R:7
//4:L:-1,R:-1
//5:L:-1,R:-1
//6:L:-1,R:-1
//7:L:-1,R:-1


package BinaryTreeDataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrintTreeLevelWise {
	public static BinaryTreeNode<Integer> TakeTreeInputLevelWise(){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the root data");
		int n = s.nextInt();
		if(n==-1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(n);
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
	public static void PrintTreeLevelWise(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode data = queue.poll();
			System.out.print(data.data+":");
			if(data.left==null) {
				System.out.print("L:"+-1);
			}else {
				System.out.print("L:"+data.left.data);
				queue.add(data.left);
			}
			if(data.right==null) {
				System.out.print(",R:"+-1);
			}else {
				System.out.print(",R:"+data.right.data);
				queue.add(data.right);
			}
			System.out.println();
		}
		
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = TakeTreeInputLevelWise();
		PrintTreeLevelWise(root);
	}
}
