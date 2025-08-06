package trees;

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
	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<>(4);
		TreeNode<Integer> node1 = new TreeNode<>(5);
		TreeNode<Integer> node2 = new TreeNode<>(6);
		TreeNode<Integer> node3 = new TreeNode<>(7);
		TreeNode<Integer> node4 = new TreeNode<>(8);
		root.children.add(node1);
		root.children.add(node2);
		node1.children.add(node3);
		node1.children.add(node4);
		PrintTree(root);
	}
	
	
}
