public class BasicExercises {

    public static void main(String[] args) {

        BasicExercises basicExercises = new BasicExercises();

        basicExercises.helloWorldEx();
        basicExercises.assignmentEx();
        basicExercises.parametersEx("Hello World!");

        System.out.println(basicExercises.returnEx());
        System.out.println(basicExercises.paramsOpsEx(5, 10));

        System.out.println(basicExercises.conditionalsEx(2, 3, true));
        System.out.println(basicExercises.conditionalsEx(2, 3, false));

        System.out.println(basicExercises.conditionals2Ex(1, 0));
        System.out.println(basicExercises.conditionals2Ex(1, 2));

        basicExercises.iterationEx(10);
        basicExercises.arraysEx();
        basicExercises.iterationArraysEx();
        basicExercises.iterationArrays2Ex();

    }

    private void helloWorldEx() {
        System.out.println("Hello World!");
    }

    private void assignmentEx() {
        String hw = "Hello World!";
        System.out.println(hw);
    }

    private void parametersEx(String inText) {
        System.out.println(inText);
    }

    private String returnEx() {
        return "Hello World!";
    }

    private int paramsOpsEx(int x, int y) {
        return x + y;
    }

    private int conditionalsEx(int x, int y, boolean sum) {
        if (sum) {
            return x + y;
        } else {
            return x * y;
        }
    }

    private int conditionals2Ex(int x, int y) {
        if (x == 0 ) {
            return y;
        } else if (y == 0) {
            return x;
        } else {
            return x + y;
        }
    }

    private void iterationEx(int x) {

        for (int i = 0; i < 20; i++) {
            System.out.println(conditionals2Ex(x, i));
        }

    }

    private void arraysEx() {

        int[] myArray = new int[10];

        for (int i = 0; i < 10; i++) {
            myArray[i] = 2 * i;
        }

        System.out.println(conditionals2Ex(myArray[3], myArray[5]));

    }

    private void iterationArraysEx() {

        int[] myArray = new int[10];

        for (int i = 0; i < 10; i++) {
            myArray[i] = 2 * i;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(myArray[i]);
        }

    }

    private void iterationArrays2Ex() {

        int[] myArray = new int[10];

        for (int i = 0; i < 10; i++) {
            myArray[i] = i;
            System.out.println(myArray[i]);
        }

        for (int i = 0; i < 10; i++) {
            myArray[i] *= 10;
            System.out.println(myArray[i]);
        }

    }




}
