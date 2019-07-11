package queen;

public class Main
{	    
    public static void main(String[] args)
    {   	 	
    	System.out.println("A '1' on the board represents a queen, a '0' is a blank square." + "\n");
    	Queen.firstQueen(Board.board); //Method to allow the user to place a queen on the board.
    	Board.show(Board.board, 0);	//Prints the board to the console.
    	System.out.println("Now the board has been populated with the remaining queens. \n");
    	Queen.solve(Board.board, 0); //This method performs the backtracking algorithm.    	
    	Board.show(Board.board, 0);   
    	System.out.println("Now the remaining solution(s) for this co-ordinate will be printed. \n");
    	Board.showall(Board.board, 0, Queen.yco, Queen.xco); //Shows all of the solutions for the given queen.
    }     
} 
    

	
    
	
