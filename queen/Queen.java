package queen;
import java.util.Scanner;

public class Queen {	
	static int xco;	 //int value for the x co-ordinate.
	static int yco;  //int value for the y co-ordinate.
	public Queen()
	{		
		return;	 //Returns Queen.						
	}
	
	public static int firstQueen(int board[][])
	{				
		Scanner in = new Scanner(System.in);		
		System.out.println("Enter the x co-ordinate of the queen, e.g: 1.");
		xco = in.nextInt(); //Sets the x co-ordinate to the user input.
		System.out.println("Enter the y co-ordinate of the queen, e.g: 4.");
		yco = in.nextInt(); // Sets the y co-ordinate to the user input.
		board[8-yco][xco-1] = 1; //Places the first queen on the chessboard.
		System.out.printf("The first queen was entered at co-ordinates [%d, %d]", xco, yco);
		System.out.println("\n");		
		
		if(xco > 8) //Ensures the values entered are less than 8.
		{
			System.out.print("Please enter a valid [x] co-ordinate.");			
		}
		if(yco > 8)
		{
			System.out.print("Please enter a valid [y] co-ordinate.");
		}			
		board[8-yco][xco-1] = 1;
		return xco; //Returns the x co-ordinate value.
	}
	
	public static boolean backtracking(int board[][], int row, int col)
	{
		int z,x;
		for(z=0; z < col; z++)
		{
			//If there is a queen on the same row.
			if(board[row][z] == 1) 
			{
				return false; //Can't place queen.
			}
		}		
		for(z=row, x=col; z>=0 && x>=0; z--, x--)
		{
			//If there is a queen on the lower diagonal.
			if (board[z][x] == 1)
			{
				return false; //Can't place queen.
			}
		}		
		for(z=row, x=col; x>=0 && z<8; z++, x--)
		{
			//If there is a queen on the upper diagonal.
			if (board[z][x] == 1)
			{
				return false; //Can't place queen.
			}
		}			
		//If each of these for loops return false.
		return true; //A queen can be placed.
	}		
	
	static boolean solve(int board[][], int col)
	{
		if (col==8)
		{ //If the end of the board has been reached.
			return true;
		}
		for(int i=0; i<8; i++)
		{
			if(backtracking(board, i, col))
			{
				board[i][col] = 1;
				//Place a queen on the board
				if(solve(board, col+1) == true)
				{
					//Calculate for the next column.
					return true;
				}
				if(board[8-yco][xco-1] == 1) //If there is a queen at the user co-ordinate.
				{
					for(int h=0; h<8; h++)
					{
						board[h][xco-1] = 0; //No other queens in the user input column.
						board[8-yco][xco-1] = 1; //Places it back on the board.
					}
				}					
				board[i][col] = 0;	//Backtracks to the previous column.	
			}
		}
		//Returns false if no solution can be found
		return false;		
	}	
}