import java.util.*;

public class Fibonacci {
	public static long fib[];

	Fibonacci(int n) {
		fib = new long[n + 1];
		fib[0] = 0;
		if (n > 0)
			fib[1] = 1;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number for Fibonacci series:- ");
		int n = sc.nextInt();
		Fibonacci f = new Fibonacci(n);
		long start = System.currentTimeMillis();
		System.out.println("Fibonacci of " + n + " : " + recursiveFibonacci(n));
		long end = System.currentTimeMillis();
		System.out.println("Time taken by Recursion:- " + (end - start) + " ms");
		start = System.currentTimeMillis();
		long val = f.memoFibonacci(n);
		System.out.println("\nFibonacci of " + n + ": " + val);
		end = System.currentTimeMillis();
		System.out.println("Time taken by Memoization:- " + (end - start) + " ms");

		sc.close();
	}

	private long memoFibonacci(int n) {
		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[n];
	}

	private static long recursiveFibonacci(int n) {
		if (n <= 1)
			return n;
		else
			return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
	}
}
