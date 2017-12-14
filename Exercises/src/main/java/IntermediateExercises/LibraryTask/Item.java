package IntermediateExercises.LibraryTask;

public interface Item {

    public void add(int id, String name);
    public void update(int id, String fieldName, String newData);
    public void delete(int id);

}
