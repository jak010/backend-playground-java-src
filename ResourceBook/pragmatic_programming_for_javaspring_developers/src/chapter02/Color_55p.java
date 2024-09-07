package chapter02;

public class Color_55p {

    public final int r;
    public final int g;
    public final int b;

    public Color_55p(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public String toHex() {
        return String.format("#%02x%02x%02x", r, g, b);
    }

}
