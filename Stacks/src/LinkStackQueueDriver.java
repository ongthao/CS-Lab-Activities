/*Name: Ong Thao
 * This program is the driver class that tests if my stack is working correctly with linked lists. 
 * Date Created: 2/15/19
 */
public class LinkStackQueueDriver {
	public static void main(String[] args)
	{
		String num = "0123456789";
		List n = new List(Character.toString(num.charAt(0)));
		Stack s = new Stack(n);
		for(int i = 1; i < num.length(); i++)
			s.push(Character.toString(num.charAt(i)));
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		s.push("41");
		System.out.println(s.peek());
		System.out.print(s.toString());
	}
}