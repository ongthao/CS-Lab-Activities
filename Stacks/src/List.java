/*Name: Ong Thao
 * The purpose of this class is to create the linked list that will be used in the stack.
 * Date created: 2/15/19
 */

public class List {
	private Node front;
	
	public List(String n) {
		front = new Node(n);
	}
	
	public Node getFront()
	{
		return front;
	}
	
	public void add(String o){
		Node current = front;
		Node ne = new Node(o);
		while(current.getHead() != null)
			current = current.getHead();
		current.setHead(ne);
	}
	
	public void remove(int num)
	{
		Node current = front;
		Node n = current.getHead();
		if(num == 0)
			front = n;
		else
		{
			for(int i = 1; i < num; i++)
			{
				current = n;
				n = current.getHead();
			}
			current.setHead(n.getHead());
		}
	}
	
	public String getNum(int num)
	{
		Node current = front;
		for(int i = 0; i < num - 1; i++)
			current = current.getHead();
		return current.getS();
	}
	
	public int size()
	{
		Node current = front;
		int num = 1;
		while(current.getHead() != null)
		{
			current = current.getHead();
			num++;
		}
		return num;
	}
	
	public String toString() {
		String s = "";
		Node current = front;
		s += current.getS() + " ";
		while(current.getHead() != null) {
			current = current.getHead();
			s += current.getS() + " ";
		}
		return s;
	}
}
