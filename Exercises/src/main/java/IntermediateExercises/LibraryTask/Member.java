package IntermediateExercises.LibraryTask;

import java.util.ArrayList;
import java.util.Iterator;

public class Member {

    private int id;
    private String name;
    private String homeAddress;
    private ArrayList<Borrowable> itemsBorrowing;

    public Member(int id, String name, String homeAddress) {

        this.id = id;
        this.name = name;
        this.homeAddress = homeAddress;
        itemsBorrowing = new ArrayList<>();

    }

    public void update(String fieldName, String newData) {

        switch (fieldName.toLowerCase()) {
            case "name" :
                setName(newData);
                break;
            case "address":
                setHomeAddress(newData);
                break;
            default:
                System.out.println("Field " + fieldName + " does not exist in " + getName());
        }

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public void borrowResource(Borrowable item) {

        itemsBorrowing.add(item);

    }

    public void returnResource(Borrowable item) {

        Iterator<Borrowable> it = itemsBorrowing.iterator();
        while (it.hasNext()) {
            Borrowable i = it.next();
            if (item.equals(i)) {
                it.remove();
            }
        }

    }

    public ArrayList<Borrowable> getItemsBorrowing() {
        return itemsBorrowing;
    }

    public boolean hasItem(Borrowable item) {

        for (Borrowable i : itemsBorrowing) {
            if (i.equals(item)) {
                return true;
            }
        }

        return false;
    }
}
