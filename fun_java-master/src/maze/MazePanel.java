package maze;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static maze.Values.*;

public class MazePanel extends JPanel {

    private final int timerPause = 0;

    Cell[][] maze;
    ArrayList<Cell> path;
    Queue<Cell> queue;

    Cell start;
    Cell end;

    boolean isDone = false;


    MazePanel(Cell[][] maze) {
        this.maze = maze;
        path = new ArrayList<>();
        queue = new LinkedList<>();

        start = new Cell(startRow, startColumn, CellType.START);
        end = new Cell(endRow, endColumn, CellType.END);
        queue.add(start);

        Timer timer = new Timer(timerPause, e -> {
            (getParent()).repaint();
        });

        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics = (Graphics2D) g;


        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                Color cellColor;

                switch (maze[row][column].cellType) {
                    case START -> cellColor = START_COLOR;
                    case END -> cellColor = END_COLOR;
                    case WALL -> cellColor = WALL_COLOR;
                    default -> cellColor = SPACE_COLOR;
                }

                drawCell(row, column, cellColor, graphics);

            }
        }

        if (isDone) drawPath(graphics);

        if (!isDone && !queue.isEmpty()) nextStep();

        drawCell(start.row, start.column, START_COLOR, graphics);
        drawCell(end.row, end.column, END_COLOR, graphics);

    }


    private void drawCell(int row, int column, Color color, Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRect(column * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
    }

    private void drawPath(Graphics graphics) {
        for (Cell cell : path) {
            drawCell(cell.row, cell.column, PATH_COLOR, graphics);
        }
    }

    private void nextStep() {
        Cell current = queue.poll();
//        System.out.println(queue.size());//////////////////////////////////////////////////////////
        if (current != null) {
            ArrayList<Cell> neighbours = getNeighbours(current);
            for (Cell neighbour : neighbours) {
//                System.out.println(neighbour.column + " " + neighbour.row);////////////////////////////////
                if (neighbour.cellType == CellType.END) {
                    neighbour.previous = current;
                    isDone = true;
                    System.out.println("DONE!!!!!!");///////////////////////////////////////////////
                    getPath();

                    return;
                }
                if (neighbour.d == -1) {
                    maze[neighbour.row][neighbour.column].d = current.d + 1;
                    queue.add(neighbour);
                    neighbour.previous = current;
                }
            }
        }

        if (queue.isEmpty()) System.out.println("No way");

    }

    private ArrayList<Cell> getNeighbours(Cell current) {
        ArrayList<Cell> neighbours = new ArrayList<>();
        Cell neighbour;
        if (current.cellType != CellType.WALL && current.column > 0) {
            neighbour = maze[current.row][current.column - 1];
            if (neighbour.d == -1) neighbours.add(neighbour);
        }
        if (current.cellType != CellType.WALL && current.column < COLUMNS - 1) {
            neighbour = maze[current.row][current.column + 1];
            if (neighbour.d == -1) neighbours.add(neighbour);
        }
        if (current.cellType != CellType.WALL && current.row > 0) {
            neighbour = maze[current.row - 1][current.column];
            if (neighbour.d == -1) neighbours.add(neighbour);
        }
        if (current.cellType != CellType.WALL && current.row < ROWS - 1) {
            neighbour = maze[current.row + 1][current.column];
            if (neighbour.d == -1) neighbours.add(neighbour);
        }
        return neighbours;
    }

    private void getPath() {
        Cell current = maze[end.row][end.column];
        do {
            path.add(0, current);
            current = current.previous;
//            System.out.println(current.column + " " + current.row);//////////////////////////////////////
        } while (current != null);
//        System.out.println(path.size());//////////////////////////////////////////////
    }

}
