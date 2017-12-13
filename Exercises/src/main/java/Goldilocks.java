import java.util.ArrayList;

public class Goldilocks {

    public static void main(String[] args) {

        Goldilocks goldilocks = new Goldilocks();

        int[][] sample = {{100, 80}, {30, 50}, {130, 75}, {90, 60}, {150, 85}, {120, 70}, {200, 200}, {110, 100}};

        System.out.println(goldilocks.seatCheck(sample));

        int[][] challenge = {{100, 120}, {297, 90}, {66, 110}, {257, 113}, {276, 191},
                {280, 129},{219, 163}, {254, 193}, {86, 153}, {206, 147}, {71, 137},
                {104, 40}, {238, 127}, {52, 146}, {129, 197}, {144, 59}, {157, 124},
                {210, 59}, {11, 54}, {268, 119}, {261, 121}, {12, 189}, {186, 108},
                {174, 21}, {77, 18}, {54, 90}, {174, 52}, {16, 129}, {59, 181}, {290, 123}, {248, 132}};

        System.out.println(goldilocks.seatCheck(challenge));

    }

    public ArrayList<Integer> seatCheck(int[][] input) {

        ArrayList<Integer> returnArray = new ArrayList<Integer>();

        int goldilocksWeight = input[0][0];
        int goldilocksTemp = input[0][1];

        for (int i = 1; i < input.length; i++) {
            if (input[i][0] >= goldilocksWeight) {
                if (input[i][1] <= goldilocksTemp) {
                    returnArray.add(i);
                }
            }
        }
        return returnArray;

    }

}
