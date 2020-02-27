class Node {
	Node next;
	int data;

	Node(int n) {
		this.next = null;
		this.data = n;
	}
}


public class LinkedList {
	private Node head;
	private int count;

	LinkedList() {
		head = null;
		count = 0;
	}

	private void addToStart(int data) {
		Node temp = new Node(data);
		if (head == null)
			head = temp;
		else {
			Node tempHead = head;
			head = temp;
			temp.next = tempHead;
		}
		count++;
	}

	private void sortedInsert(int data) {
		Node temp = new Node(data);
		if (head == null) {
			head = temp;
		} else if (head.data > data) {
			temp.next = head;
			head = temp;
		} else {
			Node current = head;
			Node prev = null;
			while (current.data < data) {
				prev = current;
				if (current.next != null)
					current = current.next;
				else
					break;
			}
			if (prev == null && current.next == null)
				current.next = temp;
			else if (current.data < data && current.next == null) {
				current.next = temp;
			} else {
				prev.next = temp;
				temp.next = current;
			}
		}
		count++;
		print(head);
		System.out.println();
	}

	private void removeFromEnd() {
		Node current = head;
		while (current.next.next != null) {
			current = current.next;
		}
		System.out.println("\nDeleted:- " + current.next.data);
		current.next = null;
		count--;
	}

	private void removeFromStart() {
		System.out.println("\nDeleted:- " + head.data);
		head = head.next;
		count--;
	}

	private static Node reverse(Node current) {
		Node previous = null;
		Node nextNode;
		while (current != null) {
			nextNode = current.next;
			current.next = previous;
			previous = current;
			current = nextNode;
		}
		return previous;
	}

	private static void print(Node head) {
		Node temp = head;
		while (temp != null) {
			if (temp.next != null)
				System.out.print(temp.data + " -> ");
			else
				System.out.print(temp.data);
			temp = temp.next;
		}
	}

	public static void main(String args[]) {
		LinkedList myList = new LinkedList();
		myList.addToStart(10);
		int arr[] = {15, 54, 22, 16, 8, 35, 36, 5, 7};
		for (Integer i : arr) {
			myList.sortedInsert(i);
		}

		myList.removeFromStart();
		myList.removeFromEnd();
		System.out.println("\nLinkedList:- ");
		print(myList.head);
		System.out.println("\nNumber of nodes in list:- " + myList.count);
		System.out.println("\nLinkedList:- ");
		print(myList.head);
		System.out.println("\nReversed List:- ");
		Node reverse = reverse(myList.head);
		print(reverse);
		System.out.println("\nNumber of nodes in list:- " + myList.count);
	}
}
