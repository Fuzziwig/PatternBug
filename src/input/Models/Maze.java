package input.Models;

public class Maze {

    Locale[][] m1;
    private int[][] horisontal;
    private int[][] vertical;
    private Coord Location = new Coord(0,0);
    private Coord endLocation = new Coord(0,0);
    private int boundryx = 0;
    private int boundryy = 0;
    //Factory Design Pattern
    //used to initiate objects based on info given
    public Maze(int[][] horisontal, int[][] vertical, Coord startLocation, Coord endLocation){
        int boundryx = horisontal[0][0]+1;
        int boundryy = vertical[0][0]+1;
        this.boundryx = boundryx;
        this.boundryy = boundryy;
        this.m1 = new Locale[boundryx][boundryy];
        this.endLocation = endLocation;
        this.Location = startLocation;
        this.horisontal=horisontal;
        this.vertical=vertical;

        for (int x = 1; x<horisontal[0][0]+1; x++){

            for (int y = 1; y<vertical[0][0]-1;y++) {
                m1[x][y] = new Locale();
                m1[x][y].setBottom(horisontal[y][x] == 0);
                m1[x][y].setTop(horisontal[y + 1][x] == 0);
                m1[x][y].setLeft(vertical[x][y] == 0);
                m1[x][y].setRight(vertical[x + 1][y] == 0);
            }
        }
    }

    public boolean canMove(Coord start, Coord stop){
        int startx = start.getX();
        int stopx = stop.getX();
        int starty = start.getY();
        int stopy = stop.getY();
        //check what direction player is going
        //right ?
        if (startx<stopx && stopx<=this.boundryx){
            return (m1[startx][starty].isRight() && m1[stopx][stopy].isLeft());
        }
        //left ?
        else if (startx>stopx && stopx>0) {
            return (m1[startx][starty].isLeft() && m1[stopx][stopy].isRight());
        }
        //up ?
        else if (starty<stopy && stopy<=this.boundryy) {
            return (m1[startx][starty].isTop() && m1[stopx][stopy].isBottom());
        }
        //down ?
        else if (starty>stopy && stopy>0) {
            return (m1[startx][starty].isBottom() && m1[stopx][stopy].isTop());
        }
        return false;
    }

    public void printMap(Coord loc) {
        int x = loc.getX();
        int y = loc.getY();
        int horlen = horisontal.length - 1;
        int verlen = vertical[1].length - 1;
        boolean printloc = false;
        while (verlen > 0 || horlen > 0) {
            if (horlen > 0) {
                for (int j = 1; j < horisontal[horlen].length; j++) {
                    switch (horisontal[horlen][j]) {
                        case 0:
                            System.out.print("    ");
                            break;
                        case 1:
                            System.out.print("----");
                            break;
                        default:
                            System.out.print(horisontal[horlen][j]);
                    }
                }
                System.out.println();
                horlen--;
            }
            if (verlen > 0) {
                for (int k = 1; k < vertical.length; k++) {
                    switch (vertical[k][verlen]) {
                        case 0:
                            if (y==verlen && k==x) {
                                System.out.print(" x  ");
                            }
                            else {
                                System.out.print("    ");
                            }
                            break;
                        case 1:
                            if (k==x && y==verlen) {
                                System.out.print("I x ");
                            }
                            else {
                                System.out.print("I   ");
                            }
                            break;
                        default:
                            System.out.print(horisontal[verlen][k]);
                    }
                }
                System.out.println();
                verlen--;
            }
        }
    }

    public void setBottomM1(Coord c, boolean state) {
        this.m1[c.getX()][c.getY()].setBottom(state);
    }

    public Coord getLocation() {
        return this.Location;
    }

    public void setLocation(Coord location) {
        this.Location = location;
    }

    public Coord getEndLocation() {
        return this.endLocation;
    }

    public void setEndLocation(Coord endLocation) {
        this.endLocation = endLocation;
    }

    public int getBoundryx() {
        return boundryx;
    }

    public int getBoundryy() {
        return boundryy;
    }
}
