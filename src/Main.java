import java.util.Scanner;

public class Main {
    static int row, col;

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

    public static void askPlayerPosition(char[][] board, int[] move) {
        Scanner input = new Scanner(System.in);
        int pos; // Position

        while (true) {
            System.out.print("Enter Position (1-9): ");
            pos = input.nextInt();

            if (pos < 1 || pos > 9) {
                System.out.println("Invalid position! Please enter a number between 1 and 9.");
                continue;
            }
            move[0] = (pos - 1) / 3;
            move[1] = (pos - 1) % 3;
            if (board[move[0]][move[1]] == 'X' || board[move[0]][move[1]] == 'O') {
                System.out.println("Position taken! Try again.");
            } else {
                return;
            }


        }
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
        while (true) {
            int[] move = new int[2];
            askPlayerPosition(board, move);
            board[move[0]][move[1]] = 'X';
            board[row][col] = 'X';
            printBoard(board);
        }


    }
}