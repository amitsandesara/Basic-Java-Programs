public class HeapSort {
	private static int N;

	public static void main(String args[]) {
		long start = System.nanoTime();
		int[] arr = {5, 18, 7, 99, 87, 11, 29, 32, 8, 15, 54, 96, 45, 67, 34};
		System.out.println("Input array:- ");

		for (Integer i : arr) {
			System.out.print(" | " + i);
		}
		heapSort(arr);
		long end = System.nanoTime();
		System.out.println("\nTook " + (end - start) / 1000 + " ms to sort");
	}

	private static void heapSort(int[] arr) {
		N = arr.length - 1;
		heapify(arr); // create heap
		System.out.println("\nHeap:- ");

		for (Integer i : arr) {
			System.out.print(" | " + i);
		}
		for (int i = N; i > 0; i--) {
			swap(arr, 0, i);
			N = N - 1;
			maxHeap(arr, 0);
		}
		System.out.println("\nSorted array:- ");
		for (Integer i : arr) {
			System.out.print(" | " + i);
		}
	}

	private static void heapify(int[] arr) {
		for (int i = N / 2; i >= 0; i--) {
			maxHeap(arr, i);
		}
	}

	private static void maxHeap(int[] arr, int i) {
		int max = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < N && arr[left] > arr[i])
			max = left;
		if (right < N && arr[right] > arr[max])
			max = right;

		if (max != i) {
			swap(arr, i, max);
			maxHeap(arr, max);
		}
	}

	private static void swap(int[] arr, int i, int max) {
		int temp = arr[i];
		arr[i] = arr[max];
		arr[max] = temp;
	}
}
