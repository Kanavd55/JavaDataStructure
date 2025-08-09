package Trees;
import java.util.*;
public class TakeTreeInputLevelWise {
	
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
	
	public static void printLevelWise(TreeNode<Integer> root){
		if(root==null) {
			return;
		}
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()) {
			TreeNode<Integer> node = queue.poll();
			if(node!=null) {
				System.out.print(node.data+" ");
				for(int i=0;i<node.children.size();i++) {
					queue.add(node.children.get(i));
				}
			}else if(node == null) {
				if(queue.isEmpty()) {
					break;
				}else {
					queue.add(null);
					System.out.println();
				}
			}
		}
	}
	public static void main(String[] args) {
		TreeNode<Integer> rootNode = TakeTreeInputLevelWise();
		printLevelWise(rootNode);
	}
}
