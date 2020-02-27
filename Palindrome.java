public class Palindrome {
	public static boolean palindromeStack(String s) {
		Stack s1 = new Stack(s.length());
		if (s.length() % 2 == 0) {
			for (int j = 0; j < s.length() / 2; j++)
				s1.push(s.charAt(j));
			for (int j = s.length() / 2; j < s.length(); j++) {
				if (s.charAt(j) == s1.peek())
					s1.pop();
			}
			if (s1.isEmpty())
				return true;
		} else {
			for (int j = 0; j < s.length() / 2; j++)
				s1.push(s.charAt(j));
			for (int j = s.length() / 2 + 1; j < s.length(); j++) {
				if (s.charAt(j) == s1.peek())
					s1.pop();
			}
			if (s1.isEmpty())
				return true;
		}
		return false;
	}


	private static boolean palindromeIteration(String s) {
		for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {
			if (s.charAt(i) == s.charAt(j))
				continue;
			else
				return false;
		}
		return true;
	}

	public static void main(String args[]) {
		String s = "nayannayan";

		boolean arm = palindromeStack(s);
		boolean Arm1 = palindromeIteration(s);
		if (Arm1 && arm)
			System.out.println(s + " is palindrome");
		else
			System.out.println(s + " is not palindrome");
	}
}
