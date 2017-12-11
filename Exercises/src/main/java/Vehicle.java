public class Vehicle {

    protected String vehicleType;
    protected int id;
    protected int wheels;
    protected String colour;

    protected int mileage;
    protected int repairCost;

    Vehicle(String vehicleType, int id, int wheels, String colour) {

        this.vehicleType = vehicleType;
        this.id = id;
        this.wheels = wheels;
        this.colour = colour;

        mileage = 10000;
        repairCost = 0;

    }

    public String getVehicleType() {
        return vehicleType;
    }

    public int getId() {
        return id;
    }

    public int getMileage() {
        return mileage;
    }

    public void setRepairCost(int repairCost) {
        this.repairCost = repairCost;
    }

    public int calculateBill() {

        return mileage/1000;

    }


}
