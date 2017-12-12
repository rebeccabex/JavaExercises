public class UniqueSum {

    public int calculateUniqueSum(int x, int y, int z) {

        int sum = 0;

        if (x != y) {
            if (x != z) {
                sum += x;
                if (y != z) {
                    sum += y;
                    sum += z;
                }
            } else if (y != z) {
                sum += y;
            }
        } else if (y != z) {
            sum += z;
        }

        return sum;
    }
}
