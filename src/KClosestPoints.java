import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KClosestPoints {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] points = new int[][] {{-2,-4},{0,-2},{0,0},{-1,0},{3,-5},{-2,-3},{3,2}};
		closest(points, 3);
	}

	private static void closest(int[][] points, int k) {
		double[] point_distance = new double[points.length];
		PriorityQueue<Double> queue = new PriorityQueue<>(Collections.reverseOrder());
		for(int i= 0;i< points.length;i++) {
			double dist = Math.sqrt((points[i][0] * points[i][0]) + (points[i][1] * points[i][1]));  
			point_distance[i] = dist;
		}
		System.out.println(Arrays.toString(point_distance));
		for(int i=0;i<k;i++) {
			queue.add(point_distance[i]);
		}
		for(int i = k;i<point_distance.length;i++) {
			if(!queue.isEmpty()) {
				//System.out.println(queue.peek());
				if(queue.peek()>point_distance[i]) {
					queue.poll();
					queue.add(point_distance[i]);
				}
			}
		}
		for(Double d : queue) {
			System.out.println(d);
		}
	}

}
