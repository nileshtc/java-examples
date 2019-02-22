
public class BST {

	public static class Node{
		Node left, right;
		int data;
		public Node(int data) {
			this.data = data;
		}
	
	
		public void insert(int value) {
			if(value <= data)
			{
				if(left == null) {
					left = new Node(value);
				}
				else {
					left.insert(value);
				}
			}
			else {
				if(right == null) {
					right = new Node(value);
				}
				else {
					right.insert(value);
				}
			}
		}
		public boolean contains(int value) {
			if(value == data) return true;
			else if(value < data) {
					if(left == null) {
						return false;
					}
					else {
						return left.contains(value);
					}
				}
			else {
				if(right == null) {
					return false;
				}
				else {
					return right.contains(value);
				}
			}
		}
		
		public void printInOrder() {
			if(left != null) {
				left.printInOrder();
			}
			System.out.println(data);
			if(right !=null) {
				right.printInOrder();
			}
		}
		public void printPreOrder() {
			System.out.println(data);
			if(left != null) {
				left.printInOrder();
			}
			
			if(right !=null) {
				right.printInOrder();
			}
		}
		public void printPostOrder() {
			
			if(left != null) {
				left.printInOrder();
			}
			
			if(right !=null) {
				right.printInOrder();
			}
			System.out.println(data);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST bst = new BST();
		BST.Node node = new BST.Node(10);
		node.insert(9);
		node.insert(24);
		node.insert(252);
		System.out.println(node.contains(9));
		
		node.printInOrder();
		node.printPreOrder();
		node.printPostOrder();
	}

}
