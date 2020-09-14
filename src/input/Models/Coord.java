package input.Models;

import java.util.Objects;

public class Coord {

    private int x;
    private int y;

    public Coord() {
    }

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setEmpty(){
        this.setX(0);
        this.setY(0);
    }

    public void setEquals(Coord c){
        this.setX(c.getX());
        this.setY(c.getY());
    }

    public Coord up (){
        return (new Coord(this.x, this.y+1));
    }

    public Coord down (){
        return (new Coord(this.x, this.y-1));
    }

    public Coord left (){
        return (new Coord(this.x-1, this.y));
    }

    public Coord right(){
        return (new Coord(this.x+1, this.y));
    }

    @Override
    public String toString() {
        return "Coord{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        Coord coord = (Coord) o;
        return this.getX() == coord.getX() &&
                this.getY() == coord.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}

