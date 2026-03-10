package com.dsa.pattern;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Demonstrates the <b>Tree Traversal Pattern</b>.
 *
 * <p>
 * Tree traversal is a technique to visit all the nodes of a tree systematically.
 * The main types are:
 * </p>
 * <ul>
 *   <li><b>Preorder:</b> Root → Left → Right</li>
 *   <li><b>Inorder:</b> Left → Root → Right</li>
 *   <li><b>Postorder:</b> Left → Right → Root</li>
 *   <li><b>Level Order:</b> Visit nodes level by level (BFS)</li>
 * </ul>
 *
 * <h2>Key Idea</h2>
 * <ul>
 *   <li>Use recursion or a stack for DFS traversals (Preorder, Inorder, Postorder)</li>
 *   <li>Use a queue for BFS (Level Order)</li>
 *   <li>Traversal order depends on problem requirements</li>
 * </ul>
 *
 * <h2>When to Use</h2>
 * <ul>
 *   <li>Binary Tree problems</li>
 *   <li>Binary Search Tree operations</li>
 *   <li>Tree-based algorithms (DFS, BFS)</li>
 *   <li>Computing height, diameter, or sum of nodes</li>
 * </ul>
 *
 * <h2>Example Implementation</h2>
 *
 * <pre>{@code
 * package com.dsa.pattern;
 *
 * import java.util.LinkedList;
 * import java.util.Queue;
 *
 * public class TreeTraversalExample {
 *
 *     static class TreeNode {
 *         int val;
 *         TreeNode left, right;
 *         TreeNode(int val) { this.val = val; }
 *     }
 *
 *     // Preorder traversal (Root → Left → Right)
 *     public static void preorder(TreeNode root) {
 *         if (root == null) return;
 *         System.out.print(root.val + " ");
 *         preorder(root.left);
 *         preorder(root.right);
 *     }
 *
 *     // Inorder traversal (Left → Root → Right)
 *     public static void inorder(TreeNode root) {
 *         if (root == null) return;
 *         inorder(root.left);
 *         System.out.print(root.val + " ");
 *         inorder(root.right);
 *     }
 *
 *     // Postorder traversal (Left → Right → Root)
 *     public static void postorder(TreeNode root) {
 *         if (root == null) return;
 *         postorder(root.left);
 *         postorder(root.right);
 *         System.out.print(root.val + " ");
 *     }
 *
 *     // Level Order traversal (BFS)
 *     public static void levelOrder(TreeNode root) {
 *         if (root == null) return;
 *         Queue<TreeNode> queue = new LinkedList<>();
 *         queue.add(root);
 *         while (!queue.isEmpty()) {
 *             TreeNode node = queue.poll();
 *             System.out.print(node.val + " ");
 *             if (node.left != null) queue.add(node.left);
 *             if (node.right != null) queue.add(node.right);
 *         }
 *     }
 *
 *     public static void main(String[] args) {
 *         TreeNode root = new TreeNode(1);
 *         root.left = new TreeNode(2);
 *         root.right = new TreeNode(3);
 *         root.left.left = new TreeNode(4);
 *         root.left.right = new TreeNode(5);
 *
 *         System.out.print("Preorder: "); preorder(root); System.out.println();
 *         System.out.print("Inorder: "); inorder(root); System.out.println();
 *         System.out.print("Postorder: "); postorder(root); System.out.println();
 *         System.out.print("Level Order: "); levelOrder(root); System.out.println();
 *     }
 * }
 * }</pre>
 *
 * <h2>Complexity</h2>
 * <ul>
 *   <li>Time Complexity: O(n), where n is the number of nodes</li>
 *   <li>Space Complexity: O(h) for recursion stack (DFS), O(n) for BFS queue</li>
 * </ul>
 *
 * <h2>Applications</h2>
 * <ul>
 *   <li>Binary Tree traversal problems</li>
 *   <li>Binary Search Tree operations</li>
 *   <li>Tree-based computations (height, diameter, sum)</li>
 *   <li>Graph/tree DFS & BFS analogues</li>
 * </ul>
 */
public class TreeTraversal {

	public class TreeTraversalExample {

		static class TreeNode {
			int val;
			TreeNode left, right;

			TreeNode(int val) {
				this.val = val;
			}
		}

		// Preorder traversal (Root → Left → Right)
		public static void preorder(TreeNode root) {
			if (root == null)
				return;
			System.out.print(root.val + " ");
			preorder(root.left);
			preorder(root.right);
		}

		// Inorder traversal (Left → Root → Right)
		public static void inorder(TreeNode root) {
			if (root == null)
				return;
			inorder(root.left);
			System.out.print(root.val + " ");
			inorder(root.right);
		}

		// Postorder traversal (Left → Right → Root)
		public static void postorder(TreeNode root) {
			if (root == null)
				return;
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.val + " ");
		}

		// Level Order traversal (BFS)
		public static void levelOrder(TreeNode root) {
			if (root == null)
				return;
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				System.out.print(node.val + " ");
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
		}

		public static void main(String[] args) {
			TreeNode root = new TreeNode(1);
			root.left = new TreeNode(2);
			root.right = new TreeNode(3);
			root.left.left = new TreeNode(4);
			root.left.right = new TreeNode(5);

			System.out.print("Preorder: ");
			preorder(root);
			System.out.println();
			System.out.print("Inorder: ");
			inorder(root);
			System.out.println();
			System.out.print("Postorder: ");
			postorder(root);
			System.out.println();
			System.out.print("Level Order: ");
			levelOrder(root);
			System.out.println();
		}
	}
}