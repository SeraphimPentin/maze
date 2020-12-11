package maze;

import java.util.Random;

public class Cell {

    CellType cellType;
    int d = -1;

//    Cell[] neighbours;
    Cell previous = null;

    int row;
    int column;

    Cell(int row, int column, CellType cellType) {
        this.row = row;
        this.column = column;
        this.cellType = cellType;

        if (cellType == CellType.START) d = 0;
    }


}

enum CellType {
    WALL,
    SPACE,
    START,
    END
}
