/*Name: Ong Thao
 * Purpose of this class is to push, pop, and peek a stack using linked lists in which is called by the driver. 
 * Date created: 2/15/19
 */

public class Stack {
	private List nums;
	
	public Stack(List nums)
	{
		this.nums = nums;
	}
	
	//pushes a new element to the top
	public void push(String c)
	{
		nums.add(c);
	}
	
	//pops the top element and returns its value
	public String pop()
	{
		String n = nums.getNum(nums.size());
		nums.remove(nums.size() - 1);
		return n;
	}
	
	//peeks and returns a copy of the first element
	public String peek()
	{
		return nums.getNum(nums.size());
	}
	
	//gets the size of the elements in the list
	public int getSize()
	{
		return nums.size();
	}
	
	public String toString()
	{
		return nums.toString();
	}
}
