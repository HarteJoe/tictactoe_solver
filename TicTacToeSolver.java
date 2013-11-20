/* 
** @author: Josef Harte
** This Java program can determine the winner of a Tic Tac Toe game
** See the README
*/

import java.io.*;

public class TicTacToeSolver {
    
    public static void main( String[] args ) {
		
		int noOfCases; 
		char player1; 
		char[][] board = new char[3][3]; // 2D array represents the game board
		
		try { 
			
		BufferedReader reader = new BufferedReader( new FileReader( args[0] ) );
		noOfCases = Integer.valueOf( reader.readLine() ); // Gets no. of test cases
		
		int currentCase;
		case_loop:
		for ( currentCase = 1; currentCase < noOfCases + 1; currentCase++ ) {			
			String playerString = reader.readLine(); // Gets next player, X or O
			player1 = playerString.charAt(0);
		
			// Read in the sample board
			for ( int i = 0; i < 3; i++ ) {
				String line = reader.readLine();
				board[i] = line.toCharArray();
			}
			
			// Perfect play from both players from the start (a blank board) leads to a draw
			blank_board:
			for ( char[] row: board ) {
				for ( char ch: row ) {
					if ( ch != '_' ) {
						break blank_board;
					} else {
						System.out.println("Case " + currentCase + ": Draw");
						continue case_loop;
					}
				}
			}
			
			// Check if player1 can win with their next go by marking a square INBETWEEN 2 other marked squares
			if ( ( (board[0][0] == player1) && (board[0][2] == player1) && (board[0][1] == '_' ) ) ||
			 	( (board[0][0] == player1) && (board[2][0]  == player1) && (board[1][0] == '_' ) ) ||
				( (board[0][2] == player1) && (board[2][2]  == player1) && (board[1][1] == '_' ) ) ||
				( (board[2][2] == player1) && (board[2][0]  == player1) && (board[2][1] == '_' ) ) ||
				( (board[2][0] == player1) && (board[0][2]  == player1) && (board[1][1] == '_' ) ) || 					  					( (board[0][1] == player1) && (board[2][1]  == player1) && (board[1][1] == '_' ) ) ||
				( (board[1][0] == player1) && (board[1][2]  == player1) && (board[1][1] == '_' ) )
			) {	
					System.out.println("Case " + currentCase + ": " + player1 + " Wins");
					continue case_loop;
			}
				
			// Check if player1 can win with their next go by marking a square after 2 other CONSECUTIVE squares
			// These are the horizontal and vertical lines:
			for ( int i = 0; i < 3; i++ ) {
				if( (board[i][0] == player1) && (board[i][1] == player1) && (board[i][2] == '_') ) {				 
					System.out.println("Case " + currentCase + ": " + player1 + " Wins");
					continue case_loop;
				} else if ( (board[i][2] == player1) && (board[i][1] == player1) && (board[i][0] == '_') ) {
					System.out.println("Case " + currentCase + ": " + player1 + " Wins");
					continue case_loop;
				} else if ( (board[0][i] == player1) && (board[1][i] == player1) && (board[2][i] == '_') ) {
					System.out.println("Case " + currentCase + ": " + player1 + " Wins");
					continue case_loop;
				} else if ( (board[2][i] == player1) && (board[1][i] == player1) && (board[0][i] == '_') ) {
					System.out.println("Case " + currentCase + ": " + player1 + " Wins");
					continue case_loop;
				}
			}
			
			// Check if player1 can win with their next go by marking a square after 2 other CONSECUTIVE squares
			// These are the diagonal lines:
			if ( ( (board[0][0] == player1) && (board[1][1] == player1) && (board[2][2] == '_') ) ||
				( (board[2][2] == player1) && (board[1][1] == player1) && (board[0][0] == '_') ) ||
				( (board[0][2] == player1) && (board[1][1] == player1) && (board[2][0] == '_') ) ||
				( (board[2][0] == player1) && (board[1][1] == player1) && (board[0][2] == '_') )
			) {
				System.out.println("Case " + currentCase + ": " + player1 + " Wins");
				continue case_loop;
			} else {
			
				/* Since it's a perfect game, if all the above fail then it must be a draw as each player
				can prevent the other from winning */
				System.out.println("Case " + currentCase + ": Draw"); 
			}				
		}
		
		} catch (FileNotFoundException ex) {
			System.err.println("The input file was not found");
			System.exit(1);	
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(1);
		}			
    }

}
