import java.util.*;

public class PowerSet {

	private static void powerSet(char[] set) {
		int powerSetSize = (int) Math.pow(2, set.length);
		String[] binarySet = new String[powerSetSize];
		String zero = "0";
		HashSet<Set<Character>> hset = new HashSet<Set<Character>>();

		for (int i = 0; i < powerSetSize; i++) {
			String temp = Integer.toString(i, 2);
			while (String.valueOf(temp).length() != set.length) {
				temp = zero + temp;
			}
			binarySet[i] = (temp);
		}

		for (int j = 0; j < binarySet.length; j++) {
			Set<Character> temp = new HashSet<Character>();
			for (int k = set.length - 1; k >= 0; k--) {
				if (binarySet[j].charAt(k) == '1') {
					temp.add(set[set.length - k - 1]);
				}
			}
			hset.add(temp);
		}

		Iterator<Set<Character>> iter = hset.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println("Total sets in PowerSet:- " + hset.size());
	}

	public static void main(String args[]) {
		char set[] = {'1', '2', '3', '6', '8', '9'};
		long startTime = System.nanoTime();
		powerSet(set);
		long endTime = System.nanoTime();
		System.out.println("Took " + (endTime - startTime) / 1000 + " ms for execution");
	}
}
