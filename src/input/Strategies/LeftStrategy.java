package input.Strategies;

import input.Models.Coord;
import input.Models.Maze;

public class LeftStrategy extends Strategy {

    protected Direction[] directionPriority = {Direction.LEFT, Direction.UP, Direction.DOWN,  Direction.RIGHT};

    public LeftStrategy(Maze maze) {
        super(maze);
        System.out.print("__         ______     ______   ______  \n");
        System.out.print("/\\ \\       /\\  ___\\   /\\  ___\\ /\\__  _\\\n");
        System.out.print("\\ \\ \\____  \\ \\  __\\   \\ \\  __\\ \\/_/\\ \\/\n");
        System.out.print(" \\ \\_____\\  \\ \\_____\\  \\ \\_\\      \\ \\_\\\n");
        System.out.print("  \\/_____/   \\/_____/   \\/_/       \\/_/\n");

    }

}
