package TICTAC;

public class PlayTicTac {
	
	
	  /**
      board a 3x3 array containing 0, 1, 2, values indicating
      blanks or player numbers
      */ 
	  private int[][] board;
	   
	   public PlayTicTac() {
		   this.board = new int[3][3];
	   }
	   
	   /**
	      Checks if player has won tic-tac-toe along diagonal lines.
	      @param player the player to check for a winning sequence of marks
	      @return true if player won, false otherwise
	   */
	   private boolean wonDiagonal( int player)
	   {
	      int count = 0;
	      // check one diagonal
	      for (int i = 0; i < 3; i++)
	      {
	         if (this.board[i][i] == player)
	         {
	            count++;
	         }
	      }
	      if (count == 3)
	      {
	         return true;
	      }
	      else
	      {
	         count = 0;
	      }

	      // check other diagonal
	      for (int i = 0; i < 3; i++)
	      {
	         if (this.board[i][2 - i] == player)
	         {
	            count++;
	         }
	      }
	      if (count == 3)
	      {
	         return true;
	      }
	      else
	      {
	         return false;
	      }
	   }

	   /**
	      Checks if player has won tic-tac-toe along straight lines.
	      @param player the player to check for a winning sequence of marks
	      @return true if player won, false otherwise
	   */
	   private boolean wonStraightLines( int player)
	   {
	      for (int i = 0; i < 3; i++)
	      {
	         int count = 0;
	         for (int j = 0; j < 3; j++)
	         {
	            if (this.board[i][j] == player)
	            {
	               count++;
	            }
	         }
	         if (count == 3)
	         {
	            return true;
	         }
	      }
	      for (int i = 0; i < 3; i++)
	      {
	         int count = 0;
	         for (int j = 0; j < 3; j++)
	         {
	            if (board[j][i] == player)
	            {
	               count++;
	            }
	         }
	         if (count == 3)
	         {
	            return true;
	         }
	      }
	      return false;
	   }

	   /**
	      Checks if player has won.
	      @param player the player to check for a winning sequence of marks
	      @return true if player won, false otherwise
	   */
	   public boolean win(int player)
	   {
	      if (wonDiagonal(player) || wonStraightLines(player))
	      {
	         return true;
	      }
	      else
	      {
	         return false;
	      }
	   }

	   /**
	      Draws gameboard, player 1 is X, player 2 is O.
	   */
	   public void drawBoard()
	   {
	      System.out.println("|-----|");
	      for (int i = 0; i < 3; i++)
	      {
	         for (int j = 0; j < 3; j++)
	         {
	            if (board[i][j] == 1)
	            {
	               System.out.print("|X");
	            }
	            else if (board[i][j] == 2)
	            {
	               System.out.print("|O");
	            }
	            else
	            {
	               System.out.print("| ");
	            }
	         }
	         System.out.println("|\n|-----|");
	      }
	   }
	   
	   /**
	      Choose a cell for player has won.
	      @param r the row number chose
	      @param c the column number chose
	      @param player the player who choose a position	      
	      @throws UnavailableCellException is the cell has been occupied (by either player)   
	      */
	   
	   public void choose(int r, int c, int player) throws UnavailableCellException {
		   if (this.board[r][c] !=0)
			   throw new UnavailableCellException();
		   this.board[r][c] = player;
	   }
	}



