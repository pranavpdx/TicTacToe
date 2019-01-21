import java.util.Scanner;

public class TicTacToe {
	int[][] board = new int[3][3];
	final int BLANK = 0;
	final int X_MOVE = 1;
	final int O_MOVE = 2;
	final int O_TURN = 0;
	final int X_TURN = 1;
	int turn = X_TURN;
	Scanner scanner;
	String input;
	int xWins = 0;
	int oWins = 0;

	public TicTacToe() {
		boolean stillPlaying = true;
		scanner = new Scanner(System.in);
		System.out.println("Welcome to the Tic-Tac-Toe Game!");
		System.out.println("Enter player 1's name (This player will be X): ");
		String player1 = scanner.nextLine();
		System.out.println("Enter player 2's name (This player will be O): ");
		String player2 = scanner.nextLine();
		while (stillPlaying == true) {
			System.out.println("Ok! Lets play! Its " +player1 + "'s turn:");
			printBoard();
			while (checkWin(X_MOVE) == false && checkWin(O_MOVE) == false && checkTie() == false) {
				input = scanner.nextLine();
				if (input.length() != 2) {
					System.out.println("Enter a letter(a, b, or c) followed by a number (1, 2, or 3)");
				} else if (input.charAt(0) != 'a' && input.charAt(0) != 'b' && input.charAt(0) != 'c') {
					System.out.println("Row must be an a, b, or c");
				} else if (input.charAt(1) != '1' && input.charAt(1) != '2' && input.charAt(1) != '3') {
					System.out.println("colomn must be a 1, 2, or 3");
				} else {
					int row = input.charAt(0) - 'a';
					int colomn = input.charAt(1) - '1';
					if (board[row][colomn] == BLANK) {
						if (turn == X_TURN) {
							board[row][colomn] = X_MOVE;
							turn = O_TURN;
						} else {
							board[row][colomn] = O_MOVE;
							turn = X_MOVE;
						}
					} else {
						System.out.println("Sorry! There's already an X or an O there");
					}
					printBoard();
					if( turn == O_TURN && checkWin(X_MOVE) == false && checkWin(O_MOVE) == false 
						&& checkTie() == false ) {
						System.out.println(player2 + "'s turn:");
					}else if (turn == X_TURN && checkWin(X_MOVE) == false && checkWin(O_MOVE) == false 
							  && checkTie() == false ) {
						System.out.println(player1 + "'s turn:");
					}
				}
				if (checkWin(X_MOVE) == true) {
					System.out.println("Congratulations! " + player1 + " wins");
					xWins ++;
					System.out.println(player1 + " has won " + xWins + " times!");
				} else if(checkWin(O_MOVE) == true) {
					System.out.println("Congratulations! " + player2 + " wins");
					oWins++;
					System.out.println(player2 + " has won " + oWins + " times!");
				} else if( checkTie() == true) {
					System.out.println("Its a tie!");
				}
			}
			System.out.println("Would you like to play again?");
			String input2 = scanner.nextLine();
			if (input2.equals("yes") || input2.equals("y") || input2.equals("Yes")) {
				turn = X_TURN;
				for (int row = 0; row < board.length; row++) {
					for (int colomn = 0; colomn < board[0].length; colomn++) {
						board[row][colomn] = BLANK;
					}
				}
			} else {
				stillPlaying = false;
				System.out.println("Thank you for playing");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TicTacToe();
	}

	public void printBoard() {
		System.out.println(" \t1\t2\t3");
		for (int row = 0; row < board.length; row++) {
			String output = (char) ('a' + row) + "\t";
			for (int colomn = 0; colomn < board[0].length; colomn++) {
				if (board[row][colomn] == BLANK) {
					output += "\t";
				} else if (board[row][colomn] == X_MOVE) {
					output += "X\t";
				} else if (board[row][colomn] == O_MOVE) {
					output += "O\t";
				}
			}
			System.out.println(output);
		}
	}

	public boolean checkWin(int player) {
		if (board[0][0] == player && board[0][1] == player && board[0][2] == player) {
			return true;
		}
		if (board[1][0] == player && board[1][1] == player && board[1][2] == player) {
			return true;
		}
		if (board[2][0] == player && board[2][1] == player && board[2][2] == player) {
			return true;
		}
		if (board[0][0] == player && board[1][0] == player && board[2][0] == player) {
			return true;
		}
		if (board[0][1] == player && board[1][1] == player && board[2][1] == player) {
			return true;
		}
		if (board[0][2] == player && board[1][2] == player && board[2][2] == player) {
			return true;
		}
		if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
			return true;
		}
		if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
			return true;
		}
		else{return false;}
	}

	public boolean checkTie() {
		int x = 0;
		for (int row = 0; row < board.length; row++) {
			for (int colomn = 0; colomn < board[0].length; colomn++) {
				if (board[row][colomn] != BLANK) {
					x = x+1;
				}
			}
		}
		if( x == 9) {
			return true;
		}else {
			return false;
		}
		
	}
}
