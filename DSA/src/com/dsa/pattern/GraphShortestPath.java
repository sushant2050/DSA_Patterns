package com.dsa.pattern;

import java.util.*;

/**
 * Demonstrates the <b>Graph Shortest Path Pattern</b>.
 *
 * <p>
 * Shortest Path algorithms find the minimum distance or cost between nodes in a
 * graph. This class demonstrates three common approaches:
 * </p>
 *
 * <ul>
 * <li><b>Dijkstra:</b> Single-source shortest path, works with non-negative
 * weights</li>
 * <li><b>Bellman-Ford:</b> Single-source shortest path, handles negative
 * weights and detects negative cycles</li>
 * <li><b>Floyd-Warshall:</b> All-pairs shortest path, handles negative weights
 * (no negative cycles)</li>
 * </ul>
 *
 * <h2>Example Implementations</h2>
 *
 * <pre>{@code
 * package com.dsa.pattern;
 *
 * import java.util.*;
 *
 * public class GraphShortestPathExample {
 *
 * 	// ------------------ DIJKSTRA ------------------
 * 	static class Edge {
 * 		int to, weight;
 * 
 * 		Edge(int to, int weight) {
 * 			this.to = to;
 * 			this.weight = weight;
 * 		}
 * 	}
 *
 * 	static class Graph {
 * 		int V;
 * 		List<List<Edge>> adj;
 *
 * 		Graph(int V) {
 * 			this.V = V;
 * 			adj = new ArrayList<>();
 * 			for (int i = 0; i < V; i++)
 * 				adj.add(new ArrayList<>());
 * 		}
 *
 * 		void addEdge(int u, int v, int w) {
 * 			adj.get(u).add(new Edge(v, w));
 * 			adj.get(v).add(new Edge(u, w)); // remove for directed graph
 * 		}
 * 	}
 *
 * 	// Dijkstra: Single-source shortest path for non-negative weights
 * 	public static int[] dijkstra(Graph g, int src) {
 * 		int[] dist = new int[g.V];
 * 		Arrays.fill(dist, Integer.MAX_VALUE);
 * 		dist[src] = 0;
 *
 * 		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
 * 		pq.offer(new int[] { src, 0 });
 *
 * 		while (!pq.isEmpty()) {
 * 			int[] curr = pq.poll();
 * 			int u = curr[0], d = curr[1];
 * 			if (d > dist[u])
 * 				continue;
 * 			for (Edge e : g.adj.get(u)) {
 * 				if (dist[u] + e.weight < dist[e.to]) {
 * 					dist[e.to] = dist[u] + e.weight;
 * 					pq.offer(new int[] { e.to, dist[e.to] });
 * 				}
 * 			}
 * 		}
 * 		return dist;
 * 	}
 *
 * 	// ------------------ BELLMAN-FORD ------------------
 * 	// Returns distances array or null if negative cycle exists
 * 	public static int[] bellmanFord(int V, int[][] edges, int src) {
 * 		int[] dist = new int[V];
 * 		Arrays.fill(dist, Integer.MAX_VALUE);
 * 		dist[src] = 0;
 *
 * 		for (int i = 0; i < V - 1; i++) {
 * 			for (int[] e : edges) {
 * 				int u = e[0], v = e[1], w = e[2];
 * 				if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v])
 * 					dist[v] = dist[u] + w;
 * 			}
 * 		}
 *
 * 		// Check for negative weight cycles
 * 		for (int[] e : edges) {
 * 			int u = e[0], v = e[1], w = e[2];
 * 			if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v])
 * 				return null;
 * 		}
 *
 * 		return dist;
 * 	}
 *
 * 	// ------------------ FLOYD-WARSHALL ------------------
 * 	public static int[][] floydWarshall(int V, int[][] edges) {
 * 		int INF = 1000000000;
 * 		int[][] dist = new int[V][V];
 * 		for (int i = 0; i < V; i++)
 * 			Arrays.fill(dist[i], INF);
 * 		for (int i = 0; i < V; i++)
 * 			dist[i][i] = 0;
 *
 * 		for (int[] e : edges) {
 * 			dist[e[0]][e[1]] = e[2];
 * 		}
 *
 * 		for (int k = 0; k < V; k++)
 * 			for (int i = 0; i < V; i++)
 * 				for (int j = 0; j < V; j++)
 * 					if (dist[i][k] < INF && dist[k][j] < INF)
 * 						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
 *
 * 		return dist;
 * 	}
 *
 * 	public static void main(String[] args) {
 * 		Graph g = new Graph(5);
 * 		g.addEdge(0, 1, 2);
 * 		g.addEdge(0, 2, 4);
 * 		g.addEdge(1, 2, 1);
 * 		g.addEdge(1, 3, 7);
 * 		g.addEdge(2, 4, 3);
 * 		g.addEdge(3, 4, 1);
 *
 * 		System.out.println("=== Dijkstra ===");
 * 		int[] distD = dijkstra(g, 0);
 * 		System.out.println(Arrays.toString(distD));
 *
 * 		System.out.println("=== Bellman-Ford ===");
 * 		int[][] edgeList = { { 0, 1, 2 }, { 0, 2, 4 }, { 1, 2, 1 }, { 1, 3, 7 }, { 2, 4, 3 }, { 3, 4, 1 } };
 * 		int[] distBF = bellmanFord(5, edgeList, 0);
 * 		System.out.println(distBF != null ? Arrays.toString(distBF) : "Negative cycle detected");
 *
 * 		System.out.println("=== Floyd-Warshall ===");
 * 		int[][] distFW = floydWarshall(5, edgeList);
 * 		for (int i = 0; i < 5; i++)
 * 			System.out.println(Arrays.toString(distFW[i]));
 * 	}
 * }
 * }</pre>
 *
 * <h2>Complexity</h2>
 * <ul>
 * <li>Dijkstra: O((V + E) log V) with priority queue</li>
 * <li>Bellman-Ford: O(V * E)</li>
 * <li>Floyd-Warshall: O(V³)</li>
 * <li>Space: O(V + E) for Dijkstra, O(V) for Bellman-Ford, O(V²) for
 * Floyd-Warshall</li>
 * </ul>
 *
 * <h2>Applications</h2>
 * <ul>
 * <li>Routing and navigation systems</li>
 * <li>Network optimization</li>
 * <li>All-pairs shortest path analysis</li>
 * <li>Detecting negative weight cycles</li>
 * </ul>
 */
