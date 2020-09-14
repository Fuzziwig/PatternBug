package input.Strategies;

import input.Models.Coord;
import input.Models.Maze;
import input.Models.Route;

import java.util.Stack;

public abstract class Strategy {

    protected enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    protected Direction[] directionPriority = {Direction.RIGHT, Direction.DOWN, Direction.UP, Direction.LEFT};
    protected int steps = 0;
    protected Stack<Route> routestack = new Stack<Route>();
    protected Maze maze;

    public Strategy(Maze maze) {
        this.maze = maze;
    }

    public void init() {
        //current location
        Coord curloc = maze.getLocation();
        //route headed to the void till we find a proper route
        Route route = new Route(new Coord(curloc.getX(), curloc.getY()), new Coord(0,0));
        Coord empty = new Coord(0,0);
        Coord stop= new Coord(0,0);
        Coord dest = new Coord(0,0);
        routestack.push(route);
        System.out.println("current location" + curloc);
        maze.printMap(curloc);
        System.out.println();
        System.out.println();
//        System.out.println(routestack.peek().toString());
        //time counter
        long start =System.currentTimeMillis();
        //keep trying till we get to the goal
        while (!curloc.equals(maze.getEndLocation())){

        //test what directions are possible with priority depending on strategy
            for (int d = 0; d<directionPriority.length;d++){
                if (!stop.equals(empty)){ break; }
                switch(directionPriority[d]){
                    case UP:
                        dest = curloc.up();
//                        System.out.println("going up?");
//                        System.out.println("curloc "+ curloc.toString());
//                        System.out.println("stop "+stop.toString());
//                        System.out.println("prev route start"+routestack.peek().getStart().toString());
//                        System.out.println("prev route stop"+routestack.peek().getStop().toString());
//                        System.out.println("full route "+routestack.peek().toString());
//                        System.out.println("checking dest "+dest.toString());
                        if (maze.canMove(curloc, dest) && !routestack.peek().getStart().equals(dest)){
                            stop.setEquals(dest);
                        }
                        break;
                    case DOWN:
                        dest = curloc.down();
//                        System.out.println("going down?");
//                        System.out.println("curloc "+ curloc.toString());
//                        System.out.println("stop "+stop.toString());
//                        System.out.println("prev route start"+routestack.peek().getStart().toString());
//                        System.out.println("prev route stop"+routestack.peek().getStop().toString());
//                        System.out.println("full route "+routestack.peek().toString());
//                        System.out.println("checking dest "+dest.toString());
                        if (maze.canMove(curloc, dest) && !routestack.peek().getStart().equals(dest)){
                            stop.setEquals(dest);
                        }
                        break;
                    case LEFT:
                        dest = curloc.left();
//                        System.out.println("going left?");
//                        System.out.println("curloc "+ curloc.toString());
//                        System.out.println("stop "+stop.toString());
//                        System.out.println("prev route start"+routestack.peek().getStart().toString());
//                        System.out.println("prev route stop"+routestack.peek().getStop().toString());
//                        System.out.println("full route "+routestack.peek().toString());
//                        System.out.println("checking dest "+dest.toString());
                        if (maze.canMove(curloc, dest) && !routestack.peek().getStart().equals(dest)){
                            stop.setEquals(dest);
                        }
                        break;
                    case RIGHT:
                        dest = curloc.right();
//                        System.out.println("going right?");
//                        System.out.println("curloc "+ curloc.toString());
//                        System.out.println("stop "+stop.toString());
//                        System.out.println("prev route start"+routestack.peek().getStart().toString());
//                        System.out.println("prev route stop"+routestack.peek().getStop().toString());
//                        System.out.println("full route "+routestack.peek().toString());
//                        System.out.println("checking dest "+dest.toString());
                        if (maze.canMove(curloc, dest) && !routestack.peek().getStart().equals(dest)){
                            stop.setEquals(dest);
                        }
                        break;
                }
            }
            if (stop.getX()==0 && stop.getX()==0) {
                System.out.println("dead end time to switch tactics");
                Direction tmp = directionPriority[0];
                directionPriority[0]=directionPriority[3];
                directionPriority[3]=tmp;
                routestack.pop();
            }
            else {
//                System.out.println("we found a place to go "+stop.toString());
                this.steps++;
                route = new Route(new Coord(curloc.getX(), curloc.getY()), new Coord(stop.getX(), stop.getY()));
                //route.setStart(curloc);
//                System.out.println(curloc.toString());
                //route.setStop(stop);
//                System.out.println("curloc "+curloc.toString());
//                System.out.println("stop "+stop.toString());
//                System.out.println("new route "+route.toString());
                routestack.push(route);
//                System.out.println("peeked route"+routestack.peek().toString());
                maze.setLocation(stop);
                curloc.setEquals(stop);
                stop.setEmpty();
                System.out.println("step "+steps);
                maze.printMap(curloc);
                System.out.println();
                System.out.println();
            }

        }
        long finish =System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Route taken : ");
        routestack.forEach(System.out::println);
        System.out.println("maze completed with "+ steps+" steps");
        System.out.println("time measured to be "+timeElapsed+" ms");
    }
}
