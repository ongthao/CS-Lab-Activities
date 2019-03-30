/*Name: Ong Thao
 * Program description: Purpose of this class is to create the board to play the tic-tac-toe game on. 
 * Date Created: 3/29/19*/

public class TTTBoard {
	private int boardSize;
	private char[][] board;
	
	public TTTBoard(int size)
	{
		boardSize = size;
		board = new char[size][size];
	}
	
	public TTTBoard()
	{
		boardSize = 3;
		board = new char[3][3];
	}
	
	public char get(int r, int c) 
	{
		return board[r][c];
	}
	
	public void set(int r, int c, char ch)
	{
		board[r][c] = ch;
	}
	
	public int size()
	{
		return boardSize;
	}
	
	public char winner()
	{
		if(checkRows() != ' ')
			return checkRows();
		else if(checkColumns() != ' ')
			return checkColumns();
		else if(checkDia() != ' ')
			return checkDia();
		return ' ';
	}
	
	public char checkRows()
	{
		for(int i = 0; i < size(); i++)
		{
			if(board[i][0] == 'O' && board[i][1] == 'O' && board[i][2] == 'O')
				return 'O';
			else if(board[i][0] == 'X' && board[i][1] == 'X' && board[i][2] == 'X')
				return 'X';
		}
		return ' ';
	}
	
	public char checkColumns()
	{
		for(int i = 0; i < size(); i++)
		{
			if(board[0][i] == 'O' && board[1][i] == 'O' && board[2][i] == 'O')
				return 'O';
			else if(board[0][i] == 'X' && board[1][i] == 'X' && board[2][i] == 'X')
				return 'X';
		}
		return ' ';	
	}
	
	public char checkDia()
	{
		if((board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') || (board[2][0] == 'O' && board[1][1] == 'O' && board[0][2] == 'O'))
			return 'O';
		else if((board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') || (board[2][0] == 'X' && board[1][1] == 'X' && board[0][2] == 'X'))
			return 'X';
		return ' ';
	}	
	
	public String toString()
	{
		String n = "";
		for(int i = 0; i < board.length; i++)
		{
			n += " | ";
			for(int j = 0; j < board[i].length; j++)
			{
				n += board[i][j] + " | ";
			}
			n += "\n";
		}
		return n;
	}
}
