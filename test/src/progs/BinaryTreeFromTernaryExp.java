package progs;

import java.util.Stack;

/*
 * https://www.geeksforgeeks.org/convert-ternary-expression-binary-tree/
 */
public class BinaryTreeFromTernaryExp {

	class Node {
		char data;
		Node left, right;

		public Node(char item) {
			data = item;
			left = null;
			right = null;
		}
	}

	// Function to convert Ternary Expression to a Binary
	// Tree. It return the root of tree
	Node convertExpression(char[] expression) {

		if (expression.length == 0)
			return null;

		Stack<Node> stk = new Stack<>();
		Node root = new Node(expression[0]);
		stk.push(root);

		for (int i = 1; i < expression.length; i++) {

			if (expression[i] == '?') {
				Node n = stk.peek();
				n.left = new Node(expression[i + 1]);
				stk.push(n.left);
			} else if (expression[i] == ':') {
				stk.pop();
				Node n = stk.pop();
				n.right = new Node(expression[i + 1]);
				stk.push(n.right);
			}
		}
		return root;
	}

	// function print tree
	public void printTree(Node root) {
		if (root == null)
			return;

		System.out.print(root.data + " ");
		printTree(root.left);
		printTree(root.right);
	}

	// Driver program to test above function
	public static void main(String args[]) {
		String exp = "a?b?c:d:e";
		BinaryTreeFromTernaryExp tree = new BinaryTreeFromTernaryExp();
		char[] expression = exp.toCharArray();
		Node root = tree.convertExpression(expression);
		tree.printTree(root);
	}
}
