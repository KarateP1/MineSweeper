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
        gameBoard.printBoard();
        //System.out.println(gameBoard.getRows());
    }
}
