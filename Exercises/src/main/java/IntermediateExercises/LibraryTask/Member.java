package IntermediateExercises.LibraryTask;

import java.util.ArrayList;

public class Member {

    private int id;
    private String name;
    private String homeAddress;
    private ArrayList<Resource> resourcesBorrowing;

    public Member(int id, String name, String homeAddress) {

        this.id = id;
        this.name = name;
        this.homeAddress = homeAddress;
        resourcesBorrowing = new ArrayList<Resource>();

    }

    public void update(String fieldName, String newData) {

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

    public void setName(String name) {
        this.name = name;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public ArrayList<Resource> getResourcesBorrowing() {
        return resourcesBorrowing;
    }
}
