package IntermediateExercises.LibraryTask;

import java.util.List;

public interface Periodical {

    public List<Edition> getEditionList();
    public Edition findEditionByDate(int date, int month, int year);
    public void addEdition(Edition edition);
    public String editionsToString();
}
