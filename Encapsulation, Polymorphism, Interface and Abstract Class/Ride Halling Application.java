interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public String getVehicleDetails() {
        return driverName + " driving " + vehicleId + " @ ₹" + ratePerKm + "/km";
    }

    public double getRatePerKm() {
        return ratePerKm;
    }
}

class Car extends Vehicle implements GPS {
    private String location;

    public Car(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 50;
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String location) {
        this.location = location;
    }
}

class Bike extends Vehicle implements GPS {
    private String location;

    public Bike(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String location) {
        this.location = location;
    }
}

class Auto extends Vehicle implements GPS {
    private String location;

    public Auto(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 20;
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String location) {
        this.location = location;
    }
}

public class RideHailingDemo {
    public static void main(String[] args) {
        Vehicle[] rides = {
            new Car("CAR123", "Abhishek", 15),
            new Bike("BIKE456", "Ravi", 10),
            new Auto("AUTO789", "Kiran", 12)
        };

        for (Vehicle v : rides) {
            ((GPS) v).updateLocation("Sector 21");
            System.out.println(v.getVehicleDetails());
            System.out.println("Fare for 10 km: ₹" + v.calculateFare(10));
            System.out.println("Current Location: " + ((GPS) v).getCurrentLocation());
            System.out.println();
        }
    }
}
