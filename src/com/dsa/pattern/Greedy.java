package com.dsa.pattern;

import java.util.Arrays;

/**
 * Demonstrates the <b>Greedy Pattern</b>.
 *
 * <p>
 * Greedy algorithms build a solution iteratively by choosing the locally optimal choice
 * at each step, with the hope that these local choices lead to a globally optimal solution.
 * </p>
 *
 * <h2>Key Idea</h2>
 * <ul>
 *   <li>Make the best choice at each step based on a defined criterion</li>
 *   <li>Do not reconsider previous choices (no backtracking)</li>
 *   <li>Works for problems that have the greedy-choice property and optimal substructure</li>
 * </ul>
 *
 * <h2>When to Use</h2>
 * <ul>
 *   <li>Interval scheduling / activity selection problems</li>
 *   <li>Huffman coding</li>
 *   <li>Kruskal's Minimum Spanning Tree</li>
 *   <li>Dijkstra's shortest path (with non-negative weights)</li>
 *   <li>Coin change problem (for certain coin systems)</li>
 * </ul>
 *
 * <h2>Example Implementation</h2>
 *
 * <pre>{@code
 * package com.dsa.pattern;
 *
 * import java.util.Arrays;
 *
 * public class GreedyExample {
 *
 *     // Activity selection problem (maximize number of non-overlapping activities)
 *     static class Activity implements Comparable<Activity> {
 *         int start, finish;
 *         Activity(int start, int finish) { this.start = start; this.finish = finish; }
 *
 *         public int compareTo(Activity other) {
 *             return this.finish - other.finish; // sort by finish time
 *         }
 *     }
 *
 *     public static void activitySelection(Activity[] activities) {
 *         Arrays.sort(activities);
 *         int n = activities.length;
 *         System.out.println("Selected activities:");
 *         int lastFinish = 0;
 *         for (Activity act : activities) {
 *             if (act.start >= lastFinish) {
 *                 System.out.println("Activity (" + act.start + ", " + act.finish + ")");
 *                 lastFinish = act.finish;
 *             }
 *         }
 *     }
 *
 *     public static void main(String[] args) {
 *         Activity[] activities = {
 *             new Activity(1, 4),
 *             new Activity(3, 5),
 *             new Activity(0, 6),
 *             new Activity(5, 7),
 *             new Activity(3, 9),
 *             new Activity(5, 9),
 *             new Activity(6, 10),
 *             new Activity(8, 11)
 *         };
 *
 *         activitySelection(activities);
 *     }
 * }
 * }</pre>
 *
 * <h2>Complexity</h2>
 * <ul>
 *   <li>Time Complexity: O(n log n) for sorting + O(n) selection = O(n log n)</li>
 *   <li>Space Complexity: O(n) for storing activities or output</li>
 * </ul>
 *
 * <h2>Applications</h2>
 * <ul>
 *   <li>Interval scheduling / activity selection</li>
 *   <li>Huffman encoding</li>
 *   <li>Kruskal's MST</li>
 *   <li>Dijkstra's shortest path (non-negative weights)</li>
 *   <li>Certain coin change problems</li>
 * </ul>
 */
public class Greedy {

	public class GreedyExample {

		// Activity selection problem (maximize number of non-overlapping activities)
		static class Activity implements Comparable<Activity> {
			int start, finish;

			Activity(int start, int finish) {
				this.start = start;
				this.finish = finish;
			}

			public int compareTo(Activity other) {
				return this.finish - other.finish; // sort by finish time
			}
		}

		public static void activitySelection(Activity[] activities) {
			Arrays.sort(activities);
			int n = activities.length;
			System.out.println("Selected activities:");
			int lastFinish = 0;
			for (Activity act : activities) {
				if (act.start >= lastFinish) {
					System.out.println("Activity (" + act.start + ", " + act.finish + ")");
					lastFinish = act.finish;
				}
			}
		}

		public static void main(String[] args) {
			Activity[] activities = { new Activity(1, 4), new Activity(3, 5), new Activity(0, 6), new Activity(5, 7),
					new Activity(3, 9), new Activity(5, 9), new Activity(6, 10), new Activity(8, 11) };

			activitySelection(activities);
		}
	 }
}