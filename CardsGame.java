/*Name: Ong Thao
  Program Description: This program prompts the user for a sum then runs through a combination of four cards (out of a deck of 52), calculates
  the total sum of the four cards, compares the total sum to the inputted sum, counts the total combinations that make up the desired sum, and outputs 
  the results
  Date Created: 4/17/18*/

import java.util.Scanner;

public class CardsGame
{
   public static void main(String[] args) 
   {
      Scanner kb = new Scanner(System.in);
      //calls the sum method to start the game
      sum(kb);
   }
   
   //purpose of this method is to output prompts, calculate combinations, and output the results of the game
   public static void sum(Scanner kb)
   {
      //initilizing the array of decks using the initilize method
      int [] deck = initialize();
      String answer = "";
      do 
      {
         //calling the dataValidation method to prompt for the sum and validate the values of the sum 
         int sum = dataValidation(kb);
         int count = 0;
         String combo = ""; 
         int total = 0; 
         //loops through possible combinations
         for (int i = 0; i < deck.length; i++)//starts at 52
         {
            for (int j = i + 1; j < deck.length; j++)//starts at 51
            {
               for (int n = j + 1; n < deck.length; n++)//starts at 50
               {
                  for (int x = n + 1; x < deck.length; x++)//starts at 49
                  {
                     if (sum == deck[i] + deck [j] + deck [n] + deck [x])
                     {
                        //adds a counter for every time the sum matches the sum of the four cards picked out   
                        count++;    
                        //prints out each set of four cards that makes the sum (optional: uncomment to print out list of combinations)
                        //combo += deck [i] + " " + deck [j] + " " + deck [n] + " " + deck [x] + "\n";
                     }
                     total++;//counter to count the total number of combinations
                  }
               }
            }
         }
         //outputs the cards that make up the sum specifed by the user
         //System.out.print("Here is the list of all the combinations: \n" + combo);
         //outputs the total number of combinations of four cards out of the 52 cards in the deck
         System.out.println("Total number of combinations: " + total);
         //outputs the total combinations that make up the sum specified by user
         System.out.println("The number of picks that yields the sum of " + sum + " is " + count);
         //prompt for user if they want to continue
         System.out.print("Do you want to continue: ");
         //user inputs their answer
         answer = kb.next();
         //input validation for the user's input for the question "Do you want to continue:" for when they enter anything other than "yes" or "no"
         while (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no"))
         {
            System.out.print("Do you want to continue: ");
            answer = kb.next();
         }
       }while (answer.equalsIgnoreCase("yes"));//play the game while the user says "yes"
       System.out.print("\nHave a nice day! ");
   }
   
   //purpose of this method is to prompt the user for the sum and validate the inputs obtained from the user
   public static int dataValidation(Scanner kb)
   {
      //declaring return value
      int sum = 0;
      do 
      {
         //prompts user to enter the sum
         System.out.print("Enter the sum of the combinations that you want: ");
         //while the user does not enter an integer, keep looping until they enter an integar
         while (!kb.hasNextInt())
         {
            //refreshes or clears out the input
            kb.next();
            //prompts user again
            System.out.print("Enter the sum of the combinations that you want: ");
         }
         //user inputs the desired sum
         sum = kb.nextInt();
      }while (sum <= 0);//run the loop until the sum is a positive integer
      //returns the desired sum value 
      return sum;
   }
   
   //purpose of this method is to provide initialization of each card in the deck
   public static int[] initialize()
   {
      int [] cards = new int[52];
      int n = 0; 
      for (int i = 0; i < 4; i++)
      {
         for (int j = 1; j <= 13; j++)
         {
            cards[n] = j;
            n++;
         }
      }
      //returns the cards array 
      return cards; 
   }
}