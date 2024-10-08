package chapter06.example;

import java.util.Objects;

public class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Point point = (Point) o;
//        return x == point.x && y == point.y;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(x, y);
//    }

    public static void main(String[] args) {

        final Point p1 = new Point(1, 2);
        final Point p2 = new Point(1, 2);

        System.out.println(p1.equals(p2)); // false 출력
    }
}
