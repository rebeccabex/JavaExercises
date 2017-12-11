public class Paint{

    private String name;
    private int capacity;
    private double price;
    private int coverage;

    Paint(String name, int capacity, double price, int coverage) {

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

    public double costToPaint(int area) {

        return price * tinsToBuy(area);

    }

    public int wastedPaint(int area) {

        return coveragePerTin() * tinsToBuy(area) - area;

    }

    public String getReceipt(int area) {

        int tins = tinsToBuy(area);
        double cost = costToPaint(area);
        int waste = wastedPaint(area);

        String receipt = "Brand: " + name;
        receipt += "\nCapacity: " + capacity;
        receipt += "\nPrice per tin: " + price;
        receipt += "\nNumber of tins: " + tins;
        receipt += "\nTotal cost: " + cost;
        receipt += "\nWaste: " + waste;

        return receipt;

    }

}
