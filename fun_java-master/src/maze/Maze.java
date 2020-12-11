package maze;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static maze.Values.*;

public class Maze {

    static Cell[][] maze;

    public static void main(String[] args) {
        maze = new Cell[ROWS][COLUMNS];

        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                CellType cellType;
                if (row == startRow && column == startColumn) {
                    cellType = CellType.START;

                } else if (row == endRow && column == endColumn) {
                    cellType = CellType.END;
                } else {
                    float r = new Random().nextFloat();
                    if (r < 0.5) {
                        cellType = CellType.WALL;
                    } else {
                        cellType = CellType.SPACE;
                    }

                }
                maze[row][column] = new Cell(row, column, cellType);
            }
        }

        EventQueue.invokeLater(Maze::setupFrame);
    }

    private static void setupFrame() {
        JFrame frame = new JFrame("Maze");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MazePanel mazePanel = new MazePanel(maze);
        mazePanel.setPreferredSize(new Dimension(COLUMNS * CELL_SIZE, ROWS * CELL_SIZE));
        frame.getContentPane().add(mazePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}


