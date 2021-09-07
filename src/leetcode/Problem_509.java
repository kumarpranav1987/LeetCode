package leetcode;

import java.util.Arrays;

public class Problem_509 {
	public static void main(String[] args) {
		Problem_509 p = new Problem_509();
		System.out.println(p.fib(3));
	}

	public int fib(int n) {
		int[] memo = new int[n + 1];
		Arrays.fill(memo, -1);
		return fib(n, memo);
	}

	private int fib(int n, int[] memo) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (memo[n] != -1) {
			return memo[n];
		}
		memo[n] = fib(n - 1) + fib(n - 2);
		return memo[n];
	}
}
