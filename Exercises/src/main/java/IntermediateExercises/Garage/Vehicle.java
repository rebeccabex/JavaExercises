package IntermediateExercises.Garage;

public abstract class Vehicle {

    protected String registration;
    protected int wheels;
    protected String colour;

    protected int mileage;
    protected int repairCost;

    Vehicle(String registration, int wheels, String colour, int mileage) {

        this.registration = registration;
        this.wheels = wheels;
        this.colour = colour;

        this.mileage = mileage;
        repairCost = 0;

    }

    Vehicle(String registration, int wheels, String colour) {

        this(registration, wheels, colour, 10000);

    }

    public String getRegistration() {
        return registration;
    }

    public int getMileage() {
        return mileage;
    }

    public void setRepairCost(int repairCost) {
        this.repairCost = repairCost;
    }

    public abstract int calculateBill();


}
