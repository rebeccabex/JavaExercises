package IntermediateExercises;

import java.util.ArrayList;

public class PaintWizard {

    private ArrayList<Paint> paintList;

    public PaintWizard() {

         paintList = new ArrayList<Paint>();

        Paint cheapoMax = new Paint("CheapoMax", 20, 1999, 10);
        Paint averageJoes = new Paint("AverageJoes", 15, 1799, 11);
        Paint duluxourousPaints = new Paint("DuluxourousPaints", 10, 2500, 20);

        paintList.add(cheapoMax);
        paintList.add(averageJoes);
        paintList.add(duluxourousPaints);

    }

    public Paint cheapestPaint(int roomSize) {

        int lowestCost = -1;
        Paint bestValue = null;

        for(Paint p : paintList) {
            int cost = p.costToPaint(roomSize);
            if (lowestCost < 0 || cost < lowestCost) {
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
