package IntermediateExercises.LibraryTask;

public interface Borrowable {

    public boolean isAvailable();
    public int borrowItem(int currDate);
    public void returnItem();
    public int getLoanLength();
    public void setLoanLength(int loanLength);

}
