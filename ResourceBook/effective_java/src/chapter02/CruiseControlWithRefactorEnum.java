package chapter02;

import java.util.Objects;

/**
 * 자바코딩의기술(60p)
 */
public class CruiseControlWithRefactorEnum {

    private double targetSpeedKmh;

    void setPreset(SpeedPreset speedPreset) {
        Objects.requireNonNull(speedPreset);
        setTargetSpeedKmh(speedPreset.speedKmh);
    }

    void setTargetSpeedKmh(double speedKmh) {
        targetSpeedKmh = speedKmh;
    }


}

enum SpeedPreset {
    STOP(0), PLANETARY_SPEED(7667), CRUISE_SPEED(16944);

    final double speedKmh;

    SpeedPreset(double speedKmh) {
        this.speedKmh = speedKmh;
    }
}