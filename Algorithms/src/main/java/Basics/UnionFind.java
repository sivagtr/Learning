package Basics;

import java.util.Arrays;

public class UnionFind {
	public static void main(String[] args) {
		UnionFind unionFind = new UnionFind();
		System.out.println("Cycle Detected " + (unionFind.isCycle() == 1));
	}

	private int find(int parent[], int i) {
		if(parent[i] == -1)
			return i;
		return find(parent, parent[i]);
	}

	private void Union(int parent[], int x, int y) {
		parent[x] = y;
	}


	// The main function to check whether a given graph
	// contains cycle or not
	private int isCycle() {
		// Allocate memory for creating V subsets
		int[][] edgeList = {{1, 2}, {2, 3}, {4, 6}, {4, 3}, {7, 6}, {4, 5}, {1, 5}};
		int n = 7;
		int parent[] = new int[n + 1];

		// Initialize all subsets as single element sets
		for(int i = 0; i < parent.length; ++i)
			parent[i] = -1;

		// Iterate through all edges of graph, find subset of both
		// vertices of every edge, if both subsets are same, then
		// there is cycle in graph.
		for(int i = 0; i < edgeList.length; ++i) {
			int x = find(parent, edgeList[i][0]);
			int y = find(parent, edgeList[i][1]);
			System.out.println("X " + x + " Y " + y);
			if(x == y) {
				Arrays.stream(parent).forEach(System.out::println);
				return 1;
			}

			Union(parent, x, y);
		}
		Arrays.stream(parent).forEach(System.out::println);
		return 0;
	}
}
