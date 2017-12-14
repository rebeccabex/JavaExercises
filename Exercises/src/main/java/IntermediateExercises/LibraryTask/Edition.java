package IntermediateExercises.LibraryTask;

public class Edition {

    private int id;
    private int date;
    private int month;
    private int year;
    private int volume;
    private int issue;

    public Edition(int id, int date, int month, int year) {

        this.id = id;
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public Edition(int id, int date, int month, int year, int volume, int issue) {

        this.id = id;
        this.date = date;
        this.month = month;
        this.year = year;
        this.volume = volume;
        this.issue = issue;

    }

    public int getId() {
        return id;
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

        if (id != edition.id) return false;
        if (date != edition.date) return false;
        if (month != edition.month) return false;
        if (year != edition.year) return false;
        if (volume != edition.volume) return false;
        return issue == edition.issue;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + date;
        result = 31 * result + month;
        result = 31 * result + year;
        result = 31 * result + volume;
        result = 31 * result + issue;
        return result;
    }
}
