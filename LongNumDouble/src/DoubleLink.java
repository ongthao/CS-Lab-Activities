/*Name: Ong Thao
 * Program description: purpose of this class is to create the Double link list object. 
 * Date created: 2/15/19
 */

public class DoubleLink {
	private Node front;
	private int size = 0;

	public DoubleLink(Node n) {
		front = n;
		size++;
	}

	public void setFront(Node n) {
		front = n;
		size++;
	}

	public Node getFront() {
		return front;
	}

	public int getSize() {
		return size;
	}

	public void addMostSignificant(int digit) {
		Node n = new Node(digit);
		n.setHead(front);
		front.setTail(n);
		size++;
	}

	public void addLeastSignificant(int digit) {
		Node n = new Node(digit);
		Node curr = front;
		while (curr.getHead() != null)
			curr = curr.getHead();
		n.setTail(curr);
		curr.setHead(n);
		size++;
	}

	public void insert(int position, int digit) {
		Node n = new Node(digit);
		Node curr = front;
		for (int i = 2; i < position; i++) {
			if (curr.getHead() == null)
				break;
			curr = curr.getHead();
		}
		if (curr.getHead() != null) {
			n.setHead(curr.getHead());
			n.setTail(curr);
			curr.getHead().setTail(n);
			curr.setHead(n);
		} else {
			n.setTail(curr);
			curr.setHead(n);
		}
		size++;
	}

	public String add(DoubleLink num) {
		Node n = front;
		Node o = num.getFront();
		while (n.getHead() != null || o.getHead() != null) {
			if (n.getHead() != null)
				n = n.getHead();
			if (o.getHead() != null)
				o = o.getHead();
		}
		String sum = "";
		int carry = 0;
		while (n.getTail() != null && o.getTail() != null) {
			if (n.getNum() + o.getNum() + carry < 10) {
				sum += Integer.toString(n.getNum() + o.getNum() + carry);
				carry = 0;
			} else {
				sum += Integer.toString((n.getNum() + o.getNum() + carry) % 10);
				carry = 1;
			}
			o = o.getTail();
			n = n.getTail();
		}
		if (n.getNum() + o.getNum() + carry < 10) {
			sum += Integer.toString(n.getNum() + o.getNum() + carry);
			carry = 0;
		} else {
			sum += Integer.toString((n.getNum() + o.getNum() + carry) % 10);
			carry = 1;
		}
		int count = 0;
		while (n.getTail() != null || o.getTail() != null) {
			if (n.getTail() != null) {
				if (count == 0) {
					n = n.getTail();
					count++;
				}
				sum += Integer.toString(n.getNum() + carry);
				n = n.getTail();
				carry = 0;
			} else if (o.getTail() != null) {
				if (count == 0) {
					o = o.getTail();
					count++;
				}
				sum += Integer.toString(o.getNum() + carry);
				o = o.getTail();
				carry = 0;
			}
		}
		if (this.getSize() > num.getSize())
			sum += Integer.toString(n.getNum());
		else if (this.getSize() < num.getSize())
			sum += Integer.toString(o.getNum());
		String reverse = "";
		for (int i = sum.length() - 1; i >= 0; i--) {
			reverse += sum.charAt(i);
		}
		return reverse;
	}

	public void delete(int position) {
		Node curr = front;
		for (int i = 1; i < position; i++)
			curr = curr.getHead();
		curr.setHead(curr.getHead().getHead());
		size--;
	}

	public String toString() {
		Node n = front;
		String s = "";
		while (n.getHead() != null) {
			s += String.valueOf(n.getNum());
			n = n.getHead();
		}
		s += String.valueOf(n.getNum());
		return s;
	}
}