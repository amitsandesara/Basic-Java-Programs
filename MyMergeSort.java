public class MyMergeSort {
	private int[] array;
	private int[] tempMergArr;
	private int length;

	public static void main(String args[]) {
		int[] inputArr = {45, 23, 11, 89, 77, 98, 4, 28, 65, 43};
		MyMergeSort mms = new MyMergeSort();
		mms.mergeSort(inputArr);
		for (int i : inputArr) {
			System.out.print(i + " ");
		}
	}

	private void mergeSort(int[] inputArr) {
		this.array = inputArr;
		this.length = inputArr.length;
		this.tempMergArr = new int[length];
		doMergeSort(0, length - 1);
	}

	private void doMergeSort(int i, int j) {
		if (i < j) {
			int m = i + (j - i) / 2;
			doMergeSort(i, m);
			doMergeSort(m + 1, j);
			mergeParts(i, m, j);
		}
	}

	private void mergeParts(int lower, int middle, int higher) {
		for (int p = lower; p <= higher; p++) {
			tempMergArr[p] = array[p];
		}
		int i = lower;
		int j = middle + 1;
		int k = lower;
		while (i <= middle && j <= higher) {
			if (tempMergArr[i] <= tempMergArr[j]) {
				array[k] = tempMergArr[i];
				i++;
			} else {
				array[k] = tempMergArr[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			array[k] = tempMergArr[i];
			k++;
			i++;
		}
	}
}
