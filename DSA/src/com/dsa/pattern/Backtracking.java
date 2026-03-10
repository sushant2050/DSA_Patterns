package com.dsa.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates the <b>Backtracking Pattern</b>.
 *
 * <p>
 * Backtracking is a recursive, depth-first search technique used to solve
 * problems that require exploring all possible combinations or configurations
 * while pruning invalid paths early.
 * </p>
 *
 * <h2>Key Idea</h2>
 * <ul>
 *   <li>Try each option for a decision at the current step</li>
 *   <li>Recursively move to the next step</li>
 *   <li>If a path is invalid, backtrack to try other options</li>
 *   <li>Prune paths early to reduce unnecessary exploration</li>
 * </ul>
 *
 * <h2>When to Use</h2>
 * <ul>
 *   <li>Permutation / Combination problems</li>
 *   <li>Sudoku solver</li>
 *   <li>N-Queens problem</li>
 *   <li>Maze or puzzle solving</li>
 * </ul>
 *
 * <h2>Example Implementation</h2>
 *
 * <pre>{@code
 * package com.dsa.pattern;
 *
 * import java.util.ArrayList;
 * import java.util.List;
 *
 * public class BacktrackingExample {
 *
 *     // Generate all subsets of a given set
 *     public static List<List<Integer>> generateSubsets(int[] nums) {
 *         List<List<Integer>> result = new ArrayList<>();
 *         backtrack(nums, 0, new ArrayList<>(), result);
 *         return result;
 *     }
 *
 *     private static void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
 *
 *         result.add(new ArrayList<>(current));
 *
 *         for (int i = index; i < nums.length; i++) {
 *             current.add(nums[i]);             // choose
 *             backtrack(nums, i + 1, current, result); // explore
 *             current.remove(current.size() - 1); // un-choose (backtrack)
 *         }
 *     }
 *
 *     public static void main(String[] args) {
 *         int[] nums = {1, 2, 3};
 *
 *         List<List<Integer>> subsets = generateSubsets(nums);
 *
 *         System.out.println("All subsets:");
 *         for (List<Integer> subset : subsets) {
 *             System.out.println(subset);
 *         }
 *     }
 * }
 * }</pre>
 *
 * <h2>Complexity</h2>
 * <ul>
 *   <li>Time Complexity: O(2^n * n) (for generating all subsets)</li>
 *   <li>Space Complexity: O(n) recursion stack + output storage</li>
 * </ul>
 *
 * <h2>Applications</h2>
 * <ul>
 *   <li>Permutations / Combinations</li>
 *   <li>N-Queens</li>
 *   <li>Sudoku Solver</li>
 *   <li>Maze / Puzzle solving</li>
 *   <li>Word search and constraint satisfaction problems</li>
 * </ul>
 */
public class Backtracking {

	public class BacktrackingExample {

		// Generate all subsets of a given set
		public static List<List<Integer>> generateSubsets(int[] nums) {
			List<List<Integer>> result = new ArrayList<>();
			backtrack(nums, 0, new ArrayList<>(), result);
			return result;
		}

		private static void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {

			result.add(new ArrayList<>(current));

			for (int i = index; i < nums.length; i++) {
				current.add(nums[i]); // choose
				backtrack(nums, i + 1, current, result); // explore
				current.remove(current.size() - 1); // un-choose (backtrack)
			}
		}

		public static void main(String[] args) {
			int[] nums = { 1, 2, 3 };

			List<List<Integer>> subsets = generateSubsets(nums);

			System.out.println("All subsets:");
			for (List<Integer> subset : subsets) {
				System.out.println(subset);
			}
		}
	}
}