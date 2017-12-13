import java.util.Scanner;

public class TicTacToeMod {
	/**
	* this is the game board
	*/
	private static char[][] board;
	/**
	* this is the player's character. (X, 0 or Y)
	*/
	private static char playerChar;
	/**
	* size of the board, 3 if 2 people play, 5 if 3 play
	*/
	private static int boardSize;
	/**
	* no of players playing the game (2 or 3)
	*/
	private static int numberOfPlayers;
	
	/**
	* sets the size of the board as 3 or 5, depending on the no of players
	*/
	public boolean setSize(int n) { 
		if (n == 2) {
			boardSize = 3;
			return false;
		} else if(n == 3) {
			boardSize = 5;
			return false;
		} else {
			System.out.println("Please enter 2 or 3");
			return true;
		}
		
	}
	/**
	* Creates a new Game Board.
	*/
	public void createBoard(int n) {
		this.board = new char[n][n];
	}
	/**
	* This creates a default board, that is a board with 9 or 
	* 25 boxes which can be printed later.
	*/
	public void defaultBoard(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '-';
			}
		}
	}
	/**
	* this is the sets the character for the next player,
	* depending on what the first player chooses.
	*/
	public void nextPlayerChar3() {
		if (playerChar == 'x') {
			playerChar = 'o';
		}
		else {
			playerChar = 'x';
		}
	}
	/**
	* this is the sets the character for the next player,
	* depending on what the first player chooses.
	*/
	public void nextPlayerChar5() {
		if (playerChar == 'x') {
			playerChar = 'o';
		}
		else if(playerChar == 'o') {
			playerChar = 'y';
		}
		else {
			playerChar = 'x';
		}
	}
	/**
	* this method fills the board with x or o wherever the player
	* wants.
	*/
	public void fillBoard(int i, int j) {
		board[i][j] = playerChar;
	}
	/**
	* method displays the board on screen.
	*/
	public void displayBoard(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print("|");
			for (int j = 0 ; j < n; j++) {
				System.out.print(board[i][j] + "|");
			}
			System.out.println("");
			if(boardSize == 3) {
			System.out.println("--------");
			} else {
				System.out.println("-----------");
			}
		}
	}
	
	/*------------- LOGICAL FUNCTIONS ---------------*/
	/**
	* checks if 3 consecutive elements are the same.
	* @param elem1 is the first element.
	* @param elem2 is the second element.
	* @param elem3 is the third element.
	* @return true if the elements are consecutive.
	*/
	public boolean consecutiveElem3(char elem1, char elem2, char elem3) {
		if (elem1 == elem2 && elem2 == elem3) {
			if (elem1 == '-') {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
	/**
	* checks if 5 consecutive elements are the same.
	* @param elem1 is the first element.
	* @param elem2 is the second element.
	* @param elem3 is the third element.
	* @param elem4 is the fourth element.
	* @param elem5 is the fifth element.
	* @return true if the elements are consecutive.
	*/
	public boolean consecutiveElem5(char elem1, char elem2, char elem3, char elem4, char elem5) {
		if (elem1 == elem2 && elem2 == elem3 && elem3 == elem4 && elem4 == elem5) {
			if (elem1 == '-' ) {
				return false;
			} else {
			return true;
			}
		} else {
			return false;
		}
	}
	/**
	* checks if 3 elements in a row are consecutive
	* @return true if elements in a row are consecutive.
	*/
	public boolean consecutiveRow3() {
		boolean output = false;
		for (int i = 0; i < 3; i++) {
			if (consecutiveElem3(board[0][i], board[1][i], board[2][i]) ) {
				output = true;
			}
		}
		if (board[0][0] == '-') {
			output = false;
		}
		return output;
	}
	/**
	* checks if 5 elements in a row are consecutive
	* @return true if elements in a row are consecutive.
	*/
	public boolean consecutiveRow5() {
		boolean output = false;
		for (int i = 0; i < 5; i++) {
			if (consecutiveElem5(board[0][i], board[1][i], board[2][i], board[3][i], 
					board[4][i])) {
				output = true;
			}
		}
		return output;
	}

	/**
	* checks if 3 elements in a column are consecutive
	* @return true if elements in a column are consecutive.
	*/
	public boolean consecutiveColumn3() {
		boolean output = false;
		for (int i = 0; i < 3; i++) {
			if (consecutiveElem3(board[i][0], board[i][1], board[i][2])) {
				output =true;
			}
		}
		if (board[0][0] == '-') {
			output = false;
		}
		return output;
	}
	/**
	* checks if 5 elements in a column are consecutive
	* @return true if elements in a column are consecutive.
	*/
	
	public boolean consecutiveColumn5() {
		boolean output = false;
		for (int i = 0; i < 5; i++) {
			if (consecutiveElem5(board[i][0], board[i][1], board[i][2], board[i][3], 
					board[i][4])) {
				output = true;
			}
		}
		return output;
	}
	/**
	* checks if 3 elements in a diagonal are consecutive
	* @return true if elements in a diagonal are consecutive.
	*/
	public boolean consecutiveDiagonal3() {
		boolean output = false;
		
			if (consecutiveElem3(board[0][0],board[1][1], board[2][2])) {
				output = true;
			}
			if (consecutiveElem3(board[0][2], board[1][1], board[2][0])) {
				output = true; 
			}
			if (board[0][0] == '-') {
				output = false;
			}
		
		return output;
	}
	
        /**
	* checks if 5 elements in a diagonal are consecutive
	* @return true if elements in a diagonal are consecutive.
	*/
	public boolean consecutiveDiagonal5() {
		boolean output = false;
		for (int i = 0; i < 5; i++) {
			if (consecutiveElem5(board[0][0], board[1][1], board[2][2], 
					board[3][3], board[4][4]) || consecutiveElem5(board[4][0],board[3][1],board[2][2],board[1][3],board[0][4])) {
				output = true;
			}
			
		}
		return output;
	}
	/**
	* checks if the game has a winner
	* @return true if the game has a winner.
	*/
	public boolean winner3() {
		if (consecutiveRow3() || consecutiveColumn3() || consecutiveDiagonal3()) {
			return true;
		} else {
			return false;
		}
	}
	/**
	* checks if the game has a winner
	* @return true if the game has a winner.
	*/
	public boolean winner5() {
		if (consecutiveRow5() || consecutiveColumn5() || consecutiveDiagonal5()) {
			return true;
		} else {
			return false;
		}
	}
	/**
	* a constructor
	* it calls setSize, createBoard, and default.
	* so if a variable of type TicTacToe is made then all
	* the methods are called and the work is done already.
	*/
	public TicTacToeMod() {
		setSize(numberOfPlayers);
		createBoard(boardSize);
		defaultBoard(boardSize);
		
		
	}
	/**
	* The main method.
	*/

	public static void main(String args[]) {
		
		System.out.println("Welcome to a game of tic tac toe!");
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
		System.out.println("How many players do you want to play with? ");
		numberOfPlayers = scanner.nextInt();
		if (numberOfPlayers == 2 || numberOfPlayers ==3) {
		break; //break out of loop if input is valid.
		}
		System.out.println("Please enter 2 or 3");
		}
		
		while(true) {
		System.out.println("What character do you want to start with?");
		playerChar = scanner.next().charAt(0);
		if (playerChar == 'x' || playerChar == 'o') {
			break; // break out of loop if input is valid.
		}
		System.out.println("Please enter x or o");
		}
		
		TicTacToeMod Tictactoe = new TicTacToeMod();
		
		if (numberOfPlayers == 2) {
		while (true) {
			int counter = 0;
			int row;
			int col;
			
			while (true) {
				
				while (true) {
					
					System.out.println("Choose your row");
					row = scanner.nextInt();
					if(row < boardSize && row >= 0) {
						// break out of loop if row input is less than the size.
						// (Inputs start with 0)
						break; 
					} else {
						System.out.println("Please enter a valid row");
					}
					}
					
					
					while (true) {
					System.out.println("Choose your column");
					col = scanner.nextInt();
					if(col < boardSize && col >= 0) {
						// break out of loop if row input is less than the size.
						// (Inputs start with 0)
						break;
					} else {
						System.out.println("Please enter a valid column");
					}
					}
					if (board[row][col] == 'x' || board[row][col] == 'o') {
						System.out.println("Cell already occupied");
					} else {
						break; //break out of loop if the box was empty
					}
				
			}
			
			
			
			
			
			
			Tictactoe.fillBoard(row,  col);
			Tictactoe.displayBoard(boardSize);
			
			
			if (Tictactoe.winner3()) { // Game is over if there is a winner.
				System.out.println("Game over!");
				System.exit(0);
			}
			else if (counter >= 9) { // Game is also over if there is a draw
				// That is if every box is filled and there is no winner
				System.out.println("Draw!");
				System.exit(0);
			}
			
			else {
				Tictactoe.nextPlayerChar3(); 
			}
			
		}
		}
		// This is the same code as above, but instead for a 3 person game
		else {
			while (true) {
				int counter = 0;
				int row;
				int col;
				
				while(true) {
					while (true) {
						
						System.out.println("Choose your row");
						row = scanner.nextInt();
						if(row < boardSize && row >= 0) {
							break;
						} else {
							System.out.println("Please enter a valid row");
						}
						}
					
					
					
					while (true) {
						System.out.println("Choose your column");
						col = scanner.nextInt();
						if(col < boardSize && col >= 0) {
							break;
						} else {
							System.out.println("Please enter a valid column");
						}
						}
					if (board[row][col] == 'o' || board[row][col] == 'x' || board[row][col] =='y') {
						System.out.println("Cell already occupied");
					} else {
						break;
					}
					
				}
				
				
				
				
				
				Tictactoe.fillBoard(row,  col);
				Tictactoe.displayBoard(boardSize);
				
				
				if (Tictactoe.winner5()) {
					System.out.println("Game over!");
					System.exit(0);
				}
				else if (counter >= 25) {
					System.out.println("Draw!");
					System.exit(0);
				}
				
				else {
					Tictactoe.nextPlayerChar5();
				}
				
			}
			
		}
		
		
		
		
	}
	
}
