package IntermediateExercises;

import java.util.ArrayList;

public class PeopleManager {

    private ArrayList<Person> personList = new ArrayList<Person>();

    public void addPerson(Person newPerson) {
        personList.add(newPerson);
    }


    public Person searchByName(String name) {

        name = name.toLowerCase();

        for (Person p : personList) {
            if (p.getName().toLowerCase().equals(name)) {
                return p;
            }
        }

        return null;

    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }
}
