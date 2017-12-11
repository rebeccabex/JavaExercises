import java.util.ArrayList;

public class Garage {

    private ArrayList<Vehicle> garage;

    Garage() {

        garage = new ArrayList<Vehicle>();

    }

    public void addVehicle(Vehicle newVehicle) {
        garage.add(newVehicle);
    }

    public Vehicle findVehicleById(int vehicleId) {

        for (Vehicle v : garage) {
            if (v.getId() == vehicleId) {
                return v;
            }
        }

        System.out.println("Vehicle ID not found");
        return null;

    }

    public String getVehicleType(int vehicleId) {

        String vehicleType = "";

        Vehicle v = findVehicleById(vehicleId);
        if (v != null) {
            vehicleType = v.getVehicleType();
        }

        return vehicleType;

    }

    public void removeVehicleById(int vehicleId) {

       Vehicle v = findVehicleById(vehicleId);

       if (v != null) {
           garage.remove(v);
       }

    }

    public void removeVehicleByType(String vehicleType) {

        vehicleType = vehicleType.toLowerCase();

        ArrayList<Vehicle> removeList = new ArrayList<Vehicle>();

        for (Vehicle v : garage) {
            if (v.getVehicleType().equals(vehicleType)) {
                removeList.add(v);
            }
        }

        garage.removeAll(removeList);

    }

    public int fixVehicle(int vehicleId) {

        Vehicle v = findVehicleById(vehicleId);

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
