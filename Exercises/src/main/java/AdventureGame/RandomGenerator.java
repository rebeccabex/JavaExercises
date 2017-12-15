package AdventureGame;

import java.util.Random;

public class RandomGenerator {

    private Random randGen;

    public RandomGenerator() {
        randGen = new Random();
    }

    // inclusive of min, exclusive of max
    public int getRandomInt(int max, int min) {
        return randGen.nextInt(max) + min;
    }

    public int getRandomInt(int max) {
        return getRandomInt(max, 0);
    }

}
