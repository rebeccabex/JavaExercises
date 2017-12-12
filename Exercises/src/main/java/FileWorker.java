import java.io.*;
import java.util.ArrayList;

public class FileWorker {

    FileWorker() {

        ArrayList<Person> personList = new ArrayList<Person>();
        ArrayList<String> nameList = new ArrayList<String>();

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

            nameList.add(p.getName());
        }

        ArrayList<Person> readList = readFromFile(nameList);

        for (Person p : readList) {
            System.out.println(p.toString());
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

     public ArrayList<Person> readFromFile(ArrayList<String> nameList) {

        ArrayList<Person> personList = new ArrayList<Person>();

        for (String name : nameList) {

            BufferedReader br = null;
            FileReader fr = null;

            try {

                String filename = "C:\\Users\\Admin\\JavaExercises\\Exercises\\" + name + ".txt";

                fr = new FileReader(filename);
                br = new BufferedReader(fr);

                String sCurrentLine;
                String personString = "";

                while ((sCurrentLine = br.readLine()) != null) {
                    personString += sCurrentLine;
                }

                Person newPerson = parsePersonString(personString);

                personList.add(newPerson);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (br != null) {
                        br.close();
                    }
                    if (fr != null) {
                        fr.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }
         return personList;
     }

    private Person parsePersonString(String personString) {

        String[] splitString = personString.split(";");

        String personName = "";
        int personAge = 0;
        String personJobTitle = "";

        for (String s : splitString) {
            String[] splitLine = s.split(":");

            switch (splitLine[0].toLowerCase().trim()) {
                case "name":
                    personName = splitLine[1].trim();
                    break;
                case "age":
                    personAge = Integer.parseInt(splitLine[1].trim());
                    break;
                case "job title":
                    personJobTitle = splitLine[1].trim();
                    break;
                default:
                    break;
            }
        }

        return new Person(personName, personAge, personJobTitle);


    }

    private void closeBuffered(Closeable c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

//    public ArrayList


}
