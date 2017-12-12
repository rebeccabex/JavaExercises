public class Van extends Vehicle {

    private int capacity;

    Van(String registration, String colour, int capacity, int mileage) {

        super(registration,4, colour);
        this.capacity = capacity;

    }

    Van(String registration, String colour, int capacity) {

        super(registration,4, colour);
        this.capacity = capacity;

    }

    @Override
    public int calculateBill() {

        return 60 + mileage/1000;

    }

}
