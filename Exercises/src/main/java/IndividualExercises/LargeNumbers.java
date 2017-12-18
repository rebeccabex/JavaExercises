package IndividualExercises;

import AdventureGame.CLInterface;

public class LargeNumbers {

    private String shortName;
    private String longName;

    public LargeNumbers(boolean scanner) {

        if (scanner) {
            CLInterface cl = new CLInterface();

            boolean running = true;

            while (running) {
                String input = cl.playerInput("Please enter a number, or 'end' to exit");
                if (input.equalsIgnoreCase("end")) {
                    running = false;
                } else {
                    System.out.println(bothForms(input));
                }
            }
        }
    }

    public static void main(String[] args) {
        LargeNumbers ln = new LargeNumbers(true);
    }

    public String bothForms(String number) {

        if (number.matches("\\d*")) {
            if (number.matches("0*")) {
                return "Short form: 0\nLong form: 0";
            } else {
                while (number.startsWith("0")) {
                    number = number.substring(1);
                }
                if (number.length() < 25) {
                    String returnString = "Short form: " + createName(number, true).trim();
                    returnString += "\nLong form: " + createName(number, false).trim();
                    return returnString;
                } else {
                    return "That number is too large. Maximum length 24 digits.";
                }
            }
        } else {
            return "Not a number";
        }
    }

    public String createName(String number, boolean shortForm) {

        int digits = number.length();
        int beginLength = digits % 3 == 0 ? 3 : digits % 3;

        String begin = number.substring(0, beginLength);
        String end = number.substring(beginLength);

        if (number.matches("0*")) {
            return "";
        } else if (begin.matches("0*")) {
            return createName(end, shortForm);
        } else if (digits <= 3) {
            return number;
        } else {
            return begin + getSuffix((digits - 1) / 3, shortForm) + createName(end, shortForm);
        }
    }

    public String getSuffix(int power, boolean shortForm) {

        if (shortForm && power > 2) {
            power = (power - 1) * 2;
        }

        String[] name = {"", " thousand ", " million ", " milliard ", " billion ", " billiard ",
                " trillion ", " trilliard ", " quadrillion ", " quadrilliard ", " quintillion ",
                " quintilliard ", " sextillion ", " sextilliard "};

        return name[power];
    }

}
