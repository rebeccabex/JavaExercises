package IntermediateExercises.LibraryTask;

import java.util.ArrayList;
import java.util.List;

public class Journal extends Resource implements Periodical {

    private String publisher;
    private List<Edition> editionList;

    public Journal(int id, String name, String publisher) {

        super(id, name);

        this.publisher = publisher;
        editionList = new ArrayList<Edition>();

    }

    @Override
    public void update(String fieldName, String newData) {

        switch (fieldName.toLowerCase()) {
            case "name":
                setName(newData);
                break;
            case "publisher":
                setPublisher(newData);
                break;
            default:
                System.out.println("Field " + fieldName + " does not exist in " + getName());
        }
    }

    public void addEdition(int editionId, int date, int month, int year, int volume, int issue) {

        Edition edition = new Edition(editionId, date, month, year, volume, issue);
        editionList.add(edition);

    }

    public String getPublisher() {
        return publisher;
    }

    private void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public List<Edition> getEditionList() {
        return editionList;
    }

    @Override
    public Edition findEditionByDate(int date, int month, int year) {

        for (Edition e : editionList) {
            if (e.getDate() == date && e.getMonth() == month && e.getYear() == year) {
                return e;
            }
        }

        return null;
    }

    @Override
    public void addEdition(Edition edition) {
        editionList.add(edition);
    }
}
