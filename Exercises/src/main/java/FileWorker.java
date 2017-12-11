import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileWorker {

    FileWorker() {

        ArrayList<Person> personList = new ArrayList<Person>();

        Person person1 = new Person("Alice", 25, "Software Engineer");
        Person person2 = new Person("Bob", 30, "Tester");
        Person person3 = new Person("Charlie", 35, "Senior Software Engineer");
        Person person4 = new Person("Dan", 22, "Junior Software Engineer");
        Person person5 = new Person("Eve", 20, "Human Resources");

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);

        for (Person p : personList) {
            writeToFile(p);
        }

    }

    public void writeToFile(Person person) {

        String filename = "C:\\Users\\Admin\\JavaExercises\\Exercises\\" + person.getName() + ".txt";

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            String data = person.toString();

            fw = new FileWriter(filename);
            bw = new BufferedWriter(fw);
            bw.write(data);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                if (bw != null) {
                    bw.close();
                }

                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

}
