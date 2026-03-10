package com.dsa.pattern;

/**
 * Demonstrates the <b>Segment Tree Pattern</b>.
 *
 * <p>
 * A Segment Tree is a binary tree used for efficient range queries and updates
 * on an array. It allows querying for sums, minimums, maximums, GCD, or other
 * associative operations over a segment of the array in O(log n) time.
 * </p>
 *
 * <h2>Key Idea</h2>
 * <ul>
 * <li>Each node represents a segment (interval) of the array</li>
 * <li>Leaf nodes store individual array elements</li>
 * <li>Internal nodes combine results of their children (sum, min, max,
 * etc.)</li>
 * <li>Supports efficient point updates and range queries in O(log n) time</li>
 * </ul>
 *
 * <h2>When to Use</h2>
 * <ul>
 * <li>Range sum query (RSQ)</li>
 * <li>Range minimum / maximum query (RMQ)</li>
 * <li>Dynamic updates on arrays with frequent queries</li>
 * <li>Problems requiring associative operations on subarrays</li>
 * </ul>
 *
 * <h2>Example Implementation (Range Sum)</h2>
 *
 * <pre>{@code
 * package com.dsa.pattern;
 *
 * public class SegmentTreeExample {
 *
 * 	static class SegmentTree {
 * 		int[] tree;
 * 		int n;
 *
 * 		SegmentTree(int[] arr) {
 * 			n = arr.length;
 * 			tree = new int[4 * n];
 * 			build(arr, 0, n - 1, 0);
 * 		}
 *
 * 		private void build(int[] arr, int start, int end, int node) {
 * 			if (start == end) {
 * 				tree[node] = arr[start];
 * 				return;
 * 			}
 * 			int mid = (start + end) / 2;
 * 			build(arr, start, mid, 2 * node + 1);
 * 			build(arr, mid + 1, end, 2 * node + 2);
 * 			tree[node] = tree[2 * node + 1] + tree[2 * node + 2]; // sum
 * 		}
 *
 * 		public void update(int idx, int val) {
 * 			updateUtil(0, n - 1, idx, val, 0);
 * 		}
 *
 * 		private void updateUtil(int start, int end, int idx, int val, int node) {
 * 			if (start == end) {
 * 				tree[node] = val;
 * 				return;
 * 			}
 * 			int mid = (start + end) / 2;
 * 			if (idx <= mid)
 * 				updateUtil(start, mid, idx, val, 2 * node + 1);
 * 			else
 * 				updateUtil(mid + 1, end, idx, val, 2 * node + 2);
 * 			tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
 * 		}
 *
 * 		public int query(int l, int r) {
 * 			return queryUtil(0, n - 1, l, r, 0);
 * 		}
 *
 * 		private int queryUtil(int start, int end, int l, int r, int node) {
 * 			if (r < start || end < l)
 * 				return 0; // no overlap
 * 			if (l <= start && end <= r)
 * 				return tree[node]; // total overlap
 * 			int mid = (start + end) / 2;
 * 			int left = queryUtil(start, mid, l, r, 2 * node + 1);
 * 			int right = queryUtil(mid + 1, end, l, r, 2 * node + 2);
 * 			return left + right; // partial overlap
 * 		}
 * 	}
 *
 * 	public static void main(String[] args) {
 * 		int[] arr = { 1, 3, 5, 7, 9, 11 };
 * 		SegmentTree st = new SegmentTree(arr);
 *
 * 		System.out.println("Sum of values in range [1, 3]: " + st.query(1, 3));
 * 		st.update(1, 10);
 * 		System.out.println("After update, sum of values in range [1, 3]: " + st.query(1, 3));
 * 	}
 * }
 * }</pre>
 *
 * <h2>Complexity</h2>
 * <ul>
 * <li>Time Complexity: O(n) for building, O(log n) for query and update</li>
 * <li>Space Complexity: O(4 * n) for tree array</li>
 * </ul>
 *
 * <h2>Applications</h2>
 * <ul>
 * <li>Range sum / minimum / maximum queries with updates</li>
 * <li>Dynamic interval queries</li>
 * <li>Competitive programming problems involving intervals</li>
 * </ul>
 */
public class SegmentTree {
	int[] tree;
	int n;

	SegmentTree(int[] arr) {
		n = arr.length;
		tree = new int[4 * n];
		build(arr, 0, n - 1, 0);
	}

	private void build(int[] arr, int start, int end, int node) {
		if (start == end) {
			tree[node] = arr[start];
			return;
		}
		int mid = (start + end) / 2;
		build(arr, start, mid, 2 * node + 1);
		build(arr, mid + 1, end, 2 * node + 2);
		tree[node] = tree[2 * node + 1] + tree[2 * node + 2]; // sum
	}

	public void update(int idx, int val) {
		updateUtil(0, n - 1, idx, val, 0);
	}

	private void updateUtil(int start, int end, int idx, int val, int node) {
		if (start == end) {
			tree[node] = val;
			return;
		}
		int mid = (start + end) / 2;
		if (idx <= mid)
			updateUtil(start, mid, idx, val, 2 * node + 1);
		else
			updateUtil(mid + 1, end, idx, val, 2 * node + 2);
		tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
	}

	public int query(int l, int r) {
		return queryUtil(0, n - 1, l, r, 0);
	}

	private int queryUtil(int start, int end, int l, int r, int node) {
		if (r < start || end < l)
			return 0; // no overlap
		if (l <= start && end <= r)
			return tree[node]; // total overlap
		int mid = (start + end) / 2;
		int left = queryUtil(start, mid, l, r, 2 * node + 1);
		int right = queryUtil(mid + 1, end, l, r, 2 * node + 2);
		return left + right; // partial overlap
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 7, 9, 11 };
		SegmentTree st = new SegmentTree(arr);

		System.out.println("Sum of values in range [1, 3]: " + st.query(1, 3));
		st.update(1, 10);
		System.out.println("After update, sum of values in range [1, 3]: " + st.query(1, 3));
	}
}