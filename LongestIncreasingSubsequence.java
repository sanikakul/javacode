package practiceproblems;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] input = {5, 2, 6, 3, 4, 1, 9, 9, 8, 9, 5};
		List<Integer> output = new ArrayList<>();
		output = isLongestIncresingSubsequence(input, output);
		System.out.println();
	}

	private static List<Integer> isLongestIncresingSubsequence(int[] input, List<Integer> output) {
		int[] sorted = {1, 2, 3, 4, 5, 5, 6, 8, 9, 9, 9};
		/*
		 * Get the input array sorted using Quicksort.
		 * Time Complexity is O(nlogn)
		 * 
		 sorted = QuickSort(input);
		 */
		return output;
	}

}
