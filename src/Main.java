import java.util.Random;
import java.util.Scanner;

public class Main {
    static int totalMoves = 0;

    public static void printBoard(char[][] board) {
        System.out.println("****************************");
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
        System.out.println("****************************");
    }

    public static void askPlayerPosition(char[][] board) {
        Scanner input = new Scanner(System.in);
        int pos; // Position

        while (true) {
            System.out.print("Enter Position (1-9): ");
            pos = input.nextInt();

            if (pos < 1 || pos > 9) {
                System.out.println("Invalid position! Please enter a number between 1 and 9.");
                continue;
            }
            int row = (pos - 1) / 3;
            int col = (pos - 1) % 3;
            if (board[row][col] != 'X' && board[row][col] != 'O') {
                board[row][col] = 'X';
                totalMoves++;
                break;
            } else {
                System.out.println("Position taken! Try again.");

            }
        }
    }

    public static void computerMove(char[][] board) {
        Random rand = new Random();
        int row, col;
        while (true) {
            int pos = rand.nextInt(9) + 1;
            row = (pos - 1) / 3;
            col = (pos - 1) % 3;
            if (board[row][col] != 'X' && board[row][col] != 'O') {
                System.out.println("Computer chose position: " + pos);
                board[row][col] = 'O';
                totalMoves++;
                break;
            }
        }

    }

    public static boolean isWinner(char[][] board, char s) {
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == s && board[row][1] == s && board[row][2] == s) {
                return true;
            }
        }
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == s && board[1][col] == s && board[2][col] == s) {
                return true;
            }
        }
        if (board[0][0] == s && board[1][1] == s && board[2][2] == s) {
            return true;
        }

        if (board[0][2] == s && board[1][1] == s && board[2][0] == s) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe Game!");
        System.out.println("You will be playing VS computer...");
        char[][] board = {
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'},
        };
        printBoard(board);

        for (int i = 0; i < 9; i++) {

            askPlayerPosition(board);
            printBoard(board);
       if (isWinner(board,'X')){
           System.out.println("You won !!");
           break;
       }
       if (  totalMoves ==9){
           System.out.println("No one wins");
           break;
       }
            computerMove(board);
            printBoard(board);
            if (isWinner(board,'O')){
                System.out.println("Game Over !! Computer wins ");
                break;
            }
            if (totalMoves == 9) {
                System.out.println("No one wins.");
                break;
            }
        }


    }
}