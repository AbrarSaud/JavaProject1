import java.util.Scanner;

public class Main {
    public static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
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



    }
}