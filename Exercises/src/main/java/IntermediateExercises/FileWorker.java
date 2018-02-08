package IntermediateExercises;

import java.io.*;
import java.util.ArrayList;

public class FileWorker {

    public FileWorker() {

    }

    public void fileWorkerExample() {

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

        String filename = person.getName() + ".txt";
        String data = person.toString();

        fileWriter(filename, data);

    }

    public boolean fileWriter(String filename, String data) {

        BufferedWriter bw = null;
        FileWriter fw = null;

        boolean success = false;

        try {

            fw = new FileWriter(filename);
            bw = new BufferedWriter(fw);
            bw.write(data);

            success = true;

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
        return success;
    }

    public ArrayList<Person> readFromFile(ArrayList<String> nameList) {

        ArrayList<Person> personList = new ArrayList<Person>();

        for (String name : nameList) {

            String filename = name + ".txt";

            ArrayList<String> stringArray = fileReader(filename);

            String personString = "";

            for (String s : stringArray) {
                personString += s;
            }

            Person newPerson = parsePersonString(personString);

            personList.add(newPerson);
        }
         return personList;
    }

    public ArrayList<String> fileReader(String filename) {

         ArrayList<String> stringArray = new ArrayList<String>();

         BufferedReader br = null;
         FileReader fr = null;

         try {
             fr = new FileReader(filename);
             br = new BufferedReader(fr);

             String sCurrentLine;
             String personString = "";

             while ((sCurrentLine = br.readLine()) != null) {
                 stringArray.add(sCurrentLine);
             }
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
         return stringArray;
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

}
