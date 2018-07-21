package progs;

class Tree1 {

	private Node1 root;
	private int preIndex = 0;

	Node1 constructTree(int[] pre, int[] inorder, int start, int end) {

		if (start > end)
			return null;

		int index = findInorderIndex(inorder, pre[preIndex]);

		if (index != -1) {

			Node1 node = new Node1(pre[preIndex++]);
			node.left = constructTree(pre, inorder, start, index - 1);
			node.right = constructTree(pre, inorder, index + 1, end);
			return node;
		}
		return null;
	}

	int findInorderIndex(int[] inorder, int data) {

		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == data)
				return i;
		}
		return -1;
	}

	void printInorder(Node1 root) {

		if (root != null) {
			printInorder(root.left);
			System.out.println(root.data);
			printInorder(root.right);
		}
	}
}

class Node1 {

	int data;
	Node1 left;
	Node1 right;

	Node1(int data) {

		this.data = data;
		this.left = this.right = null;
	}

}

public class TreeConstructPreInorder {

	public static void main(String[] args) {
		int in[] = { 4, 2, 5, 1, 6, 3 };
		int pre[] = { 1, 2, 4, 5, 3, 6 };

		Tree1 t = new Tree1();
		Node1 root = t.constructTree(pre, in, 0, pre.length - 1);
		t.printInorder(root);
	}

}
