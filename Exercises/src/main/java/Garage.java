import java.util.ArrayList;

public class Garage {

    private ArrayList<Vehicle> garage;

    Garage() {

        garage = new ArrayList<Vehicle>();

    }

    public void addVehicle(Vehicle newVehicle) {
        garage.add(newVehicle);
    }

    public Vehicle findVehicleByReg(String vehicleReg) {

        for (Vehicle v : garage) {
            if (v.getRegistration().equals(vehicleReg)) {
                return v;
            }
        }

        return null;

    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) {

        vehicleType = vehicleType.toLowerCase();

        ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();

        for (Vehicle v : garage) {
            if(getVehicleType(v).toLowerCase().equals(vehicleType)) {
                vehicleList.add(v);
            }
        }

        return vehicleList;
    }

    public String getVehicleType(String vehicleReg) {

        Vehicle v = findVehicleByReg(vehicleReg);
        return getVehicleType(v);

    }

    public String getVehicleType(Vehicle v) {

        String vehicleType = "";

        if (v != null) {
            Class vClass = v.getClass();
            vehicleType = vClass.getSimpleName().toLowerCase();
        }

        return vehicleType;

    }

    public void removeVehicleByReg(String vehicleReg) {

       Vehicle v = findVehicleByReg(vehicleReg);

       if (v != null) {
           garage.remove(v);
       }

    }

    public void removeVehicleByType(String vehicleType) {

        garage.removeAll(getVehiclesByType(vehicleType));

    }

    public int fixVehicle(String vehicleReg) {

        Vehicle v = findVehicleByReg(vehicleReg);

        return v.calculateBill();

    }

    public int[] calculateBillAll() {

        int[] vehicleBills = new int[garage.size()];
        int count = 0;

        for (Vehicle v : garage) {
            vehicleBills[count] = v.calculateBill();
            count++;
        }

        return vehicleBills;

    }

    public void emptyGarage(){
        garage.clear();
    }

}
