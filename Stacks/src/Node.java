public class Node
{
	private String s;
	private Node head;
	private Node tail;
	
	public Node(String n){
		this.s = n;
		this.head = null;
		this.tail = null;
	}
	
	public String getS() {
		return s;
	}
	
	public Node getHead() {
		return head;
	}
	
	public Node getTail() {
		return tail;
	}
	
	public void setS(String n) {
		s = n;
	}
	
	public void setHead(Node n) {
		head = n;
	}

	public void setTail(Node n) {
		tail = n;
	}
}
