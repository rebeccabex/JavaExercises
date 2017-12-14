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

    }

    public void deleteResource(Resource resource) {

    }

    public void deleteMember(Member member) {

    }

    public int borrowResource(Resource resource, Member member) {
        return -1;
    }

    public void returnResource(Resource resource, Member member) {

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
        return null;

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

}
