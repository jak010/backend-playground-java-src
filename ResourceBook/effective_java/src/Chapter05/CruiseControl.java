package Chapter05;

// 129page
public class CruiseControl {
    static final double SPEED_ON_LIGHT_KMH = 1079242850;
    static final double SPEED_LIMIT = SPEED_ON_LIGHT_KMH;

    private double targetSpeedKmh;

    void setTargetSpeedKmh(double speedKmh) {
        if (speedKmh < 0) {
            throw new IllegalArgumentException();
        } else if (speedKmh <= SPEED_LIMIT) {
            targetSpeedKmh = speedKmh;
        } else {
            throw new IllegalArgumentException();
        }
    }

}
