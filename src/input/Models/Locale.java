package input.Models;

public class Locale {

    private boolean top;
    private boolean bottom;
    private boolean right;
    private boolean left;

    public Locale() {
    }

    public Locale(boolean top, boolean bottom, boolean right, boolean left) {
        this.top = top;
        this.bottom = bottom;
        this.right = right;
        this.left = left;
    }

    public boolean isTop() {
        return top;
    }

    public void setTop(boolean top) {
        this.top = top;
    }

    public boolean isBottom() {
        return bottom;
    }

    public void setBottom(boolean bottom) {
        this.bottom = bottom;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    @Override
    public String toString() {
        return
                "Locale{" +
                "top=" + top +
                ", bottom=" + bottom +
                ", right=" + right +
                ", left=" + left +
                '}';
    }
}
