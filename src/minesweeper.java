public class minesweeper {
    public tile[][] board;
    public int mines;
    public minesweeper(int row, int col, int mines) {
        
    }
    public minesweeper(int[][] input) {
        board = new tile[input.length][input[0].length];
        for(int i = 0; i < input.length; i++) {
            for(int j = 0; j < input[0].length; j++) {
                if(input[i][j] == -1) {
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
        return new int[][]{};
    }
    public int revealCell(int row, int col) {
        return -1;
    }
    public void flagCell(int row, int col) {

    }
    public int countAdjacentMines(int row, int col) {
        return 0;
    }
    public boolean checkWin() {
        return false;
    }
    public boolean checkLose() {
        return false;
    }
    public int getRows() {
        return board.length;
    }
    public int getCols() {
        return board[0].length;
    }
    public int getTotalMines() {
        int cnt = 0;
        for(int i = 0; i<board.length; ++i){
            for(int j = 0; j<board[0].length; ++j){
                if(board[i][j].getMineStatus()){
                    ++cnt;
                }
            }
        }
        return cnt;
    }
    public tile getCell(int row, int col){
        return board[row][col];
    }
    public String toString() {
        String str = "";
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                str += board[i][j].toString();
            }
            str += "\n";
        }
        return str;
    }

    public void printBoard(){
        for(int i = 0; i<board.length; ++i){
            for(int j = 0; j<board[0].length; ++j){
                if(board[i][j].getRevealed()){
                    if(board[i][j].getMineStatus()){
                        System.out.print("* ");
                    }
                    else{
                        System.out.print(board[i][j].getSurroundingAmount()+" ");
                    }
                }
                else if(board[i][j].getFlaggedStatus()){
                        System.out.print("F ");
                    }
                else{
                    System.out.print("# ");
                }
            }
            System.out.println();
        }
    }
}
