package assignment;

public class VehicleDemo {
    public static void main(String[] args) {
        Truck truck = new Truck("Volvo Truck", "Blue", 6, "FH16");
        Bus bus = new Bus("Tata Bus", "Yellow", 4, "Starbus");
        PassengerCar car = new PassengerCar("Honda City", "White", 4, "ZX 2023");

        System.out.println("=== Truck ===");
        truck.displayDetails();
        truck.start();
        truck.loadGoods();
        truck.fuelType();
        truck.stop();

        System.out.println("\n=== Bus ===");
        bus.displayDetails();
        bus.start();
        bus.pickPassengers();
        bus.fuelType();
        bus.stop();

        System.out.println("\n=== Car ===");
        car.displayDetails();
        car.start();
        car.playMusic();
        car.fuelType();
        car.stop();
    }
}

class Vehicle {
    protected String brand;
    protected String color;
    protected int noOfWheels;
    protected String model;

    public Vehicle(String brand, String color, int noOfWheels, String model) {
        this.brand = brand;
        this.color = color;
        this.noOfWheels = noOfWheels;
        this.model = model;
    }

    public void start() {
        System.out.println(brand + " is starting...");
    }

    public void stop() {
        System.out.println(brand + " is stopping...");
    }

    public void fuelType() {
        System.out.println(brand + " uses fuel.");
    }

    public void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Color: " + color);
        System.out.println("Wheels: " + noOfWheels);
        System.out.println("Model: " + model);
    }
}


class Truck extends Vehicle {
    public Truck(String brand, String color, int noOfWheels, String model) {
        super(brand, color, noOfWheels, model);
    }

    public void loadGoods() {
        System.out.println(brand + " is loading goods.");
    }

    @Override
    public void fuelType() {
        System.out.println(brand + " runs on diesel.");
    }
}

class Bus extends Vehicle {
    public Bus(String brand, String color, int noOfWheels, String model) {
        super(brand, color, noOfWheels, model);
    }

    public void pickPassengers() {
        System.out.println(brand + " is picking up passengers.");
    }

    @Override
    public void fuelType() {
        System.out.println(brand + " runs on CNG.");
    }
}


class PassengerCar extends Vehicle {
    public PassengerCar(String brand, String color, int noOfWheels, String model) {
        super(brand, color, noOfWheels, model);
    }

    public void playMusic() {
        System.out.println(brand + " is playing music.");
    }

    @Override
    public void fuelType() {
        System.out.println(brand + " runs on petrol.");
    }
}


/*
 * === Truck ===
Brand: Volvo Truck
Color: Blue
Wheels: 6
Model: FH16
Volvo Truck is starting...
Volvo Truck is loading goods.
Volvo Truck runs on diesel.
Volvo Truck is stopping...

=== Bus ===
Brand: Tata Bus
Color: Yellow
Wheels: 4
Model: Starbus
Tata Bus is starting...
Tata Bus is picking up passengers.
Tata Bus runs on CNG.
Tata Bus is stopping...

=== Car ===
Brand: Honda City
Color: White
Wheels: 4
Model: ZX 2023
Honda City is starting...
Honda City is playing music.
Honda City runs on petrol.
Honda City is stopping...
*/



