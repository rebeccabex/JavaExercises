package IntermediateExercises.Garage;

public class Car extends Vehicle {

    private int doors;

    Car(String registration, String colour, int doors, int mileage, int wheels) {

        super(registration, wheels, colour, mileage);
        this.doors = doors;

    }

    Car(String registration, String colour, int doors, int mileage) {

        this(registration, colour, doors, mileage, 4);

    }

    Car(String registration, String colour, int doors) {

        this(registration, colour, doors, 10000);

    }

    @Override
    public int calculateBill() {

        return 50 + mileage/1000;

    }

}
