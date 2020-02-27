import java.util.*;

class newStack {
	private int maxSize;
	private char[] stackArray;
	private int top;

	newStack(int s) {
		maxSize = s;
		stackArray = new char[maxSize];
		top = -1;
	}

	public void push(char s) {
		stackArray[++top] = s;
	}

	public char pop() {
		char s = stackArray[top--];
		return s;
	}

	public char peek() {
		if (top != -1) {
			return stackArray[top];
		} else
			return 0;
	}
}


public class Paranthesis {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string with paranthesis:- ");
		String str = sc.nextLine();
		int length = str.length();

		newStack myStack = new newStack(length);
		boolean myFlag = true;
		for (int i = 0; i < length; i++) {

			if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
				myStack.push(str.charAt(i));
				continue;
			} else if (str.charAt(i) == '}' && myStack.peek() == '{') {
				myStack.pop();
			} else if (str.charAt(i) == ')' && myStack.peek() == '(') {
				myStack.pop();
			} else if (str.charAt(i) == ']' && myStack.peek() == '[') {
				myStack.pop();
			} else if (Character.isLetterOrDigit(str.charAt(i))) {
				continue;
			} else {
				myFlag = false;
			}
		}
		System.out.println(myFlag ? "Valid paranthesis" : "Not a valid paranthesis");
		sc.close();
	}
}

