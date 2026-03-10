package com.dsa.pattern;

import java.util.*;

/**
 * Demonstrates the <b>Meet in the Middle (MITM) Pattern</b>.
 *
 * <p>
 * Meet in the Middle is an optimization technique for problems that are too
 * large for brute-force but can be split into two halves. It is commonly used
 * for subset sum, combinatorial search, or problems where N is too large for
 * 2^N brute-force.
 * </p>
 *
 * <h2>Key Idea</h2>
 * <ul>
 * <li>Split the problem into two halves.</li>
 * <li>Compute all possible solutions for each half.</li>
 * <li>Combine results intelligently (often with binary search or hash
 * maps).</li>
 * <li>Reduces complexity from O(2^N) to O(2^(N/2)).</li>
 * </ul>
 *
 * <h2>When to Use</h2>
 * <ul>
 * <li>Subset sum / knapsack variants with moderate N (~30-40)</li>
 * <li>Combinatorial problems too large for naive brute force</li>
 * <li>Problems where splitting halves and combining reduces complexity</li>
 * </ul>
 *
 * <h2>Example Implementation (Subset Sum)</h2>
 *
 * <pre>{@code
 * package com.dsa.pattern;
 *
 * import java.util.*;
 *
 * public class MeetInTheMiddleExample {
 *
 * 	// Generate all subset sums of array arr
 * 	public static List<Integer> generateSums(int[] arr) {
 * 		List<Integer> sums = new ArrayList<>();
 * 		int n = arr.length;
 * 		for (int mask = 0; mask < (1 << n); mask++) {
 * 			int sum = 0;
 * 			for (int i = 0; i < n; i++) {
 * 				if ((mask & (1 << i)) != 0)
 * 					sum += arr[i];
 * 			}
 * 			sums.add(sum);
 * 		}
 * 		return sums;
 * 	}
 *
 * 	// Check if subset sum equals target
 * 	public static boolean subsetSum(int[] arr, int target) {
 * 		int n = arr.length;
 * 		int mid = n / 2;
 *
 * 		int[] left = Arrays.copyOfRange(arr, 0, mid);
 * 		int[] right = Arrays.copyOfRange(arr, mid, n);
 *
 * 		List<Integer> leftSums = generateSums(left);
 * 		List<Integer> rightSums = generateSums(right);
 * 		Collections.sort(rightSums);
 *
 * 		for (int s : leftSums) {
 * 			int remaining = target - s;
 * 			if (Collections.binarySearch(rightSums, remaining) >= 0)
 * 				return true;
 * 		}
 * 		return false;
 * 	}
 *
 * 	public static void main(String[] args) {
 * 		int[] arr = { 3, 34, 4, 12, 5, 2 };
 * 		int target = 9;
 * 		System.out.println("Subset sum " + target + " exists? " + subsetSum(arr, target));
 * 	}
 * }
 * }</pre>
 *
 * <h2>Complexity</h2>
 * <ul>
 * <li>Time: O(2^(N/2) * log(2^(N/2))) = O(2^(N/2) * N/2) due to sorting/binary
 * search</li>
 * <li>Space: O(2^(N/2)) for storing subset sums</li>
 * </ul>
 *
 * <h2>Applications</h2>
 * <ul>
 * <li>Subset sum problem for moderate N</li>
 * <li>Meet in the middle combinatorial optimization</li>
 * <li>Problems requiring splitting search space into halves</li>
 * </ul>
 */
public class MeetInTheMiddle {

	// Generate all subset sums of array arr
	public static List<Integer> generateSums(int[] arr) {
		List<Integer> sums = new ArrayList<>();
		int n = arr.length;
		for (int mask = 0; mask < (1 << n); mask++) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				if ((mask & (1 << i)) != 0)
					sum += arr[i];
			}
			sums.add(sum);
		}
		return sums;
	}

	// Check if subset sum equals target
	public static boolean subsetSum(int[] arr, int target) {
		int n = arr.length;
		int mid = n / 2;

		int[] left = Arrays.copyOfRange(arr, 0, mid);
		int[] right = Arrays.copyOfRange(arr, mid, n);

		List<Integer> leftSums = generateSums(left);
		List<Integer> rightSums = generateSums(right);
		Collections.sort(rightSums);

		for (int s : leftSums) {
			int remaining = target - s;
			if (Collections.binarySearch(rightSums, remaining) >= 0)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 34, 4, 12, 5, 2 };
		int target = 9;
		System.out.println("Subset sum " + target + " exists? " + subsetSum(arr, target));
	}
}