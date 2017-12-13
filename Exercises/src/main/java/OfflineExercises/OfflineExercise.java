package OfflineExercises;

public class OfflineExercise {

    public static void main(String[] args) {

        OfflineExercise oe = new OfflineExercise();

        System.out.println("\nTask 1");
        System.out.println(oe.doubleChar("The"));
        System.out.println(oe.doubleChar("AAbb"));
        System.out.println(oe.doubleChar("Hi-There"));

        System.out.println("\nTask 2");
        System.out.println(oe.sandwichFilling("breadjambread"));
        System.out.println(oe.sandwichFilling("xxbreadjambreadyy"));
        System.out.println(oe.sandwichFilling("xxbreadyy"));

        System.out.println("\nTask 3");
        System.out.println(oe.evenlySpaced(2, 4, 6));
        System.out.println(oe.evenlySpaced(4, 6, 2));
        System.out.println(oe.evenlySpaced(4, 6, 3));

        System.out.println("\nTask 4");
        System.out.println(oe.nTwice("Hello", 2));
        System.out.println(oe.nTwice("Chocolate", 3));
        System.out.println(oe.nTwice("Chocolate", 1));

        System.out.println("\nTask 5");
        System.out.println(oe.endsLy("oddly"));
        System.out.println(oe.endsLy("y"));
        System.out.println(oe.endsLy("oddy"));

        System.out.println("\nTask 6");
        System.out.println(oe.stringClean("yyzzza"));
        System.out.println(oe.stringClean("abbbcdd"));
        System.out.println(oe.stringClean("Hello"));

        System.out.println("\nTask 7");
        System.out.println(oe.fibonacci(0));
        System.out.println(oe.fibonacci(1));
        System.out.println(oe.fibonacci(2));
        System.out.println(oe.fibonacci(8));

        System.out.println("\nTask 8");
        System.out.println(oe.bunnyEars(0));
        System.out.println(oe.bunnyEars(1));
        System.out.println(oe.bunnyEars(2));
        System.out.println(oe.bunnyEars(8));

        System.out.println("\nTask 9");
        String[] diamondArray = oe.diamond(4);
        for (String str : diamondArray) {
            System.out.println(str);
        }

    }

    public String doubleChar(String input) {

        String doubleString = "";

        for (int i = 0; i <input.length(); i++) {
            doubleString += input.charAt(i) + "" + input.charAt(i);
        }

        return  doubleString;

    }

    public  String sandwichFilling(String sandwich) {

        String filling = "\"\"";

        sandwich = sandwich.toLowerCase();

        if (sandwich.indexOf("bread") != -1) {

            sandwich = sandwich.split("bread", 2)[1];

            if (sandwich.indexOf("bread") != -1) {

                filling = sandwich.split("bread", 2)[0];

            }
        }

        return filling;

    }

    public boolean evenlySpaced(int a, int b, int c) {

        int min = Integer.min(Integer.min(a, b), c);
        int max = Integer.max(Integer.max(a, b), c);

        int mid = 0;

        if (a == min) {
            if (b == max) {
                mid = c;
            } else {
                mid = b;
            }
        } else if (a == max) {
            if (b == min) {
                mid = c;
            } else {
                mid = b;
            }
        } else {
            mid = a;
        }

        if (max - mid == mid - min) {
            return true;
        } else {
            return false;
        }

    }

    public String nTwice(String input, int n) {

        String start = input.substring(0, n);
        String end = input.substring(input.length()-n);

        return  start + end;

    }

    public boolean endsLy(String input){

        return input.endsWith("ly");

    }

    public String stringClean(String input) {

        char currentChar = input.charAt(0);
        String cleanedString = input.substring(0,1);

        for (int i = 1; i < input.length(); i++) {

            if (input.charAt(i) != currentChar) {
                currentChar = input.charAt(i);
                cleanedString += input.substring(i,i+1);
            }
        }

        return cleanedString;

    }

    public int fibonacci(int n) {

        if (n == 0 || n == 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }

    }

    public int bunnyEars(int bunnies) {

        if (bunnies < 1) {
            return 0;
        } else {
            return bunnyEars(bunnies - 1) + 2;
        }

    }

    public String[] diamond(int size) {

        if (size/2*2 == size) {
            size++;
        }

        String[] diamondArray = new String[size];

        int last = size - 1;
        int mid = last / 2;

        for (int i = 0; i < size; i++) {
            if (i == mid) {
                diamondArray[i] = "x";
            } else {
                diamondArray[i] = " ";
            }
            for (int j = 1; j < size; j++) {
                int cell = i + j;
                if (cell >= mid && cell <= mid + last && Math.abs(i - j) <= mid) {
                    diamondArray[i] += "x";
                } else {
                    diamondArray[i] += " ";
                }
            }
        }

        return diamondArray;

    }

}
