import java.util.*;
import java.io.*;

public class minesweepermain {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("src/minesweepExample.txt"));
        int rows = in.nextInt();
        int cols = in.nextInt();
        int[][] board = new int[rows][cols];
        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 6; ++j) {
                board[i][j] = in.nextInt();
            }
        }
        minesweeper gameBoard = new minesweeper(board);
        in.close();

        Scanner userInput = new Scanner(System.in);
        gameBoard.printBoard();
        while (true) {
            System.out.println("Reveal or Flag");
            String input = userInput.next();
            System.out.println("Row num, Col num");
            int row = userInput.nextInt();
            int col = userInput.nextInt();

            if (input.toLowerCase().equals("reveal")) {
                gameBoard.revealCell(row, col);
                if(gameBoard.getCell(row, col).getSurroundingAmount() == 0){
                    gameBoard.revealZeros(row, col);
                }
            }
            else if(input.toLowerCase().equals("flag")){
                gameBoard.flagCell(row, col);
            }
            else{
                System.out.println("Invalid input");
            }

            gameBoard.printBoard();
            if(gameBoard.checkLose(row, col)){
                System.out.println("You lost Loser");
                break;
            }
            else if(gameBoard.checkWin()){
                System.out.println("You win Winner!");
                break;
            }
        }

    }
}
