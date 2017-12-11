public class Car extends Vehicle {

    private int doors;

    Car(int id, String colour, int doors) {

        super("car", id,4, colour);
        this.doors = doors;

    }

    @Override
    public int calculateBill() {

        return 50+ mileage/1000;

    }

}
