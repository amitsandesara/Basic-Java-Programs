import java.util.Scanner;

public class QueueImpl {
	private int front, rear;
	private int[] queueArray;
	private int size;
	private int len;

	public QueueImpl(int s) {
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
		queueArray[++rear] = s;
	}

	public int deQueue() {
		if (front == rear)
			front = rear = -1;
		if (!isEmpty()) {
			len--;

			return queueArray[front++];
		}

		return -1;
	}

	public boolean isFull() {
		return front == 0 && rear == size - 1;
	}

	public int peek() {
		return queueArray[rear];
	}

	public boolean isEmpty() {
		return (front == -1);
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of Queue:- ");
		int n = sc.nextInt();
		QueueImpl queue = new QueueImpl(n);
		queue.enQueue(1);
		queue.enQueue(20);
		queue.enQueue(30);
		queue.enQueue(40);
		System.out.println("Size:- " + queue.size);
		System.out.println("Queue's length:- " + queue.len);
		System.out.println("Last:- " + queue.peek());
		queue.enQueue(50);
		queue.deQueue();
		for (int i = queue.front; i <= queue.rear; i++)
			System.out.print(queue.queueArray[i] + " ");

		sc.close();
	}
}
