import java.util.ArrayList;

public class PaintWizard {

    private ArrayList<Paint> paintList;

    public PaintWizard() {

         paintList = new ArrayList<Paint>();

        Paint cheapoMax = new Paint("CheapoMax", 20, 19.99, 10);
        Paint averageJoes = new Paint("AverageJoes", 15, 17.99, 11);
        Paint duluxourousPaints = new Paint("DuluxourousPaints", 10, 25, 20);

        paintList.add(cheapoMax);
        paintList.add(averageJoes);
        paintList.add(duluxourousPaints);

    }

    public Paint cheapestPaint(int roomSize) {

        double lowestCost = -1;
        Paint bestValue = null;

        for(Paint p : paintList) {
            double cost = p.costToPaint(roomSize);
            if (lowestCost == -1 || cost < lowestCost) {
                lowestCost = cost;
                bestValue = p;
            }
        }

        return bestValue;
    }

    public Paint leastWaste(int roomSize) {

        int lowestWaste = -1;
        Paint bestPaint = null;


        for(Paint p : paintList) {
            int waste = p.wastedPaint(roomSize);
            if (lowestWaste == -1 || waste < lowestWaste) {
                lowestWaste = waste;
                bestPaint = p;
            }
        }

        return bestPaint;

    }
}
