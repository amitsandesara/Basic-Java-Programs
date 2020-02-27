
@SuppressWarnings("serial")
public class EnhancedFor extends Exception {


	public static void main(String args[]) {

		int total = 0;
		int arr[] = {4, 5, 64, 34, 23, 78};
		int nums[] = {1, 1, 1, 2, 2, 3, 3, 3, 3};

		for (int x : arr) {
			total += x;
		}
		System.out.println(total);

		for (int i = 0; i < nums.length; i++) {
			System.out.println("i = " + i + " ");
			while ((nums[i] == nums[i + 1])) {
				i++;
				System.out.println(" In while: i=  " + i + " ");
				if (!((i + 1) < nums.length))
					break;
			}
			System.out.println(nums[i]);
		}

		String s = "JAVA";
		s.concat(" SE 6");
		System.out.println(s);
		System.out.println(s instanceof Object);
		int max = Math.max(34, 34);
		System.out.println(max);
	}
}
