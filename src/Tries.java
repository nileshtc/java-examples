
public class Tries {
	public static class Node{
		private static int NUM_OF_CHAR = 26;
		Node[] children = new Node[NUM_OF_CHAR];
		int size = 0;
		private static int getCharIndex(char c) {
			return c - 'a';
		}
		private Node getNode(char c) {
			return children[getCharIndex(c)];
		}
		private void setNode(char c, Node node) {
			children[getCharIndex(c)] = node;
		}
		public void add(String s) {
			add(s, 0);
		}
		private void add(String s, int index) {
			
			if(index == s.length()) return;
			size++;
			char current = s.charAt(index);
			int charCode = getCharIndex(current);
			Node child = getNode(current);
			if(child == null) {
				child = new Node();
				setNode(current, child);
			}
			child.add(s, index+1);
		}
		public int findCount(String s, int index) {
			if(index == s.length()) {
				return size;
			}
			Node child = getNode(s.charAt(index));
			if(child == null) {
				return 0;
			}
			return child.findCount(s, index+1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node = new Node();
		node.add("ada");
		node.add("trevor");
		node.add("adil");
		node.add("nilesh");
		System.out.println(node.findCount("a", 1));
	}

}
