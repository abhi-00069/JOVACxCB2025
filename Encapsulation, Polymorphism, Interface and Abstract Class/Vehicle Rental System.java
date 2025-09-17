interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public abstract double calculateRentalCost(int days);

    public String getDetails() {
        return type + " (" + vehicleNumber + ") - ₹" + rentalRate + "/day";
    }

    public double getRentalRate() {
        return rentalRate;
    }
}

class Car extends Vehicle implements Insurable {
    public Car(String number, double rate) {
        super(number, "Car", rate);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return 1500;
    }

    public String getInsuranceDetails() {
        return "Car Insurance: ₹1500";
    }
}

class Bike extends Vehicle implements Insurable {
    public Bike(String number, double rate) {
        super(number, "Bike", rate);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return 500;
    }

    public String getInsuranceDetails() {
        return "Bike Insurance: ₹500";
    }
}

class Truck extends Vehicle implements Insurable {
    public Truck(String number, double rate) {
        super(number, "Truck", rate);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 1000; 
    }

    public double calculateInsurance() {
        return 2500;
    }

    public String getInsuranceDetails() {
        return "Truck Insurance: ₹2500";
    }
}

public class VehicleRentalDemo {
    public static void main(String[] args) {
        Vehicle[] fleet = {
            new Car("CAR123", 1500),
            new Bike("BIKE456", 500),
            new Truck("TRUCK789", 3000)
        };

        for (Vehicle v : fleet) {
            System.out.println(v.getDetails());
            System.out.println("Rental for 3 days: ₹" + v.calculateRentalCost(3));
            System.out.println(((Insurable) v).getInsuranceDetails());
            System.out.println("Insurance Cost: ₹" + ((Insurable) v).calculateInsurance());
            System.out.println();
        }
    }
}
