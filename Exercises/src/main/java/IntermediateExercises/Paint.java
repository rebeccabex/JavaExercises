package IntermediateExercises;

public class Paint{

    private String name;
    private int capacity;
    private int price;
    private int coverage;

    Paint(String name, int capacity, int price, int coverage) {

        this.name = name;
        this.capacity = capacity;
        this.price = price;
        this.coverage = coverage;

    }

    public String getName() {
        return name;
    }

    public int coveragePerTin() {
        return coverage * capacity;
    }

    public int tinsToBuy(int area) {

        int tins = area / coveragePerTin();

        if (area % coveragePerTin() != 0) {
            tins++;
        }

        return tins;

    }

    public int costToPaint(int area) {

        return price * tinsToBuy(area);

    }

    public int wastedPaint(int area) {

        return coveragePerTin() * tinsToBuy(area) - area;

    }

    public String getReceipt(int area) {

        int tins = tinsToBuy(area);
        int cost = costToPaint(area);
        int waste = wastedPaint(area);

        String receipt = "Brand: " + name;
        receipt += "\nCapacity: " + capacity;
        receipt += "\nPrice per tin: £" + (price / 100) + "." + (price % 100);
        receipt += "\nNumber of tins: " + tins;
        receipt += "\nTotal cost: £" + (cost / 100) + "." + (cost % 100);
        receipt += "\nWaste: " + waste;

        return receipt;

    }

}
