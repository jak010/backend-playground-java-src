package chapter02;

import sun.print.CUPSPrinter;

public class CruiseControlWithRefactor {

    static final int STOP_PRESET = 0;
    static final int PLANETART_SPEED_PRESET = 1;
    static final int CRUISE_SPEED_PRESET = 2;

    static final double CRUISE_SPEED_KMH = 16944;
    static final double PLANETARY_SPEED_KMH = 7667;
    static final double STOP_SPEED_KMH = 0;

    private double targetSpeedKmh;

    void setStopPreset(int speedPreset) {
        if (speedPreset == CRUISE_SPEED_PRESET) {
            setTargetSpeedKmh(CRUISE_SPEED_PRESET);
        } else if (speedPreset == PLANETART_SPEED_PRESET) {
            setTargetSpeedKmh(PLANETARY_SPEED_KMH);
        } else if (speedPreset == STOP_PRESET) {
            setTargetSpeedKmh(STOP_SPEED_KMH);
        }
    }

    void setTargetSpeedKmh(double speed) {
        targetSpeedKmh = speed;
    }

}
