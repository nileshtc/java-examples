
public class Queue {
	private static class Node{
		private int data;
		private Node next;
		private Node(int data) {
			this.data = data;
		}
	}
	private Node head;
	private Node tail;
	public boolean isEmpty() {
		return head == null;
	}
	public int peek() {
		if(!isEmpty()){
			return head.data;
		}
		throw new NullPointerException();
	}
	public void add(int data) {
		Node node = new Node(data);
		if(tail != null) {
			tail.next = node;
		}
		tail = node;
		if(head == null) {
			head = node;
		}
	}
	public int remove() {
		int data = head.data;
		head = head.next;
		if(head==null) {
			tail = null;
		}
		return data;
	}
	
	public static void main(String[] args) {
		Queue queue = new Queue();
		Queue.Node node = new Queue.Node(10);
		queue.add(12);
		queue.add(23);
		queue.add(651);
		System.out.println(queue.isEmpty());
		System.out.println(queue.peek());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		
		System.out.println(queue.isEmpty());
	}
	
}
