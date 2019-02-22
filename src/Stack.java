
public class Stack {
	static class Node{
		private int data;
		private Node next;
		private Node(int data) {
			this.data = data;
		}
	}
	
	private Node top;
	public boolean isEmpty() {
		return top == null;
	}
	public int peek() {
		if(!isEmpty()) {
			return top.data;
		}
		throw new NullPointerException();
		
	}
	
	public void push(int data) {
		Node node = new Node(data);
		node.next = top;
		top = node;
	}
	public int pop() {
		if(top == null) throw new NullPointerException();
		int data = top.data;
		top = top.next;
		return data;
	}
	public static void main(String[] args) {
		Stack stack = new Stack();
		Stack.Node node = new Stack.Node(10);
		stack.push(12);
		stack.push(34);
		System.out.println(stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		
		System.out.println(stack.isEmpty());
	}
}
