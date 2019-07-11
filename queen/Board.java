package queen;
public class Board
{		
	public static int board[][] = new int [8][8]; //Initiates a new 2D array with size 8x8.
	public Board() 
	{					
	}
	
	static void show(int[][] board, int col)
	{							
			for(int i=0; i<8; i++)
	    	{
	    		for(int j=0; j<8; j++)
	    		{	    			
	    			System.out.print(" "+ board[i][j] + " "); //Prints the chessboard to the console.
	    		}
	    		System.out.println(); //Prints each row.
	    	}
			System.out.println("\n");			
	}	
	
	static void showall(int[][] board, int col, int yco, int xco)
	{			
			if(board[8-yco][xco-1] == 1) //If the inputs co-ordinates have a queen.
			{
				if(Queen.solve(board, col) != (Queen.solve(board, col+1)))
				{ //And the columns do not have the same solution.
					Board.show(board, col+1);	 //Print the new solution.
				}	
				else
				{
					System.out.println("No more solutions for this co-ordinate.");
				}
			}
			
		}				
	}