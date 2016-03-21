
public class InsertionSort {
	public static void main(String args[]){
		long startTime = System.nanoTime();
		int[] arr = {45, 18, 7, 99, 87, 11, 29, 32, 8, 15, 54, 96, 45, 67, 34};
		System.out.println("Input Array:- ");
		print(arr);
		ISort(arr);
		System.out.println("\nSorted Array:- ");
		print(arr);
		long endTime = System.nanoTime();
		System.out.println("\nTook "+(endTime-startTime)/1000+" ms to sort");
	}

	private static void ISort(int[] arr) {
		// TODO Auto-generated method stub
		for(int i = 0; i < arr.length; i++){
			int currentValue = arr[i];
			int position = i;
			while(position > 0 && currentValue < arr[position-1]){
				arr[position] = arr[position -1];
				position--;
			}
			{
				arr[position] = currentValue;
			}
		}
	}

	private static void print(int[] arr) {
		// TODO Auto-generated method stub
		for(Integer j : arr){
			System.out.print(" "+ j+" |");
		}
	}
}
