package chapter04;


public class Rover {

    static final double WalkingSpeed = 3;

    final String SerialNumber;
    double MilesPerHour;

    Rover(String newSerialiNumber) {
        SerialNumber = newSerialiNumber;
    }

    void Drive() {
        MilesPerHour = WalkingSpeed;
    }

    void Stop() {
        MilesPerHour = 0;
    }

}
