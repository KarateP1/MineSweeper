
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
            Scanner s = new Scanner(new File("minesweepExample.txt"));
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
        assertEquals("Test Total Mines is Correct", ms.getTotalMines(), 4);
    }

    @Test
    public void testMinesAround() {
        assertEquals("Test Total Mines Around 2 2", ms.countAdjacentMines(2, 2), 2);
    }

    @Test
    public void testRevealEmptyCell() {
        assertEquals("Test RevealTile: 0", ms.revealCell(0,3), 0);
    }

    @Test
    public void testRevealAdjactentMinesCell() {
        assertEquals("Test RevealTile: 0", ms.revealCell(0,0), 1);
    }



}