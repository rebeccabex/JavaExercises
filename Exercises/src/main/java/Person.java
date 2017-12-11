public class Person {

    private String name;
    private int age;
    private String jobTitle;

    Person(String name, int age, String jobTitle) {

        this.name = name;
        this.age = age;
        this.jobTitle = jobTitle;

    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {

        String personString = "Name: " + name;
        personString += "\nAge: " + age;
        personString += "\nJob title: " + jobTitle;

        return personString;

    }

}
