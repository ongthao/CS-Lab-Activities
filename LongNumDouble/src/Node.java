/*Name: Ong Thao
 * Program Description: Purpose of this program is to create the nodes for the double linked lists. (the nodes are the elements in the linked list)
 * Date created: 2/15/19
 */

public class Node {
	private int num;
	private Node head;
	private Node tail;

	public Node(int num) {
		this.num = num;
		this.tail = null;
		this.head = null;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setHead(Node n) {
		head = n;
	}

	public void setTail(Node n) {
		tail = n;
	}

	public int getNum() {
		return num;
	}

	public Node getHead() {
		return head;
	}

	public Node getTail() {
		return tail;
	}
}
