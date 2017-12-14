package IntermediateExercises.LibraryTask;

import java.util.ArrayList;

public class Library {

    ArrayList<Resource> resourceList;

    public Library() {

         resourceList = new ArrayList<Resource>();

    }

    public static void main(String[] args) {

        Library library = new Library();

    }

    public void addResource(Resource newResource) {
        resourceList.add(newResource);
    }

    public int getResourceCount() {
        return resourceList.size();
    }

    public int getBookCount() {
        return resourceList.size();
    }

    public int getNewspaperCount() {
        return resourceList.size();
    }

    public int getJournalCount() {
        return resourceList.size();
    }

}
