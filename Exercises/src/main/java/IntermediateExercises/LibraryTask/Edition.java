package IntermediateExercises.LibraryTask;

public class Edition extends Resource {

    private int date;
    private int month;
    private int year;
    private int volume;
    private int issue;

    public Edition(int id, int date, int month, int year) {

        super(id, "");
        this.date = date;
        this.month = month;
        this.year = year;
        this.volume = -1;
        this.issue = -1;
    }

    public Edition(int id, int date, int month, int year, int volume, int issue) {

        super(id, "");
        this.date = date;
        this.month = month;
        this.year = year;
        this.volume = volume;
        this.issue = issue;

    }

    @Override
    public void update(String field, String newData) {



    }

    public int getDate() {
        return date;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getVolume() {
        return volume;
    }

    public int getIssue() {
        return issue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edition edition = (Edition) o;

        if (getId() != edition.getId()) return false;
        if (date != edition.date) return false;
        if (month != edition.month) return false;
        if (year != edition.year) return false;
        if (volume != edition.volume) return false;
        return issue == edition.issue;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + date;
        result = 31 * result + month;
        result = 31 * result + year;
        result = 31 * result + volume;
        result = 31 * result + issue;
        return result;
    }

    @Override
    public String toString() {
        String editionString = "Date: " + date +
                ", Month: " + month +
                ", Year: " + year;
        if (volume > 0) {
            editionString += ", Volume: " + volume;
        }

        if (issue > 0) {
            editionString += ", Isuse: " + issue;
        }

        return editionString;
    }
}
