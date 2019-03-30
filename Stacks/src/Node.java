/*Name: Ong Thao
 * Purpose of this class is to create nodes (or elements) to use for the linked list.
 * Date created: 2/15/19
 */

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
