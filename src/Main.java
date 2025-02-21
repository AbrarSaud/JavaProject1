import java.util.Random;
import java.util.Scanner;

public class Main {
    static int totalMoves = 0;//  number of moves in a round

    // This method prints the game board.
    public static void printBoard(char[][] board) {
        System.out.println("\n****************************");
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
        System.out.println("**************************** \n");
    }

    //This method asks the player to choose a position and e chosen number is valid or Invalid
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
            // Convert 1-9 input into 2D array indexes
            int row = (pos - 1) / 3;
            int col = (pos - 1) % 3;
            // Check if the chosen position is empty
            if (board[row][col] != 'X' && board[row][col] != 'O') {
                board[row][col] = 'X';
                totalMoves++; // Increase move (counter)
                break;
            } else {
                System.out.println("Position taken! Try again.");

            }
        }
    }
    // This method makes the computer pick a random position (1-9)
    public static void computerMove(char[][] board) {
        Random rand = new Random();
        int row, col;
        while (true) {
            int pos = rand.nextInt(9) + 1;// random number between 1 and 9
            // Convert 1-9 input into 2D array indexes
            row = (pos - 1) / 3;
            col = (pos - 1) % 3;
            // Check if the chosen position is empty
            if (board[row][col] != 'X' && board[row][col] != 'O') {
                System.out.println("Computer chose position: " + pos);
                board[row][col] = 'O';
                totalMoves++; // Increase move (counter)
                break;
            }
        }
    }

    //  This method checks if a player or computer has won
    public static boolean isWinner(char[][] board, char s) {
        // Check each row for a win
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == s && board[row][1] == s && board[row][2] == s) {
                return true;// wins with a full row
            }
        }
        // Check each column for a win
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == s && board[1][col] == s && board[2][col] == s) {
                return true;// wins with a full column
            }
        }
        // Check  (top-left) to (bottom-right)
        if (board[0][0] == s && board[1][1] == s && board[2][2] == s) {
            return true;
        }
        // Check (top-right) to (bottom-left)
        if (board[0][2] == s && board[1][1] == s && board[2][0] == s) {
            return true;
        }
        return false;// No win
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int totalRounds;
        int playerWins = 0;
        int computerWins = 0;
        System.out.println("Welcome to Tic-Tac-Toe Game!");
        System.out.println("You will be playing VS computer...");
        System.out.print("Enter number of rounds (1 or 3): ");
        totalRounds = input.nextInt();
        //  Validate rounds input
        if (totalRounds == 1 || totalRounds == 3) {
            System.out.println("---------- Game  Started ----------");
            for (int i = 0; i < totalRounds; i++) {
                System.out.println("\n***** Round " + (i
                        + 1) + " *****");
                // Create board with numbers (1-9)
                char[][] board = {
                        {'1', '2', '3'},
                        {'4', '5', '6'},
                        {'7', '8', '9'},
                };
                totalMoves = 0;// count for the new round
                printBoard(board);
                while (totalMoves < 9) {
                    askPlayerPosition(board);
                    printBoard(board);
                    // Check if player won
                    if (isWinner(board, 'X')) {
                        System.out.println("You won! this round!");
                        playerWins++;
                        break;
                    }
                    // If all moves are used
                    if (totalMoves == 9) {
                        System.out.println("No one wins this round!");
                        break;
                    }
                    computerMove(board);
                    printBoard(board);
                    // Check if computer won
                    if (isWinner(board, 'O')) {
                        System.out.println("Computer wins! this round! ");
                        computerWins++;
                        break;
                    }
                    if (totalMoves == 9) {
                        System.out.println("No one wins this round! ");
                        break;
                    }

                }
            }
            // Final game results
            System.out.println("\n---------- Game Over! ----------");
            System.out.println("---> Player Wins: " + playerWins);
            System.out.println("---> Computer Wins: " + computerWins);
            if (playerWins > computerWins) {
                System.out.println("- You won !!");
            } else if (computerWins > playerWins) {
                System.out.println("-Computer won !!");
            } else {
                System.out.println("-No one wins");
            }

        } else {
            System.out.println(" Please enter 1 or 3.");

        }
        input.close();

    }
}