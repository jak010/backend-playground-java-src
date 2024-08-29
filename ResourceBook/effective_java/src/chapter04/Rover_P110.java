package chapter04;

public class Rover_P110 {

    static final double WalkingSpeed = 3;

    final String serialNumber;
    double milesPerHour;

    Rover_P110(String newSerialiNumber) {
        this.serialNumber = newSerialiNumber;
    }

    void drive() {
        milesPerHour = WalkingSpeed;
    }

    void stop() {
        milesPerHour = 0;
    }

}
