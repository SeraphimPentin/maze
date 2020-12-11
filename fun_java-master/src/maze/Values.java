package maze;

import java.awt.*;

public class Values {
    final static int CELL_SIZE = 10;
    final static int ROWS = 40;
    final static int COLUMNS = 60;

    final static int startRow = 0;
    final static int startColumn = 0;
    static int endRow = ROWS - 1;
    final static int endColumn = COLUMNS - 1;

    final static Color WALL_COLOR = Color.black;
    final static Color SPACE_COLOR = Color.white;
    final static Color START_COLOR = new Color(144, 216, 168);//Color(216, 216, 120);
    final static Color PLAYER_PATH_COLOR = new Color(213, 213, 107);//new Color(144, 216, 168);
    final static Color END_COLOR = new Color(255, 120, 96);//Color(24, 144, 168);
    final static Color PATH_COLOR = new Color(96, 122, 255);
//    final static Color OPEN_SET_COLOR = new Color(0, 0, 0, 49);
//    final static Color CLOSED_SET_COLOR = new Color(0, 0, 0, 22);
//    final static Color MONSTER_COLOR = new Color(255, 120, 96);
//    final static Color MONSTER_PATH_COLOR = new Color(255, 120, 96, 143);


}
