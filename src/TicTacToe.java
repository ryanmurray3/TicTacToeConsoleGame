import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        // Initialize the game board with empty values
        board = new char[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
        //set the initial player
        currentPlayer = 'X';
    }

    public void displayBoard() {
        System.out.println("-------------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public void makeMove() {
        Scanner scanner = new Scanner(System.in);
        //prompt the current player to enter their move
        System.out.println("Player " + currentPlayer + ", enter your move (row and column):");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        //update the game board with the player's move
        board[row][col] = currentPlayer;
        //switch to the next player
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public boolean checkWin() {
            //check rows
            for (int row = 0; row < 3; row++) {
                if(board[row][0] != ' ' && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
                    return true;
                }
            }
            //check columns
            for (int col = 0; col < 3; col++) {
                if (board[0][col] != ' ' && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                    return true;
                }
            }
            //check diagonals
            if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
                return true;
            }
            if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
                return true;
            }
            return false;
        }
        public boolean isBoardFull() {
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++){
                if(board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();

        // Game loop
        while (true) {
            // Display the current state of the game board
            game.displayBoard();

            // Make a move
            game.makeMove();

            // Check for a win
            if (game.checkWin()) {
                System.out.println("Player " + game.currentPlayer + " wins!");
                break;
            }

            // Check for a draw
            if (game.isBoardFull()) {
                System.out.println("It's a draw!");
                break;
            }
        }

    }

}