public class GraphShortestPath {

	// ------------------ DIJKSTRA ------------------
	static class Edge {
		int to, weight;

		Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	static class Graph {
		int V;
		List<List<Edge>> adj;

		Graph(int V) {
			this.V = V;
			adj = new ArrayList<>();
			for (int i = 0; i < V; i++)
				adj.add(new ArrayList<>());
		}

		void addEdge(int u, int v, int w) {
			adj.get(u).add(new Edge(v, w));
			adj.get(v).add(new Edge(u, w)); // remove for directed graph
		}
	}

	// Dijkstra: Single-source shortest path for non-negative weights
	public static int[] dijkstra(Graph g, int src) {
		int[] dist = new int[g.V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
		pq.offer(new int[] { src, 0 });

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int u = curr[0], d = curr[1];
			if (d > dist[u])
				continue;
			for (Edge e : g.adj.get(u)) {
				if (dist[u] + e.weight < dist[e.to]) {
					dist[e.to] = dist[u] + e.weight;
					pq.offer(new int[] { e.to, dist[e.to] });
				}
			}
		}
		return dist;
	}

	// ------------------ BELLMAN-FORD ------------------
	// Returns distances array or null if negative cycle exists
	public static int[] bellmanFord(int V, int[][] edges, int src) {
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;

		for (int i = 0; i < V - 1; i++) {
			for (int[] e : edges) {
				int u = e[0], v = e[1], w = e[2];
				if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v])
					dist[v] = dist[u] + w;
			}
		}

		// Check for negative weight cycles
		for (int[] e : edges) {
			int u = e[0], v = e[1], w = e[2];
			if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v])
				return null;
		}

		return dist;
	}

	// ------------------ FLOYD-WARSHALL ------------------
	public static int[][] floydWarshall(int V, int[][] edges) {
		int INF = 1000000000;
		int[][] dist = new int[V][V];
		for (int i = 0; i < V; i++)
			Arrays.fill(dist[i], INF);
		for (int i = 0; i < V; i++)
			dist[i][i] = 0;

		for (int[] e : edges) {
			dist[e[0]][e[1]] = e[2];
		}

		for (int k = 0; k < V; k++)
			for (int i = 0; i < V; i++)
				for (int j = 0; j < V; j++)
					if (dist[i][k] < INF && dist[k][j] < INF)
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);

		return dist;
	}

	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(0, 1, 2);
		g.addEdge(0, 2, 4);
		g.addEdge(1, 2, 1);
		g.addEdge(1, 3, 7);
		g.addEdge(2, 4, 3);
		g.addEdge(3, 4, 1);

		System.out.println("=== Dijkstra ===");
		int[] distD = dijkstra(g, 0);
		System.out.println(Arrays.toString(distD));

		System.out.println("=== Bellman-Ford ===");
		int[][] edgeList = { { 0, 1, 2 }, { 0, 2, 4 }, { 1, 2, 1 }, { 1, 3, 7 }, { 2, 4, 3 }, { 3, 4, 1 } };
		int[] distBF = bellmanFord(5, edgeList, 0);
		System.out.println(distBF != null ? Arrays.toString(distBF) : "Negative cycle detected");

		System.out.println("=== Floyd-Warshall ===");
		int[][] distFW = floydWarshall(5, edgeList);
		for (int i = 0; i < 5; i++)
			System.out.println(Arrays.toString(distFW[i]));
	}
}