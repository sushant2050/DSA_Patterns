package com.dsa.pattern;

import java.util.Arrays;

/**
 * Demonstrates the <b>Dynamic Programming (DP) Pattern</b>.
 *
 * <p>
 * Dynamic Programming is an optimization technique used to solve problems by breaking them
 * down into overlapping subproblems, solving each subproblem only once, and storing their
 * results (memoization or tabulation) to avoid recomputation.
 * </p>
 *
 * <h2>Key Idea</h2>
 * <ul>
 *   <li>Identify overlapping subproblems</li>
 *   <li>Define a recurrence relation</li>
 *   <li>Use memoization (top-down) or tabulation (bottom-up) to store results</li>
 *   <li>Combine subproblem solutions to get the final answer</li>
 * </ul>
 *
 * <h2>When to Use</h2>
 * <ul>
 *   <li>Fibonacci numbers or factorial-like sequences</li>
 *   <li>Knapsack problems</li>
 *   <li>Coin change / minimum path sum / matrix chain multiplication</li>
 *   <li>Longest common subsequence / substring problems</li>
 * </ul>
 *
 * <h2>Example Implementation</h2>
 *
 * <pre>{@code
 * package com.dsa.pattern;
 *
 * import java.util.Arrays;
 *
 * public class DynamicProgrammingExample {
 *
 *     // Fibonacci using Top-Down DP (Memoization)
 *     public static int fibonacci(int n, int[] memo) {
 *         if (n <= 1) return n;
 *         if (memo[n] != -1) return memo[n];
 *         memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
 *         return memo[n];
 *     }
 *
 *     // Fibonacci using Bottom-Up DP (Tabulation)
 *     public static int fibonacciBottomUp(int n) {
 *         if (n <= 1) return n;
 *         int[] dp = new int[n + 1];
 *         dp[0] = 0; dp[1] = 1;
 *         for (int i = 2; i <= n; i++) {
 *             dp[i] = dp[i - 1] + dp[i - 2];
 *         }
 *         return dp[n];
 *     }
 *
 *     public static void main(String[] args) {
 *         int n = 10;
 *
 *         int[] memo = new int[n + 1];
 *         Arrays.fill(memo, -1);
 *
 *         System.out.println("Fibonacci (Top-Down) of " + n + " = " + fibonacci(n, memo));
 *         System.out.println("Fibonacci (Bottom-Up) of " + n + " = " + fibonacciBottomUp(n));
 *     }
 * }
 * }</pre>
 *
 * <h2>Complexity</h2>
 * <ul>
 *   <li>Time Complexity: O(n) for both memoization and tabulation</li>
 *   <li>Space Complexity: O(n) for memo array or DP table + recursion stack (top-down)</li>
 * </ul>
 *
 * <h2>Applications</h2>
 * <ul>
 *   <li>Fibonacci sequence</li>
 *   <li>Knapsack problem</li>
 *   <li>Longest common subsequence / substring</li>
 *   <li>Minimum path sum in a grid</li>
 *   <li>Coin change and other combinatorial optimization problems</li>
 * </ul>
 */
public class DynamicProgramming {

	public class DynamicProgrammingExample {

		// Fibonacci using Top-Down DP (Memoization)
		public static int fibonacci(int n, int[] memo) {
			if (n <= 1)
				return n;
			if (memo[n] != -1)
				return memo[n];
			memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
			return memo[n];
		}

		// Fibonacci using Bottom-Up DP (Tabulation)
		public static int fibonacciBottomUp(int n) {
			if (n <= 1)
				return n;
			int[] dp = new int[n + 1];
			dp[0] = 0;
			dp[1] = 1;
			for (int i = 2; i <= n; i++) {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
			return dp[n];
		}

		public static void main(String[] args) {
			int n = 10;

			int[] memo = new int[n + 1];
			Arrays.fill(memo, -1);

			System.out.println("Fibonacci (Top-Down) of " + n + " = " + fibonacci(n, memo));
			System.out.println("Fibonacci (Bottom-Up) of " + n + " = " + fibonacciBottomUp(n));
		}
	}
}