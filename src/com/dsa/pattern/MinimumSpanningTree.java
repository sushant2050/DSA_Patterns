package com.dsa.pattern;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Demonstrates the <b>Minimum Spanning Tree (MST) Pattern</b>.
 *
 * <p>
 * A Minimum Spanning Tree of a connected, weighted graph is a subset of edges
 * that connects all vertices without cycles and with the minimum total weight.
 * Two common algorithms are Kruskal’s and Prim’s.
 * </p>
 *
 * <h2>Key Idea</h2>
 * <ul>
 * <li><b>Kruskal’s Algorithm:</b> Sort all edges by weight and pick edges in
 * increasing order, using Union-Find to avoid cycles.</li>
 * <li><b>Prim’s Algorithm:</b> Start from a node and iteratively add the
 * smallest edge connecting a visited node to an unvisited node.</li>
 * </ul>
 *
 * <h2>When to Use</h2>
 * <ul>
 * <li>Constructing minimal-cost networks (roads, pipelines, electricity
 * grids)</li>
 * <li>Cluster analysis</li>
 * <li>Graph optimization problems</li>
 * </ul>
 *
 * <h2>Example Implementation</h2>
 *
 * <pre>{@code
 * package com.dsa.pattern;
 *
 * import java.util.*;
 *
 * public class MinimumSpanningTreeExample {
 *
 * 	static class Edge implements Comparable<Edge> {
 * 		int u, v, weight;
 * 
 * 		Edge(int u, int v, int w) {
 * 			this.u = u;
 * 			this.v = v;
 * 			this.weight = w;
 * 		}
 * 
 * 		public int compareTo(Edge other) {
 * 			return this.weight - other.weight;
 * 		}
 * 	}
 *
 * 	// ------------------ KRUSKAL ------------------
 * 	static class UnionFind {
 * 		int[] parent, rank;
 * 
 * 		UnionFind(int n) {
 * 			parent = new int[n];
 * 			rank = new int[n];
 * 			Arrays.fill(rank, 0);
 * 			for (int i = 0; i < n; i++)
 * 				parent[i] = i;
 * 		}
 * 
 * 		int find(int x) {
 * 			return parent[x] == x ? x : (parent[x] = find(parent[x]));
 * 		}
 * 
 * 		boolean union(int x, int y) {
 * 			int px = find(x), py = find(y);
 * 			if (px == py)
 * 				return false;
 * 			if (rank[px] < rank[py])
 * 				parent[px] = py;
 * 			else if (rank[px] > rank[py])
 * 				parent[py] = px;
 * 			else {
 * 				parent[py] = px;
 * 				rank[px]++;
 * 			}
 * 			return true;
 * 		}
 * 	}
 *
 * 	public static int kruskalMST(int V, List<Edge> edges) {
 * 		Collections.sort(edges);
 * 		UnionFind uf = new UnionFind(V);
 * 		int totalWeight = 0;
 * 		for (Edge e : edges) {
 * 			if (uf.union(e.u, e.v))
 * 				totalWeight += e.weight;
 * 		}
 * 		return totalWeight;
 * 	}
 *
 * 	// ------------------ PRIM ------------------
 * 	public static int primMST(int V, List<List<Edge>> adj) {
 * 		boolean[] visited = new boolean[V];
 * 		PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
 * 		pq.add(new Edge(0, 0, 0)); // start from node 0
 * 		int totalWeight = 0;
 * 		while (!pq.isEmpty()) {
 * 			Edge e = pq.poll();
 * 			if (visited[e.v])
 * 				continue;
 * 			visited[e.v] = true;
 * 			totalWeight += e.weight;
 * 			for (Edge next : adj.get(e.v))
 * 				if (!visited[next.v])
 * 					pq.add(next);
 * 		}
 * 		return totalWeight;
 * 	}
 *
 * 	public static void main(String[] args) {
 * 		int V = 5;
 * 		List<Edge> edges = Arrays.asList(new Edge(0, 1, 2), new Edge(0, 3, 6), new Edge(1, 2, 3), new Edge(1, 3, 8),
 * 				new Edge(1, 4, 5), new Edge(2, 4, 7), new Edge(3, 4, 9));
 *
 * 		System.out.println("=== Kruskal MST Total Weight ===");
 * 		System.out.println(kruskalMST(V, edges));
 *
 * 		System.out.println("=== Prim MST Total Weight ===");
 * 		List<List<Edge>> adj = new ArrayList<>();
 * 		for (int i = 0; i < V; i++)
 * 			adj.add(new ArrayList<>());
 * 		for (Edge e : edges) {
 * 			adj.get(e.u).add(new Edge(e.u, e.v, e.weight));
 * 			adj.get(e.v).add(new Edge(e.v, e.u, e.weight));
 * 		}
 * 		System.out.println(primMST(V, adj));
 * 	}
 * }
 * }</pre>
 *
 * <h2>Complexity</h2>
 * <ul>
 * <li>Kruskal: O(E log E) for sorting edges + O(E α(V)) for Union-Find</li>
 * <li>Prim: O(E log V) using priority queue</li>
 * <li>Space Complexity: O(V + E) for adjacency or edge lists</li>
 * </ul>
 *
 * <h2>Applications</h2>
 * <ul>
 * <li>Network design problems (minimum cost)</li>
 * <li>Clustering / hierarchical clustering</li>
 * <li>Graph optimization and connectivity analysis</li>
 * </ul>
 */
