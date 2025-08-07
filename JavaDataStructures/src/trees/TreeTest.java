package trees;
import java.util.Queue;
import java.util.LinkedList;
public class TreeTest {
	public static void PrintTree(TreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		System.out.println(root.data);
		for(int i=0;i<root.children.size();i++) {
			PrintTree(root.children.get(i));
		}
	}
	public static void PrintTreeImproved(TreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode<Integer> node = queue.poll();
			System.out.print(node.data+": ");
			for(int i=0;i<node.children.size();i++) {
				System.out.print(node.children.get(i).data+" ");
				queue.add(node.children.get(i));
			}
			System.out.println();
		}
		
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
		TreeNode<Integer> root = new TreeNode<>(4);
		TreeNode<Integer> node1 = new TreeNode<>(2);
		TreeNode<Integer> node2 = new TreeNode<>(3);
		TreeNode<Integer> node3 = new TreeNode<>(1);
		TreeNode<Integer> node4 = new TreeNode<>(5);
		TreeNode<Integer> node5 = new TreeNode<>(6);
		root.children.add(node1);
		root.children.add(node2);
		root.children.add(node3);
		node2.children.add(node4);
		node2.children.add(node5);
		printLevelWise(root);
//		PrintTree(root);
//		PrintTreeImproved(root);
	}
	
	
}
