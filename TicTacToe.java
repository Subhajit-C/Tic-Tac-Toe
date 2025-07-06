package TicTacToe;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[][] board = new char[3][3];
        initializeBoard(board);

        char player = 'X';
        boolean gameOver = false;

        while (!gameOver) {
            printBoard(board);
            System.out.print("Player " + player + ", enter your move (row and column: 0-2): ");
            
            int row = scan.nextInt();
            int col = scan.nextInt();

            // Validate input range
            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid position! Please enter values between 0 and 2.");
                continue;
            }

            // Validate if position is empty
            if (board[row][col] != ' ') {
                System.out.println("That position is already taken! Try again.");
                continue;
            }

            board[row][col] = player;

            if (haveWon(board, player)) {
                printBoard(board);
                System.out.println("Player " + player + " has won!");
                gameOver = true;
            } else if (isBoardFull(board)) {
                printBoard(board);
                System.out.println("The game is a draw!");
                gameOver = true;
            } else {
                // Switch player
                player = (player == 'X') ? 'O' : 'X';
            }
        }
    }

    private static void initializeBoard(char[][] board) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
    }

    private static boolean haveWon(char[][] board, char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }

        return false;
    }

    private static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printBoard(char[][] board) {
        System.out.println("\nBoard:");
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(" " + board[row][col]);
                if (col < 2) System.out.print(" |");
            }
            System.out.println();
            if (row < 2) System.out.println("---+---+---");
        }
        System.out.println();
    }
}
