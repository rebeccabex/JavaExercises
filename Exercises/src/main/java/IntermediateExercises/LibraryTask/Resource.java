package IntermediateExercises.LibraryTask;

public abstract class Resource {

    private int id;
    private String name;

    public Resource(int id, String name) {

        this.id = id;
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public abstract void update(String field, String newData);

}
