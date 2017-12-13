package IntermediateExercises.Garage;

public class Motorcycle extends Vehicle {

    private boolean sidecar;

    Motorcycle(String registration, String colour, boolean sidecar, int mileage) {

        super(registration,2, colour, mileage);
        this.sidecar = sidecar;

    }

    Motorcycle(String registration, String colour, boolean sidecar) {

        super(registration,2, colour);
        this.sidecar = sidecar;

    }

    @Override
    public int calculateBill() {

        return 40 + mileage/1000;

    }

}
