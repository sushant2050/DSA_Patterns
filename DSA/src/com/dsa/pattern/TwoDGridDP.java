package com.dsa.pattern;

/**
 * Demonstrates the <b>2D / Grid Dynamic Programming (DP) Pattern</b>.
 *
 * <p>
 * 2D DP is used for problems that can be represented as a grid (matrix) where
 * the solution at a cell depends on previous cells, such as unique paths,
 * minimum path sum, or coin change in grids.
 * </p>
 *
 * <h2>Key Idea</h2>
 * <ul>
 * <li>Define a 2D DP table `dp[i][j]` representing the solution for cell (i,
 * j)</li>
 * <li>Use previously computed results from neighboring cells (top, left, or
 * diagonal)</li>
 * <li>Iteratively fill the DP table using recurrence relations</li>
 * <li>Optionally optimize space to 1D array if only previous row is needed</li>
 * </ul>
 *
 * <h2>When to Use</h2>
 * <ul>
 * <li>Grid-based pathfinding problems</li>
 * <li>Minimum/maximum sum along paths</li>
 * <li>Counting unique paths or ways in a matrix</li>
 * <li>Classic DP problems like edit distance, matrix chain multiplication,
 * etc.</li>
 * </ul>
 *
 * <h2>Example Implementation (Unique Paths)</h2>
 *
 * <pre>{@code
 * package com.dsa.pattern;
 *
 * public class TwoDGridDPExample {
 *
 * 	// Count unique paths in m x n grid moving only down or right
 * 	public static int uniquePaths(int m, int n) {
 * 		int[][] dp = new int[m][n];
 *
 * 		// Base case: first row and first column have only 1 way
 * 		for (int i = 0; i < m; i++)
 * 			dp[i][0] = 1;
 * 		for (int j = 0; j < n; j++)
 * 			dp[0][j] = 1;
 *
 * 		for (int i = 1; i < m; i++) {
 * 			for (int j = 1; j < n; j++) {
 * 				dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // sum of top + left
 * 			}
 * 		}
 * 		return dp[m - 1][n - 1];
 * 	}
 *
 * 	public static void main(String[] args) {
 * 		int m = 3, n = 7;
 * 		System.out.println("Number of unique paths in a " + m + "x" + n + " grid: " + uniquePaths(m, n));
 * 	}
 * }
 * }</pre>
 *
 * <h2>Complexity</h2>
 * <ul>
 * <li>Time: O(m * n) to fill the DP table</li>
 * <li>Space: O(m * n) for the DP table (can be optimized to O(n))</li>
 * </ul>
 *
 * <h2>Applications</h2>
 * <ul>
 * <li>Unique paths counting in grids</li>
 * <li>Minimum / maximum path sum problems</li>
 * <li>2D versions of knapsack or DP problems</li>
 * <li>Edit distance, matrix chain multiplication</li>
 * </ul>
 */
public class TwoDGridDP {

	public class TwoDGridDPExample {

		// Count unique paths in m x n grid moving only down or right
		public static int uniquePaths(int m, int n) {
			int[][] dp = new int[m][n];

			// Base case: first row and first column have only 1 way
			for (int i = 0; i < m; i++)
				dp[i][0] = 1;
			for (int j = 0; j < n; j++)
				dp[0][j] = 1;

			for (int i = 1; i < m; i++) {
				for (int j = 1; j < n; j++) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // sum of top + left
				}
			}
			return dp[m - 1][n - 1];
		}

		public static void main(String[] args) {
			int m = 3, n = 7;
			System.out.println("Number of unique paths in a " + m + "x" + n + " grid: " + uniquePaths(m, n));
		}
	}
}