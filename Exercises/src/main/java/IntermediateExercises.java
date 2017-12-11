import java.util.ArrayList;
import java.util.Arrays;

public class IntermediateExercises {

    public static void main(String[] args) {

        IntermediateExercises intermediateExercises = new IntermediateExercises();

        System.out.println(intermediateExercises.blackjackEx(18, 21));
        System.out.println(intermediateExercises.blackjackEx(20, 18));
        System.out.println(intermediateExercises.blackjackEx(22, 22));

        System.out.println(intermediateExercises.uniqueSumEx(1, 2, 3));
        System.out.println(intermediateExercises.uniqueSumEx(3, 3, 3));
        System.out.println(intermediateExercises.uniqueSumEx(1, 1, 2));

        System.out.println(intermediateExercises.tooHotEx(70, false));
        System.out.println(intermediateExercises.tooHotEx(100, false));
        System.out.println(intermediateExercises.tooHotEx(100, true));
        System.out.println(intermediateExercises.tooHotEx(50, true));

        intermediateExercises.peopleEx();

        intermediateExercises.garageEx();

        intermediateExercises.paintWizardEx();

        intermediateExercises.fileWorkerEx();

    }

    private int blackjackEx(int x, int y) {

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

    private int uniqueSumEx(int x, int y, int z) {

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

    private boolean tooHotEx(int temperature, boolean isSummer) {

        if (isSummer) {
            if (temperature >= 60 && temperature <= 100) {
                return true;
            }
        } else if (temperature >= 60 && temperature <= 90) {
                return true;
        }

        return false;

    }

    private void peopleEx() {

        System.out.println("\nPeople Exercises");

        Person person1 = new Person("Alice", 25, "Software Engineer");
        Person person2 = new Person("Bob", 30, "Tester");
        Person person3 = new Person("Charlie", 35, "Senior Software Engineer");

        ArrayList<Person> PeopleList = new ArrayList<Person>();

        PeopleList.add(person1);
        PeopleList.add(person2);
        PeopleList.add(person3);

        for (Person p : PeopleList) {
            System.out.println(p.toString());
        }

        Person found = peopleSearch(PeopleList, "Alice");
        if (found != null) {
            System.out.println(found.toString());
        }

    }

    private Person peopleSearch(ArrayList<Person> PeopleList, String name) {

        name = name.toLowerCase();

        for (Person p : PeopleList) {
            if (p.getName().toLowerCase().equals(name)) {
                return p;
            }
        }

        System.out.println("Person not found");
        return null;

    }

    private void garageEx() {

        System.out.println("\nGarage Exercises");

        Garage myGarage = new Garage();
        Car newCar = new Car(1, "red", 2);
        Motorcycle newMotorcycle = new Motorcycle(2, "black", false);
        Van newVan = new Van(3, "white", 1000);
        Car newCar2 = new Car(4, "blue", 5);

        myGarage.addVehicle(newCar);
        myGarage.addVehicle(newMotorcycle);
        myGarage.addVehicle(newVan);
        myGarage.addVehicle(newCar2);

        System.out.println(myGarage.fixVehicle(3));
        System.out.println(Arrays.toString(myGarage.calculateBillAll()));

        myGarage.removeVehicleById(3);
        System.out.println(Arrays.toString(myGarage.calculateBillAll()));

        myGarage.removeVehicleByType("car");
        System.out.println(Arrays.toString(myGarage.calculateBillAll()));

        myGarage.addVehicle(newVan);
        myGarage.addVehicle(newCar2);
        System.out.println(Arrays.toString(myGarage.calculateBillAll()));

        myGarage.emptyGarage();

    }

    private void paintWizardEx() {

        System.out.println("\nPaint Wizard Exercises");

        ArrayList<Paint> paintList = new ArrayList<Paint>();

        Paint cheapoMax = new Paint("CheapoMax", 20, 19.99, 10);
        Paint averageJoes = new Paint("AverageJoes", 15, 17.99, 11);
        Paint duluxourousPaints = new Paint("DuluxourousPaints", 10, 25, 20);

        paintList.add(cheapoMax);
        paintList.add(averageJoes);
        paintList.add(duluxourousPaints);

        System.out.println(cheapestPaint(paintList,100).getReceipt(100));
        System.out.println(cheapestPaint(paintList,100).getReceipt(1000));

        System.out.println(leastWaste(paintList,100).getReceipt(100));
        System.out.println(leastWaste(paintList,100).getReceipt(1000));

    }

    private Paint cheapestPaint(ArrayList<Paint> paintList, int roomSize) {

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

    private Paint leastWaste(ArrayList<Paint> paintList, int roomSize) {

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

    private void fileWorkerEx() {

        FileWorker fileWorker = new FileWorker();

    }


}
