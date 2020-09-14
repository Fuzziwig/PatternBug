package input.Models;

public class Route {

    Coord start;
    Coord stop;

    public Route() {
    }

    public Route(Coord start, Coord stop) {
        this.start = start;
        this.stop = stop;
    }

    public Coord getStart() {
        return start;
    }

    public void setStart(Coord start) {
        this.start.setX(start.getX());
        this.start.setY(start.getY());
    }

    public Coord getStop() {
        return stop;
    }

    public void setStop(Coord stop) {
        this.stop.setX(stop.getX());
        this.stop.setY(stop.getY());
    }

    @Override
    public String toString() {
        return "Move{" +
                "start=" + start +
                ", stop=" + stop +
                '}';
    }


}

//
//    private List<Route<Locale>> locales = new ArrayList<Route<Locale>>();
//    private Route<Locale> prevdest = null;
//    private Locale feature;
//
//    public Route(Locale feature){
//        this.feature = feature;
//    }
//
//    public Route(Locale feature, Route<Locale> prevdest) {
//        this.prevdest = prevdest;
//        this.feature = feature;
//    }


