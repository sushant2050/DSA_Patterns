package com.dsa.pattern;


import java.util.Stack;

/**
 * Demonstrates the <b>Monotonic Stack Pattern</b>.
 *
 * <p>
 * A Monotonic Stack is a stack that maintains its elements in either
 * increasing or decreasing order. It is commonly used to solve problems
 * that require the next greater or smaller element for each array element.
 * </p>
 *
 * <h2>Key Idea</h2>
 * <ul>
 *   <li>Maintain a stack where elements are monotonic (increasing or decreasing)</li>
 *   <li>While iterating, pop elements that violate the monotonic property</li>
 *   <li>Use the stack to answer queries like "next greater element"</li>
 * </ul>
 *
 * <h2>When to Use</h2>
 * <ul>
 *   <li>Next Greater / Smaller Element problems</li>
 *   <li>Histogram problems (largest rectangle in histogram)</li>
 *   <li>Temperature / Rainfall / Stock span type questions</li>
 * </ul>
 *
 * <h2>Example Implementation</h2>
 *
 * <pre>{@code
 * package com.dsa.pattern;
 *
 * import java.util.Stack;
 *
 * public class MonotonicStackExample {
 *
 *     // Find next greater element for each element in array
 *     public static int[] nextGreaterElement(int[] arr) {
 *
 *         int[] result = new int[arr.length];
 *         Stack<Integer> stack = new Stack<>();
 *
 *         for (int i = arr.length - 1; i >= 0; i--) {
 *
 *             while (!stack.isEmpty() && stack.peek() <= arr[i]) {
 *                 stack.pop();
 *             }
 *
 *             result[i] = stack.isEmpty() ? -1 : stack.peek();
 *             stack.push(arr[i]);
 *         }
 *
 *         return result;
 *     }
 *
 *     public static void main(String[] args) {
 *
 *         int[] arr = {2, 1, 2, 4, 3};
 *         int[] nge = nextGreaterElement(arr);
 *
 *         System.out.println("Next Greater Elements:");
 *         for (int i = 0; i < arr.length; i++) {
 *             System.out.println(arr[i] + " -> " + nge[i]);
 *         }
 *     }
 * }
 * }</pre>
 *
 * <h2>Complexity</h2>
 * <ul>
 *   <li><b>Time Complexity:</b> O(n)</li>
 *   <li><b>Space Complexity:</b> O(n)</li>
 * </ul>
 *
 * <h2>Applications</h2>
 * <ul>
 *   <li>Next Greater / Smaller Element problems</li>
 *   <li>Largest Rectangle in Histogram</li>
 *   <li>Stock Span Problem</li>
 *   <li>Daily Temperatures Problem</li>
 * </ul>
 */
public class MonotonicStack {

	public class MonotonicStackExample {

		// Find next greater element for each element in array
		public static int[] nextGreaterElement(int[] arr) {

			int[] result = new int[arr.length];
			Stack<Integer> stack = new Stack<>();

			for (int i = arr.length - 1; i >= 0; i--) {

				while (!stack.isEmpty() && stack.peek() <= arr[i]) {
					stack.pop();
				}

				result[i] = stack.isEmpty() ? -1 : stack.peek();
				stack.push(arr[i]);
			}

			return result;
		}

		public static void main(String[] args) {

			int[] arr = { 2, 1, 2, 4, 3 };
			int[] nge = nextGreaterElement(arr);

			System.out.println("Next Greater Elements:");
			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i] + " -> " + nge[i]);
			}
		}
	}
}