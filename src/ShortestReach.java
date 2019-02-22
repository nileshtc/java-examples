import java.util.Arrays;
import java.util.LinkedList;

public class ShortestReach {
	public static class Graph {
		private Node[] nodes;
		private static int EDGE_DISTANCE = 6;

		public Graph(int size) {

		}

		private class Node {
			public int startId;
			public int[] neighbor;
		}

		private Node getNode(int id) {
			return nodes[id];
		}
		public void addEdge(int first, int second) {
			
		}
		public int[] shortestReach(int startId) {
			LinkedList<Integer> queue = new LinkedList<>();
			queue.add(startId);
			int[] distance = new int[nodes.length];
			Arrays.fill(distance, -1);
			distance[startId] = 0;
			while(!queue.isEmpty()) {
				int node = queue.poll();
				for(int neighbor:nodes[node].neighbor) {
					if(distance[neighbor] == -1) {
						distance[neighbor] = distance[node] + EDGE_DISTANCE;
						queue.add(neighbor);
					}
				}
			}
			return distance;
		}

	}
}
