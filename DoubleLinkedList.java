
class DoubleNode {
	DoubleNode next;
	DoubleNode prev;
	int data;

	DoubleNode(int n) {
		this.next = null;
		this.prev = null;
		this.data = n;
	}
}


public class DoubleLinkedList {
	private static DoubleNode head;
	private int count;

	DoubleLinkedList() {
		head = null;
		count = 0;
	}

	public void insert(int value) {
		DoubleNode newNode = new DoubleNode(value);
		if (head == null) {
			head = newNode;
		} else {
			DoubleNode temp = head;
			while (temp.next != null)
				temp = temp.next;

			temp.next = newNode;
			newNode.prev = temp;
		}
		count++;
	}

	private void print(DoubleNode head) {
		// TODO Auto-generated method stub

		DoubleNode temp = head;
		while (temp != null) {
			if (temp.next != null)
				System.out.print(temp.data + " -> ");
			else {
				System.out.println(temp.data);
				break;
			}
			temp = temp.next;
		}
	}

	private DoubleNode reverse(DoubleNode current) {
		DoubleNode P = null;
		DoubleNode N;

		while (current != null) {
			N = current.next;
			current.next = P;
			current.prev = N;
			P = current;
			current = N;
		}

		return P;
	}

	public static void main(String args[]) {
		DoubleLinkedList myList = new DoubleLinkedList();
		int arr[] = {11, 34, 45, 74, 43, 64, 41, 66, 86, 95};
		for (Integer i : arr) {
			myList.insert(i);
		}
		System.out.println("LinkedList:- ");
		myList.print(head);
		System.out.println("Reversed LinkedList:- ");
		DoubleNode reverseHead = myList.reverse(head);
		myList.print(reverseHead);
		System.out.println("Total Nodes in LinkedList:- " + myList.count);
	}

}
