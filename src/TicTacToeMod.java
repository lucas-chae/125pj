import java.util.Scanner;

public class TicTacToeMod {
	
	private char[][] board;
	private static char playerChar;
	private static int boardSize;
	private static int numberOfPlayers;
	
	
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
	
	public void createBoard(int n) {
		this.board = new char[n][n];
	}
	
	public void defaultBoard(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '-';
			}
		}
	}
	
	public void nextPlayerChar3() {
		if (playerChar == 'x') {
			playerChar = 'o';
		}
		else {
			playerChar = 'x';
		}
	}
	
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
	
	public void fillBoard(int i, int j) {
		board[i][j] = playerChar;
	}
	
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
		
	public boolean winner3() {
		if (consecutiveRow3() || consecutiveColumn3() || consecutiveDiagonal3()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean winner5() {
		if (consecutiveRow5() || consecutiveColumn5() || consecutiveDiagonal5()) {
			return true;
		} else {
			return false;
		}
	}
	
	public TicTacToeMod() {
		setSize(numberOfPlayers);
		createBoard(boardSize);
		defaultBoard(boardSize);
		
		
	}

	public static void main(String args[]) {
		
		System.out.println("Welcome to a game of tic tac toe!");
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many players do you want to play with? ");
		numberOfPlayers = scanner.nextInt();
		System.out.println("What character do you want to start with?");
		playerChar = scanner.next().charAt(0);
		
		TicTacToeMod Tictactoe = new TicTacToeMod();
		
		if (numberOfPlayers == 2) {
		while (true) {
			int counter = 0;
			System.out.println("Choose your row");
			int row = scanner.nextInt();
			System.out.println("Choose your column");
			int col = scanner.nextInt();
			Tictactoe.fillBoard(row,  col);
			Tictactoe.displayBoard(boardSize);
			
			
			if (Tictactoe.winner3()) {
				System.out.println("Game over!");
				System.exit(0);
			}
			else if (counter >= 9) {
				System.out.println("Draw!");
				System.exit(0);
			}
			
			else {
				Tictactoe.nextPlayerChar3();
			}
			
		}
		}
		
		else {
			while (true) {
				int counter = 0;
				System.out.println("Choose your row");
				int row = scanner.nextInt();
				System.out.println("Choose your column");
				int col = scanner.nextInt();
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
