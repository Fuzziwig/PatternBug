package input;

import input.Models.Coord;
import input.Models.Maze;
import input.Players.BugPlayer;
import input.Strategies.VanillaStrategy;

public class Main {

    public static void main(String[] args) {

        //define the maze
        int[][] hor = { {6},
                {0,1,0,1,1,1,1},
                {1,0,1,1,0,0,0},
                {2,1,0,0,1,0,0},
                {3,0,0,1,0,1,0},
                {4,1,1,1,1,0,1},
                {5,1,1,0,1,1,1}
        };

        int[][] ver ={ {7},
                {0,1,1,1,1,1},
                {1,0,0,1,0,0},
                {2,0,1,1,1,0},
                {3,0,0,0,0,0},
                {4,1,1,0,1,0},
                {5,0,1,1,0,0},
                {6,1,1,1,1,1},
        };
        //define a player
        BugPlayer bp = new BugPlayer("Bugsy Malone");
        bp.setStrategy(new VanillaStrategy(new Maze(hor, ver, new Coord(2,1), new Coord(3,5))));
        bp.init();

    }

}