public class MinimumSpanningTree {

	static class Edge implements Comparable<Edge> {
		int u, v, weight;

		Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.weight = w;
		}

		public int compareTo(Edge other) {
			return this.weight - other.weight;
		}
	}

	// ------------------ KRUSKAL ------------------
	static class UnionFind {
		int[] parent, rank;

		UnionFind(int n) {
			parent = new int[n];
			rank = new int[n];
			Arrays.fill(rank, 0);
			for (int i = 0; i < n; i++)
				parent[i] = i;
		}

		int find(int x) {
			return parent[x] == x ? x : (parent[x] = find(parent[x]));
		}

		boolean union(int x, int y) {
			int px = find(x), py = find(y);
			if (px == py)
				return false;
			if (rank[px] < rank[py])
				parent[px] = py;
			else if (rank[px] > rank[py])
				parent[py] = px;
			else {
				parent[py] = px;
				rank[px]++;
			}
			return true;
		}
	}

	public static int kruskalMST(int V, List<Edge> edges) {
		Collections.sort(edges);
		UnionFind uf = new UnionFind(V);
		int totalWeight = 0;
		for (Edge e : edges) {
			if (uf.union(e.u, e.v))
				totalWeight += e.weight;
		}
		return totalWeight;
	}

	// ------------------ PRIM ------------------
	public static int primMST(int V, List<List<Edge>> adj) {
		boolean[] visited = new boolean[V];
		PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
		pq.add(new Edge(0, 0, 0)); // start from node 0
		int totalWeight = 0;
		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			if (visited[e.v])
				continue;
			visited[e.v] = true;
			totalWeight += e.weight;
			for (Edge next : adj.get(e.v))
				if (!visited[next.v])
					pq.add(next);
		}
		return totalWeight;
	}

	public static void main(String[] args) {
		int V = 5;
		List<Edge> edges = Arrays.asList(new Edge(0, 1, 2), new Edge(0, 3, 6), new Edge(1, 2, 3), new Edge(1, 3, 8),
				new Edge(1, 4, 5), new Edge(2, 4, 7), new Edge(3, 4, 9));

		System.out.println("=== Kruskal MST Total Weight ===");
		System.out.println(kruskalMST(V, edges));

		System.out.println("=== Prim MST Total Weight ===");
		List<List<Edge>> adj = new ArrayList<>();
		for (int i = 0; i < V; i++)
			adj.add(new ArrayList<>());
		for (Edge e : edges) {
			adj.get(e.u).add(new Edge(e.u, e.v, e.weight));
			adj.get(e.v).add(new Edge(e.v, e.u, e.weight));
		}
		System.out.println(primMST(V, adj));
	}
}