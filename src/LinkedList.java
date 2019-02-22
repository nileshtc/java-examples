
public class LinkedList {
	public LinkedList(int data) {
		head = new Node(data);
	}
	Node head;
	class Node{
		Node next = null;
		int data;
		public Node(int d) {
			data = d;
		}
		
	}
	
	
	void appendAtEnd(int d) {
		if(head == null) {
			head = new Node(d);
			return;
		}
		//Node end = new Node(d);
		
		Node n = head;
		while(n.next != null) {
			n = n.next;
		}
		n.next = new Node(d);
	}
	Node deleteNode(Node head, int d) {
		if(head == null) return null;
		Node n = head;
		if(n.data == d) {
			return head.next;
		}
		while(n.next!= null) {
			if(n.next.data == d) {
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		return head;
	}
	void deleteWithValue(int v)
	{
		if(head == null) return;
		if(head.data == v) {
			head = head.next;
			return;
		}
		Node current = head;
		while(current.next != null)
		{
			if(current.next.data == v) {
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}
	void appendToStart(int d) {
		
		Node h = new Node(d);
		
		h.next = head;
		head = h;
	}
	void print(Node node) {
		while(node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}
	
	public static void main(String[] args) {
		
		LinkedList node = new LinkedList(10);
		node.appendAtEnd(12);
		node.appendAtEnd(13);
		node.appendAtEnd(15);
		System.out.println("=============================");
		node.print(node.head);
		node.deleteNode(node.head,13);
		System.out.println("=============================");
		node.print(node.head);
		node.deleteWithValue(12);
		System.out.println("=============================");
		node.print(node.head);
		node.appendToStart(41);
		node.appendToStart(32);
		System.out.println("=============================");
		node.print(node.head);
	}

}
