
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Scanner;
import java.io.File;
import org.junit.*;

public class minesweeperTest {

    private minesweeper ms;

    @Before
    public void setUp() {
        try {
            Scanner s = new Scanner(new File("src/minesweepExample.txt"));
            int rows = s.nextInt();
            int cols = s.nextInt();
            int[][] board = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    board[i][j] = s.nextInt();
                }
            }
            ms = new minesweeper(board);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void testBoardLength() {
        assertEquals("Test Board Length is 6", ms.getRows(), 6);
    }

    @Test
    public void testBoardWidth() {
        assertEquals("Test Board Width is 6", ms.getCols(), 6);
    }

    @Test
    public void testTotalMines() {
        assertEquals("Test Total Mines is Correct", 4, ms.getTotalMines());
    }

    @Test
    public void testCountingEdgeCell(){
        assertEquals("Test Mines around 0 2", 1, ms.countAdjacentMines(0, 2));
    }

    @Test
    public void testMinesAround() {
        assertEquals("Test Total Mines Around 2 2", ms.countAdjacentMines(2, 2), 2);
    }

    @Test
    public void testMinesAroundEmptyCell(){
        assertEquals("Test counting mines around 3 1", ms.countAdjacentMines(3, 1), 0);
    }

    @Test
    public void testRevealEmptyCell() {
        assertEquals("Test RevealTile: 0", ms.revealCell(0, 3), 0);
    }

    @Test
    public void testRevealAdjactentMinesCell() {
        assertEquals("Test RevealTile: 1 2", ms.revealCell(1, 2), 2);
    }

    @Test
    public void testCornerCell() {
        assertEquals("Test RevealTile: 0 0", ms.revealCell(0, 0), 1);
    }

    @Test
    public void testCellWithMine() {
        assertEquals("Test RevealTile: 1 1", ms.revealCell(1, 1), -1);
    }

    @Test
    public void testRevealCellAlreadyRevealed(){
         ms.revealCell(0, 0);
         String init = ms.toString();
         ms.revealCell(0, 0);
         String test = ms.toString();
         assertEquals("Test if Reaveling a cell twice doesn't change board", test, init);
    }

    @Test
    public void testFlaggingWorks(){
        ms.flagCell(0, 0);
        assertEquals("Test flagging flags", ms.getCell(0, 0).getFlaggedStatus(), true);
    }

    @Test
    public void testFlaggingUnreavealedCell(){
        ms.flagCell(0, 0);
        assertEquals("Test flagging unreavealed cell", ms.getCell(0, 0).getFlaggedStatus(), true);
    }

    @Test
    public void testUnflaggingCell(){
        ms.flagCell(0, 0);
        ms.flagCell(0, 0);
        assertEquals("Test unflagging cell", ms.getCell(0, 0).getFlaggedStatus(), false);
    }

    @Test
    public void testReavelingMineLose(){
        ms.revealCell(1, 1);
        assertEquals("Test if reavling mine losses game", ms.checkLose(), true);
    }
}