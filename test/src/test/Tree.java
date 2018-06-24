package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class Tree {

	Node root;

	public Tree(int data) {
		root = new Node(data);
	}

	public Tree() {
		// Default
	}

	public void preOrderTraversal(Node node) {

		if (node == null)
			return;

		System.out.print(node.getData());
		preOrderTraversal(node.getLeft());
		preOrderTraversal(node.getRight());
	}

	public void postOrderTraversal(Node node) {

		if (node == null)
			return;

		postOrderTraversal(node.getLeft());
		postOrderTraversal(node.getRight());
		System.out.print(node.getData());
	}

	public void inOrderTraversal(Node node) {

		if (node == null)
			return;

		inOrderTraversal(node.getLeft());
		System.out.print(node.getData());
		inOrderTraversal(node.getRight());

	}

	public void levelOrderTraversal1(Node node) {

		int height = getHeight(node);
		for (int i = 1; i <= height; i++)
			levelOrder(node, i);
	}

	public void levelOrderTraversal2(Node root) {

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {

			Node n = queue.remove();
			System.out.print(n.getData());
			if (n.getLeft() != null)
				queue.add(n.getLeft());

			if (n.getRight() != null)
				queue.add(n.getRight());
		}
	}

	public void levelOrder(Node node, int height) {

		if (node == null)
			return;

		if (height == 1)
			System.out.print(node.getData());
		levelOrder(node.getLeft(), height - 1);
		levelOrder(node.getRight(), height - 1);
	}

	private int getHeight(Node node) {

		if (node == null)
			return 0;

		return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
	}

	public void printVerticalOrder(Node root)
    {
        // Create a map and store vertical order in map using
        // function getVerticalOrder()
        TreeMap<Integer,List<Integer>> map = new TreeMap<>();
        int hd =0;
        getVerticalOrder(root,hd,map);
         
        // Traverse the map and print nodes at every horigontal
        // distance (hd)
        for (Entry<Integer, List<Integer>> entry : map.entrySet())
        {
            System.out.println(entry.getValue());
        }
    }
	private void getVerticalOrder(Node node, int hd, TreeMap<Integer, List<Integer>> map) {

		if(node == null)
			return;
		
		if(map.get(hd)!=null)
			map.get(hd).add(node.getData());
		else {
			List<Integer> data = new ArrayList<>();
			data.add(node.getData());
			map.put(hd, data);
		}
				
		getVerticalOrder(node.getLeft(), hd-1, map);
		getVerticalOrder(node.getRight(), hd+1, map);
	}

	 Node findLCA(Node node, int n1, int n2)
	    {
	        // Base case
	        if (node == null)
	            return null;
	 
	        // If either n1 or n2 matches with root's key, report
	        // the presence by returning root (Note that if a key is
	        // ancestor of other, then the ancestor key becomes LCA
	        if (node.getData() == n1 || node.getData() == n2)
	            return node;
	 
	        // Look for keys in left and right subtrees
	        Node left_lca = findLCA(node.getLeft(), n1, n2);
	        Node right_lca = findLCA(node.getRight(), n1, n2);
	 
	        // If both of the above calls return Non-NULL, then one key
	        // is present in once subtree and other is present in other,
	        // So this node is the LCA
	        if (left_lca!=null && right_lca!=null)
	            return node;
	 
	        // Otherwise check if left subtree or right subtree is LCA
	        return (left_lca != null) ? left_lca : right_lca;
	    }
	 
	
	public static void main(String[] args) {

		Tree tree = new Tree(1);
		tree.root.setLeft(new Node(2));
		tree.root.setRight(new Node(3));
		tree.root.getLeft().setLeft(new Node(4));
		tree.root.getLeft().setRight(new Node(5));
		tree.root.getRight().setLeft(new Node(6));
		tree.root.getRight().setRight(new Node(7));
/*
 * 			1
 * 		2		3
 * 	  4   5   6   7
 * 
 */
		System.out.println("PreOrder traversal");
		tree.preOrderTraversal(tree.root);
		System.out.println("\n");

		System.out.println("PostOrder Traversal");
		tree.postOrderTraversal(tree.root);
		System.out.println("\n");
		
		System.out.println("Inorder Traversal");
		tree.inOrderTraversal(tree.root);
		System.out.println("\n");
		
		System.out.println("Level order Traversal without queue O(n2)");
		tree.levelOrderTraversal1(tree.root);
		System.out.println("\n");
		
		System.out.println("Level order Traversal with queue");
		tree.levelOrderTraversal2(tree.root);
		System.out.println("\n");
		
		System.out.println("Vertical Traversal");
		tree.printVerticalOrder(tree.root);
		
	}
}

class Node {

	private Node left;
	private Node right;
	private int data;

	public Node(int data) {
		this.data = data;
		this.left = this.right = null;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}
