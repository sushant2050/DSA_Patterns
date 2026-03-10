package com.dsa.pattern;

/**
 * Demonstrates the <b>Sliding Window Pattern</b>.
 *
 * <p>
 * The Sliding Window technique is used to efficiently process
 * a range of elements in an array or list. Instead of recalculating
 * values for every subarray, a "window" moves across the array,
 * expanding and shrinking as needed.
 * </p>
 *
 * <h2>When to Use</h2>
 * <ul>
 *   <li>Subarray or substring problems</li>
 *   <li>Maximum or minimum sum of a subarray</li>
 *   <li>Longest substring with certain conditions</li>
 *   <li>Problems involving contiguous elements</li>
 * </ul>
 *
 * <h2>Key Idea</h2>
 * <p>
 * Maintain a window using two pointers:
 * </p>
 * <ul>
 *   <li><b>start</b> → beginning of window</li>
 *   <li><b>end</b> → end of window</li>
 * </ul>
 *
 * <p>
 * The window expands when adding elements and shrinks when constraints are violated.
 * </p>
 *
 * <h2>Example Implementation</h2>
 *
 * <pre>{@code
 * package com.dsa.pattern;
 *
 * public class SlidingWindowExample {
 *
 *     // Find maximum sum of subarray of size k
 *     public static int maxSumSubarray(int[] arr, int k) {
 *
 *         int windowSum = 0;
 *         int maxSum = 0;
 *         int windowStart = 0;
 *
 *         for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
 *
 *             windowSum += arr[windowEnd]; // expand window
 *
 *             if (windowEnd >= k - 1) {
 *
 *                 maxSum = Math.max(maxSum, windowSum);
 *
 *                 System.out.println("Window [" + windowStart + "," + windowEnd + "] Sum: " + windowSum);
 *
 *                 windowSum -= arr[windowStart]; // shrink window
 *                 windowStart++;
 *             }
 *         }
 *
 *         return maxSum;
 *     }
 *
 *     public static void main(String[] args) {
 *
 *         int[] arr = {2, 1, 5, 1, 3, 2};
 *         int k = 3;
 *
 *         int result = maxSumSubarray(arr, k);
 *
 *         System.out.println("Maximum Sum of Subarray of size " + k + " = " + result);
 *     }
 * }
 * }</pre>
 *
 * <h2>Complexity</h2>
 * <ul>
 *   <li><b>Time Complexity:</b> O(n)</li>
 *   <li><b>Space Complexity:</b> O(1)</li>
 * </ul>
 *
 * <h2>Common Problems Using Sliding Window</h2>
 * <ul>
 *   <li>Maximum sum subarray of size k</li>
 *   <li>Longest substring without repeating characters</li>
 *   <li>Minimum window substring</li>
 *   <li>Average of subarrays of size k</li>
 * </ul>
 */
public class SlidingWindow {
	public class SlidingWindowExample {
		
		    // Find maximum sum of subarray of size k
		    public static int maxSumSubarray(int[] arr, int k) {
		
		        int windowSum = 0;
		        int maxSum = 0;
		        int windowStart = 0;
		
		        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
		
		            windowSum += arr[windowEnd]; // expand window
		
		            if (windowEnd >= k - 1) {
		
		                maxSum = Math.max(maxSum, windowSum);
		
		                System.out.println("Window [" + windowStart + "," + windowEnd + "] Sum: " + windowSum);
		
		                windowSum -= arr[windowStart]; // shrink window
		                windowStart++;
		            }
		        }
		
		        return maxSum;
		    }
		
		    public static void main(String[] args) {
		
		        int[] arr = {2, 1, 5, 1, 3, 2};
		        int k = 3;
		
		        int result = maxSumSubarray(arr, k);
		
		        System.out.println("Maximum Sum of Subarray of size " + k + " = " + result);
		    }
		}
}