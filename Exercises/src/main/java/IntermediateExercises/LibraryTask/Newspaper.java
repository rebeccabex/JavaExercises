package IntermediateExercises.LibraryTask;

import java.util.ArrayList;
import java.util.List;

public class Newspaper extends Resource implements Periodical {

    private String editor;
    private List<Edition> editionList;

    public Newspaper(int id, String name, String editor) {

        super(id, name);

        this.editor = editor;
        editionList = new ArrayList<Edition>();

    }

    @Override
    public void update(String fieldName, String newData) {

    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    @Override
    public List<Edition> getEditionList() {
        return editionList;
    }

    public void addEdition(int editionId, int date, int month, int year) {

        Edition newEdition = new Edition(editionId, date, month, year);
        editionList.add(newEdition);

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
}
