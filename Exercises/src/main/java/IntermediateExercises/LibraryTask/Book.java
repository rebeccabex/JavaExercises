package IntermediateExercises.LibraryTask;

public class Book extends Resource implements Borrowable {

    private int yearPublished;
    private String author;
    private boolean available;
    private int loanLength;

    public Book(int id, String name, int yearPublished, String author) {

        super(id, name);

        this.yearPublished = yearPublished;
        this.author = author;
        available = true;
        loanLength = 21;

    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {

        return yearPublished;
    }

    @Override
    public int getLoanLength() {
        return loanLength;
    }

    private void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    private void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void setLoanLength(int loanLength) {
        this.loanLength = loanLength;
    }

    @Override
    public void update(String fieldName, String newData) {

        switch (fieldName.toLowerCase()) {
            case "name":
                setName(newData);
                break;
            case "author":
                setAuthor(newData);
                break;
            case "yearpublished":
            case "year published":
                setYearPublished(Integer.parseInt(newData));
                break;
            default:
                System.out.println("Field " + fieldName + " does not exist in " + getName());
        }

    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public int borrowItem(int currentDate) {

        if(isAvailable()) {
            available = false;
            return currentDate + loanLength;
        } else {
            return -1;
        }
    }

    @Override
    public void returnItem() {
        available = true;
    }


}
