package IntermediateExercises;

public class Blackjack {

    public int compareHands(int x, int y) {

        if (x > 21) {
            if (y > 21) {
                return 0;
            } else {
                return y;
            }
        } else if (y > 21) {
            return x;
        } else if (x > y) {
            return x;
        } else {
            return y;
        }

    }

}
