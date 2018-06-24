package progs;

public class LinkedListCRUD {

	Node head;

	public static void main(String[] args) {

		LinkedListCRUD ll = new LinkedListCRUD();
		ll.head = null;
		ll.push(2);
		ll.push(3);
		ll.push(4);
		ll.push(5);
		ll.push(6);

		ll.traverseList(ll.head);
		//ll.deleteNode(4);
		Node node = ll.reverse(ll.head);
		ll.traverseList(node);
	}

	class Node {

		int data;
		Node next;

		Node(int data) {

			this.data = data;
			next = null;
		}
	}

	/* traverse the list */
	void traverseList(Node head) {

		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data);
			temp = temp.next;
		}
		System.out.println("\n");
	}

	void push(int data) {

		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	/* Delete a node with given data */
	void deleteNode(int data) {

		Node temp = head;
		Node prev = null;

		while (temp.data != data && temp != null) {

			prev = temp;
			temp = temp.next;
		}

		if (prev != null) {
			prev.next = temp.next;
		} else
			head = head.next;
	}

	/* Function to reverse the linked list */
	Node reverse(Node node) {
		Node prev = null;
		Node current = node;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}

}
