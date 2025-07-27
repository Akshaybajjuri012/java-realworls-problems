package abstractdemo;


abstract class Vehicle {
 
 abstract void startEngine();
 abstract void stopEngine();
}


class Car extends Vehicle {
 @Override
 void startEngine() {
     System.out.println("Car engine started.");
 }

 @Override
 void stopEngine() {
     System.out.println("Car engine stopped.");
 }
}


class Motorcycle extends Vehicle {
 @Override
 void startEngine() {
     System.out.println("Motorcycle engine started.");
 }

 @Override
 void stopEngine() {
     System.out.println("Motorcycle engine stopped.");
 }
}


public class VehicleTest {
 public static void main(String[] args) {
     Vehicle myCar = new Car();
     myCar.startEngine();
     myCar.stopEngine();

     Vehicle myMotorcycle = new Motorcycle();
     myMotorcycle.startEngine();
     myMotorcycle.stopEngine();
 }
}


/*
Car engine started.
Car engine stopped.
Motorcycle engine started.
Motorcycle engine stopped.
*/
