package IntermediateExercises.LibraryTask;

import java.util.ArrayList;
import java.util.List;

public class Library {

    ArrayList<Resource> resourceList;
    ArrayList<Member> memberList;

    public Library() {

         resourceList = new ArrayList<Resource>();
         memberList = new ArrayList<Member>();

    }

    public static void main(String[] args) {

        Library library = new Library();

    }

    public void addResource(Resource newResource) {
        resourceList.add(newResource);
    }

    public void addMember(Member newMember) {
        memberList.add(newMember);
    }

    public void updateResource(Resource resource, String fieldName, String newData) {

        resource.update(fieldName, newData);

    }

    public void updateMember(Member member, String fieldName, String newData) {

        member.update(fieldName, newData);

    }

    public void deleteResource(Resource resource) {
        resourceList.remove(resource);
    }

    public void deleteMember(Member member) {
        memberList.remove(member);
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

    public Resource findResourceById(int id) {

        for (Resource r : resourceList) {
            if (r.getId() == id) {
                return r;
            }
        }

        return null;
    }

    public Member findMemberById(int id) {
        return null;

    }

    public List<Resource> getAllResources() {
        return null;

    }

    public List<Resource> getAvailableResources() {

//        List<Resource> returnList = new ArrayList<>();
//
//        for (Resource i : resourceList) {
//            if (i instanceof Borrowable) {
//                if (((Borrowable) i).isAvailable()) {
//                    returnList.add(i);
//                }
//            }
//        }
//        return returnList;

        return null;

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

//        to implement properly
        int id = 1;

        Edition edition = new Edition(id, date, month, year);

        periodical.addEdition(edition);

    }

    public void addNewPeriodicalEdition(Periodical periodical, int date, int month, int year, int volume, int issue) {

//        to implement properly
        int id = 1;

        Edition edition = new Edition(id, date, month, year, volume, issue);

        periodical.addEdition(edition);

    }

}
