package leetcode;

import java.util.Arrays;

public class Problem_338 {
	public static void main(String[] args) {
		Problem_338 p = new Problem_338();
		System.out.println(Arrays.toString(p.countBits(10)));
	}

	public int[] countBits(int n) {
		int[] result = new int[n + 1];
		result[0] = 0;
		for (int i = 1; i <= n; i++) {
			result[i] = result[i - (int) Math.pow(2, (int) (Math.log10(i) / Math.log10(2)))] + 1;
		}
		return result;
	}
}
