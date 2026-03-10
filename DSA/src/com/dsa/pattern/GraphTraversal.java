package com.dsa.pattern;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Demonstrates the <b>Graph Traversal Pattern</b>.
 *
 * <p>
 * Graph traversal is a technique to visit all nodes in a graph systematically.
 * The two main types are:
 * </p>
 * <ul>
 *   <li><b>Depth-First Search (DFS):</b> Explores as far as possible along each branch before backtracking</li>
 *   <li><b>Breadth-First Search (BFS):</b> Explores all neighbors at the current depth before moving deeper</li>
 * </ul>
 *
 * <h2>Key Idea</h2>
 * <ul>
 *   <li>DFS can be implemented recursively or with a stack</li>
 *   <li>BFS is implemented using a queue</li>
 *   <li>Keep track of visited nodes to avoid cycles</li>
 * </ul>
 *
 * <h2>When to Use</h2>
 * <ul>
 *   <li>Finding connected components</li>
 *   <li>Shortest path in unweighted graphs (BFS)</li>
 *   <li>Topological sorting</li>
 *   <li>Detecting cycles</li>
 *   <li>Maze or grid exploration</li>
 * </ul>
 *
 * <h2>Example Implementation</h2>
 *
 * <pre>{@code
 * package com.dsa.pattern;
 *
 * import java.util.*;
 *
 * public class GraphTraversalExample {
 *
 *     static class Graph {
 *         int V;
 *         List<List<Integer>> adj;
 *
 *         Graph(int V) {
 *             this.V = V;
 *             adj = new ArrayList<>();
 *             for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
 *         }
 *
 *         void addEdge(int u, int v) {
 *             adj.get(u).add(v);
 *             adj.get(v).add(u); // undirected graph
 *         }
 *     }
 *
 *     // Depth-First Search (DFS)
 *     public static void dfs(int node, boolean[] visited, Graph g) {
 *         visited[node] = true;
 *         System.out.print(node + " ");
 *         for (int neighbor : g.adj.get(node)) {
 *             if (!visited[neighbor]) dfs(neighbor, visited, g);
 *         }
 *     }
 *
 *     // Breadth-First Search (BFS)
 *     public static void bfs(int start, Graph g) {
 *         boolean[] visited = new boolean[g.V];
 *         Queue<Integer> queue = new LinkedList<>();
 *         visited[start] = true;
 *         queue.add(start);
 *
 *         while (!queue.isEmpty()) {
 *             int node = queue.poll();
 *             System.out.print(node + " ");
 *             for (int neighbor : g.adj.get(node)) {
 *                 if (!visited[neighbor]) {
 *                     visited[neighbor] = true;
 *                     queue.add(neighbor);
 *                 }
 *             }
 *         }
 *     }
 *
 *     public static void main(String[] args) {
 *         Graph g = new Graph(5);
 *         g.addEdge(0, 1);
 *         g.addEdge(0, 2);
 *         g.addEdge(1, 3);
 *         g.addEdge(2, 4);
 *
 *         System.out.print("DFS starting from node 0: ");
 *         boolean[] visited = new boolean[g.V];
 *         dfs(0, visited, g);
 *         System.out.println();
 *
 *         System.out.print("BFS starting from node 0: ");
 *         bfs(0, g);
 *     }
 * }
 * }</pre>
 *
 * <h2>Complexity</h2>
 * <ul>
 *   <li>Time Complexity: O(V + E), where V is number of vertices and E is number of edges</li>
 *   <li>Space Complexity: O(V) for visited array and recursion stack / queue</li>
 * </ul>
 *
 * <h2>Applications</h2>
 * <ul>
 *   <li>Graph connectivity</li>
 *   <li>Shortest path in unweighted graphs</li>
 *   <li>Cycle detection</li>
 *   <li>Topological sorting</li>
 *   <li>Maze or grid exploration problems</li>
 * </ul>
 */
public class GraphTraversal {

	public class GraphTraversalExample {

		static class Graph {
			int V;
			List<List<Integer>> adj;

			Graph(int V) {
				this.V = V;
				adj = new ArrayList<>();
				for (int i = 0; i < V; i++)
					adj.add(new ArrayList<>());
			}

			void addEdge(int u, int v) {
				adj.get(u).add(v);
				adj.get(v).add(u); // undirected graph
			}
		}

		// Depth-First Search (DFS)
		public static void dfs(int node, boolean[] visited, Graph g) {
			visited[node] = true;
			System.out.print(node + " ");
			for (int neighbor : g.adj.get(node)) {
				if (!visited[neighbor])
					dfs(neighbor, visited, g);
			}
		}

		// Breadth-First Search (BFS)
		public static void bfs(int start, Graph g) {
			boolean[] visited = new boolean[g.V];
			Queue<Integer> queue = new LinkedList<>();
			visited[start] = true;
			queue.add(start);

			while (!queue.isEmpty()) {
				int node = queue.poll();
				System.out.print(node + " ");
				for (int neighbor : g.adj.get(node)) {
					if (!visited[neighbor]) {
						visited[neighbor] = true;
						queue.add(neighbor);
					}
				}
			}
		}

		public static void main(String[] args) {
			Graph g = new Graph(5);
			g.addEdge(0, 1);
			g.addEdge(0, 2);
			g.addEdge(1, 3);
			g.addEdge(2, 4);

			System.out.print("DFS starting from node 0: ");
			boolean[] visited = new boolean[g.V];
			dfs(0, visited, g);
			System.out.println();

			System.out.print("BFS starting from node 0: ");
			bfs(0, g);
		}
	}
}