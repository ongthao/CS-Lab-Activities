/*Name: Ong Thao
  Program Description: The purpose of this class is to mimic the act of stacking through peek, pop, and push to create a stack that we can modify
  Date Created: 6/26/18*/
import java.util.ArrayList;
public class GenericStack<T> implements Stack<T> 
{
   ArrayList<T> list = new ArrayList<T>();

   //returns the size of the list
   public int size()
   {
      return list.size();
   }

   //returns a copy of the top element of the list 
   public T peek()
   {
      return list.get(list.size() - 1);
   }

   //gets rid of top and returns its value
   public T pop()
   {
      return list.remove(list.size() - 1);
   }

   //pushes the new Object to the top of the list 
   public void push(T o)
   {
      list.add(o);
   }

   //checks if the list is empty or not
   public boolean isEmpty()
   {
      return list.size() == 0;
   }

   //checks if one object or stack is the same as another stack
   public boolean equals(GenericStack<T> s) 
   {
      if(this.size() != s.size()) 
         return false;
      for(int i = 0; i < list.size(); i++) 
      {
         if(!list.get(i).equals(s.list.get(i))) 
            return false;
      }
      return true;
   }

   //this method prints out the elements of the stack
   public String toString()
   {
      String r = "";
      for (int i = list.size() - 1; i >= 1; i--)
         r += list.get(i) + " ";
      return r;
   }

   //This method returns a copy of the arraylist/Stack
   public GenericStack<T> copy()
   {
      GenericStack<T> c = new GenericStack<T>();
      for(int i = 0; i < list.size(); i++)
         c.list.add(list.get(i));
      return c;
   }
}