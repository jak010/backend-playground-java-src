package Chapter05;

// 130 page
public class CruiseControlv2 {

    static final double SPEED_ON_LIGHT_KMH = 1079242850;
    static final double SPEED_LIMIT = SPEED_ON_LIGHT_KMH;

    private double targetSpeedKmh;

    void setTargetSpeedKmh(double speedKmh) {
        if (speedKmh < 0 || speedKmh > SPEED_LIMIT) {
            throw new IllegalArgumentException();
        }
        targetSpeedKmh = speedKmh;
    }


}
