import java.util.Scanner;

public class CircularQueue {
	private int front, rear;
	private int[] queueArray;
	private static int size;
	private int len;

	public CircularQueue(int s) {
		front = rear = -1;
		size = s;
		queueArray = new int[size];
		len = 0;
	}

	public void enQueue(int s) {
		if (rear == -1)
			front = 0;

		if (isFull()) {
			System.out.println("Queue is full");
			return;
		}
		len++;
		System.out.println("Adding:- " + s);

		rear = (rear + 1) % size;
		queueArray[rear] = s;
	}

	public int deQueue() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			return -1;
		} else {
			if (front == rear)
				front = rear = -1;

			len--;
			int ele = queueArray[front];
			front = (front + 1) % size;
			return ele;
		}
	}

	public boolean isFull() {
		return size == len;
	}

	public int peek() {
		return queueArray[rear];
	}

	public boolean isEmpty() {
		return (front == -1);
	}



	public static void main(String args[]) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of Queue:- ");
		int n = sc.nextInt();
		CircularQueue queue = new CircularQueue(n);
		queue.enQueue(10);
		queue.enQueue(2);
		queue.enQueue(35);
		queue.enQueue(13);
		queue.enQueue(40);
		// Printing queue
		for (int i = queue.front; i <= queue.rear; i++) {
			System.out.print(queue.queueArray[i] + " ");
		}
		System.out.println();
		queue.deQueue();
		queue.enQueue(28);
		queue.deQueue();
		queue.enQueue(70);
		// Printing queue
		for (int i = 0; i < CircularQueue.size; i++) {
			System.out.print(queue.queueArray[i] + " ");
		}
		System.out.println("FP:- " + queue.front + "Rear:- " + queue.rear);


		for (int i = 0; i < size;) {
			if (queue.queueArray[i] > queue.queueArray[i++]) {
				int x = queue.deQueue();
				queue.enQueue(x);
			} else
				i++;
		}
		for (int i = 0; i < CircularQueue.size; i++) {
			System.out.print(queue.queueArray[i] + " ");
		}
	}
}
