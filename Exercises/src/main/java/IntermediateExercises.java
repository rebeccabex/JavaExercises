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

    public int blackjackEx(int x, int y) {

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

    public int uniqueSumEx(int x, int y, int z) {

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

    public boolean tooHotEx(int temperature, boolean isSummer) {

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
        Car newCar = new Car("ABC123", "red", 2);
        Motorcycle newMotorcycle = new Motorcycle("DEF456", "black", false);
        Van newVan = new Van("GHJ789", "white", 1000);
        Car newCar2 = new Car("KLM012", "blue", 5, 50000, 3);
        Car newCar3 = new Car("NPQ345", "blue", 5, 70000);

        myGarage.addVehicle(newCar);
        myGarage.addVehicle(newMotorcycle);
        myGarage.addVehicle(newVan);
        myGarage.addVehicle(newCar2);

        System.out.println(myGarage.fixVehicle("GHJ789"));
        System.out.println(Arrays.toString(myGarage.calculateBillAll()));

        myGarage.removeVehicleByReg("GHJ789");
        System.out.println(Arrays.toString(myGarage.calculateBillAll()));

        myGarage.removeVehicleByType("car");
        System.out.println(Arrays.toString(myGarage.calculateBillAll()));

        myGarage.addVehicle(newVan);
        myGarage.addVehicle(newCar3);
        System.out.println(Arrays.toString(myGarage.calculateBillAll()));

        myGarage.emptyGarage();

    }

    private void paintWizardEx() {

        System.out.println("\nPaint Wizard Exercises");

        PaintWizard paintWizard = new PaintWizard();

        System.out.println(paintWizard.cheapestPaint(100).getReceipt(100));
        System.out.println(paintWizard.cheapestPaint(100).getReceipt(1000));

        System.out.println(paintWizard.leastWaste(100).getReceipt(100));
        System.out.println(paintWizard.leastWaste(100).getReceipt(1000));

    }

    private void fileWorkerEx() {

        FileWorker fileWorker = new FileWorker();

    }


}
