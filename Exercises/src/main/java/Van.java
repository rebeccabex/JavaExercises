public class Van extends Vehicle {

    private int capacity;

    Van(int id, String colour, int capacity) {

        super("van", id,4, colour);
        this.capacity = capacity;

    }

    @Override
    public int calculateBill() {

        return 60 + mileage/1000;

    }

}
