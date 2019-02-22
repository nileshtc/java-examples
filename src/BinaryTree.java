import java.util.Scanner;

class Node {
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}

public class BinaryTree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			if (n == 0) {
				System.out.println(0);
				continue;
			}
			Node root = null;
			for (int i = 0; i < n; i++) {
				int a = sc.nextInt();
				int a1 = sc.nextInt();
				char lr = sc.next().charAt(0);
				if (i == 0) {
					root = new Node(a);
					switch (lr) {
					case 'L':
						root.left = new Node(a1);
						break;
					case 'R':
						root.right = new Node(a1);
						break;
					}
				} else {
					insert(root, a, a1, lr);
				}
			}

			GfG g = new GfG();
			System.out.println(g.maxDiff(root));

		}
	}

	public static void insert(Node root, int a, int a1, char lr) {
		if (root == null) {
			return;
		}
		if (root.data == a) {
			switch (lr) {
			case 'L':
				root.left = new Node(a1);
				break;
			case 'R':
				root.right = new Node(a1);
				break;
			}
			return;
		}
		insert(root.left, a, a1, lr);
		insert(root.right, a, a1, lr);
	}

}
/*
 * Please note that it's Function problem i.e. you need to write your solution
 * in the form of Function(s) only. Driver Code to call/invoke your function is
 * mentioned above.
 */

//User function Template for Java
//Back-end complete function Template for Java
class GfG {
	int max = Integer.MIN_VALUE;

	int maxDiff(Node root) {
//your code here
		max(root, root.data);
		return max;
	}

	void max(Node root, int maxNodeData) {
		if (root == null) {
			if (max < 0)
				max = 0;
			return;
		}
		else {
			if (root.data > maxNodeData)
				maxNodeData = root.data;
			Node left = root.left;
			Node right = root.right;
			if (left == null && right == null) {
                
			} else if (left != null && right == null) {
			    int leftdiff = maxNodeData - left.data;
				if (leftdiff > max)
					max = leftdiff;
				max(left, maxNodeData);
			}

			else if (left == null && right != null) {
			    int rightdiff = maxNodeData - right.data;
				if (rightdiff > max)
					max = rightdiff;
				max(right, maxNodeData);
			}

			else {
				if (max < left.data && left.data < right.data)
					max = maxNodeData - left.data;
				else if (right.data <= left.data && maxNodeData - right.data > max)
					max = maxNodeData - right.data;
				max(left, maxNodeData);
				max(right, maxNodeData);
			}

		}
	}
}