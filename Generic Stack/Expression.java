/*Name: Ong Thao
  Program Description: Purpose of this program is to apply stacking concepts by converting infix expressions to postfix then evaluating the postfix
  Date Created: 6/26/18*/
import java.util.*;
import java.util.StringTokenizer;//a class for tokenizing a string
public class Expression
{
	public static void main(String[] args)
	{
      start(); //this method calls all of the other methods to start the process of obtaining an infix expression 
  	}	
	
   //purpose of this method is to call other methods to validate and evaluate an expression inputted by the user
   public static void start()
   {
      Scanner kb = new Scanner(System.in);
      String ans = "";
      do 
      {
         //prompts for user's expression 
         String e = dataValid(kb);
         //this variable is what we use to create the post fix 
         String s = ""; 
         //when we hit a space we move to the next index to skip the space
         for (int i = 0; i < e.length(); i++)
         {
            if(e.charAt(i) != ' ')
               s += e.charAt(i);
         }
         String n = "";
         for (int i = 0; i < s.length(); i++)
         {
            //if condition for making sure that the number after a number is part of a number of a whole number
            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '/' || s.charAt(i) == '*')
               //add spaces after and before each operand
               n += " " + s.charAt(i) + " ";
            else if(s.charAt(i) == '(')
               //if it is a beginning parentheses add a space after
               n += s.charAt(i) + " ";
            else if(s.charAt(i) == ')')
               //if there is an end parentheses add a space before
               n += " " + s.charAt(i);
            else
               //just print out the digit without adding any spaces (this helps account for those numbers with multiple digits
               n += s.charAt(i);
         }
         System.out.print("postFix = " + postFix(n) + "\n" + postFix(n));
         //will only get Integer.MIN_VALUE if the equation is divided by 0
         if(postfixEvaluate(postFix(n), kb) != Integer.MIN_VALUE)
         {
            System.out.print("= " + postfixEvaluate(postFix(n), kb) + "\n");
            //prompts user for another expression
            System.out.print("Do you have another expression : ");
            ans = kb.nextLine();
            System.out.println();
            //if the user answers anything other than "no" or "yes, we loop until the user enters a correct response
            while (!ans.equalsIgnoreCase("no") && !ans.equalsIgnoreCase("yes"))
            {
               System.out.print("Invalid Response. Please enter yes or no. Do you have another expression? : ");
               ans = kb.nextLine();
               System.out.println();
            }
            //if the user enters no, then we end the whole loop and print out a goodbye message
            if(ans.equalsIgnoreCase("no"))
               System.out.print("Good Bye");
         }
         else
            break;
      }while(ans.equalsIgnoreCase("yes"));//only loops for as long as the user enters "yes"
   }
   
   //purpose of this method is to change the infix to postfix
 	public static String postFix(String s)
	{
      GenericStack<String> e1 = new GenericStack<String>();
      e1.list.add("#");
      String r = "";
      StringTokenizer n = new StringTokenizer(s);
      while (n.hasMoreTokens())
      {
         String m = n.nextToken();
         //if the next token is an operand
         if(m.equals("+") || m.equals("-") || m.equals("/") || m.equals("*"))
         {
            //we compare the operand by first peeking at the top operand
            if(e1.peek().equals("+") || e1.peek().equals("-"))
            {
               //comparing the operands and popping the operand of equal or higher precedence
               if(m.equals("+") || m.equals("-"))
               {
                  //need to make a for loop that keeps popping until we reach the operand of equal precendence and replace it with "m"
                  while(e1.peek().equals("/") || e1.peek().equals("*") || e1.peek().equals("+") || e1.peek().equals("-") && !e1.peek().equals("#"))    
                     r += e1.pop() + " ";
                  //push m to top
                  e1.push(m);
               }
               else
                  e1.push(m);
            }
            else if(e1.peek().equals("/") || e1.peek().equals("*"))
            {
               //checking the read operand, if it is of lesser precendence than the top peeked operand then...
               if(m.equals("+") || m.equals("-"))
               {
                  //keeps popping until we reach the operand of equal precendence
                  while(e1.peek().equals("/") || e1.peek().equals("*") || e1.peek().equals("+") || e1.equals("-")) 
                     r += e1.pop() + " ";
                  e1.push(m);
               }
               else 
               {
                  //if the operand is a division or multiplication then we pop the top and replace it
                  while(e1.peek().equals("/") || e1.peek().equals("*"))
                     r += e1.pop() + " ";
                  e1.push(m);
               }
            }
            else
               e1.push(m);//if it is the first operand then we just push it to the top
         }
         else if(m.equals("(") || m.equals(")"))
         {
            if(m.equals(")"))
            {
               while(!e1.peek().equals("("))
                  r += e1.pop() + " ";
               e1.pop();
            }
            else
            {
               e1.push(m);
            }
         }
         else 
            r += m + " ";//if it is a number just add it to the string
      }
      //adding the rest of the operands (except for the "#") into the string
      r += e1.toString();
      return r;
   }
   
   //purpose of this method is to evaluate the expression using only the postfix expression
	public static int postfixEvaluate(String s, Scanner kb)
	{
		//create a new generic stack that will store the numbers
      GenericStack<String> eval = new GenericStack<String>();
      eval.list.add("");
      StringTokenizer n = new StringTokenizer(s);
      int sol = 0;
      while (n.hasMoreTokens())
      {
         String t = n.nextToken();
         //determines if the token is an operand or number
         if(t.equals("+"))
         {
            //convert the string into an integer and add the two top numbers together
            sol = Integer.parseInt(eval.pop() + "") + Integer.parseInt(eval.pop() + "");
            eval.push(Integer.toString(sol));
         }
         else if(t.equals("-"))
         {
            //need to divide the bottom by the top (bottom/top) so made two variables to represent the first and second pop
            int a = Integer.parseInt(eval.pop() + "");
            int b = Integer.parseInt(eval.pop() + "");
            sol = b - a;
            //push difference to top
            eval.push(Integer.toString(sol));
         }
         else if(t.equals("/"))
         {
            int a = Integer.parseInt(eval.pop() + ""); //first pop
            int b = Integer.parseInt(eval.pop() + ""); //second pop
            //data validation for dividing by zero (thou shall not divide by zero)
            if(a == 0)
            {
               System.out.println("\n\nCannot divide by zero. Please try again.\n");
               start();
               return Integer.MIN_VALUE;
            }
            else 
            {
               sol = b / a;//divide second pop by first pop
               eval.push(Integer.toString(sol));
            }
         }
         else if(t.equals("*"))
         {
            sol = Integer.parseInt(eval.pop() + "") * Integer.parseInt(eval.pop() + "");
            eval.push(Integer.toString(sol) + "");
         }
         //if the token is not an operand then it is a number, so add the number into the stack
         else 
            eval.push(t);
      }
      return sol;	 			 	
	}		
   
   //the purpose of this method is to validate our expression by checking for all possible cases that may cause the program to crash
   public static String dataValid(Scanner kb)
   {
      System.out.print("Enter your infix expression: ");
      String e = kb.nextLine();
      int index = 0;
      //counts the number of parentheses (if there is a pair of opening and closing parentheses, then the equatation is valid)
      int count = 0, count2 = 0; 
      //data validation for if the user did not enter a character that is not either a digit or operand
      while(index != e.length() - 1)
      {
         //if the user enters anything that is not a digit or operand, we print out an error statement
         if(!Character.isDigit(e.charAt(index)) && e.charAt(index) != '+' && e.charAt(index) != '-' && e.charAt(index) != '/' && e.charAt(index) != '*' && e.charAt(index) != '(' && e.charAt(index) != ')' && e.charAt(index) != ' ')
         {
            System.out.print("Invalid input. Please enter your infix expression again: ");
            e = kb.nextLine();
            index = 0;//new expression written so have to go back and check this new expression starting from index "0"
         }
         if (index != 0)
            index++;//increment the index to get next character (we are checking every character
         //the first two if statements below keeps track of the number of parentheses we have
         if(e.charAt(index) == '(')
            count++;
         else if (e.charAt(index) == ')')
            count2++;
         if(index == 0)
            index++;
         //evaluating the number of parentheses to determine if it is a valid expression
         else if(index == e.length() - 1 && count != count2)
         {
            System.out.print("Invalid input. Please enter your infix expression again: ");
            e = kb.nextLine();
            index = 0;
            count = 0;
            count2 = 0;
         }
      }
      return e;
   }				
}			