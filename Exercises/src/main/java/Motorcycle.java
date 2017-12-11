public class Motorcycle extends Vehicle {

    private boolean sidecar;

    Motorcycle(int id, String colour, boolean sidecar) {

        super("motorcycle", id,2, colour);
        this.sidecar = sidecar;

    }

    @Override
    public int calculateBill() {

        return 40+ mileage/1000;

    }

}
