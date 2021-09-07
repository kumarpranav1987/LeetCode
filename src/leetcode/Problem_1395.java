package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem_1395 {
	public static void main(String[] args) {
		int[] rating = new int[] { 100, 101, 102 };
		Problem_1395 p = new Problem_1395();
		System.out.println(p.numTeams(rating));
	}

	public int numTeams(int[] rating) {
		Map<String, Integer> memo = new HashMap<>();
		int increasing = numTeams(rating, 3, 0, 0, memo);
		memo = new HashMap<>();
		int decreasing = numTeamsMin(rating, 3, Integer.MAX_VALUE, 0, memo);
		return increasing + decreasing;
	}

	private int numTeams(int[] rating, int membersToSelect, int lastSelectedRating, int startIndex,
			Map<String, Integer> memo) {
		Integer result = memo.get(getKey(membersToSelect, lastSelectedRating, startIndex));
		if (result != null) {
			return result.intValue();
		}
		if (membersToSelect == 0) {
			return 1;
		}
		if (startIndex >= rating.length) {
			return 0;
		}
		int count = 0;
		for (int i = startIndex; i < rating.length; i++) {
			if (rating[i] > lastSelectedRating) {
				count += numTeams(rating, membersToSelect - 1, rating[i], i + 1, memo);
			}
		}
		memo.put(getKey(membersToSelect, lastSelectedRating, startIndex), count);
		return count;
	}

	private int numTeamsMin(int[] rating, int membersToSelect, int lastSelectedRating, int startIndex,
			Map<String, Integer> memo) {
		Integer result = memo.get(getKey(membersToSelect, lastSelectedRating, startIndex));
		if (result != null) {
			return result.intValue();
		}
		if (membersToSelect == 0) {
			return 1;
		}
		if (startIndex >= rating.length) {
			return 0;
		}
		int count = 0;
		for (int i = startIndex; i < rating.length; i++) {
			if (rating[i] < lastSelectedRating) {
				count += numTeamsMin(rating, membersToSelect - 1, rating[i], i + 1, memo);
			}
		}
		memo.put(getKey(membersToSelect, lastSelectedRating, startIndex), count);
		return count;
	}

	private String getKey(int membersToSelect, int lastSelectedRating, int startIndex) {
		return String.valueOf(membersToSelect) + ":" + String.valueOf(lastSelectedRating) + ":"
				+ String.valueOf(startIndex);
	}
}
