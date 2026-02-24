import java.util.ArrayList;

public class minesweeper {
    public tile[][] board;
    public int mines;

    public minesweeper(int row, int col, int mines) {

    }

    public minesweeper(int[][] input) {
        board = new tile[input.length][input[0].length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] == -1) {
                    tile temp = new tile(true, -1);
                    board[i][j] = temp;
                } else {
                    tile temp = new tile(false, input[i][j]);
                    board[i][j] = temp;
                }
            }
        }
    }

    public int[][] initializeBoard(int rows, int cols, int mineCount) {
        return new int[][] {};
    }

    public void revealZeros(int row, int col) {
        ArrayList<tile> tilesThatAreZeros = new ArrayList<>();
        if (row != 0 && col != 0) // top left
        {
            if (board[row - 1][col - 1].getSurroundingAmount() == 0) {
                tilesThatAreZeros.add(board[row - 1][col - 1]);
                board[row - 1][col - 1].setReveal(true);
            }
        }
        if (row != 0) // top middle
        {
            if (board[row - 1][col].getSurroundingAmount() == 0) {
                tilesThatAreZeros.add(board[row - 1][col]);
                board[row - 1][col].setReveal(true);
            }
        }
        if (row != 0 && col != board[row].length - 1) // top right
        {
            if (board[row - 1][col + 1].getSurroundingAmount() == 0) {
                tilesThatAreZeros.add(board[row - 1][col + 1]);
                board[row - 1][col + 1].setReveal(true);
            }
        }
        if (col != 0) // middle left
        {
            if (board[row][col - 1].getSurroundingAmount() == 0) {
                tilesThatAreZeros.add(board[row][col - 1]);
                board[row][col - 1].setReveal(true);
            }
        }
        if (col != board[row].length - 1) // middle right
        {
            if (board[row][col + 1].getSurroundingAmount() == 0) {
                tilesThatAreZeros.add(board[row][col + 1]);
                board[row][col + 1].setReveal(true);
            }
        }
        if (row != board.length - 1 && col != 0) // bottom left
        {
            if (board[row + 1][col - 1].getSurroundingAmount() == 0) {
                tilesThatAreZeros.add(board[row + 1][col - 1]);
                board[row + 1][col - 1].setReveal(true);
            }
        }
        if (row != board.length - 1) // bottom middle
        {
            if (board[row + 1][col].getSurroundingAmount() == 0) {
                tilesThatAreZeros.add(board[row + 1][col]);
                board[row + 1][col].setReveal(true);
            }
        }

        if (row != board.length - 1 && col != board[row].length - 1) // bottom right
        {
            if (board[row + 1][col + 1].getSurroundingAmount() == 0) {
                tilesThatAreZeros.add(board[row + 1][col + 1]);
                board[row + 1][col + 1].setReveal(true);
            }
        }
    }

    public int revealCell(int row, int col) {
        board[row][col].setReveal(true);
        checkLose(row, col);
        return board[row][col].getSurroundingAmount();
    }

    public void flagCell(int row, int col) {
        board[row][col].setFlagged(!board[row][col].getFlaggedStatus());
    }

    public int countAdjacentMines(int row, int col) {
        return board[row][col].getSurroundingAmount();
    }

    public boolean checkWin() {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (!board[i][j].getRevealed() || (board[i][j].getMineStatus() && !board[i][j].getFlaggedStatus())) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkLose(int row, int col) {
        return board[row][col].getMineStatus();
    }

    public int getRows() {
        return board.length;
    }

    public int getCols() {
        return board[0].length;
    }

    public int getTotalMines() {
        int cnt = 0;
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j].getMineStatus()) {
                    ++cnt;
                }
            }
        }
        return cnt;
    }

    public tile getCell(int row, int col) {
        return board[row][col];
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                str += board[i][j].toString();
            }
            str += "\n";
        }
        return str;
    }

    public void printBoard() {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j].getRevealed()) {
                    if (board[i][j].getMineStatus()) {
                        System.out.print("* ");
                    } else {
                        System.out.print(board[i][j].getSurroundingAmount() + " ");
                    }
                } else if (board[i][j].getFlaggedStatus()) {
                    System.out.print("F ");
                } else {
                    System.out.print("# ");
                }
            }
            System.out.println();
        }
    }
}
