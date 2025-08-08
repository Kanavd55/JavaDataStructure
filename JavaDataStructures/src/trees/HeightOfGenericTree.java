package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HeightOfGenericTree {
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
	
	public static int getHeight(TreeNode<Integer> root){
		if(root==null) {
			return 0;
		}
		int Height = 0;
		for(int i=0;i<root.children.size();i++) {
			int childHeight=getHeight(root.children.get(i));
			if(childHeight>Height) {
				Height=childHeight;
			}
		}
		return Height+1;
	}
	public static void main(String[] args) {
		TreeNode<Integer> rootNode = TakeTreeInputLevelWise();
		System.out.println(getHeight(rootNode));
	}
}
