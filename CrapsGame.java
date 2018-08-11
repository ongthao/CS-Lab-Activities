/* Name: Ong Thao
   Program Description: This program utilizes a Random generator to play the game of craps and calculates the probability of winning the game of craps.
   Date Created: 4/10/18*/
import java.util.Random;
import java.util.Scanner;
public class CrapsGame
{
   //main method calls the play method to play the game and the description method to output the game info
   public static void main(String[] args)
   {
      //calls description method
      description();
      //calls play method
      play();
   }
   
   //the play method counts the total number of losses and wins and simulates the playing of the game
   public static void play()
   {
      //declaring variable numOfWins (to keep count of the number of wins), numOfLoss(to keep count of the number of losses), constant(makes sure that the game plays a specific num of times)
      int numOfWins = 0, numOfLoss = 0, constant = 10000;
      //loop runs 10,000 times 
      for (int i = 1; i <= constant; i++)
      {
         //calls comeOutRoll method to start the game with a first roll and returns a "win" or "loss"
         String outRoll = comeOutRoll();
         //if the comeOutRoll returns a "win", we increment numOfWins by one
         if (outRoll.equalsIgnoreCase("win"))
            numOfWins++;
         //if the comeOutRoll return a "loss", we increment numOfLoss by one
         else if (outRoll.equalsIgnoreCase("loss"))
            numOfLoss++;
      }
      //after calculating the total number of wins and loss, we output the result using the playAgain method and determines if the user would like to play again
      playAgain(numOfWins,numOfLoss);      
   }
   
   //this method is the first method called by the play method to start the game
   public static String comeOutRoll()
   {
      Random rand = new Random();
      //variable "f" is initialized to the random value of the first die
      int f = rand.nextInt(6)+1;
      //variable "s" is initialized to the random value of the second die
      int s = rand.nextInt(6)+1;
      //calls the winOrLoss method to evaluate if the first roll is a win, loss, or point and returns the result 
      return winOrLoss(f+s);
   }
   
   //this method receives a number as an integar and determines if the comeOutRoll is a win, loss, or point
   public static String winOrLoss(int n)
   {
      //result is the return value for this method
      String result = "";
      //switch statments or case structures are used to evaluate if the user loss or won with the first roll
      switch (n)
      {
         //if the user gets a 7 or 11 on their first roll, they win
         case 7: case 11:
            result = "win";
            break;
            
         //if the user gets a 2, 3, or 12 on their first roll, they lose
         case 2: case 3: case 12:
            result = "loss";
            break;
            
         //if the user does not get the numbers above, they keep rolling
         case 4: case 5: case 6: case 8: case 9: case 10: 
            //the keepRolling method's return value lets the user know if the roll is either a 7 or "the point"
            int a = keepRolling(n);
            //if the user gets a 7 first, then they loss OR if the user gets a "the point" first, then they win
            if (a == 7)
               result = "loss";
            else if (a == n)
               result = "win";
      }
      return result;
   }
   
   public static int keepRolling(int thePoint)
   {
      Random rand = new Random();
      //num is return method
      int num = 0;
      //makes sure that the loop runs at least once
      do
      {
         //user keeps rolling until they get a "7" or "the point"
         int f = rand.nextInt(6)+1;
         int s = rand.nextInt(6)+1;
         num = f + s;
      }while (num != 7 && num != thePoint);
      //after getting a "7" or "the point", we return this value to the winOrLoss method to determine if we won this game
      return num;
   }
   
   //purpose of this method is to out the game description
   public static void description()
   {
      System.out.println("Computer will play a crap game for you. Here are the \nrules of the game:\n Two six sided dice is rolled\n Come out roll: The first roll of the dice in a craps\nround");
      System.out.println("A come out roll of 7 or 11 automatically wins\nA come out roll of 2, 3, or 12 automatically loses\nA come out roll of 4, 5, 6, 8, 9, or 10 becomes The Point\nIf the player gets the point he/she will keep playing by");
      System.out.println("rolling the dice until he/she gets a 7 or the point.\nIf the point is rolled first, then the player wins the\nbet.\nIf a 7 is rolled first, then the player loses.\n\n\n\n\nLet's start playing\n");
   }
   
   //outputs the results, asks user if they would like to play again, and validates the user's answer
   public static void playAgain(int wins, int loss)
   {
      Scanner kb = new Scanner(System.in);
      //outputs the result for the last game played
      System.out.println("In the simulation we :\n     won " + wins + " times\n     lost " + loss + " times,\n     for a probability of " + String.format("%.4f", winProbability(wins, loss)) + "\nHit enter key to continue\n");
      String space = kb.nextLine();
      //asks user if they would like to play another time
      System.out.print("Would you like to play another game yes/no? ");
      String answer = kb.next();
      //this while loop is an input validation that checks if the user enters specifically "yes" or "no"
      while (!answer.equalsIgnoreCase("no") && !answer.equalsIgnoreCase("yes"))
      {
            //separates the repeated prompts with a blank line
            System.out.println();
            //prompts user again because they did not enter "yes" or "no"
            System.out.print("Would you like to play another game yes/no? ");
            answer = kb.next();
      }
      //while the user enters "yes", the loop continues to play the game
      while (answer.equalsIgnoreCase("yes"))
      {
            //calls play method to allow user to play the game
            play();
            //a break is implemented so after the user plays the game after a yes, the loop does not play the game again automatically. 
            break;
      }
      //if the user enters no, a friendly goodbye message is given
      if (answer.equalsIgnoreCase("no"))
      {
            System.out.print("Have a nice day. GoodBye");
      }
   }
   
   //purpose of this method is to calculate the winning probability
   public static double winProbability(int win, int loss)
   {
      //calculates the probability of winning
      double prob = (double) win / (win + loss);
      //returns the probability
      return prob;
   }
}