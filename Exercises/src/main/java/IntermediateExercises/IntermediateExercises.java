package IntermediateExercises;

import java.util.ArrayList;
import java.util.Arrays;

public class IntermediateExercises {

    public static void main(String[] args) {

        IntermediateExercises intermediateExercises = new IntermediateExercises();

        intermediateExercises.blackjackEx();

        intermediateExercises.uniqueSumEx();

        intermediateExercises.tooHotEx();

        intermediateExercises.peopleEx();

        intermediateExercises.garageEx();

        intermediateExercises.paintWizardEx();

        intermediateExercises.fileWorkerEx();

    }

    public void blackjackEx() {

        Blackjack blackjack = new Blackjack();

        System.out.println(blackjack.compareHands(18, 21));
        System.out.println(blackjack.compareHands(20, 18));
        System.out.println(blackjack.compareHands(22, 22));

    }

    public void uniqueSumEx() {

        UniqueSum uniqueSum = new UniqueSum();

        System.out.println(uniqueSum.calculateUniqueSum(1, 2, 3));
        System.out.println(uniqueSum.calculateUniqueSum(3, 3, 3));
        System.out.println(uniqueSum.calculateUniqueSum(1, 1, 2));

    }

    public void tooHotEx() {

        TemperatureChecker temperatureChecker = new TemperatureChecker();

        System.out.println(temperatureChecker.isTempGood(70, false));
        System.out.println(temperatureChecker.isTempGood(100, false));
        System.out.println(temperatureChecker.isTempGood(100, true));
        System.out.println(temperatureChecker.isTempGood(50, true));

    }

    private void peopleEx() {

        System.out.println("\nPeople Exercises");

        PeopleManager peopleManager = new PeopleManager();

        Person person1 = new Person("Alice", 25, "Software Engineer");
        Person person2 = new Person("Bob", 30, "Tester");
        Person person3 = new Person("Charlie", 35, "Senior Software Engineer");

        peopleManager.addPerson(person1);
        peopleManager.addPerson(person2);
        peopleManager.addPerson(person3);

        ArrayList<Person> personList = peopleManager.getPersonList();

        for (Person p : personList) {
            System.out.println(p);
        }

        Person found = peopleManager.searchByName("Alice");
        if (found != null) {
            System.out.println(found.toString());
        }

    }

    private void garageEx() {


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
