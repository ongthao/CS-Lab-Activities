/*Name: Ong Thao
 * Program description: Purpose of this class is to simulate and play the game Tic-Tac-Toe. (Have plans to create GUI for this program)
 * Date created: 3/29/19
 */

import java.util.*;

public class TTTDriver {

	public static void main(String[] args) {
		TTTBoard n = new TTTBoard();
		Scanner kb = new Scanner(System.in);
		System.out.println(n.toString());
		while(n.winner() == ' ')
		{
			System.out.println("Player O, where do you want to place your \"O\"? Write in form \"0 1\" . (Row is 0, column is 1) ");
			n.set(kb.nextInt(), kb.nextInt(), 'O');
			System.out.println(n.toString());
			if(n.winner() == 'O')
				break;
			System.out.println("Player X, where do you want to place your \"X\"? Write in form \"0 1\". (Row is 0, column is 1) ");
			n.set(kb.nextInt(), kb.nextInt(), 'X');
			System.out.println(n.toString());
			if(n.winner() == 'X')
				break;
		}
		System.out.println("Final results \n \n" + n.toString());
		System.out.println("The winner is Player " + n.winner() + "!!!\n\nThanks for playing. :)");
	}
}
