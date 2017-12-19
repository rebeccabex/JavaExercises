package IntermediateExercises.LibraryTask;

import IntermediateExercises.FileWorker;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private ArrayList<Resource> resourceList;
    private ArrayList<Member> memberList;
    private int nextResourceId;
    private int nextMemberId;

    public Library() {

        nextResourceId = 1;
        nextMemberId = 1;

        resourceList = new ArrayList<Resource>();
        memberList = new ArrayList<Member>();

    }

    public static void main(String[] args) {

        Library library = new Library();

    }

//    public void addResource(String name, ) {
//        resourceList.add(newResource);
//    }

    public void addBook(String name, int yearPublished, String author) {

        int id = nextResourceId;
        nextResourceId++;
        Book newBook = new Book(id, name, yearPublished, author);
        resourceList.add(newBook);

    }

    public void addNewspaper(String name, String editor) {

        int id = nextResourceId;
        nextResourceId++;
        Newspaper newNewspaper = new Newspaper(id, name, editor);
        resourceList.add(newNewspaper);

    }

    public void addJournal(String name, String publisher) {

        int id = nextResourceId;
        nextResourceId++;
        Journal newJournal = new Journal(id, name, publisher);
        resourceList.add(newJournal);

    }

    public void addMember(String name, String address) {

        int id = nextMemberId;
        nextMemberId++;
        Member newMember = new Member(id, name, address);
        memberList.add(newMember);

    }

    public void updateResource(Resource resource, String fieldName, String newData) {
        resource.update(fieldName, newData);
    }

    public void updateResourceById(int resourceId, String fieldName, String newData) {

        Resource resource = findResourceById(resourceId);

        if (resource != null) {
            updateResource(resource, fieldName, newData);
        }
    }

    public void updateMember(Member member, String fieldName, String newData) {

        member.update(fieldName, newData);

    }

    public void updateMemberById(int memberId, String fieldName, String newData) {

        Member member = findMemberById(memberId);

        if (member != null) {
            updateMember(member, fieldName, newData);
        }
    }

    public void deleteResource(Resource resource) {
        resourceList.remove(resource);
    }

    public void deleteResourceById(int id) {

        Resource resource = findResourceById(id);

        if (resource != null) {
            deleteResource(resource);
        }
    }

    public void deleteMember(Member member) {
        memberList.remove(member);
    }

    public void deleteMemberById(int id) {

        Member member = findMemberById(id);

        if (member != null) {
            deleteMember(member);
        }
    }

    public int borrowResource(Member member, Borrowable item) {

//        need to make this use real date
        int currentDate = 18;

        if (item.isAvailable()) {
            member.borrowResource(item);
            return item.borrowItem(currentDate);
        } else {
            return -1;
        }

    }

    public int borrowResourceByIds(int memberId, int itemId) {

        Member member = findMemberById(memberId);
        Resource resource = findResourceById(itemId);

        if (member != null && resource != null && resource instanceof Borrowable) {
            return borrowResource(member, (Borrowable) resource);
        } else {
            return -1;
        }

    }

    public int returnResource(Member member, Borrowable item) {

        int fine = 0;

        if (member.hasItem(item)) {
            member.returnResource(item);
//            to implement
            fine = 0;
            item.returnItem();
        } else {
            fine = -1;
        }

        return fine;

    }

    public int returnResourceByIds(int memberId, int itemId) {

        Member member = findMemberById(memberId);
        Resource resource = findResourceById(itemId);

        if (member != null && resource != null && resource instanceof Borrowable) {
            return returnResource(member, (Borrowable) resource);
        } else {
            return -1;
        }

    }

    public Resource findResourceById(int id) {

        for (Resource r : resourceList) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    public Member findMemberById(int id) {

        for (Member m : memberList) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    public List<Resource> getAllResources() {
        return null;

    }

    public List<Resource> getAvailableResources() {

        List<Resource> returnList = new ArrayList<>();

        for (Resource i : resourceList) {
            if (i instanceof Borrowable) {
                if (((Borrowable) i).isAvailable()) {
                    returnList.add(i);
                }
            } else if (i instanceof Periodical && ((Periodical) i).getEditionList().size() > 0) {
                returnList.add(i);
//                Periodical p = (Periodical) i;
//                for (Edition e : p.getEditionList()) {
//                    returnList.add(e);
//                }
            } else {
                returnList.add(i);
            }
        }
        return returnList;
    }

    public List<Resource> getBorrowableResources() {

        List<Resource> returnList = new ArrayList<>();

        for (Resource i : resourceList) {
            if (i instanceof Borrowable) {
                if (((Borrowable) i).isAvailable()) {
                    returnList.add(i);
                }
            }
        }
        return returnList;
    }

    public String resourceListToString(List<Resource> inputList) {

        String returnString = "";

        for (Resource r : inputList) {
            returnString += r.toString() + System.lineSeparator();
        }
        return returnString;
    }

    public List<Member> getAllMembers() {

        return null;
    }

    public int getResourceCount() {
        return resourceList.size();
    }

    public int getMemberCount() {
        return memberList.size();
    }

    public int getTypeOfResourceCount(String resourceType) {

        int count = 0;

        for (Resource r : resourceList) {
            if (r.getClass().getSimpleName().toLowerCase().equals(resourceType.toLowerCase())) {
                count++;
            }
        }
        return count;
    }

    public void addNewPeriodicalEdition(Periodical periodical, int date, int month, int year) {

        int id = nextResourceId;
        nextResourceId++;

        Edition edition = new Edition(id, date, month, year);

        periodical.addEdition(edition);

    }

    public void addNewPeriodicalEditionById(int periodicalId, int date, int month, int year) {

        Resource resource = findResourceById(periodicalId);
        if (resource != null && resource instanceof Periodical) {
            addNewPeriodicalEdition((Periodical) resource, date, month, year);
        }

    }

    public void addNewPeriodicalEdition(Periodical periodical, int date, int month, int year, int volume, int issue) {

        int id = nextResourceId;
        nextResourceId++;

        Edition edition = new Edition(id, date, month, year, volume, issue);

        periodical.addEdition(edition);

    }

    public void addNewPeriodicalEditionById(int periodicalId, int date, int month, int year, int volume, int issue) {

        Resource resource = findResourceById(periodicalId);
        if (resource != null && resource instanceof Periodical) {
            addNewPeriodicalEdition((Periodical) resource, date, month, year, volume, issue);
        }

    }

    public boolean saveAvailableResources(String filename) {

        if (filename.endsWith(".txt")) {

            FileWorker fw = new FileWorker();

            return fw.fileWriter(filename, resourceListToString(getAvailableResources()));

        } else {
            return false;
        }
    }

    public boolean loadAvailableResources(String filename) {


        return false;
    }

}
