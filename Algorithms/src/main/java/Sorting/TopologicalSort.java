package Sorting;


import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Supplier;

/**
 * Non Optimized Topological Sort, Prints only ans
 */
public class TopologicalSort {

	private final Supplier<List<Integer>[]> graphSupplier = () -> {
		int n = 6;
//		int[][] edges = {{2, 0}, {1, 2}, {2, 3}, {1, 3}, {3, 4}, {4, 2}, {3, 5}, {2, 5}};  // With CYCLE
		int[][] edges = {{2, 0}, {1, 2}, {2, 3}, {1, 3}, {3, 4}, {3, 5}, {2, 5}}; // NO CYCLE
		List<Integer>[] graph = new List[n];
		for(int i = 0; i < n; i++) {
			graph[i] = new LinkedList<>();
		}
		for(int[] edge : edges) {
			graph[edge[0]].add(edge[1]);
		}
		return graph;
	};

	public static void main(String[] args) {
		TopologicalSort topologicalSort = new TopologicalSort();
		topologicalSort.performSort();

	}

	private void performSort() {
		List<Integer>[] graph = graphSupplier.get();
		List<Integer> ans = new LinkedList<>();
		for(int i = 0; i < graph.length; i++)
			System.out.println(graph[i]);
		System.out.println("---------");
		List<Pair<Integer, Integer>> inDegree = updateInDegree(graph, true);
		System.out.println(inDegree);
		Queue<Integer> queue = new LinkedList<>();
		queue.add(inDegree.get(0).k);
		boolean[] isVisited = new boolean[inDegree.size()];
		isVisited[inDegree.get(0).k] = true;
		outer:
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				int node = queue.poll();
				if(findPair(inDegree, node).v == 0) {
					ans.add(node);
					for(int j : graph[node]) {
						findPair(inDegree, j).v--;
					}
					graph[node] = new LinkedList<>();
					int index = 0;
					for(int k = 0; k < inDegree.size(); k++) {
						if(inDegree.get(k).k == node) {
							index = k;
						}
					}
					inDegree.remove(index);
					Collections.sort(inDegree, Comparator.comparingInt(value -> value.v));
					System.out.println(inDegree);
				}
				if(inDegree.isEmpty()) break outer;
				if(inDegree.get(0).v == 0) {
					queue.add(inDegree.get(0).k);
				} else {
					System.out.println("Error:: Cycle Detected  !!!");
					break outer;
				}
			}
		}


		System.out.println(ans);

	}

	private Pair<Integer, Integer> findPair(List<Pair<Integer, Integer>> inDegree, int node) {
		return inDegree.stream().filter(integerIntegerPair -> integerIntegerPair.k == node).findAny().orElse(new Pair<>(-1, -1));
	}

	private List<Pair<Integer, Integer>> updateInDegree(List<Integer>[] graph, boolean initial) {
		List<Pair<Integer, Integer>> inDegree = new LinkedList<>();
		for(int i = 0; i < graph.length; i++) {
			for(int j : graph[i]) {
				boolean isFound = false;
				for(Pair<Integer, Integer> p : inDegree) {
					if(p.k == j) {
						p.v = p.v + 1;
						isFound = true;
						break;
					}
				}
				if(!isFound) {
					inDegree.add(new Pair(j, 1));
				}
			}
		}
		if(initial)
			for(int i = 0; i < inDegree.size(); i++) {
				int finalI = i;
				Pair<Integer, Integer> p = inDegree.stream().filter(integerIntegerPair -> integerIntegerPair.k == finalI).findAny().orElse(null);
				if(p == null) {
					inDegree.add(new Pair<>(i, 0));
				}
			}

		Collections.sort(inDegree, Comparator.comparingInt(value -> value.v));
		return inDegree;
	}

	private class Pair<K, V> {
		private final K k;
		private V v;

		public Pair(K k, V v) {
			this.k = k;
			this.v = v;
		}

		@Override
		public String toString() {
			return "Pair{" +
					"k=" + k +
					", v=" + v +
					'}';
		}
	}

}
