package input.Strategies;

import input.Models.Maze;

public class VanillaStrategy extends Strategy{

    public VanillaStrategy(Maze maze) {
        super(maze);
        System.out.println("Vanilla strategy");
    }
}
