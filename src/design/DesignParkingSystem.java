package design;

/**
 *Design a parking system for a parking lot. The parking lot has three kinds of parking spaces: big, medium, and small,
 * with a fixed number of slots for each size.
 *
 * Implement the ParkingSystem class:
 *
 * ParkingSystem(int big, int medium, int small) Initializes object of the ParkingSystem class.
 * The number of slots for each parking space are given as part of the constructor.
 * bool addCar(int carType) Checks whether there is a parking space of carType for the car that wants to get into the parking lot.
 * carType can be of three kinds: big, medium, or small, which are represented by 1, 2, and 3 respectively.
 * A car can only park in a parking space of its carType.
 * If there is no space available, return false, else park the car in that size space and return true.
 * Input
 * ["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
 * [[1, 1, 0], [1], [2], [3], [1]]
 * Output
 * [null, true, true, false, false]
 *
 * Explanation
 * ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
 * parkingSystem.addCar(1); // return true because there is 1 available slot for a big car
 * parkingSystem.addCar(2); // return true because there is 1 available slot for a medium car
 * parkingSystem.addCar(3); // return false because there is no available slot for a small car
 * parkingSystem.addCar(1); // return false because there is no available slot for a big car. It is already occupied.
 */
public class DesignParkingSystem {

    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        System.out.println(parkingSystem.addCar(1)); // return true because there is 1 available slot for a big car
        System.out.println(parkingSystem.addCar(2)); // return true because there is 1 available slot for a medium car
        System.out.println(parkingSystem.addCar(3)); // return false because there is no available slot for a small car
        System.out.println(parkingSystem.addCar(1)); // return false because there is no available slot for a big car. // It is already occupied.
    }
}

class ParkingSystem {

    int[] parkingPlace;
    public ParkingSystem(int big, int medium, int small) {
        parkingPlace = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {

        // -1 as index is from 0
        int availParkingSpace = parkingPlace[carType-1];
        System.out.println(availParkingSpace);
        if(availParkingSpace > 0) {
            parkingPlace[carType-1]--;
            return true;
        } else {
            return false;
        }
    }
}